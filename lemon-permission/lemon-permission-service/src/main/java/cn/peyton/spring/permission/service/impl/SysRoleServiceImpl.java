package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.permission.bo.RoleBo;
import cn.peyton.spring.permission.dao.SysRoleAclMapper;
import cn.peyton.spring.permission.dao.SysRoleMapper;
import cn.peyton.spring.permission.dao.SysRoleUserMapper;

import cn.peyton.spring.permission.dto.AclDto;
import cn.peyton.spring.permission.dto.AclModuleLevelDto;
import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.permission.entity.SysRole;
import cn.peyton.spring.permission.param.RoleParam;
import cn.peyton.spring.permission.service.SysRoleService;
import cn.peyton.spring.permission.service.log.SysRoleLog;
import cn.peyton.spring.usergroup.bo.EmployeeBo;
import cn.peyton.spring.usergroup.dao.SysEmployeeMapper;
import cn.peyton.spring.usergroup.param.EmployeeParam;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.validator.Validation;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <h3>角色 Service 实现类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 23:06
 * @version: 1.0.0
 * </pre>
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleUserMapper sysRoleUserMapper;
    @Resource
    private SysRoleAclMapper sysRoleAclMapper;
    @Resource
    private SysEmployeeMapper sysEmployeeMapper;

    @Resource
    private SysLogService sysLogService;
    @Resource
    private SysRoleLog sysRoleLog;

    /**
     * <h4>保存角色对象</h4>
     * @param param
     */
    @Override
    public void save(RoleParam param) {
        //参数校验
        Validation.check(param);
        if (checkExist(param.getName(), param.getId())) {
            throw new ParamException("角色名称已存在");
        }

        SysRole role = param.convert();
        role.setOperator(RequestHolder.getCurrentUser().getUserName());
        role.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        role.setOperateTime(new Date());
        sysRoleMapper.insertSelective(role);
        //日志操作
        sysLogService.save(null, role,sysRoleLog);
    }

    /**
     * <h4>更新角色对象</h4>
     * @param param
     */
    @Override
    public void update(RoleParam param) {
        //参数校验
        Validation.check(param);
        SysRole before = sysRoleMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的角色不存在");

        if ((!before.getName().equals(param.getName())) && checkExist(param.getName(), param.getId())) {
            throw new ParamException("角色名称已存在");
        }

        SysRole after = param.convert();
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        sysRoleMapper.updateByPrimaryKeySelective(after);
        //日志操作
        sysLogService.save(before,after,sysRoleLog);
    }

    /**
     * <h4>查找所有角色集合</h4>
     * @return
     */
    @Override
    public List<RoleParam> findByAll() {

        return new RoleBo().adapter(sysRoleMapper.selectByAll());
    }

    @Override
    public List<RoleParam> findRoleListByUserId(Integer userId) {
        List<Integer> roleIdList = sysRoleUserMapper.selectRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Lists.newArrayList();
        }
        return new RoleBo().adapter(sysRoleMapper.selectByIdList(roleIdList));
    }

    @Override
    public List<RoleParam> findRoleListByAclId(Integer aclId) {
        List<Integer> roleIdList = sysRoleAclMapper.selectRoleIdListByAclId(aclId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Lists.newArrayList();
        }
        return new RoleBo().adapter(sysRoleMapper.selectByIdList(roleIdList));
    }

    @Override
    public List<EmployeeParam> findUserListByRoleList(List<RoleParam> roleList) {
        if (CollectionUtils.isEmpty(roleList)) {
            return Lists.newArrayList();
        }
        List<Integer> roleIdList = roleList.stream()
                .map(role -> role.getId())
                .collect(Collectors.toList());
        List<Integer> userIdList = sysRoleUserMapper.selectUserIdListByRoleIdList(roleIdList);
        if (CollectionUtils.isEmpty(userIdList)) {
            return Lists.newArrayList();
        }
        return new EmployeeBo().adapter(sysEmployeeMapper.selectByIdList(userIdList));
    }


    /**
     * <h4>判断角色名称是否存在</h4>
     * @param name 角色名称
     * @param id 角色ID
     * @return 返回 true表示 存在
     */
    private boolean checkExist(String name, Integer id) {
        return sysRoleMapper.countByName(name,id) > 0;
    }


}
