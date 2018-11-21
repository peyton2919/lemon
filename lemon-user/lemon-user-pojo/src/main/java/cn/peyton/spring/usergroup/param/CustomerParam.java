package cn.peyton.spring.usergroup.param;

import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.usergroup.entity.Customer;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Pattern;
import cn.peyton.spring.validator.constraints.Size;

/**
 * <h3>客户 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:36:15
 * @version 1.0.0
 * </pre>
*/
public class CustomerParam{
	/** 编号  */
	private Long id;
	/** 名称  */
    @NotBlank(message = "客户名称不能为空")
    @Length(max = 50,message = "客户长度不能超过50个字符")
	private String name;
	/** 登录名  */
    @NotBlank(message = "客户登录名名称不能为空")
    @Length(max = 50,message = "客户登录名长度不能超过50个字符")
	private String loginName;
	/** 顾客头像地址  */
    @Length(max = 150,message = "客户头像长度不能超过150个字符")
	private String avatar;
	/** 密码  */
	@NotBlank(message = "密码不能为空")
    @Length(min = 6,max =16,message = "密码长度为6-16个字符之间")
	private String pwd;
    /** 确认密码 */
    @NotBlank(message = "确认密码不能为空")
	private String confirmPwd;
	/** 电话  */
	@Pattern(regexp = Regulation.REGEX_TEL,message = "电话格式不正确")
    @Length(max = 50,message = "电话长度不能超过50个字符")
	private String tel;
	/** 手机  */
    @Pattern(regexp = Regulation.REGEX_PHONE,message = "手机格式不正确")
    @Length(max = 50,message = "手机长度不能超过50个字符")
	private String phone;
	/** 地址  */
    @Length(max = 100,message = "地址长度不能超过100个字符")
	private String add;
	/** qq  */
    @Pattern(regexp = Regulation.REGEX_QQ,message = "QQ格式不正确")
    @Length(max = 50,message = "QQ长度不能超过50个字符")
	private String qq;
	/** 传真  */
	@Pattern(regexp = Regulation.REGEX_TEL,message = "传真格式不正确")
    @Length(max = 50,message = "传真长度不能超过50个字符")
	private String fax;
	/** 邮箱  */
    @Pattern(regexp = Regulation.REGEX_EMAIL_ALL,message = "邮箱格式不正确")
    @Length(max = 100,message = "邮箱长度不能超过100个字符")
	private String email;
	/** 出生日期  */
    @Pattern(regexp = Regulation.REGEX_DATE,message = "出生日期格式不正确")
    @Length(max = 30,message = "出生日期长度不能超过30个字符")
	private String birth;
	/** 身份证  */
    @Pattern(regexp = Regulation.REGEX_IDENTITY,message = "身份证格式不正确")
    @Length(max = 20,message = "身份证长度不能超过20个字符")
	private String identity;
	/** 登录次数  */
	private Integer loc;
	/** 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1  */
	private Integer status;
	/** 经常使用，每点击一次加1  */
	private Integer hot;
	/** 地区编号  */
	@NotBlank(message = "请选择地区")
	private Long regiId;
	/** 顾客等级编号  */
    @NotBlank(message = "请选择客户等级")
	private Integer cugrId;
	/** 创建时间  */
	private String created;
	/** 最后登录时间  */
	private String updated;
	/** 取值范围 0为批发客户,1为零售客户 [默认为1]  */
	@Size(min = 0,max = 1,message = "客户类型不正确")
	private Integer type;
	/** 加密串  */
	private String encrypt;
	/** 最后登录IP  */
	private String lastIp;
	/** 说明  */
    @Length(max = 250,message = "说明长度不能超过250个字符")
	private String explain;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成CustomerInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cusName,cusLoginName,cusAvatar,cusPwd,cusTel,cusPhone,cusAdd,cusQq,cusFax,
     * 	 cusEmail,cusBirth,cusIdentity,cusLoc,cusStatus,cusHot,areaId,cugrId,
     * 	 cusCreated,cusUpdated,cusType,cusEncrypt,cusLastIp,cusExplain]
     * </pre>
     */
    public Customer convert(){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setCusName(name);
        customer.setCusLoginName(loginName);
        customer.setCusAvatar(avatar);
        customer.setCusPwd(pwd);
        customer.setCusTel(tel);
        customer.setCusPhone(phone);
        customer.setCusAdd(add);
        customer.setCusQq(qq);
        customer.setCusFax(fax);
        customer.setCusEmail(email);
        customer.setCusBirth(DateUtil.conventStr2Date(birth));
        customer.setCusIdentity(identity);
        customer.setCusLoc(loc);
        customer.setCusStatus(status);
        customer.setCusHot(hot);
        customer.setRegiId(regiId);
        customer.setCugrId(cugrId);
        customer.setCusCreated(DateUtil.conventStr2Date(created));
        customer.setCusUpdated(DateUtil.conventStr2Date(updated));
        customer.setCusType(type);
        customer.setCusEncrypt(encrypt);
        customer.setCusLastIp(lastIp);
        customer.setCusExplain(explain);
        return customer;
    }

    /**
     * <h4>CustomerInfo对象转成CustomerParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cusName,cusLoginName,cusAvatar,cusPwd,cusTel,cusPhone,cusAdd,cusQq,cusFax,
     * 	 cusEmail,cusBirth,cusIdentity,cusLoc,cusStatus,cusHot,areaId,cugrId,
     * 	 cusCreated,cusUpdated,cusType,cusEncrypt,cusLastIp,cusExplain]
     * </pre>
     */
    public CustomerParam compat(Customer customer){
        if(null == customer){
            return new CustomerParam();
        }
        this.id = customer.getId();
        this.name = customer.getCusName();
        this.loginName = customer.getCusLoginName();
        this.avatar = customer.getCusAvatar();
        this.pwd = customer.getCusPwd();
        this.tel = customer.getCusTel();
        this.phone = customer.getCusPhone();
        this.add = customer.getCusAdd();
        this.qq = customer.getCusQq();
        this.fax = customer.getCusFax();
        this.email = customer.getCusEmail();
        this.birth = DateUtil.conventDate2Str(customer.getCusBirth());
        this.identity = customer.getCusIdentity();
        this.loc = customer.getCusLoc();
        this.status = customer.getCusStatus();
        this.hot = customer.getCusHot();
        this.regiId = customer.getRegiId();
        this.cugrId = customer.getCugrId();
        this.created = DateUtil.conventDate2Str(customer.getCusCreated());
        this.updated = DateUtil.conventDate2Str(customer.getCusUpdated());
        this.type = customer.getCusType();
        this.encrypt = customer.getCusEncrypt();
        this.lastIp = customer.getCusLastIp();
        this.explain = customer.getCusExplain();
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
	 * @param avatar 顾客头像地址 
	 */ 
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	/** 
	 * @return 顾客头像地址 
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
     * @param confirmPwd  确认密码
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
	 * @param birth 出生日期 
	 */ 
	public void setBirth(String birth){
		this.birth = birth;
	}

	/** 
	 * @return 出生日期 
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

    /**
     * @param regiId 地区编号
     */
    public void setRegiId(Long regiId){
        this.regiId = regiId;
    }

    /**
     * @return 地区编号
     */
    public Long getRegiId(){
        return regiId;
    }

    /**
	 * @param cugrId 顾客等级编号 
	 */ 
	public void setCugrId(Integer cugrId){
		this.cugrId = cugrId;
	}

	/** 
	 * @return 顾客等级编号 
	 */ 
	public Integer getCugrId(){
		return cugrId;
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
	 * @param type 取值范围 0为批发客户,1为零售客户 [默认为1] 
	 */ 
	public void setType(Integer type){
		this.type = type;
	}

	/** 
	 * @return 取值范围 0为批发客户,1为零售客户 [默认为1] 
	 */ 
	public Integer getType(){
		return type;
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
