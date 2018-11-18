package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.permission.dao.SysRoleUserMapper;
import cn.peyton.spring.permission.entity.SysRoleUser;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.permission.service.SysRoleUserService;
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
 * <h3>角色用户 Service 实现类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 23:28
 * @version: 1.0.0
 * </pre>
 */
@Service("sysRoleUserService")
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysEmployeeMapper sysEmployeeMapper;
    @Resource
    private SysLogService sysLogService;

    @Override
    public List<SysEmployee> getListByRoleId(Integer roleId) {
        List<Integer> empIdList = sysRoleUserMapper.getUserIdListByRoleId(roleId);
        if (CollectionUtils.isEmpty(empIdList)) {
            return Lists.newArrayList();
        }
        return sysEmployeeMapper.selectByIdList(empIdList);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void changeRoleUsers(int roleId, List<Integer> userIdList) {
        List<Integer> originUserIdList = sysRoleUserMapper.getUserIdListByRoleId(roleId);
        if (originUserIdList.size() == userIdList.size()) {
            Set<Integer> originUserIdSet = Sets.newHashSet(originUserIdList);
            Set<Integer> userIdSet = Sets.newHashSet(userIdList);
            originUserIdSet.removeAll(userIdSet);
            if (CollectionUtils.isEmpty(originUserIdSet)) {
                return;
            }
        }
        updateRoleUsers(roleId, userIdList);
        saveRoleUserLog(roleId,originUserIdList,userIdList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    protected void updateRoleUsers(int roleId, List<Integer> userIdList) {
        sysRoleUserMapper.deleteByRoleId(roleId);
        if (CollectionUtils.isEmpty(userIdList)) {
            return;
        }
        List<SysRoleUser> roleUserList = Lists.newArrayList();
        for (Integer userId : userIdList) {
            SysRoleUser roleUser = new SysRoleUser(roleId,userId,
                    RequestHolder.getCurrentUser().getUserName(),new Date(),
                    IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
            roleUserList.add(roleUser);
        }
        sysRoleUserMapper.batchInsert(roleUserList);
    }
    /**
     *  <h4>保存 角色用户日志</h4>
     * @param roleId 角色ID
     * @param before 旧的数据
     * @param after 新的数据
     */
    private void saveRoleUserLog(int roleId, List<Integer> before, List<Integer> after) {
        SysLogWithBLOBs sysLog = new SysLogWithBLOBs();
        sysLog.setType(LogType.TYPE_ROLE_USER);
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
