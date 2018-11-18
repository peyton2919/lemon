package cn.peyton.spring.permission.service;

import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.permission.entity.SysRole;
import cn.peyton.spring.permission.param.RoleParam;

import java.util.List;

/**
 * <h3>角色 Service 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 21:13
 * @version: 1.0.0
 * </pre>
 */
public interface SysRoleService {
    /**
     * <h4>保存角色对象</h4>
     * @param param 角色参数 传递类对象
     */
    void save(RoleParam param) ;

    /**
     * <h4>更新角色对象</h4>
     * @param param 角色参数 传递类对象
     */
    void update(RoleParam param) ;

    /**
     * <h4>查找所有角色集合</h4>
     * @return 角色对象集合
     */
    List<SysRole> getAll();

    /**
     * <h4>根据 用户ID 获取 角色对象集合</h4>
     * @param userId 用户ID
     * @return 角色对象集合
     */
    List<SysRole> getRoleListByUserId(Integer userId);

    /**
     * <h4>根据权限ID 获取 角色对象集合</h4>
     * @param aclId 权限ID
     * @return 角色对象集合
     */
    List<SysRole> getRoleListByAclId(Integer aclId);

    /**
     * <h4>根据 角色对象集合 获取 用户对象集合</h4>
     * @param roleList 角色对象集合
     * @param type 用户类型 0 顾客; 1 供应商; 2 员工; 3 管理员; 默认 0
     * @return 用户对象集合
     */
    List<BaseUser> getUserListByRoleList(List<SysRole> roleList,Integer type);
}
