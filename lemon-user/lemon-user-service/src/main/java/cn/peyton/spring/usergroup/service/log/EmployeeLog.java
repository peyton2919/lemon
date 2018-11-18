package cn.peyton.spring.usergroup.service.log;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.dao.SysLogMapper;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.usergroup.dao.SysEmployeeMapper;
import cn.peyton.spring.usergroup.entity.SysEmployee;
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
 * <h3>员工 日志 类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.usergroup.service.log.EmployeeLog.java
 * @create date: 2018/11/17 15:22
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Component
public class EmployeeLog extends AbstractLogFactory<SysEmployee> {
    @Resource
    private SysLogMapper sysLogMapper;
    @Resource
    private SysEmployeeMapper sysEmployeeMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        Long employeeId;
        try {
            employeeId = Long.parseLong(sysLog.getTargetId());
        } catch (Exception e) {
            throw new ParamException("用户编号转换错误!");
        }
        SysEmployee before = sysEmployeeMapper.selectByPrimaryKey(employeeId);
        CheckedUtil.checkNoNull(before, "待还原用户已经不存在了");
        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ParamException("新增和删除操作不做还原");
        }
        SysEmployee after = JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<SysEmployee>() {
        });
        after.setEmpLastIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setEmpUpdated(new Date());
        sysEmployeeMapper.updateByPrimaryKey(after);
        save(sysLog,before,after,false);

    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysEmployee before, SysEmployee after) {
        sysLog.setType(LogType.TYPE_USER);
        sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
    }
}
