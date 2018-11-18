package cn.peyton.spring.permission.service.log;

import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.permission.dao.SysRoleMapper;
import cn.peyton.spring.permission.entity.SysRole;
import cn.peyton.spring.permission.entity.SysRoleUser;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.base.Preconditions;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>角色用户 日志类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.service.log.SysRoleUserLog.java
 * @createDate: 2018-11-18 23:16
 * @version: 1.0.0
 * </pre>
 */
@Component
public class SysRoleUserLog extends AbstractLogFactory<SysRoleUser> {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        SysRole userRole = sysRoleMapper.selectByPrimaryKey(Integer.valueOf(sysLog.getTargetId()));
        Preconditions.checkNotNull(userRole, "角色已经不存在了");
        sysRoleUserService.changeRoleUsers(sysLog.getTargetId().intValue(), JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<List<Long>>() {
        }));
    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysRoleUser before, SysRoleUser after) {
        sysLog.setType(LogType.TYPE_ROLE_USER);
        sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
    }
}
