package cn.peyton.spring.permission.service;

import cn.peyton.spring.usergroup.param.EmployeeParam;

import java.util.List;

/**
 * <h3>角色用户 Service 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 21:13
 * @version: 1.0.0
 * </pre>
 */
public interface SysRoleUserService {

    /**
     * <h4>根据 角色ID 查找 用户集合</h4>
     * @param roleId 角色ID
     * @return 用户集合
     */
    List<EmployeeParam> findListByRoleId(Integer roleId);

    /**
     * <h4>更新角色用户对象集合</h4>
     * @param roleId 角色ID
     * @param userIdList 用户ID集合
     */
    void changeRoleUsers(int roleId, List<Integer> userIdList);
}
