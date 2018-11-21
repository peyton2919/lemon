package cn.peyton.spring.basis.bo;

import cn.peyton.spring.basis.entity.Warehouse;
import cn.peyton.spring.basis.param.WarehouseParam;
import cn.peyton.spring.def.BaseBo;

/**
 * <h3>仓库 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.WarehouseBo.java
 * @createDate: 2018/9/13 16:29
 * @version: 1.0.0
 * </pre>
 */
public final class WarehouseBo extends BaseBo<WarehouseParam, Warehouse> {

    @Override
    public WarehouseParam compat(Warehouse info) {
        return new WarehouseParam().compat(info);
    }
}
