package cn.peyton.spring.log.entity;

import java.util.Date;

/**
 * <h3>权限日志 实体类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 10:27
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class SysLog {
    /** 日志ID */
    private Long id;
    /** 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系 */
    private Integer type;
    /**  基于type后指定的对象id，比如用户、权限、角色等表的主键 */
    private String targetId;
    /** 操作者 */
    private String operator;
    /** 最后一次更新的时间 */
    private Date operateTime;
    /** 最后一次更新者的ip地址 */
    private String operateIp;
    /** 当前是否复原过，0：没有，1：复原过 */
    private Integer status;

    //================================== Constructor =======================================//

    //================================== GET AND SET =======================================//
    /**
     * @return 日志ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 日志ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type 权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * @param targetId 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    /**
     * @return 操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator 操作者
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * @return 最后一次更新的时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime 最后一次更新的时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return 最后一次更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * @param operateIp 最后一次更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    /**
     * @return 当前是否复原过，0：没有，1：复原过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 当前是否复原过，0：没有，1：复原过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}