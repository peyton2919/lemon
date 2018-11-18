package cn.peyton.spring.usergroup.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.usergroup.entity.SysEmployee;
import cn.peyton.spring.usergroup.param.EmployeeParam;

/**
 * <h3>员工 业务对象类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.usergroup.bo.EmployeeBo.java
 * @create date: 2018/11/18 11:00
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class EmployeeBo extends BaseBo<EmployeeParam,SysEmployee> {
    @Override
    public EmployeeParam compat(SysEmployee info) {
        return new EmployeeParam().compat(info);
    }
}
