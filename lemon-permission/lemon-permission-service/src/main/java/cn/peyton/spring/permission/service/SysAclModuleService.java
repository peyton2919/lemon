package cn.peyton.spring.permission.service;

import cn.peyton.spring.permission.param.AclModuleParam;

/**
 * <h3>权限模块 Service 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 21:11
 * @version: 1.0.0
 * </pre>
 */
public interface SysAclModuleService {

    /**
     * <h4>添加</h4>
     * @param param 权限模块对象
     */
    void save(AclModuleParam param);

    /**
     * <h4>更新</h4>
     * @param param 权限模块对象
     */
    void update(AclModuleParam param);

    /**
     * <h4>删除</h4>
     * @param aclModuleId 权限模块ID
     */
    void delete(int aclModuleId);

}
