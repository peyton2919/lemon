package cn.peyton.spring.usergroup.entity;

import java.util.Date;

/**
 * <h3>供应商 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/17 10:58:54
 * @version 1.0.0
 * </pre>
*/
public class Supplier {
	/** 编号  */
	private Long id;
	/** 供应商名称  */
	private String supName;
	/** 供应商登录名  */
	private String supLoginName;
	/** 供应商头像地址  */
	private String supAvatar;
	/** 密码  */
	private String supPwd;
	/** 电话  */
	private String supTel;
	/** 手机  */
	private String supPhone;
	/** 地址  */
	private String supAdd;
	/** qq  */
	private String supQq;
	/** 传真  */
	private String supFax;
	/** 邮箱  */
	private String supEmail;
	/** 登录次数  */
	private Integer supLoc;
	/** 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1  */
	private Integer supStatus;
	/** 创建时间  */
	private Date supCreated;
	/** 最后登录时间  */
	private Date supUpdated;
	/** 加密串  */
	private String supEncrypt;
	/** 最后登录IP  */
	private String supLastIp;
	/** 说明  */
	private String supExplain;
	/** 外接网址  */
	private String supWebSite;
	/** 连接外网标识码  */
	private String supWebCode;
	/** 经常使用，每点击一次加1  */
	private Integer supHot;

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
	 * @param supName 供应商名称 
	 */ 
	public void setSupName(String supName){
		this.supName = supName;
	}

	/** 
	 * @return 供应商名称 
	 */ 
	public String getSupName(){
		return supName;
	}

	/** 
	 * @param supLoginName 供应商登录名 
	 */ 
	public void setSupLoginName(String supLoginName){
		this.supLoginName = supLoginName;
	}

	/** 
	 * @return 供应商登录名 
	 */ 
	public String getSupLoginName(){
		return supLoginName;
	}

	/** 
	 * @param supAvatar 供应商头像地址 
	 */ 
	public void setSupAvatar(String supAvatar){
		this.supAvatar = supAvatar;
	}

	/** 
	 * @return 供应商头像地址 
	 */ 
	public String getSupAvatar(){
		return supAvatar;
	}

	/** 
	 * @param supPwd 密码 
	 */ 
	public void setSupPwd(String supPwd){
		this.supPwd = supPwd;
	}

	/** 
	 * @return 密码 
	 */ 
	public String getSupPwd(){
		return supPwd;
	}

	/** 
	 * @param supTel 电话 
	 */ 
	public void setSupTel(String supTel){
		this.supTel = supTel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getSupTel(){
		return supTel;
	}

	/** 
	 * @param supPhone 手机 
	 */ 
	public void setSupPhone(String supPhone){
		this.supPhone = supPhone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getSupPhone(){
		return supPhone;
	}

	/** 
	 * @param supAdd 地址 
	 */ 
	public void setSupAdd(String supAdd){
		this.supAdd = supAdd;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getSupAdd(){
		return supAdd;
	}

	/** 
	 * @param supQq qq 
	 */ 
	public void setSupQq(String supQq){
		this.supQq = supQq;
	}

	/** 
	 * @return qq 
	 */ 
	public String getSupQq(){
		return supQq;
	}

	/** 
	 * @param supFax 传真 
	 */ 
	public void setSupFax(String supFax){
		this.supFax = supFax;
	}

	/** 
	 * @return 传真 
	 */ 
	public String getSupFax(){
		return supFax;
	}

	/** 
	 * @param supEmail 邮箱 
	 */ 
	public void setSupEmail(String supEmail){
		this.supEmail = supEmail;
	}

	/** 
	 * @return 邮箱 
	 */ 
	public String getSupEmail(){
		return supEmail;
	}

	/** 
	 * @param supLoc 登录次数 
	 */ 
	public void setSupLoc(Integer supLoc){
		this.supLoc = supLoc;
	}

	/** 
	 * @return 登录次数 
	 */ 
	public Integer getSupLoc(){
		return supLoc;
	}

	/** 
	 * @param supStatus 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1
	 */ 
	public void setSupStatus(Integer supStatus){
		this.supStatus = supStatus;
	}

	/** 
	 * @return 状态，1为可用，0不可用，2为删除, 3 为申请中， 默认为1
	 */ 
	public Integer getSupStatus(){
		return supStatus;
	}

	/** 
	 * @param supCreated 创建时间 
	 */ 
	public void setSupCreated(Date supCreated){
		this.supCreated = supCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getSupCreated(){
		return supCreated;
	}

	/** 
	 * @param supUpdated 最后登录时间 
	 */ 
	public void setSupUpdated(Date supUpdated){
		this.supUpdated = supUpdated;
	}

	/** 
	 * @return 最后登录时间 
	 */ 
	public Date getSupUpdated(){
		return supUpdated;
	}

	/** 
	 * @param supEncrypt 加密串 
	 */ 
	public void setSupEncrypt(String supEncrypt){
		this.supEncrypt = supEncrypt;
	}

	/** 
	 * @return 加密串 
	 */ 
	public String getSupEncrypt(){
		return supEncrypt;
	}

	/** 
	 * @param supLastIp 最后登录IP 
	 */ 
	public void setSupLastIp(String supLastIp){
		this.supLastIp = supLastIp;
	}

	/** 
	 * @return 最后登录IP 
	 */ 
	public String getSupLastIp(){
		return supLastIp;
	}

	/** 
	 * @param supExplain 说明 
	 */ 
	public void setSupExplain(String supExplain){
		this.supExplain = supExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getSupExplain(){
		return supExplain;
	}

	/** 
	 * @param supWebSite 外接网址 
	 */ 
	public void setSupWebSite(String supWebSite){
		this.supWebSite = supWebSite;
	}

	/** 
	 * @return 外接网址 
	 */ 
	public String getSupWebSite(){
		return supWebSite;
	}

	/** 
	 * @param supWebCode 连接外网标识码 
	 */ 
	public void setSupWebCode(String supWebCode){
		this.supWebCode = supWebCode;
	}

	/** 
	 * @return 连接外网标识码 
	 */ 
	public String getSupWebCode(){
		return supWebCode;
	}

	/** 
	 * @param supHot 经常使用，每点击一次加1 
	 */ 
	public void setSupHot(Integer supHot){
		this.supHot = supHot;
	}

	/** 
	 * @return 经常使用，每点击一次加1 
	 */ 
	public Integer getSupHot(){
		return supHot;
	}

}
