package cn.peyton.spring.permission.entity;

import java.util.Date;

/**
 * <h3>角色权限 实体类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:15
 * @version: 1.0.0
 * </pre>
 */
public class SysRoleAcl {
    /** 角色权限ID */
    private Integer id;
    /** 角色ID */
    private Integer roleId;
    /** 权限ID */
    private Integer aclId;
    /** 操作者 */
    private String operator;
    /** 最后一次更新的时间 */
    private Date operateTime;
    /** 最后一次更新者的ip地址 */
    private String operateIp;

    //================================== Constructor =======================================//


    //================================== GET AND SET =======================================//

    /**
     * @return 角色权限ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 角色权限ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return 权限id
     */
    public Integer getAclId() {
        return aclId;
    }

    /**
     * @param aclId 权限id
     */
    public void setAclId(Integer aclId) {
        this.aclId = aclId;
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