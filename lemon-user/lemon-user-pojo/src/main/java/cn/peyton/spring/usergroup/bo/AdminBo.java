package cn.peyton.spring.usergroup.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.usergroup.entity.SysAdmin;
import cn.peyton.spring.usergroup.param.AdminParam;

/**
 * <h3>管理员 业务对象类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.usergroup.bo.AdminBo.java
 * @create date: 2018/11/20 9:23
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AdminBo extends BaseBo<AdminParam,SysAdmin> {
    @Override
    public AdminParam compat(SysAdmin info) {
        return new AdminParam().compat(info);
    }
}
