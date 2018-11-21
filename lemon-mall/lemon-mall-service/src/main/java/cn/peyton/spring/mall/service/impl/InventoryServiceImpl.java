package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.mall.bo.InventoryBo;
import cn.peyton.spring.mall.entity.Inventory;
import cn.peyton.spring.mall.param.InventoryParam;
import cn.peyton.spring.mall.service.InventoryService;
import cn.peyton.spring.mall.dao.InventoryMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>库存主 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
	@Resource
	private InventoryMapper inventoryMapper;

    @Override
    public void save(InventoryParam param) {

    }

    @Override
    public void update(InventoryParam param) {

    }

    @Override
    public void updateDetailAndTotal(InventoryParam param) {

    }

    @Override
    public InventoryParam findById(Long id) {
        return new InventoryParam().compat(inventoryMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<InventoryParam> findByAll(PageQuery page) {
        PageResult<InventoryParam> result = new PageResult<>();
        int count = inventoryMapper.count();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new InventoryBo().adapter(inventoryMapper.selectByAll(page)));
        }
        return result;
    }

    @Override
    public InventoryParam findByComIdAndWarId(String comId, Integer warId) {
        return new InventoryParam().compat(inventoryMapper.selectByComIdAndWarId(comId,warId));
    }

    @Override
    public PageResult<InventoryParam> findByComId(String comId, PageQuery page) {
        PageResult<InventoryParam> result = new PageResult<>();
        int count = inventoryMapper.countByComId(comId);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new InventoryBo().adapter(inventoryMapper.selectByComId(comId,page)));
        }
        return result;
    }

    @Override
    public List<Inventory> findDisplayByComId(String comId) {
        return inventoryMapper.selectDisplayByComId(comId);
    }

    @Override
    public PageResult<InventoryParam> findByWarId(Integer warId, PageQuery page) {
        PageResult<InventoryParam> result = new PageResult<>();
        int count = inventoryMapper.countByWarId(warId);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new InventoryBo().adapter(inventoryMapper.selectByWarId(warId,page)));
        }
        return result;
    }

    @Override
    public PageResult<InventoryParam> findLikeByComName(String comName, PageQuery page) {
        PageResult<InventoryParam> result = new PageResult<>();
        int count = inventoryMapper.countLikeByKeyword(comName);
        if (count > 0) {
            result.setTotal(count);
            result.setData(new InventoryBo().adapter(inventoryMapper.selectLikeByKeyword(comName,page)));
        }
        return result;
    }
}
