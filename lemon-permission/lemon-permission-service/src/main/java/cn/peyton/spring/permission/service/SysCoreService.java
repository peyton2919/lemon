package cn.peyton.spring.permission.service;

import cn.peyton.spring.permission.entity.SysAcl;

import java.util.List;

/**
 * <h3>主核心 Service 接口</h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * MailListener: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: perm
 * PackageName: cn.peyton.spring.perm.service.SysCoreService.java
 * CreateDate: 2018/7/5 12:11
 * Version: 1.0.0
 * </pre>
 */
public interface SysCoreService {

    /**
     * <h4>根据当前登录用户ID 获取 相应的权限点集合</h4>
     *
     * @return
     */
    List<SysAcl> getCurrentUserAclList();

    /**
     * <h4>角色ID 获取 角色权限</h4>
     *
     * @param roleId 角色ID
     * @return 权限点集合
     */
    List<SysAcl> getRoleAclList(Integer roleId);

    /**
     * <h4>根据用户ID 获取 权限对象集合</h4>
     * @param userId 用户ID
     * @return 权限对象集合
     */
    List<SysAcl> getUserAclList(Integer userId);

    /**
     * <h4>是否是超级管理员</h4>
     * @return 是管理员返回true
     */
    //boolean isSuperAdmin();

    /**
     * <h4>判断权限链接</h4>
     * @param url
     * @return
     */
    boolean hasUrlAcl(String url);
}
