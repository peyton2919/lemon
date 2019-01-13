package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.permission.dao.SysAclMapper;
import cn.peyton.spring.permission.dao.SysAclModuleMapper;
import cn.peyton.spring.permission.entity.SysAclModule;
import cn.peyton.spring.permission.param.AclModuleParam;
import cn.peyton.spring.permission.service.SysAclModuleService;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.permission.service.log.SysAclModuleLog;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.LevelUtil;
import cn.peyton.spring.validator.Validation;
import com.google.common.base.Preconditions;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <h3>权限模块 Service 实现类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 22:30
 * @version: 1.0.0
 * </pre>
 */
@Service("sysAclModuleService")
public class SysAclModuleServiceImpl implements SysAclModuleService{
    @Resource
    private SysAclModuleMapper sysAclModuleMapper;
    @Resource
    private SysAclMapper sysAclMapper;
    @Resource
    private SysLogService sysLogService;
    @Resource
    private SysAclModuleLog sysAclModuleLog;

    /**
     * <h4></h4>
     * @param param
     */
    @Override
    public void save(AclModuleParam param) {
        Validation.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的权限模块");
        }
        SysAclModule aclModule = param.convert();
        aclModule.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()));
        aclModule.setOperator(RequestHolder.getCurrentUser().getUserName());
        aclModule.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        aclModule.setOperateTime(new Date());
        sysAclModuleMapper.insertSelective(aclModule);
        //日志操作
        sysLogService.save(null,aclModule,sysAclModuleLog);
    }

    /**
     * <h4></h4>
     * @param param
     */
    @Override
    public void update(AclModuleParam param) {
        Validation.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一级下存在相同名称的权限模块");
        }
        SysAclModule before = sysAclModuleMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的权限模块不存在");

        SysAclModule after = param.convert();
        after.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()));
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        updateWithChild(before,after);
        //日志操作
        sysLogService.save(before,after,sysAclModuleLog);
    }

    @Override
    public void delete(int aclModuleId) {
        SysAclModule aclModule = sysAclModuleMapper.selectByPrimaryKey(aclModuleId);
        Preconditions.checkNotNull(aclModule, "待删除权限模块不存在,无法删除");
        if (sysAclModuleMapper.countByParentId(aclModule.getId()) > 0) {
            throw new ParamException("当前模块下面有子模块,无法删除");
        }
        if (sysAclMapper.countByAclModuleId(aclModule.getId()) > 0) {
            throw new ParamException("当前模块下面有用户,无法删除");
        }
        sysAclModuleMapper.deleteByPrimaryKey(aclModule.getId());
    }

    /**
     * <h4></h4>
     * @param before
     * @param after
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateWithChild(SysAclModule before, SysAclModule after) {
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!after.getLevel().equals(before.getLevel())) {
            List<SysAclModule> aclModuleList = sysAclModuleMapper.selectChildAclModuleListByLevel(before.getLevel() + "." + before.getId());
            if (CollectionUtils.isNotEmpty(aclModuleList)) {
                for (SysAclModule aclModule : aclModuleList) {
                    String level = aclModule.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        aclModule.setLevel(level);
                    }
                }
                sysAclModuleMapper.batchUpdateLevel(aclModuleList);
            }
        }
        sysAclModuleMapper.updateByPrimaryKeySelective(after);
    }

    /**
     * <h4></h4>
     * @param parentId
     * @param aclModuleName
     * @param deptId
     * @return
     */
    private boolean checkExist(Integer parentId, String aclModuleName, Integer deptId) {

        return sysAclModuleMapper.countByNameAndParentId(parentId, aclModuleName, deptId) >0;
    }

    /**
     * <h4></h4>
     * @param aclModlueId
     * @return
     */
    private String getLevel(Integer aclModlueId) {
        SysAclModule aclModule = sysAclModuleMapper.selectByPrimaryKey(aclModlueId);
        if (aclModule == null) {
            return  null;
        }
        return aclModule.getLevel();
    }
}
