package cn.peyton.spring.log.service;

import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.log.dao.SysLogMapper;
import cn.peyton.spring.log.entity.SysLogWithBLOBs;
import cn.peyton.spring.util.IpUtil;
import cn.peyton.spring.util.JsonMapper;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <h3>抽象 日志 工厂类 .</h3>
 * <pre>
 *     保存日志，要实体这个抽象 类
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.log.service.AbstractLogFactory.java
 * @create date: 2018/11/17 10:55
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public abstract class AbstractLogFactory<T>{

    @Resource
    private SysLogMapper sysLogMapper;

    /**
     * <h4>数据还原</h4>
     * @param sysLog 日志对象
     */
    public abstract void recover(SysLogWithBLOBs sysLog);

    /**
     *<h4>初始化 SysLogWithBLOBs 中的[type , targetId] 这二个值 </h4>
     * <pre>
     *      sysLog.setType(LogType.TYPE_USER);
     *      sysLog.setTargetId(after == null ? String.valueOf(before.getId()) : String.valueOf(after.getId()));
     * </pre>
     * @param sysLog SysLogWithBLOBs 对象
     * @param before 之前对象
     * @param after 之后对象
     */
    public abstract void initObjectValue(SysLogWithBLOBs sysLog,T before,T after);




    /**
     * <h4>保存 日志</h4>
     * @param sysLog SysLogWithBLOBs 对象
     * @param before 旧的数据
     * @param after 新的数据
     * @param recovery 条件用来区分是保存与返原保存[true,false]
     */
    public  void save(SysLogWithBLOBs sysLog,T before, T after,boolean recovery){
        if(null == sysLog){
            sysLog = new SysLogWithBLOBs();
        }
        sysLog.setOldValue(before == null ? "" : JsonMapper.obj2String(before));
        sysLog.setNewValue(after == null ? "" : JsonMapper.obj2String(after));
        sysLog.setOperator(RequestHolder.getCurrentUser().getUserName());
        sysLog.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        sysLog.setOperateTime(new Date());
        sysLog.setStatus(recovery ? Holder.RECOVERY_NO : Holder.RECOVERY_YES);
        //调用抽象方法
        initObjectValue(sysLog,before,after);
        sysLogMapper.insertSelective(sysLog);
    };

    /**
     * <h3>AbstractLogFactory 支持 接口</h3>
     * <pre>
     * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
     * @create date: 2018/11/18 9:20
     * @author: <a href="http://www.peyton.cn">peyton</a>
     * @version: 1.0.0
     * </pre>
     */
    public interface Holder{
        /** 已经复原过 */
        int RECOVERY_YES = 1;
        /** 没有复原过 */
        int RECOVERY_NO = 0;
    }
}
