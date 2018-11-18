package cn.peyton.spring.permission.service.log;

import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.permission.dao.SysRoleMapper;
import cn.peyton.spring.permission.entity.SysRole;
import cn.peyton.spring.permission.entity.SysRoleAcl;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.base.Preconditions;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>角色权限 日志类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.service.log.SysRoleAclLog.java
 * @createDate: 2018-11-18 23:11
 * @version: 1.0.0
 * </pre>
 */
@Component
public class SysRoleAclLog extends AbstractLogFactory<SysRoleAcl> {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        SysRole aclRole = sysRoleMapper.selectByPrimaryKey(Integer.valueOf(sysLog.getTargetId()));
        Preconditions.checkNotNull(aclRole, "角色已经不存在了");
        sysRoleAclService.changeRoleAcls(sysLog.getTargetId().intValue(), JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<List<Integer>>() {
        }));
    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysRoleAcl before, SysRoleAcl after) {
        sysLog.setType(LogType.TYPE_ROLE_ACL);
        sysLog.setTargetId(after == null ? String.valueOf(before.getAclId()) : String.valueOf(after.getAclId()));
    }
}
