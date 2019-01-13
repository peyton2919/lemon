package cn.peyton.spring.usergroup.bo;

import cn.peyton.spring.def.BaseConvertBo;
import cn.peyton.spring.usergroup.entity.Supplier;
import cn.peyton.spring.usergroup.param.SupplierParam;

/**
 * <h3>供应商 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.SupplierConvertBo.java
 * @createDate: 2018/9/17 12:12
 * @version: 1.0.0
 * </pre>
 */
public class SupplierConvertBo extends BaseConvertBo<SupplierParam,Supplier> {
    @Override
    public SupplierParam compat(Supplier info) {
        return new SupplierParam().compat(info);
    }
}
