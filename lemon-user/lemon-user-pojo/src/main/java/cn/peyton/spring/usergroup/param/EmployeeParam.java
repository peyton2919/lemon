package cn.peyton.spring.usergroup.param;

import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.usergroup.entity.SysEmployee;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.validator.constraints.*;

/**
 * <h3>员工 参数 传递类[用来展示数据]</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 14:09
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class EmployeeParam {

    /** 编号  */
    private Long id;
    /** 名称  */
    @NotBlank(message = "员工名不可以为空")
    @Length(max = 50,message = "员工名长度需要在50个字以内")
    private String name;
    /** 登录名  */
    @NotBlank(message = "登录名不可以为空")
    @Length(max = 50,message = "登录名长度需要在50个字以内")
    private String loginName;
    /** 密码  */
    private String pwd;
    /** 电话  */
    @Length(max = 50,message = "电话长度需要在50个字以内")
    @Telephone
    private String tel;
    /** 手机  */
    @Length(max = 50,message = "手机长度需要在50个字以内")
    @Phone
    private String phone;
    /** 地址  */
    @Length(max = 100,message = "地址长度需要在100个字以内")
    private String add;
    /** qq  */
    @Length(max = 50,message = "QQ长度需要在50个字以内")
    @Pattern(regexp = Regulation.REGEX_QQ ,message = "QQ格式不正确")
    private String qq;
    /** 传真  */
    @Length(max = 50,message = "传真长度需要在50个字以内")
    @Pattern(regexp = Regulation.REGEX_TEL ,message = "传真格式不正确")
    private String fax;
    /** 邮箱  */
    @Length(max = 100,message = "邮箱长度需要在100个字以内")
    @Email
    private String email;
    /** 出生日期  格式 {yyyy/MM/dd yyyyMMdd yyyy-MM-dd} */
    @Date
    @Past
    private String birth;
    /** 身份证  */
    @Length(max = 20 , message = "身份证需要在20个字以内")
    @Pattern(regexp = Regulation.REGEX_IDENTITY,message = "身份证格式不正确!")
    private String identity;
    /** 部门编号——部门表  */
    @NotNull(message = "必需提供用户所在的部门")
    private Integer deptId;
    /** 职务编号  */
    @NotNull(message = "必需提供用户所在的职务")
    private Integer postId;
    /** 说明  */
    @Length(max = 250 ,message = "备注长度需要在250个字以内")
    private String explain;
    /** 登录次数  */
    private Integer loc;
    /** 创建时间  */
    private String created;
    /** 最后登录时间  */
    private String updated;
    /** 最后登录IP  */
    private String lastIp;
    /** 加密串 */
    private String encrypt;
    /**  状态 */
    private Integer status;

    //================================== Method =======================================//
    /**
     * <h4>对象转成SysEmployee对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,empName,empLoginName,empPwd,empTel,empPhone,empAdd,empQq,empFax,empEmail,empBirth,
     * 	 empIdentity,empLoc,empStatus,deptId,postId,empCreated,empUpdated,,empLastIp,empExplain]
     * </pre>
     */
    public SysEmployee convert(){
        SysEmployee sysEmployee = new SysEmployee();
        sysEmployee.setId(id);
        sysEmployee.setEmpName(name);
        sysEmployee.setEmpLoginName(loginName);
        sysEmployee.setEmpPwd(pwd);
        sysEmployee.setEmpTel(tel);
        sysEmployee.setEmpPhone(phone);
        sysEmployee.setEmpAdd(add);
        sysEmployee.setEmpQq(qq);
        sysEmployee.setEmpFax(fax);
        sysEmployee.setEmpEmail(email);
        sysEmployee.setEmpBirth(DateUtil.conventStr2Date(birth));
        sysEmployee.setEmpIdentity(identity);
        sysEmployee.setEmpLoc(loc);
        sysEmployee.setDeptId(deptId);
        sysEmployee.setPostId(postId);
        sysEmployee.setEmpCreated(DateUtil.conventStr2Date(created));
        sysEmployee.setEmpUpdated(DateUtil.conventStr2Date(updated));
        sysEmployee.setEmpLastIp(lastIp);
        sysEmployee.setEmpExplain(explain);
        sysEmployee.setEmpEncrypt(encrypt);
        sysEmployee.setEmpStatus(status);
        return sysEmployee;
    }

    /**
     * <h4>SysEmployee对象转成EmployeeParam对象</h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,empName,empLoginAme,empPwd,empTel,empPhone,empAdd,empQq,empFax,empEmail,
     * 	    empBirth,empIdentity,postId,deptId,empLoc,empLastIp,empCreated,empUpdated,empExplain]
     * </pre>
     * @param sysEmployee 员工对象
     * @return 员工传参对象
     */
    public EmployeeParam compat(SysEmployee sysEmployee){
        if(null == sysEmployee){
            return new EmployeeParam();
        }
        this.setId(sysEmployee.getId());
        this.setName(sysEmployee.getEmpName());
        this.setLoginName(sysEmployee.getEmpLoginName());
        this.setPwd(sysEmployee.getEmpPwd());
        this.setTel(sysEmployee.getEmpTel());
        this.setPhone(sysEmployee.getEmpPhone());
        this.setAdd(sysEmployee.getEmpAdd());
        this.setQq(sysEmployee.getEmpQq());
        this.setFax(sysEmployee.getEmpFax());
        this.setEmail(sysEmployee.getEmpEmail());
        this.setBirth(DateUtil.conventDate2Str(sysEmployee.getEmpBirth()));
        this.setIdentity(sysEmployee.getEmpIdentity());
        this.setLoc(sysEmployee.getEmpLoc());
        this.setDeptId(sysEmployee.getDeptId());
        this.setPostId(sysEmployee.getPostId());
        this.setCreated(DateUtil.conventDate2Str(sysEmployee.getEmpCreated()));
        this.setUpdated(DateUtil.conventDate2Str(sysEmployee.getEmpUpdated()));
        this.setLastIp(sysEmployee.getEmpLastIp());
        this.setExplain(sysEmployee.getEmpExplain());
        this.setEncrypt(sysEmployee.getEmpEncrypt());
        this.setStatus(sysEmployee.getEmpStatus());
        return this;
    }

    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @return 编号
     */
    public Long getId(){
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
     * @param loginName 登录名
     */
    public void setLoginName(String loginName){
        this.loginName = loginName;
    }

    /**
     * @return 登录名
     */
    public String getLoginName(){
        return loginName;
    }

    /**
     * @param pwd 密码
     */
    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    /**
     * @return 密码
     */
    public String getPwd(){
        return pwd;
    }

    /**
     * @param tel 电话
     */
    public void setTel(String tel){
        this.tel = tel;
    }

    /**
     * @return 电话
     */
    public String getTel(){
        return tel;
    }

    /**
     * @param phone 手机
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * @return 手机
     */
    public String getPhone(){
        return phone;
    }

    /**
     * @param add 地址
     */
    public void setAdd(String add){
        this.add = add;
    }

    /**
     * @return 地址
     */
    public String getAdd(){
        return add;
    }

    /**
     * @param qq qq
     */
    public void setQq(String qq){
        this.qq = qq;
    }

    /**
     * @return qq
     */
    public String getQq(){
        return qq;
    }

    /**
     * @param fax 传真
     */
    public void setFax(String fax){
        this.fax = fax;
    }

    /**
     * @return 传真
     */
    public String getFax(){
        return fax;
    }

    /**
     * @param email 邮箱
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * @return 邮箱
     */
    public String getEmail(){
        return email;
    }

    /**
     * @param birth 出生日期 格式: yyyy/MM/dd
     */
    public void setBirth(String birth){
        this.birth = birth;
    }

    /**
     * @return 出生日期 格式: yyyy/MM/dd
     */
    public String getBirth(){
        return birth;
    }

    /**
     * @param identity 身份证
     */
    public void setIdentity(String identity){
        this.identity = identity;
    }

    /**
     * @return 身份证
     */
    public String getIdentity(){
        return identity;
    }

    /**
     * @param loc 登录次数
     */
    public void setLoc(Integer loc){
        this.loc = loc;
    }

    /**
     * @return 登录次数
     */
    public Integer getLoc(){
        return loc;
    }

    /**
     * @param deptId 部门编号——部门表
     */
    public void setDeptId(Integer deptId){
        this.deptId = deptId;
    }

    /**
     * @return 部门编号——部门表
     */
    public Integer getDeptId(){
        return deptId;
    }

    /**
     * @param postId 职务编号
     */
    public void setPostId(Integer postId){
        this.postId = postId;
    }

    /**
     * @return 职务编号
     */
    public Integer getPostId(){
        return postId;
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

    /**
     * @return 加密串
     */
    public String getEncrypt() {
        return encrypt;
    }

    /**
     * @param encrypt 加密串
     */
    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    /**
     * @return  状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
