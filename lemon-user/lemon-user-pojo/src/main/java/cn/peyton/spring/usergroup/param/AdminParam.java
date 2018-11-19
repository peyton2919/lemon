package cn.peyton.spring.usergroup.param;

import cn.peyton.spring.constant.UserType;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.inf.IUser;
import cn.peyton.spring.usergroup.entity.SysAdmin;
import cn.peyton.spring.util.DateUtil;

import java.util.Date;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: lemon
 * @class name: cn.peyton.spring.usergroup.param.AdminParam.java
 * @create date: 2018/11/19 9:32
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AdminParam extends BaseUser<Integer>{

    /** 编号  */
    private Integer id;
    /** 名称  */
    private String name;
    /** 密码  */
    private String password;
    /** 状态，1为可用，0不可用，2为删除, 默认为1  */
    private Integer status;
    /** 创建时间  */
    private String created;
    /** 最后登录时间  */
    private String updated;
    /** 加密串  */
    private String encrypt;
    /** 最后登录IP  */
    private String lastIp;
    /** 说明  */
    private String explain;

    //================================== Constructor =======================================//

    //================================== Method =======================================//

    @Override
    protected String abstractUserType() {
        return UserType.ADMIN.getValue();
    }

    @Override
    protected Integer abstractUserTypeValue() {
        return IUser.ADMIN_TYPE_NUM;
    }

    @Override
    protected String abstractUserName() {
        return getName();
    }

    @Override
    protected  Integer abstractPrimaryKey() {
        return getId();
    }

    /**
     * <h4>AdminParam对象转成SysAdmin对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,password,status,created,updated,adminEncrypt,lastIp,adminExplain]
     * </pre>
     */
    public SysAdmin convert(){
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setId(id);
        sysAdmin.setName(name);
        sysAdmin.setPassword(password);
        sysAdmin.setStatus(status);
        sysAdmin.setCreated(DateUtil.conventStr2Date(created));
        sysAdmin.setUpdated(DateUtil.conventStr2Date(updated));
        sysAdmin.setAdminEncrypt(encrypt);
        sysAdmin.setLastIp(lastIp);
        sysAdmin.setAdminExplain(explain);
        return sysAdmin;
    }

    /**
     * <h4>SysAdmin对象转成AdminParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,password,status,created,updated,adminEncrypt,lastIp,adminExplain]
     * </pre>
     */
    public AdminParam compat(SysAdmin sysAdmin){
        if(null == sysAdmin){
            return new AdminParam();
        }
        this.setId(sysAdmin.getId());
        this.setName(sysAdmin.getName());
        this.setPassword(sysAdmin.getPassword());
        this.setStatus(sysAdmin.getStatus());
        this.setCreated(DateUtil.conventDate2Str(sysAdmin.getCreated()));
        this.setUpdated(DateUtil.conventDate2Str(sysAdmin.getUpdated()));
        this.setEncrypt(sysAdmin.getAdminEncrypt());
        this.setLastIp(sysAdmin.getLastIp());
        this.setExplain(sysAdmin.getAdminExplain());
        return this;
    }


//================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * @return 编号
     */
    public Integer getId(){
        return id;
    }

    /**
     * @param name 名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return 名称
     */
    public String getName(){
        return name;
    }

    /**
     * @param password 密码
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * @return 密码
     */
    public String getPassword(){
        return password;
    }

    /**
     * @param status 状态，1为可用，0不可用，2为删除, 默认为1
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * @return 状态，1为可用，0不可用，2为删除, 默认为1
     */
    public Integer getStatus(){
        return status;
    }

    /**
     * @param created 创建时间
     */
    public void setCreated(String created){
        this.created = created;
    }

    /**
     * @return 创建时间
     */
    public String getCreated(){
        return created;
    }

    /**
     * @param updated 最后登录时间
     */
    public void setUpdated(String updated){
        this.updated = updated;
    }

    /**
     * @return 最后登录时间
     */
    public String getUpdated(){
        return updated;
    }

    /**
     * @param encrypt 加密串
     */
    public void setEncrypt(String encrypt){
        this.encrypt = encrypt;
    }

    /**
     * @return 加密串
     */
    public String getEncrypt(){
        return encrypt;
    }

    /**
     * @param lastIp 最后登录IP
     */
    public void setLastIp(String lastIp){
        this.lastIp = lastIp;
    }

    /**
     * @return 最后登录IP
     */
    public String getLastIp(){
        return lastIp;
    }

    /**
     * @param explain 说明
     */
    public void setExplain(String explain){
        this.explain = explain;
    }

    /**
     * @return 说明
     */
    public String getExplain(){
        return explain;
    }
}
