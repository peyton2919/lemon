package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.enums.Tips;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.mall.bo.StorageBo;
import cn.peyton.spring.mall.bo.StorageDetailBo;
import cn.peyton.spring.mall.dao.InventoryMapper;
import cn.peyton.spring.mall.dao.StorageDetailMapper;
import cn.peyton.spring.mall.entity.Inventory;
import cn.peyton.spring.mall.entity.StorageDetail;
import cn.peyton.spring.mall.entity.Storage;
import cn.peyton.spring.mall.param.StorageParam;
import cn.peyton.spring.mall.service.StorageService;
import cn.peyton.spring.mall.dao.StorageMapper;
import cn.peyton.spring.mall.service.util.StorageUtil;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * <h3>出入库 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
@Service("storageService")
public class StorageServiceImpl implements StorageService {
    /** 入库 状态*/
    private static final int STORAGE_INTO = 0;
    /** 提示 '修改库存不足' */
    private static final String ERROR_TIPS = "修改库存不足";
	@Resource
	private StorageMapper storageMapper;
	@Resource
    private InventoryMapper inventoryMapper;
	@Resource
    private StorageDetailMapper storageDetailMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void save(StorageParam param) {
        checked(param);
        List<StorageDetail> storageDetails = new ArrayList<>();
        int size = param.getQuantities().size();
        Storage storage = param.convert();
        if (null == param.getCreated() || "".equals(param.getCreated().trim())) {
            storage.setStorCreated(new Date());
        }
        storage.setStorUpdated(new Date());
        storage.setStorStatus(Status.NORMAL.getCode());
        BaseUser<Integer> user = RequestHolder.getCurrentUser();
        storage.setEmpId(user.getPrimaryKey());
        storage.setStorEmpName(user.getUserName());
        storageMapper.insertSelective(storage);
        convent(storageDetails,storage.getId(),param.getColIds(),param.getQuantities());
        //StorageDetailParam 对象集合 转成 StorageDetail 对象集合
        storageDetailMapper.batchInsert(storageDetails);
        Inventory inventory = inventoryMapper.selectByComIdAndWarId(param.getComId(), param.getWarId());
        String detail = "";
        if (null == inventory) {
            if (param.getDirection() == STORAGE_INTO) {
                inventory = new Inventory();
                detail = StorageUtil.convertList2Str(storageDetails);
                inventory.setInveCreated(new Date());
                inventory.setInveDetail(detail);
                inventory.setInveTip(Tips.NORMAL.getCode());
                inventory.setInveTotal(param.getTotal());
                inventory.setWarId(param.getWarId());
                inventory.setComId(param.getComId());
                inventory.setInveComName(param.getComName());
                inventory.setInveExplain(param.getWarName());
                inventoryMapper.insertSelective(inventory);
            } else {
                throw new ValidationException("出库数量不足");
            }
        } else {
            Map<Integer, Integer> maps = StorageUtil.conventStr2Map(inventory.getInveDetail());
            for (int i = 0; i < size; i++) {
                StorageDetail tStorageDetail = storageDetails.get(i);
                Integer key = tStorageDetail.getColId();
                Integer iQuantity = maps.get(tStorageDetail.getColId());
                Integer uQuantity = tStorageDetail.getStdeQuantity();
                if (null == iQuantity) {
                    //入库
                    if (param.getDirection() == STORAGE_INTO) {
                        maps.put(key, uQuantity);
                    } else {
                        throw new ValidationException("出库数量不足");
                    }
                } else {
                    if (param.getDirection() == STORAGE_INTO) {
                        maps.put(key, uQuantity + iQuantity);
                    } else {
                        //出库
                        if (uQuantity > iQuantity) {
                            throw new ValidationException("出库数量不足");
                        } else {
                            maps.put(key, iQuantity - uQuantity);
                        }
                    }
                }
            }
            detail = StorageUtil.conventMap2Str(maps);
            inventory.setInveDetail(detail);
            if (param.getDirection() == STORAGE_INTO) {
                inventory.setInveTotal(inventory.getInveTotal() + param.getTotal());
            }else {
                inventory.setInveTotal(inventory.getInveTotal() - param.getTotal());
            }
            inventoryMapper.updateDetailAndTotal(inventory);
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(StorageParam param) {
        checked(param);
        //原始出入库数据
        Storage original = storageMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(original,"待更新的出入库不存在");
        Inventory inventory = inventoryMapper.selectByComIdAndWarId(param.getComId(), param.getWarId());
        CheckedUtil.checkNoNull(inventory,"待更新的主库存不存在");
        List<StorageDetail> storageDetailList = storageDetailMapper.selectByStorId(param.getId());
        CheckedUtil.checkNoNull(storageDetailList,"待更新的出入库明细不存在");
        List<StorageDetail> storageDetails = new ArrayList<>();
        int size = param.getQuantities().size();
        convent(storageDetails,original.getId(),param.getColIds(),param.getQuantities());
        int total = 0;
        Storage storage = param.convert();
        storage.setStorUpdated(new Date());
        storageMapper.updateTotal(storage);
        storageDetailMapper.deleteByStorId(original.getId());
        //StorageDetailParam 对象集合 转成 StorageDetail 对象集合
        storageDetailMapper.batchInsert(storageDetails);
        //原始 出入库明细
        Map<Integer, Integer> originalDetailMap = StorageUtil.convertList2Map(storageDetailList);
        //主库存 颜色与数量 集合
        Map<Integer, Integer> inventoryDetailMap = StorageUtil.conventStr2Map(inventory.getInveDetail());
        //入库
        for (int i = 0; i < size; i++) {
            StorageDetail storageDetail = storageDetails.get(i);
            Integer key = storageDetail.getColId();
            //更新数
            Integer uQuantity = storageDetail.getStdeQuantity();
            //原始数
            Integer oQuantity = originalDetailMap.get(key);
            //库存数
            Integer iQuantity = inventoryDetailMap.get(key);
            //入库
            if (param.getDirection() == STORAGE_INTO) {
                if (null == oQuantity) {
                    inventoryDetailMap.put(key, uQuantity);
                    total = total + uQuantity;
                } else {
                    if (uQuantity < oQuantity) {
                        if (oQuantity - uQuantity > iQuantity) {
                            throw new ValidationException();
                        }
                    }
                    inventoryDetailMap.put(key, iQuantity + (uQuantity - oQuantity));
                    total = total + (uQuantity - oQuantity);
                    //移除
                    originalDetailMap.remove(key);
                }
            } else {
                //出库 库存数
                if (null == iQuantity) {
                    throw new ValidationException(ERROR_TIPS);
                } else {
                    if (null == oQuantity) {
                        if (uQuantity > iQuantity) {
                            throw new ValidationException(ERROR_TIPS);
                        } else {
                            inventoryDetailMap.put(key, iQuantity - uQuantity);
                            total = total - uQuantity;
                        }
                    } else {
                        if (uQuantity > oQuantity) {
                            if (uQuantity - oQuantity > iQuantity) {
                                throw new ValidationException(ERROR_TIPS);
                            }
                        }
                        originalDetailMap.remove(key);
                        inventoryDetailMap.put(key, iQuantity + (oQuantity - uQuantity));
                        total = total + (oQuantity - uQuantity);
                    }
                }
            }
        }
        //循环剩余原始集合
        for (Map.Entry<Integer, Integer> entry : originalDetailMap.entrySet()) {
            Integer key = entry.getKey();
            Integer oQuantity = entry.getValue();
            Integer iQuantity = inventoryDetailMap.get(key);
            if (null == iQuantity) {
                throw new ValidationException(ERROR_TIPS);
            }
            //入库
            if (param.getDirection() == STORAGE_INTO) {
                if (oQuantity > iQuantity) {
                    throw new ValidationException(ERROR_TIPS);
                } else {
                    inventoryDetailMap.put(key, iQuantity - oQuantity);
                    total = total - oQuantity;
                }
            } else {
                inventoryDetailMap.put(key, iQuantity + oQuantity);
                total = total + oQuantity;
            }
        }
        inventory.setInveDetail(StorageUtil.conventMap2Str(inventoryDetailMap));
        inventory.setInveTotal(inventory.getInveTotal() + total);
        inventoryMapper.updateDetailAndTotal(inventory);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Long id) {
        //原始出入库数据
        Storage original = storageMapper.selectByPrimaryKey(id);
        CheckedUtil.checkNoNull(original,"待更新的出入库不存在");
        Inventory inventory = inventoryMapper.selectByComIdAndWarId(original.getComId(), original.getWarId());
        CheckedUtil.checkNoNull(inventory,"待更新的主库存不存在");
        List<StorageDetail> storageDetailList = storageDetailMapper.selectByStorId(id);
        CheckedUtil.checkNoNull(storageDetailList,"待更新的出入库明细不存在");
        int total = 0;
        int size = storageDetailList.size();
        for (int i = 0; i < size; i++) {
            total = total + storageDetailList.get(i).getStdeQuantity();
        }
        Map<Integer, Integer> inventoryDetailMap = StorageUtil.conventStr2Map(inventory.getInveDetail());
        //入库
        if (original.getStorDirection() == STORAGE_INTO) {
            if (total > inventory.getInveTotal()) {
                throw new ValidationException("无法删除,主库存数量不足");
            }
        }

        for (int i = 0; i < size; i++) {
            StorageDetail storageDetail = storageDetailList.get(i);
            Integer dQuantity = storageDetail.getStdeQuantity();
            Integer iQuantity = inventoryDetailMap.get(storageDetail.getColId());
            Integer key = storageDetail.getColId();
            if (null == iQuantity) {
                throw new ValidationException("无法删除,主库存数量不足");
            }
            if (original.getStorDirection() == STORAGE_INTO) {
                if (dQuantity > iQuantity) {
                    throw new ValidationException("无法删除,主库存数量不足");
                } else {
                    inventoryDetailMap.put(key, iQuantity - dQuantity);
                }
                inventory.setInveTotal(inventory.getInveTotal() - total);
            } else {
                inventoryDetailMap.put(key, iQuantity + dQuantity);
                inventory.setInveTotal(inventory.getInveTotal() + total);
            }
        }
        inventory.setInveDetail(StorageUtil.conventMap2Str(inventoryDetailMap));
        inventoryMapper.updateDetailAndTotal(inventory);
        storageMapper.updateStatus(id,Status.DELETE.getCode());

    }

    @Override
    public StorageParam findById(Long id) {
        StorageParam param = new StorageParam().compat(storageMapper.selectByPrimaryKey(id));
        if (null != param.getId() && !"".equals(param.getId())) {
            param.setStorageDetailParams((new StorageDetailBo()).adapter
                    (storageDetailMapper.selectByStorId(param.getId())));
        }
        return param;
    }

    @Override
    public List<StorageDetail> findDetailById(Long id) {
        List<StorageDetail> storageDetails = storageDetailMapper.selectByStorId(id);
        CheckedUtil.checkNoNull(storageDetails, "找不到相应的出入库明细");
        return storageDetails;
    }

    @Override
    public PageResult<StorageParam> findByAll(PageQuery page) {
        PageResult<StorageParam> result = new PageResult<>();
        int count = storageMapper.count();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new StorageBo().adapter(storageMapper.selectByAll(page)));
        }
        return result;
    }

