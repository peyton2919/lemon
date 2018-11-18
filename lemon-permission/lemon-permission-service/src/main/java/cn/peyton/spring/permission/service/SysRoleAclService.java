package cn.peyton.spring.permission.service;

import java.util.List;

/**
 * <h3>角色权限 Service 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 21:12
 * @version: 1.0.0
 * </pre>
 */
public interface SysRoleAclService {

    /**
     * <h4>改变角色权限</h4>
     * @param roleId 角色ID
     * @param aclIdList 权限ID 集合
     */
    void changeRoleAcls(Integer roleId, List<Integer> aclIdList);
}
