package cn.peyton.spring.permission.param;

import cn.peyton.spring.permission.entity.SysRole;
import cn.peyton.spring.validator.constraints.*;

/**
 * <h3>角色参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate: 2018-11-18 20:17
 * @version: 1.0.0
 * </pre>
 */
public final class RoleParam {

    /** 角色ID */
    private Integer id;
    /** 名称 */
    @NotBlank(message = "角色名称不可以为空")
    @Length(min = 2, max = 20,message = "角色名称长度需要在2-20个字符之间")
    private String name;
    /** 角色的类型，1：管理员角色，2：其他 */
    @Min(value = 1, message = "角色类型不合法")
    @Max(value = 2, message = "角色类型不合法")
    private Integer type = 1;
    /** 状态，1：可用，0：冻结 */
    @NotNull(message = "必须指定权限点的状态")
    @Min(value = 0, message = "角色状态不合法")
    @Max(value = 1, message = "角色状态不合法")
    private Integer status;
    /** 备注 */
    @Length(min = 0 ,max = 256,message = "角色备注需要在256个字符以内")
    private String remark;

    //================================== Method =======================================//

    /**
     * <h4>RoleParam对象转成SysRole对象</h4>
     * <pre>
     * 	 转换字段如下: [id,name,type,status,remark]
     * </pre>
     * @return 角色对象
     */
    public SysRole convert() {
        SysRole role = new SysRole();
        role.setId(id);
        role.setName(name);
        role.setType(type);
        role.setStatus(status);
        role.setRemark(remark);
        return role;
    }

    /**
     * <h4>SysRole对象转成RoleParam对象</h4>
     * <pre>
     * 	 转换字段如下: [id,name,type,status,remark]
     * </pre>
     * @param role 角色对象
     * @return 角色传参对象
     */
    public RoleParam compat(SysRole role) {
        if (null == role) {
            return new RoleParam();
        }
        this.setId(role.getId());
        this.setName(role.getName());
        this.setType(role.getType());
        this.setStatus(role.getStatus());
        this.setRemark(role.getRemark());
        return this;
    }

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
}
