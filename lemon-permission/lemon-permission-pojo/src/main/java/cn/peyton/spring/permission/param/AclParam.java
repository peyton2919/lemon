package cn.peyton.spring.permission.param;

import cn.peyton.spring.permission.entity.SysAcl;
import cn.peyton.spring.permission.entity.SysAclModule;
import cn.peyton.spring.validator.constraints.*;

/**
 * <h3>权限参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:36
 * @version: 1.0.0
 * </pre>
 */
public final class AclParam {
    /** 权限id */
    private Integer id;
    /**
     * 权限名称
     */
    @NotBlank(message = "权限点名称不可以为空")
    @Length(min = 2, max = 20,message = "权限点名称长度需要在2-20个字符之间")
    private String name;
    /** 权限所在的权限模块id */
    @NotNull(message = "必须指定权限模块")
    private Integer aclModuleId;
    /** 请求的url, 可以填正则表达式 */
    @Length(min = 6 , max = 128 ,message = "权限点URL长度需要在6-128个字符之间")
    private String url;
    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    @NotNull(message = "必须指定权限点的类型")
    @Min(value = 1, message = "权限点类型不合法")
    @Max(value = 3, message = "权限点类型不合法")
    private Integer type;
    /** 状态，1：正常，0：冻结 */
    @NotNull(message = "必须指定权限点的状态")
    @Min(value = 0, message = "权限点状态不合法")
    @Max(value = 1, message = "权限点状态不合法")
    private Integer status;
    /** 权限在当前模块下的顺序，由小到大 */
    @NotNull(message = "必须指定权限点的展示顺序")
    private Integer seq;
    /** 备注 */
    @Length(min = 0 ,max = 256,message = "权限点备注需要在256个字符以内")
    private String remark;


    //================================== Method =======================================//

    /**
     * <h4>AclParam对象转成SysAcl对象</h4>
     * <pre>
     * 	 转换字段如下: [id,name,aclModuleId,url,type,seq,status,remark]
     * </pre>
     * @return 角色对象
     */
    public SysAcl convert() {
        SysAcl acl = new SysAcl();
        acl.setId(id);
        acl.setName(name);
        acl.setAclModuleId(aclModuleId);
        acl.setUrl(url);
        acl.setType(type);
        acl.setSeq(seq);
        acl.setStatus(status);
        acl.setRemark(remark);
        return acl;
    }

    /**
     * <h4>SysAcl对象转成AclParam对象</h4>
     * <pre>
     * 	 转换字段如下: [id,name,aclModuleId,url,type,seq,status,remark]
     * </pre>
     * @param acl 角色对象
     * @return 角色传参对象
     */
    public AclParam compat(SysAcl acl) {
        if (null == acl) {
            return new AclParam();
        }
        this.setId(acl.getId());
        this.setName(acl.getName());
        this.setAclModuleId(acl.getAclModuleId());
        this.setUrl(acl.getUrl());
        this.setType(acl.getType());
        this.setSeq(acl.getSeq());
        this.setStatus(acl.getStatus());
        this.setRemark(acl.getRemark());
        return this;
    }

    //================================== Constructor =======================================//


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

}
