package cn.peyton.spring.permission.entity;

import java.util.Date;

/**
 * <h3>权限模块 实体类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:13
 * @version: 1.0.0
 * </pre>
 */
public class SysAclModule {
    /** 权限模块ID  */
    private Integer id;
    /**  权限模块名称 */
    private String name;
    /**  上级权限模块ID */
    private Integer parentId;
    /** 权限模块层级  */
    private String level;
    /**  权限模块在当前层级下的顺序，由小到大 */
    private Integer seq;
    /**  状态，1：正常，0：冻结 */
    private Integer status;
    /**  备注 */
    private String remark;
    /**  操作者 */
    private String operator;
    /**  最后一次操作时间 */
    private Date operateTime;
    /**  最后一次更新操作者的ip地址 */
    private String operateIp;

    //================================== Constructor =======================================//


    //================================== GET AND SET =======================================//

    /**
     * @return 权限模块ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 权限模块ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 权限模块名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 权限模块名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return 上级权限模块id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId 上级权限模块id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return 权限模块层级
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level 权限模块层级
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * @return 权限模块在当前层级下的顺序，由小到大
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param seq 权限模块在当前层级下的顺序，由小到大
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * @return 状态，1：正常，0：冻结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态，1：正常，0：冻结
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
     * @return 最后一次操作时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime 最后一次操作时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return 最后一次更新操作者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * @param operateIp 最后一次更新操作者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }
}