package cn.peyton.spring.permission.service;

import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.permission.param.AclParam;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;

/**
 * <h3>权限 Service 接口</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 21:12
 * @version: 1.0.0
 * </pre>
 */
public interface SysAclService {
    /**
     * <h4>保存</h4>
     * @param param
     */
    void save(AclParam param) ;

    /**
     * <h4>更新</h4>
     * @param param
     */
    void update(AclParam param);

    /**
     * <h4>根据权限模块ID 分页查找 权限对象集合</h4>
     * @param aclModuleId 权限模块ID
     * @param page 分页类
     * @return
     */
    PageResult<SysAcl> findPageByAclModuleId(Integer aclModuleId, PageQuery page);

}
