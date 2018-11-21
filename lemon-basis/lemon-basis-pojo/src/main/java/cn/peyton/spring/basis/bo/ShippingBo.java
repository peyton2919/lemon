package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.Shipping;
import cn.peyton.spring.basis.param.ShippingParam;
import cn.peyton.spring.def.BaseBo;

/**
 * <h3>运输 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.ShippingBo.java
 * @createDate: 2018/9/13 16:28
 * @version: 1.0.0
 * </pre>
 */
public final class ShippingBo extends BaseBo<ShippingParam, Shipping> {

    @Override
    public ShippingParam compat(Shipping info) {
        return new ShippingParam().compat(info);
    }
}
