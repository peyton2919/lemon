package cn.peyton.spring.permission.entity;

import java.util.Date;

/**
 * <h3>角色 实体 类 .</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:14
 * @version: 1.0.0
 * </pre>
 */
public class SysRole {
    /** 角色ID */
    private Integer id;
    /** 名称 */
    private String name;
    /** 角色的类型，1：管理员角色，2：其他 */
    private Integer type;
    /** 状态，1：可用，0：冻结 */
    private Integer status;
    /** 备注 */
    private String remark;
    /** 操作者 */
    private String operator;
    /** 最后一次更新的时间 */
    private Date operateTime;
    /** 最后一次更新者的ip地址 */
    private String operateIp;

    //================================== Constructor =======================================//


    //================================== GET AND SET =======================================//
    /**
     * @return 角色ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 角色ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return 角色的类型，1：管理员角色，2：其他
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type 角色的类型，1：管理员角色，2：其他
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 状态，1：可用，0：冻结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态，1：可用，0：冻结
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}