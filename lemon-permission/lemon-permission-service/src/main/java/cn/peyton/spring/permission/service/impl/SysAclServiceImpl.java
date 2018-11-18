package cn.peyton.spring.permission.service.impl;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.log.service.SysLogService;
import cn.peyton.spring.permission.dao.SysAclMapper;
import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.permission.param.AclParam;
import cn.peyton.spring.permission.service.SysAclService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.permission.service.log.SysAclLog;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.validator.Validation;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <h3>权限 Service 实现类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 22:52
 * @version: 1.0.0
 * </pre>
 */
@Service("sysAclService")
public class SysAclServiceImpl implements SysAclService{

    @Resource
    private SysAclMapper sysAclMapper;
    @Resource
    private SysLogService sysLogService;
    @Resource
    private SysAclLog sysAclLog;

    /**
     * <h4></h4>
     * @param param
     */
    @Override
    public void save(AclParam param) {
        Validation.check(param);
        if (checkExist(param.getAclModuleId(), param.getName(), param.getId())) {
            throw new ParamException("当前权限模块下面存在相同名称的权限点");
        }
        SysAcl acl = param.convert();
        acl.setCode(generateCode());
        acl.setOperator(RequestHolder.getCurrentUser().getUserName());
        acl.setOperateTime(new Date());
        acl.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        sysAclMapper.insertSelective(acl);
        //日志操作
        sysLogService.save(null, acl,sysAclLog);
    }

    /**
     * <h4></h4>
     * @param param
     */
    @Override
    public void update(AclParam param) {
        Validation.check(param);
        if (checkExist(param.getAclModuleId(), param.getName(), param.getId())) {
            throw new ParamException("当前权限模块下面存在相同名称的权限点");
        }
        SysAcl before = sysAclMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的权限不存在");

        SysAcl after = param.convert();
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateTime(new Date());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        sysAclMapper.updateByPrimaryKeySelective(after);
        //日志操作
        sysLogService.save(before,after,sysAclLog);
    }

    @Override
    public PageResult<SysAcl> getPageByAclModuleId(Integer aclModuleId, PageQuery page) {
        Validation.check(page);
        int count = sysAclMapper.countByAclModuleId(aclModuleId);
        if (count > 0) {
            List<SysAcl> aclList = sysAclMapper.getPageByAclModuleId(aclModuleId, page);
            return new PageResult<SysAcl>(aclList,count);
        }
        return new PageResult<SysAcl>();
    }

    /**
     * <h4></h4>
     * @param aclModuleId
     * @param name
     * @param id
     * @return
     */
    private boolean checkExist(Integer aclModuleId, String name, Integer id) {

        return sysAclMapper.countByNameAndAclModuleId(aclModuleId,name,id) > 0;
    }

    /**
     * <h4>生成Code</h4>
     * @return
     */
    private String generateCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date()) + "_" + (int)(Math.random() * 100);
    }
}
