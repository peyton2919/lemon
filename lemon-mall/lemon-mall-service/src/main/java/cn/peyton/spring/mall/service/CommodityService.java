package cn.peyton.spring.mall.service;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceLike;
import cn.peyton.spring.inf.IServiceUpdateStatus;
import cn.peyton.spring.mall.entity.Commodity;
import cn.peyton.spring.mall.param.CommodityParam;

import java.math.BigDecimal;

/**
 * <h3>商品 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/23 21:44:35
 * @version 1.0.0
 * </pre>
*/
public interface CommodityService extends IService<String,CommodityParam,Commodity>,
        IServiceLike<CommodityParam>, IServiceUpdateStatus<String>{

    /**
     * <h4>根据商品编号 查找 主图片地址</h4>
     * @param id 商品编号
     * @return 主图片地址
     */
    String findMainImgById(String id);

    /**
     * <h4>更新热度{每点击一次+1}</h4>
     * @param id 商品编号
     * @return 受影响行数
     */
    int updateHot(String id);

    /**
     * <h4>更新图片{主图和图片}</h4>
     * @param id 商品编号
     * @param mainImg 主图片地址
     * @param images 图片集合
     * @return 受影响行数
     */
    int updateImages(String id, String mainImg, String images);

    /**
     * <h4>根据价格 查找 商品对象集合</h4>
     * @param page 分页对象
     * @param type 类型 这里指3种 {1:成本价; 2:零售价; 3:批发价}
     * @param min 最小单价
     * @param max 最大单价
     * @return 商品对象集合
     */
    PageResult<CommodityParam> findByPriceBetween(PageQuery page, Integer type, BigDecimal min, BigDecimal max);

    /**
     * <h4>根据 产地编号 查找 商品对象集合</h4>
     * @param page 分页对象
     * @param oriId 产地编号
     * @return 商品对象集合
     */
    PageResult<CommodityParam> findByOriId(PageQuery page, Integer oriId);

    /**
     * <h4>根据商品类目编号 查找 商品对象集合</h4>
     * @param page 分页对象
     * @param cocaId 商品类目编号
     * @return 商品对象集合
     */
    PageResult<CommodityParam> findByCocaId(PageQuery page, Long cocaId);

}
