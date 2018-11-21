package cn.peyton.spring.usergroup.param;

import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.usergroup.entity.Supplier;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.validator.constraints.*;

/**
 * <h3>供应商 参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/17 10:58:54
 * @version 1.0.0
 * </pre>
*/
public final class SupplierParam {
	/** 编号  */
	private Long id;
	/** 供应商名称  */
	@NotBlank(message = "名称不能为空")
    @Length(max = 50,message = "名称长度不能超出50个字符!")
	private String name;
	/** 供应商登录名  */
    @NotBlank(message = "登录名称不能为空")
    @Length(max = 50,message = "登录名称长度不能超出50个字符!")
	private String loginName;
	/** 供应商头像地址  */
    @Length(max = 150,message = "头像地址长度不能超出150个字符!")
	private String avatar;
	/** 密码  */
    @NotBlank(message = "密码不能为空")
    @Length(max = 30,message = "密码长度不能超出30个字符!")
	private String pwd;
    /** 确认密码 */
    /** 密码  */
    @NotBlank(message = "确认密码不能为空")
    @Length(max = 30,message = "确认密码长度不能超出30个字符!")
	private String confirmPwd;
	/** 电话  */
	@Telephone
	private String tel;
	/** 手机  */
	@Phone
	private String phone;
	/** 地址  */
	@Length(max = 100,message = "地址长度不能超出100个字符!")
	private String add;
	/** qq  */
	@Pattern(regexp = Regulation.REGEX_QQ,message = "QQ格式不正确!")
    @Length(max = 50,message = "QQ长度不能超出50个字符!")
	private String qq;
	/** 传真  */
	@Telephone
    @Length(max = 50,message = "传真长度不能超出50个字符!")
	private String fax;
	/** 邮箱  */
	@Pattern(regexp = Regulation.REGEX_EMAIL_ALL,message = "邮箱格式不正确!")
    @Length(max = 100,message = "传真长度不能超出100个字符!")
	private String email;
	/** 登录次数  */
	private Integer loc;
	/** 状态，1为可用，0不可用，2为删除, 3 为申请中，默认为1  */
	@Size(min = 0,max = 2,message = "状态值不正确!")
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
    @Length(max = 250,message = "说明长度不能超出250个字符!")
	private String explain;
	/** 外接网址  */
	private String webSite;
	/** 连接外网标识码  */
	private String webCode;
	/** 经常使用，每点击一次加1  */
	private Integer hot;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成SupplierInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,supName,supLoginName,supAvatar,supPwd,supTel,supPhone,supAdd,supQq,supFax,supEmail,supLoc,
     * 	 supStatus,supCreated,supUpdated,supEncrypt,supLastIp,supExplain,supWebSite,supWebCode,supHot]
     * </pre>
     */
    public Supplier convert(){
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setSupName(name);
        supplier.setSupLoginName(loginName);
        supplier.setSupAvatar(avatar);
        supplier.setSupPwd(pwd);
        supplier.setSupTel(tel);
        supplier.setSupPhone(phone);
        supplier.setSupAdd(add);
        supplier.setSupQq(qq);
        supplier.setSupFax(fax);
        supplier.setSupEmail(email);
        supplier.setSupLoc(loc);
        supplier.setSupStatus(status);
        supplier.setSupCreated(DateUtil.conventStr2Date(created));
        supplier.setSupUpdated(DateUtil.conventStr2Date(updated));
        supplier.setSupEncrypt(encrypt);
        supplier.setSupLastIp(lastIp);
        supplier.setSupExplain(explain);
        supplier.setSupWebSite(webSite);
        supplier.setSupWebCode(webCode);
        supplier.setSupHot(hot);
        return supplier;
    }

    /**
     * <h4>SupplierInfo对象转成SupplierParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,supName,supLoginName,supAvatar,supPwd,supTel,supPhone,supAdd,supQq,supFax,supEmail,supLoc,supStatus,
     * 	 supCreated,supUpdated,supEncrypt,supLastIp,supExplain,supWebSite,supWebCode,supHot]
     * </pre>
     */
    public SupplierParam compat(Supplier supplier){
        if(null == supplier){return new SupplierParam();}
        this.id = supplier.getId();
        this.name = supplier.getSupName();
        this.loginName = supplier.getSupLoginName();
        this.avatar = supplier.getSupAvatar();
        this.pwd = supplier.getSupPwd();
        this.tel = supplier.getSupTel();
        this.phone = supplier.getSupPhone();
        this.add = supplier.getSupAdd();
        this.qq = supplier.getSupQq();
        this.fax = supplier.getSupFax();
        this.email = supplier.getSupEmail();
        this.loc = supplier.getSupLoc();
        this.status = supplier.getSupStatus();
        this.created = DateUtil.conventDate2Str(supplier.getSupCreated());
        this.updated = DateUtil.conventDate2Str(supplier.getSupUpdated());
        this.encrypt = supplier.getSupEncrypt();
        this.lastIp = supplier.getSupLastIp();
        this.explain = supplier.getSupExplain();
        this.webSite = supplier.getSupWebSite();
        this.webCode = supplier.getSupWebCode();
        this.hot = supplier.getSupHot();
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
	 * @param name 供应商名称
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 供应商名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param loginName 供应商登录名
	 */ 
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}

	/** 
	 * @return 供应商登录名 
	 */ 
	public String getLoginName(){
		return loginName;
	}

	/** 
	 * @param avatar 供应商头像地址
	 */ 
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	/** 
	 * @return 供应商头像地址 
	 */ 
	public String getAvatar(){
		return avatar;
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
     * @return 确认密码
     */
    public String getConfirmPwd() {
        return confirmPwd;
    }

    /**
     * @param confirmPwd 确认密码
     */
    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
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
	 * @param status 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1
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

	/** 
	 * @param webSite 外接网址
	 */ 
	public void setWebSite(String webSite){
		this.webSite = webSite;
	}

	/** 
	 * @return 外接网址 
	 */ 
	public String getWebSite(){
		return webSite;
	}

	/** 
	 * @param webCode 连接外网标识码
	 */ 
	public void setWebCode(String webCode){
		this.webCode = webCode;
	}

	/** 
	 * @return 连接外网标识码 
	 */ 
	public String getWebCode(){
		return webCode;
	}

	/** 
	 * @param hot 经常使用，每点击一次加1
	 */ 
	public void setHot(Integer hot){
		this.hot = hot;
	}

	/** 
	 * @return 经常使用，每点击一次加1 
	 */ 
	public Integer getHot(){
		return hot;
	}

}
