package cn.peyton.spring.usergroup.service.log;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.dao.SysLogMapper;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.usergroup.dao.SysDeptMapper;
import cn.peyton.spring.usergroup.entity.SysDept;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>部门 日志 实现类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.usergroup.service.log.DeptLog.java
 * @create date: 2018/11/17 12:01
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Component
public class DeptLog extends AbstractLogFactory<SysDept> {
    @Resource
    private SysDeptMapper sysDeptMapper;
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        Integer deptId;
        try {
            deptId = Integer.parseInt(sysLog.getTargetId());
        } catch (Exception e) {
            throw new ParamException("部门编号转换错误!");
        }
        SysDept before = sysDeptMapper.selectByPrimaryKey(deptId);
        CheckedUtil.checkNoNull(before,"待还原部门已经不存在了");

        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ParamException("新增和删除操作不做还原");
        }
        SysDept after = JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<SysDept>() {
        });
        after.setOperator(RequestHolder.getCurrentUser().getUserName());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());
        sysDeptMapper.updateByPrimaryKey(after);
        //保存日志
        save(sysLog,before,after,false);

    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysDept before, SysDept after) {
        sysLog.setType(LogType.TYPE_DEPT);
        sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
    }
}
