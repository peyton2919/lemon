package cn.peyton.spring.mall.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.mall.entity.Inventory;
import cn.peyton.spring.mall.param.InventoryParam;

/**
 * <h3>库存主 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.InventoryBo.java
 * @createDate: 2018/10/14 11:59
 * @version: 1.0.0
 * </pre>
 */
public class InventoryBo extends BaseBo<InventoryParam, Inventory> {

    @Override
    public InventoryParam compat(Inventory info) {
        return new InventoryParam().compat(info);
    }
}
