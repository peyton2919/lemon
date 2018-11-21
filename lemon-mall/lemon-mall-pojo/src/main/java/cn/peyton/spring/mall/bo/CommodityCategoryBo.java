package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.mall.entity.CommodityCategory;
import cn.peyton.spring.mall.param.CommodityCategoryParam;

/**
 * <h3>商品分类多层 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.CommodityCategoryBo.java
 * @createDate: 2018-09-13 22:21
 * @version: 1.0.0
 * </pre>
 */
public final class CommodityCategoryBo extends BaseBo<CommodityCategoryParam, CommodityCategory> {

    @Override
    public CommodityCategoryParam compat(CommodityCategory info) {
        return new CommodityCategoryParam().compat(info);
    }
}
