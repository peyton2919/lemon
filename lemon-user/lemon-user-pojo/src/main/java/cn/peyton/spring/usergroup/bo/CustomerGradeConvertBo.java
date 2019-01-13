package cn.peyton.spring.usergroup.bo;

import cn.peyton.spring.def.BaseConvertBo;
import cn.peyton.spring.usergroup.entity.CustomerGrade;
import cn.peyton.spring.usergroup.param.CustomerGradeParam;

/**
 * <h3>客户等级 业务对象类</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * Email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.mall.bo.CustomerGradeConvertBo.java
 * CreateDate: 2018/11/2 12:04
 * Version: 1.0.0
 * </pre>
 * @author peytonYu
 */
public class CustomerGradeConvertBo extends BaseConvertBo<CustomerGradeParam,CustomerGrade> {
    @Override
    public CustomerGradeParam compat(CustomerGrade info) {
        return new CustomerGradeParam().compat(info);
    }
}
