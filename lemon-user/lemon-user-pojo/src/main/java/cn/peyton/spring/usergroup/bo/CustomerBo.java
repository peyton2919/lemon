package cn.peyton.spring.usergroup.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.usergroup.entity.Customer;
import cn.peyton.spring.usergroup.param.CustomerParam;

/**
 * <h3>客户 业务对象类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.bo.CustomerBo.java
 * @createDate: 2018-11-04 21:41
 * @version: 1.0.0
 * </pre>
 */
public class CustomerBo extends BaseBo<CustomerParam,Customer> {
    @Override
    public CustomerParam compat(Customer info) {
        return new CustomerParam().compat(info);
    }
}
