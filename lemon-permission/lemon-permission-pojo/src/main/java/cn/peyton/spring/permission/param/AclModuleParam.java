package cn.peyton.spring.permission.param;

import cn.peyton.spring.permission.entity.SysAclModule;
import cn.peyton.spring.validator.constraints.*;

/**
 * <h3>权限模块参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:28
 * @version: 1.0.0
 * </pre>
 */
public final class AclModuleParam {
    /** 权限模块ID  */
    private Integer id;
    /**  权限模块名称 */
    @NotBlank(message = "权限模块名称不可以为空")
    @Length(min = 2 , max = 20 , message = "权限模块名称长度需要在2-20个字之间")
    private String name;
    /**  上级权限模块id */
    private Integer parentId = 0;

    /**  权限模块在当前层级下的顺序，由小到大 */
    @NotNull(message = "权限模块展示顺序不可以为空")
    private Integer seq;
    /**
     * 状态，1：正常，0：冻结
     */
    @NotNull(message = "权限模块状态不可以为空")
    @Min(value = 0,message = "权限模块状态不合法")
    @Max(value = 1,message = "权限模块状态不合法")
    private Integer status;
    /**  备注 */
    @Length(max =256,message = "权限模块名称长度需要在256个字之内", min = 0)
    private String remark;


    //================================== Method =======================================//

    /**
     * <h4>AclModuleParam对象转成SysAclModule对象</h4>
     * <pre>
     * 	 转换字段如下: [id,name,parentId,seq,status,remark]
     * </pre>
     * @return 角色对象
     */
    public SysAclModule convert() {
        SysAclModule aclModule = new SysAclModule();
        aclModule.setId(id);
        aclModule.setName(name);
        aclModule.setParentId(parentId);
        aclModule.setSeq(seq);
        aclModule.setStatus(status);
        aclModule.setRemark(remark);
        return aclModule;
    }

    /**
     * <h4>SysAclModule对象转成AclModuleParam对象</h4>
     * <pre>
     * 	 转换字段如下: [id,name,parentId,seq,status,remark]
     * </pre>
     * @param aclModule 角色对象
     * @return 角色传参对象
     */
    public AclModuleParam compat(SysAclModule aclModule) {
        if (null == aclModule) {
            return new AclModuleParam();
        }
        this.setId(aclModule.getId());
        this.setName(aclModule.getName());
        this.setParentId(aclModule.getParentId());
        this.setSeq(aclModule.getSeq());
        this.setStatus(aclModule.getStatus());
        this.setRemark(aclModule.getRemark());
        return this;
    }

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

}
