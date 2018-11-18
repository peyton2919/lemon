package cn.peyton.spring.permission.service.log;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.permission.dao.SysAclMapper;
import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>权限 日志类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.service.log.SysAclLog.java
 * @createDate: 2018-11-18 22:33
 * @version: 1.0.0
 * </pre>
 */
@Component
public class SysAclLog extends AbstractLogFactory<SysAcl> {

    @Resource
    private SysAclMapper sysAclMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        SysAcl before = sysAclMapper.selectByPrimaryKey(Integer.valueOf(sysLog.getTargetId()));
        Preconditions.checkNotNull(before, "待还原权限点已经不存在了");
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ParamException("新增和删除操作不做还原");
        }
        SysAcl after = JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<SysAcl>() {
        });
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        sysAclMapper.updateByPrimaryKey(after);
        save(sysLog,before,after,false);
    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysAcl before, SysAcl after) {
        sysLog.setType(LogType.TYPE_ACL);
        sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
    }
}
