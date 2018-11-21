package cn.peyton.spring.mall.service;

import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceByLike;
import cn.peyton.spring.inf.IServiceBySelect;
import cn.peyton.spring.mall.entity.CommoditySort;
import cn.peyton.spring.mall.param.CommoditySortParam;

/**
 * <h3>商品分类 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
public interface CommoditySortService extends IService<Integer,CommoditySortParam,CommoditySort>,
        IServiceBySelect<CommoditySortParam>,IServiceByLike<CommoditySortParam> {

}
