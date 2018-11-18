package cn.peyton.spring.usergroup.service.log;

import cn.peyton.spring.constant.LogType;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.log.dao.SysLogMapper;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.log.service.AbstractLogFactory;
import cn.peyton.spring.usergroup.dao.SysPostMapper;
import cn.peyton.spring.usergroup.entity.SysPost;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <h3>职务 日志 类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.usergroup.service.log.PostLog.java
 * @create date: 2018/11/17 15:11
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Component
public class PostLog extends AbstractLogFactory<SysPost> {
    @Resource
    private SysPostMapper sysPostMapper;
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void recover(SysLogWithBLOBs sysLog) {
        Integer postId;
        try {
            postId = Integer.parseInt(sysLog.getTargetId());
        } catch (Exception e) {
            throw new ParamException("职务编号转换错误!");
        }
        SysPost before = sysPostMapper.selectByPrimaryKey(postId);
        CheckedUtil.checkNoNull(before,"待还原职务已经不存在了");

        if (StringUtils.isBlank(sysLog.getNewValue()) || StringUtils.isBlank(sysLog.getOldValue())) {
            throw new ParamException("新增和删除操作不做还原");
        }
        SysPost after = JsonMapper.string2Obj(sysLog.getOldValue(), new TypeReference<SysPost>() {
        });

        sysPostMapper.updateByPrimaryKey(after);
        //保存日志
        save(sysLog,before,after,false);
    }

    @Override
    public void initObjectValue(SysLogWithBLOBs sysLog, SysPost before, SysPost after) {
        sysLog.setType(LogType.TYPE_POST);
        sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
    }
}
