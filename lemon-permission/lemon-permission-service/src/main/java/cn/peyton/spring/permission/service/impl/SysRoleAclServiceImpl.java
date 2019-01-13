package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.log.dao.SysLogMapper;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.permission.dao.SysRoleAclMapper;
import cn.peyton.spring.permission.entity.SysRoleAcl;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.permission.service.SysRoleAclService;
import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * <h3>角色权限 Service 实现类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 23:12
 * @version: 1.0.0
 * </pre>
 */
@Service("sysRoleAclService")
public class SysRoleAclServiceImpl implements SysRoleAclService{
    @Resource
    private SysRoleAclMapper sysRoleAclMapper;
    @Resource
    private SysLogMapper sysLogMapper;


    @SuppressWarnings("Duplicates")
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void changeRoleAcls(Integer roleId, List<Integer> aclIdList) {
        List<Integer> originAclIdList = sysRoleAclMapper.selectAclIdListByRoleIdList(Lists.newArrayList(roleId));
        if (originAclIdList.size() == aclIdList.size()) {
            Set<Integer> originAclIdSet = Sets.newHashSet(originAclIdList);
            Set<Integer> aclIdSet = Sets.newHashSet(aclIdList);
            originAclIdSet.removeAll(aclIdSet);
            if (CollectionUtils.isEmpty(originAclIdSet)) {
                return;
            }
        }
        updateRoleAcls(roleId,aclIdList);
        saveRoleAclLog(roleId,originAclIdList,aclIdList);
    }

    /**
     * <h4>更新角色权限集合</h4>
     * <pre>
     *     先删除 再添加角色权限
     * </pre>
     * @param roleId 角色ID
     * @param aclIdList 权限ID集合
     */
    public void updateRoleAcls(int roleId,List<Integer> aclIdList) {
        sysRoleAclMapper.deleteByRoleId(roleId);
        if (CollectionUtils.isEmpty(aclIdList)) {
            return;
        }
        List<SysRoleAcl> roleAclList = Lists.newArrayList();
        String username = RequestHolder.getCurrentUser().getUserName();
        String ip = IpUtil.getRemoteIp(RequestHolder.getCurrentRequest());
        for (Integer aclId : aclIdList) {
            SysRoleAcl roleAcl = new SysRoleAcl();
            roleAcl.setRoleId(roleId);
            roleAcl.setAclId(aclId);
            roleAcl.setOperator(username);
            roleAcl.setOperateTime(new Date());
            roleAcl.setOperateIp(ip);
            roleAclList.add(roleAcl);
        }
        sysRoleAclMapper.batchInsert(roleAclList);
    }

    /**
     *  <h4>保存 角色权限日志</h4>
     * @param roleId 角色ID
     * @param before 旧的数据
     * @param after 新的数据
     */
    public void saveRoleAclLog(int roleId, List<Integer> before, List<Integer> after) {
        SysLogWithBLOBs sysLog = new SysLogWithBLOBs();
        sysLog.setType(LogType.TYPE_ROLE_ACL);
        sysLog.setTargetId(String.valueOf(roleId));
        sysLog.setOldValue(before == null ? "" : JsonMapper.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonMapper.obj2String(after));
        sysLog.setOperator(RequestHolder.getCurrentUser().getUserName());
        sysLog.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(Status.NORMAL.getCode());
        sysLogMapper.insertSelective(sysLog);
    }
}

