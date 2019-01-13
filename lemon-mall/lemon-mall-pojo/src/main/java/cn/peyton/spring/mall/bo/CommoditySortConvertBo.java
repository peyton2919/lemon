package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseConvertBo;
import cn.peyton.spring.mall.entity.CommoditySort;
import cn.peyton.spring.mall.param.CommoditySortParam;

/**
 * <h3>商品分类 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.CommoditySortConvertBo.java
 * @createDate: 2018/9/13 16:25
 * @version: 1.0.0
 * </pre>
 */
public final class CommoditySortConvertBo extends BaseConvertBo<CommoditySortParam, CommoditySort> {

    @Override
    public CommoditySortParam compat(CommoditySort info) {
        return new CommoditySortParam().compat(info);
    }
}