    @Override
    public PageResult<StorageParam> findLikeByKeyword(String keyword, PageQuery page) {
        PageResult<StorageParam> result = new PageResult<>();
        int count = storageMapper.countLikeByKeyword(keyword);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new StorageBo().adapter(storageMapper.selectLikeByKeyword(keyword,page)));
        }
        return result;
    }

    @Override
    public PageResult<StorageParam> findByEmpId(Long empId, PageQuery page) {
        PageResult<StorageParam> result = new PageResult<>();
        int count = storageMapper.countByEmpId(empId);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new StorageBo().adapter(storageMapper.selectByEmpId(empId,page)));
        }
        return result;
    }

    @Override
    public PageResult<StorageParam> findByWarId(Integer warId, PageQuery page) {
        PageResult<StorageParam> result = new PageResult<>();
        int count = storageMapper.countByWarId(warId);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new StorageBo().adapter(storageMapper.selectByWarId(warId,page)));
        }
        return result;
    }

    @Override
    public PageResult<StorageParam> findByTime(Date beginTime, Date endTime, PageQuery page) {
        PageResult<StorageParam> result = new PageResult<>();
        int count = storageMapper.countByTime(beginTime,endTime);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new StorageBo().adapter(storageMapper.selectByTime(beginTime,endTime,page)));
        }
        return result;
    }

    @Override
    public PageResult<StorageParam> findByDirection(Integer direction, PageQuery page) {
        PageResult<StorageParam> result = new PageResult<>();
        int count = storageMapper.countByDirection(direction);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new StorageBo().adapter(storageMapper.selectByDirection(direction,page)));
        }
        return result;
    }

    @Override
    public PageResult<StorageParam> findMultiCondition(PageQuery page, Integer warId, Integer direction,
                                                       String comName, Date beginTime, Date endTime) {
        PageResult<StorageParam> result = new PageResult<>();
        int count = storageMapper.countMultiCondition(warId,direction,comName,beginTime,endTime);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new StorageBo().adapter(storageMapper.selectMultiCondition(page,warId,direction,
                    comName,beginTime,endTime)));
        }
        return result;
    }

    /**
     * <h4>校验Integer 集合</h4>
     * @param linkedList
     */
    private void check(LinkedList<Integer> linkedList) {
        if (null == linkedList || linkedList.size() < 1) {
            throw new ValidationException("出入库明细不能为零条");
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            if (Regulation.regex(linkedList.get(i) + "", Regulation.REGEX_INT)) {
                throw new ValidationException("出入库明细数据格式错误");
            }
        }
    }

    /**
     * <h4>数组 转成 出入库明细集合</h4>
     * @param storageDetails 出入库明细集合
     * @param storId 出入库编号
     * @param colIds 颜色编号集合
     * @param quantities 数量集合
     */
    private void convent(List<StorageDetail> storageDetails ,Long storId ,LinkedList<Integer> colIds,
                         LinkedList<Integer> quantities) {
        int size = quantities.size();
        //添加总数
        StorageDetail storageDetail;
        for (int i = 0; i < size; i++) {
            storageDetail = new StorageDetail();
            storageDetail.setColId(colIds.get(i));
            storageDetail.setStdeQuantity(quantities.get(i));
            storageDetail.setStorId(storId);
            storageDetails.add(storageDetail);
        }
    }

    /**
     * <h4>检查对象</h4>
     * @param param
     */
    private void checked(StorageParam param) {
        Validation.check(param);
        if (null == param.getQuantities() || param.getQuantities().size() < 1 ||
                null == param.getColIds() || param.getColIds().size() < 1 ||
                param.getColIds().size() != param.getQuantities().size()){
            throw new ValidationException("出入库明细不能为零条");
        }
        check(param.getQuantities());
        check(param.getColIds());
    }

}
