package cn.peyton.spring.usergroup.entity;

import java.util.Date;

/**
 * <h3>客户 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public class Customer {
	/** 编号  */
	private Long id;
	/** 名称  */
	private String cusName;
	/** 登录名  */
	private String cusLoginName;
	/** 顾客头像地址  */
	private String cusAvatar;
	/** 密码  */
	private String cusPwd;
	/** 电话  */
	private String cusTel;
	/** 手机  */
	private String cusPhone;
	/** 地址  */
	private String cusAdd;
	/** qq  */
	private String cusQq;
	/** 传真  */
	private String cusFax;
	/** 邮箱  */
	private String cusEmail;
	/** 出生日期  */
	private Date cusBirth;
	/** 身份证  */
	private String cusIdentity;
	/** 登录次数  */
	private Integer cusLoc;
	/** 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1  */
	private Integer cusStatus;
	/** 经常使用，每点击一次加1  */
	private Integer cusHot;
	/** 地区编号  */
	private Long regiId;
	/** 顾客等级编号  */
	private Integer cugrId;
	/** 创建时间  */
	private Date cusCreated;
	/** 最后登录时间  */
	private Date cusUpdated;
	/** 取值范围 0为批发客户,1为零售客户 [默认为1]  */
	private Integer cusType;
	/** 加密串  */
	private String cusEncrypt;
	/** 最后登录IP  */
	private String cusLastIp;
	/** 说明  */
	private String cusExplain;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


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
	 * @param cusName 名称 
	 */ 
	public void setCusName(String cusName){
		this.cusName = cusName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getCusName(){
		return cusName;
	}

	/** 
	 * @param cusLoginName 登录名 
	 */ 
	public void setCusLoginName(String cusLoginName){
		this.cusLoginName = cusLoginName;
	}

	/** 
	 * @return 登录名 
	 */ 
	public String getCusLoginName(){
		return cusLoginName;
	}

	/** 
	 * @param cusAvatar 顾客头像地址 
	 */ 
	public void setCusAvatar(String cusAvatar){
		this.cusAvatar = cusAvatar;
	}

	/** 
	 * @return 顾客头像地址 
	 */ 
	public String getCusAvatar(){
		return cusAvatar;
	}

	/** 
	 * @param cusPwd 密码 
	 */ 
	public void setCusPwd(String cusPwd){
		this.cusPwd = cusPwd;
	}

	/** 
	 * @return 密码 
	 */ 
	public String getCusPwd(){
		return cusPwd;
	}

	/** 
	 * @param cusTel 电话 
	 */ 
	public void setCusTel(String cusTel){
		this.cusTel = cusTel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getCusTel(){
		return cusTel;
	}

	/** 
	 * @param cusPhone 手机 
	 */ 
	public void setCusPhone(String cusPhone){
		this.cusPhone = cusPhone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getCusPhone(){
		return cusPhone;
	}

	/** 
	 * @param cusAdd 地址 
	 */ 
	public void setCusAdd(String cusAdd){
		this.cusAdd = cusAdd;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getCusAdd(){
		return cusAdd;
	}

	/** 
	 * @param cusQq qq 
	 */ 
	public void setCusQq(String cusQq){
		this.cusQq = cusQq;
	}

	/** 
	 * @return qq 
	 */ 
	public String getCusQq(){
		return cusQq;
	}

	/** 
	 * @param cusFax 传真 
	 */ 
	public void setCusFax(String cusFax){
		this.cusFax = cusFax;
	}

	/** 
	 * @return 传真 
	 */ 
	public String getCusFax(){
		return cusFax;
	}

	/** 
	 * @param cusEmail 邮箱 
	 */ 
	public void setCusEmail(String cusEmail){
		this.cusEmail = cusEmail;
	}

	/** 
	 * @return 邮箱 
	 */ 
	public String getCusEmail(){
		return cusEmail;
	}

	/** 
	 * @param cusBirth 出生日期 
	 */ 
	public void setCusBirth(Date cusBirth){
		this.cusBirth = cusBirth;
	}

	/** 
	 * @return 出生日期 
	 */ 
	public Date getCusBirth(){
		return cusBirth;
	}

	/** 
	 * @param cusIdentity 身份证 
	 */ 
	public void setCusIdentity(String cusIdentity){
		this.cusIdentity = cusIdentity;
	}

	/** 
	 * @return 身份证 
	 */ 
	public String getCusIdentity(){
		return cusIdentity;
	}

	/** 
	 * @param cusLoc 登录次数 
	 */ 
	public void setCusLoc(Integer cusLoc){
		this.cusLoc = cusLoc;
	}

	/** 
	 * @return 登录次数 
	 */ 
	public Integer getCusLoc(){
		return cusLoc;
	}

	/** 
	 * @param cusStatus 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1
	 */ 
	public void setCusStatus(Integer cusStatus){
		this.cusStatus = cusStatus;
	}

	/** 
	 * @return 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1
	 */ 
	public Integer getCusStatus(){
		return cusStatus;
	}

	/** 
	 * @param cusHot 经常使用，每点击一次加1 
	 */ 
	public void setCusHot(Integer cusHot){
		this.cusHot = cusHot;
	}

	/** 
	 * @return 经常使用，每点击一次加1 
	 */ 
	public Integer getCusHot(){
		return cusHot;
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
	 * @param cusCreated 创建时间 
	 */ 
	public void setCusCreated(Date cusCreated){
		this.cusCreated = cusCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getCusCreated(){
		return cusCreated;
	}

	/** 
	 * @param cusUpdated 最后登录时间 
	 */ 
	public void setCusUpdated(Date cusUpdated){
		this.cusUpdated = cusUpdated;
	}

	/** 
	 * @return 最后登录时间 
	 */ 
	public Date getCusUpdated(){
		return cusUpdated;
	}

	/** 
	 * @param cusType 取值范围 0为批发客户,1为零售客户 [默认为1] 
	 */ 
	public void setCusType(Integer cusType){
		this.cusType = cusType;
	}

	/** 
	 * @return 取值范围 0为批发客户,1为零售客户 [默认为1] 
	 */ 
	public Integer getCusType(){
		return cusType;
	}

	/** 
	 * @param cusEncrypt 加密串 
	 */ 
	public void setCusEncrypt(String cusEncrypt){
		this.cusEncrypt = cusEncrypt;
	}

	/** 
	 * @return 加密串 
	 */ 
	public String getCusEncrypt(){
		return cusEncrypt;
	}

	/** 
	 * @param cusLastIp 最后登录IP 
	 */ 
	public void setCusLastIp(String cusLastIp){
		this.cusLastIp = cusLastIp;
	}

	/** 
	 * @return 最后登录IP 
	 */ 
	public String getCusLastIp(){
		return cusLastIp;
	}

	/** 
	 * @param cusExplain 说明 
	 */ 
	public void setCusExplain(String cusExplain){
		this.cusExplain = cusExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getCusExplain(){
		return cusExplain;
	}

}
