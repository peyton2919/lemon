package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.permission.dao.SysAclMapper;
import cn.peyton.spring.permission.dao.SysRoleAclMapper;
import cn.peyton.spring.permission.dao.SysRoleUserMapper;
import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.permission.service.SysCacheService;
import cn.peyton.spring.permission.service.SysCoreService;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <h3>主核心 Service 实现类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-19 20:04
 * @version: 1.0.0
 * </pre>
 */
@Service("sysCoreService")
public class SysCoreServiceImpl implements SysCoreService{
    @Resource
    private SysAclMapper sysAclMapper;
    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysRoleAclMapper sysRoleAclMapper;
    @Resource
    private SysCacheService sysCacheService;


    /**
     * <h4>根据当前登录用户ID 获取 相应的权限点集合</h4>
     * @return
     */
    @Override
    public List<SysAcl> getCurrentUserAclList() {
        //获取当前登录的ID
        Integer userId = (Integer) RequestHolder.getCurrentUser().getPrimaryKey();
        return getUserAclList(userId);
    }

    /**
     * <h4>角色ID 获取 角色权限</h4>
     * @param roleId 角色ID
     * @return 权限点集合
     */
    @Override
    public List<SysAcl> getRoleAclList(Integer roleId) {
        List<Integer> list = new ArrayList<>();
        list.add(roleId);
        List<Integer> aclIdList = sysRoleAclMapper.selectAclIdListByRoleIdList(list);
        if (CollectionUtils.isEmpty(aclIdList)) {
            return new ArrayList<SysAcl>();
        }
        return sysAclMapper.selectByIdList(aclIdList);
    }

    /**
     * <h4>查询某个用户的所有权限</h4>
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<SysAcl> getUserAclList(Integer userId) {
        if (isSuperAdmin()) {
            return sysAclMapper.selectByAll();
        }
        List<Integer> userRoleIdList = sysRoleUserMapper.selectRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        List<Integer> userAclIdList = sysRoleAclMapper.selectAclIdListByRoleIdList(userRoleIdList);
        if (CollectionUtils.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        return sysAclMapper.selectByIdList(userAclIdList);
    }

    /**
     * <h4>是否是超级管理员</h4>
     * @return 是管理员返回true
     */

    protected boolean isSuperAdmin() {
        return true;
        //TODO
//        SysUser sysUser = ((SysUser)RequestHolder.getCurrentUser());
//        if (sysUser.getIsAdmin() == AdminStatus.YES.getCode()) {
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean hasUrlAcl(String url) {
        if (isSuperAdmin()) {
            return true;
        }
        List<SysAcl> aclList = sysAclMapper.selectByUrl(url);
        if (CollectionUtils.isEmpty(aclList)) {
            return true;
        }
        //先从缓存中获取
        List<SysAcl> userAclList = getCurrentUserAclListFormCache();
        Set<Integer> userAclSet = userAclList.stream().map(acl ->acl.getId()).collect(Collectors.toSet());
        //是否有效的权限点
        boolean hasValidAcl = false;

        //规则：只要有一个权限点有权限，那么我们就认为有访问权限
        for (SysAcl acl : aclList) {
            //判断一个用户是否具有某个权限点的访问权限
            //权限点无效
            if (acl == null || !Status.NORMAL.getCode().equals(acl.getStatus())) {
                continue;
            }
            hasValidAcl = true;
            if (userAclSet.contains(acl.getId())) {
                return true;
            }
        }
        if (!hasValidAcl) {
            return true;
        }
        return false;
    }

    /**
     * <h4>从缓存中获取权限</h4>
     * @return
     */
    private List<SysAcl> getCurrentUserAclListFormCache() {
        Integer userId = (Integer) RequestHolder.getCurrentUser().getPrimaryKey();
        String cacheValue = sysCacheService.getFromCache(Constants.USER_ACLS, String.valueOf(userId));
        if (StringUtils.isBlank(cacheValue)) {
            List<SysAcl> aclList = getCurrentUserAclList();
            if (CollectionUtils.isNotEmpty(aclList)) {
                sysCacheService.saveCache(JsonMapper.obj2String(aclList),600,Constants.USER_ACLS, String.valueOf(userId));
            }
            return aclList;
        }
        return JsonMapper.string2Obj(cacheValue,new TypeReference<List<SysAcl>>() {
        });
    }

}