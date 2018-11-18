package cn.peyton.spring.permission.entity;

import java.util.Date;

/**
 * <h3>权限 实体类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:09
 * @version: 1.0.0
 * </pre>
 */
public class SysAcl {
    /** 权限id */
    private Integer id;
    /** 权限码 */
    private String code;
    /** 权限名称 */
    private String name;
    /** 权限所在的权限模块id */
    private Integer aclModuleId;
    /** 请求的url, 可以填正则表达式 */
    private String url;
    /** 类型，1：菜单，2：按钮，3：其他 */
    private Integer type;
    /** 状态，1：正常，0：冻结 */
    private Integer status;
    /** 权限在当前模块下的顺序，由小到大 */
    private Integer seq;
    /** 备注 */
    private String remark;
    /** 操作者 */
    private String operator;
    /** 最后一次更新时间 */
    private Date operateTime;
    /** 最后一个更新者的ip地址 */
    private String operateIp;

    //================================== Constructor =======================================//


    //================================== Method =======================================//

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object obj) {
        return getId().equals(obj);
    }

    //================================== Method =======================================//

    //================================== GET AND SET =======================================//

    /**
     * @return 权限id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 权限id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 权限码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code 权限码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return 权限所在的权限模块id
     */
    public Integer getAclModuleId() {
        return aclModuleId;
    }

    /**
     * @param aclModuleId 权限所在的权限模块id
     */
    public void setAclModuleId(Integer aclModuleId) {
        this.aclModuleId = aclModuleId;
    }

    /**
     * @return 请求的url, 可以填正则表达式
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url 请求的url, 可以填正则表达式
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return 类型，1：菜单，2：按钮，3：其他
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type 类型，1：菜单，2：按钮，3：其他
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return 权限在当前模块下的顺序，由小到大
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param seq 权限在当前模块下的顺序，由小到大
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
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
     * @return 最后一次更新时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime 最后一次更新时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return 最后一个更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * @param operateIp 最后一个更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }
}