package cn.peyton.spring.mall.service;

import cn.peyton.spring.inf.IService;
import cn.peyton.spring.inf.IServiceLike;
import cn.peyton.spring.inf.IServiceBySelect;
import cn.peyton.spring.mall.entity.CommodityCategory;
import cn.peyton.spring.mall.param.CommodityCategoryParam;

import java.util.List;

/**
 * <h3>商品类目 Service 接口 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/14 11:25:12
 * @version 1.0.0
 * </pre>
*/
public interface CommodityCategoryService extends IService<Long,CommodityCategoryParam,CommodityCategory>,
        IServiceBySelect<CommodityCategoryParam>,IServiceLike<CommodityCategoryParam> {

    /**
     * <h4>树结构</h4>
     * @return
     */
    List<CommodityCategoryParam> tree();

}
