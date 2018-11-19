package cn.peyton.spring.permission.bo;

import cn.peyton.spring.def.BaseBo;
import cn.peyton.spring.permission.entity.SysRole;
import cn.peyton.spring.permission.param.RoleParam;

/**
 * <h3>角色 业务对象类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.permission.bo.RoleBo.java
 * @create date: 2018/11/19 11:28
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class RoleBo extends BaseBo<RoleParam,SysRole>{
    @Override
    public RoleParam compat(SysRole info) {
        return new RoleParam().compat(info);
    }
}
