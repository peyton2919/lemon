package cn.peyton.spring.permission.service.log;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.permission.dao.SysRoleMapper;
import cn.peyton.spring.permission.entity.SysRole;
import cn.peyton.spring.permission.param.RoleParam;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.JsonMapper;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>角色 日志类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.permission.service.log.SysRoleLog.java
 * @createDate: 2018-11-18 23:06
 * @version: 1.0.0
 * </pre>
 */
@Component
public class SysRoleLog extends AbstractLogFactory<SysRole> {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        SysRole before = sysRoleMapper.selectByPrimaryKey(Integer.valueOf(sysLog.getTargetId()));
        CheckedUtil.checkNoNull(before, "待还原角色已经不存在了");
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ParamException("新增和删除操作不做还原");
        }
        SysRole after = JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<SysRole>() {
        });
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        sysRoleMapper.updateByPrimaryKey(after);
        save(sysLog,before,after,false);
    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysRole before, SysRole after) {
        sysLog.setType(LogType.TYPE_ROLE);
        sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
    }
}
