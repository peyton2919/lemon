package cn.peyton.spring.permission.service;

import cn.peyton.spring.permission.dto.AclModuleLevelDto;

import java.util.List;

/**
 * <h3>树结构 Service 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.service.SysTreeService.java
 * @createDate: 2018-11-19 19:55
 * @version: 1.0.0
 * </pre>
 */
public interface SysTreeService {

    /**
     * <h4>权限模块树</h4>
     * @return 权限模块 传递层对象集合
     */
    List<AclModuleLevelDto> aclModuleTree() ;

    /**
     * <h4>权限树</h4>
     * @param roleId 角色ID
     * @return 权限模块 传递层对象集合
     */
    List<AclModuleLevelDto> roleTree(Integer roleId) ;

    /**
     * <h4>用户权限树</h4>
     * @param userId 用户ID
     * @return 权限模块 传递层对象集合
     */
    List<AclModuleLevelDto> userAclTree(Integer userId);
}
