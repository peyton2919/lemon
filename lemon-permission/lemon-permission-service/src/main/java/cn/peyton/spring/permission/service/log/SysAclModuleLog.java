package cn.peyton.spring.permission.service.log;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.permission.dao.SysAclModuleMapper;
import cn.peyton.spring.permission.entity.SysAclModule;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>权限模块 日志 类 </h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.service.log.SysAclModuleLog.java
 * @createDate: 2018-11-18 22:56
 * @version: 1.0.0
 * </pre>
 */
@Component
public class SysAclModuleLog extends AbstractLogFactory<SysAclModule> {

    @Resource
    private SysAclModuleMapper sysAclModuleMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        SysAclModule before = sysAclModuleMapper.selectByPrimaryKey(Integer.valueOf(sysLog.getTargetId()));
        CheckedUtil.checkNoNull(before, "待还原权限模块已经不存在了");
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ParamException("新增和删除操作不做还原");
        }
        SysAclModule after = JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<SysAclModule>() {
        });
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        sysAclModuleMapper.updateByPrimaryKey(after);
        save(sysLog,before,after,false);
    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysAclModule before, SysAclModule after) {
        sysLog.setType(LogType.TYPE_ACL_MODULE);
        sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
    }
}
