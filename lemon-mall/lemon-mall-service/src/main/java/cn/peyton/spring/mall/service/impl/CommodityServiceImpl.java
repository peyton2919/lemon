package cn.peyton.spring.mall.service.impl;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.exception.TransactionalException;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.file.FolderOperation;
import cn.peyton.spring.img.ImageUtil;
import cn.peyton.spring.mall.bo.CommodityConvertBo;
import cn.peyton.spring.mall.dao.DeletePictureMapper;
import cn.peyton.spring.mall.entity.Commodity;
import cn.peyton.spring.mall.entity.DeletePicture;
import cn.peyton.spring.mall.param.CommodityParam;
import cn.peyton.spring.mall.service.CommodityService;
import cn.peyton.spring.mall.dao.CommodityMapper;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.UUIDUtil;
import cn.peyton.spring.validator.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <h3>商品 Service 实现类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/23 21:44:35
 * @version 1.0.0
 * </pre>
*/
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    /**  图片扩展名 */
    private final static String EXT = ".jpg";

	@Resource
	private CommodityMapper commodityMapper;
	@Resource
    private DeletePictureMapper deletePictureMapper;

    @Override
    public int updateHot(String id) {
        return commodityMapper.updateHot(id);
    }

    @Override
    public int updateImages(String id, String mainImg, String images) {
        return commodityMapper.updateImages(id,mainImg,images);
    }

    @Override
    public PageResult<CommodityParam> findByPriceBetween(PageQuery page, Integer type, BigDecimal min, BigDecimal max) {
        int count = commodityMapper.countPriceBetween(type, min, max);
        PageResult<CommodityParam> result = new PageResult<>();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new CommodityConvertBo().adapter(commodityMapper.selectByPriceBetween(page,type,min,max)));
        }
        return result;
    }

    @Override
    public PageResult<CommodityParam> findByOriId(PageQuery page, Integer oriId) {
        int count = commodityMapper.countOriId(oriId);
        PageResult<CommodityParam> result = new PageResult<>();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new CommodityConvertBo().adapter(commodityMapper.selectByOriId(page,oriId)));
        }
        return result;
    }

    @Override
    public PageResult<CommodityParam> findByCocaId(PageQuery page, Long cocaId) {
        int count = commodityMapper.countCocaId(cocaId);
        PageResult<CommodityParam> result = new PageResult<>();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new CommodityConvertBo().adapter(commodityMapper.selectByCocaId(page,cocaId)));
        }
        return result;
    }

    @Override
    public String findMainImgById(String id) {
        return commodityMapper.selectMainImgById(id);
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public void save(CommodityParam param) {
        Validation.check(param);
        if (null == param.getImgName()) {
            throw new ValidationException("主图片不能为空");
        }
        Commodity info = param.convert();
        info.setComCreated(new Date());
        info.setComUpdated(new Date());
        info.setId(UUID.randomUUID().toString());
        //主图片处理
        info.setComMainImg(param.getPrefixPath() + mainImageHandle(param.getImgFile(),param.getCompletePath()));
        //图片集合处理
        if (null != param.getFiles()) {
            info.setComImages(createPictureAndResultName(param.getFiles(), param.getCompletePath(), param.getPrefixPath()));
        }
        commodityMapper.insertSelective(info);
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public void update(CommodityParam param){
        Validation.check(param);
        if (null == param.getImgName()) {
            throw new ValidationException("主图片不能为空");
        }
        Commodity before = commodityMapper.selectByPrimaryKey(param.getId());
        CheckedUtil.checkNoNull(before, "待更新的商品不存在");
        Commodity after = param.convert();
        after.setComUpdated(new Date());
        //判断主图片名称相同就不做处理;不同时就重新保存图片，并把旧的主图片存到删除图片表中
        if ((param.getPrefixPath() + param.getImgName()).equals(before.getComMainImg())) {
            after.setComMainImg(before.getComMainImg());
        } else {
            after.setComMainImg(param.getPrefixPath() + mainImageHandle(param.getImgFile(),param.getCompletePath()));
            DeletePicture deletePicture = new DeletePicture(before.getComMainImg(),1);
            deletePictureMapper.insert(deletePicture);
        }
        //更新时没有图片集合时
        if (null == before.getComImages() || "".equals(before.getComImages())) {
            if (null != param.getFiles()) {
                after.setComImages(createPictureAndResultName(param.getFiles(), param.getCompletePath(), param.getPrefixPath()));
            }
        }else {
            //图片集合处理
            String[] splits = before.getComImages().split(",");
            int length = splits.length;
            int size = 0,maxSize = 0;
            String prefix = "";
            StringBuilder sb = new StringBuilder();
            if (length > 2) {
                maxSize = Integer.parseInt(splits[length - 2]) + 1;
                List<DeletePicture> deletePictures = new ArrayList<>();
                prefix = splits[0];
                String suffix = splits[length - 1];
                boolean exist;
                sb.append(prefix + ",");
                List<String> imageList = param.getImages();
                //当前存在的图片路径名称
                size = imageList.size();
                for (int i = 1; i < length - 1; i++) {
                    //名称
                    String tempName = prefix + splits[i] + suffix;
                    if (size == 0) {
                        deletePictures.add(new DeletePicture(tempName,1));
                    } else if (size > 0) {
                        exist = true;
                        for (int j = 0; j < size; j++) {
                            if (imageList.get(j).contains(tempName)) {
                                sb.append(splits[i] + ",");
                                exist = false;
                                break;
                            }
                        }
                        if (exist) {
                            deletePictures.add(new DeletePicture(tempName,1));
                        }
                    }
                }
                if (deletePictures.size() > 0) {
                    deletePictureMapper.batchInsert(deletePictures);
                }
            }
            if (null == param.getFiles() && size == 0) {
                sb = new StringBuilder();
            } else if (null == param.getFiles() && size > 0) {
                sb.append(EXT);
            }else {
                String tempPrefix = prefix.substring(prefix.lastIndexOf("/") + 1);
                imagesHandle(param.getFiles(),param.getCompletePath(),sb,tempPrefix,maxSize);
                sb.append(EXT);
            }
            after.setComImages(sb.toString());
        }
        commodityMapper.updateByPrimaryKeySelective(after);
    }

    /**
     * <h4>创建图片集合并返回名称</h4>
     * @param files 上传MultipartFile对象集合
     * @param completePath 完整路径
     * @param prefixPath 前缀路径
     * @return 名称
     */
    public String createPictureAndResultName(MultipartFile[] files,String completePath,String prefixPath) {
        String imgName = UUIDUtil.createUUID();
        StringBuilder sb = new StringBuilder(prefixPath + imgName);
        sb.append(",");
        imagesHandle(files,completePath,sb,imgName,0);
        sb.append(EXT);
        return sb.toString();
    }

    /**
     * <h4>主图片处理方法</h4>
     * @param mailFile 主图片 MultipartFile对象
     * @param completePath 完整路径
     * @return 图片完整名称路径
     */
    public String mainImageHandle( MultipartFile mailFile,String completePath) {
        String mainImgName = UUIDUtil.createUUID() + EXT;
        if (mailFile.getSize() > 0) {
            try {
                ImageUtil.scale(mailFile,completePath + mainImgName,480,480,true);
            } catch (Exception e) {
                FolderOperation.delFile(completePath + mainImgName);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚事务
                throw new GlobalException("主图片保存错误!");
            }
        }
        return mainImgName;
    }

    /**
     * <h4>图片集合处理</h4>
     * @param multipartFiles 图片文件对象集合
     * @param completePath 完整路径
     * @param sb  拼接名称
     */
    public void imagesHandle(MultipartFile[] multipartFiles,String completePath,
                               StringBuilder sb,String imgName,int imgBeginNum) {
        if (null != multipartFiles && multipartFiles.length > 0) {
            int length = multipartFiles.length + imgBeginNum;
            for (int i = imgBeginNum; i < length; i++) {
                sb.append(i);
                sb.append(",");
                String tempPath = completePath + imgName + i + EXT;
                try {
                    ImageUtil.scale(multipartFiles[i - imgBeginNum],tempPath,1,true);
                } catch (Exception e) {
                    for (int j = imgBeginNum; j <= i; j++) {
                        FolderOperation.delFile(completePath + imgName + j + EXT);
                    }
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚事务
                    throw new GlobalException("图片集合保存错误!");
                }
            }
        }
    }

    @Override
    public void delete(String id) {
        //todo 删除商品
        commodityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CommodityParam findById(String id) {
        return new CommodityParam().compat(commodityMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResult<CommodityParam> findByAll(PageQuery page) {
        int count = commodityMapper.count();
        PageResult<CommodityParam> result = new PageResult<CommodityParam>();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new CommodityConvertBo().adapter(commodityMapper.selectByAll(page)));
        }
        return result;
    }

    @Override
    public PageResult<CommodityParam> findLikeByKeyword(String keyword, PageQuery page) {
        int count = commodityMapper.countLikeByKeyword(keyword);
        PageResult<CommodityParam> result = new PageResult<CommodityParam>();
        if (count > 0) {
            result.setTotal(count);
            result.setData(new CommodityConvertBo().adapter(commodityMapper.selectLikeByKeyword(keyword,page)));
        }
        return result;
    }

    @Override
    public void updateStatus(String id, Integer status) {
        commodityMapper.updateStatus(id, status);
    }
}
