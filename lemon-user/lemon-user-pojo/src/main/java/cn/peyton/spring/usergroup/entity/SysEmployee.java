package cn.peyton.spring.usergroup.entity;

import java.util.Date;

/**
 * <h3>员工 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 14:07:07
 * @version 1.0.0
 * </pre>
*/
public class SysEmployee{
	/** 编号  */
	private Long id;
	/** 名称  */
	private String empName;
	/** 登录名  */
	private String empLoginName;
	/** 密码  */
	private String empPwd;
	/** 电话  */
	private String empTel;
	/** 手机  */
	private String empPhone;
	/** 地址  */
	private String empAdd;
	/** qq  */
	private String empQq;
	/** 传真  */
	private String empFax;
	/** 邮箱  */
	private String empEmail;
	/** 出生日期 格式: yyyy/MM/dd  */
	private Date empBirth;
	/** 身份证  */
	private String empIdentity;
	/** 登录次数  */
	private Integer empLoc;
	/** 状态，1为可用，0不可用，2为删除, 默认为1  */
	private Integer empStatus;
	/** 部门编号——部门表  */
	private Integer deptId;
	/** 职务编号  */
	private Integer postId;
	/** 创建时间  */
	private Date empCreated;
	/** 最后登录时间  */
	private Date empUpdated;
	/** 加密串  */
	private String empEncrypt;
	/** 最后登录IP  */
	private String empLastIp;
	/** 说明  */
	private String empExplain;

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
	 * @param empName 名称 
	 */ 
	public void setEmpName(String empName){
		this.empName = empName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getEmpName(){
		return empName;
	}

	/** 
	 * @param empLoginName 登录名 
	 */ 
	public void setEmpLoginName(String empLoginName){
		this.empLoginName = empLoginName;
	}

	/** 
	 * @return 登录名 
	 */ 
	public String getEmpLoginName(){
		return empLoginName;
	}

	/** 
	 * @param empPwd 密码 
	 */ 
	public void setEmpPwd(String empPwd){
		this.empPwd = empPwd;
	}

	/** 
	 * @return 密码 
	 */ 
	public String getEmpPwd(){
		return empPwd;
	}

	/** 
	 * @param empTel 电话 
	 */ 
	public void setEmpTel(String empTel){
		this.empTel = empTel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getEmpTel(){
		return empTel;
	}

	/** 
	 * @param empPhone 手机 
	 */ 
	public void setEmpPhone(String empPhone){
		this.empPhone = empPhone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getEmpPhone(){
		return empPhone;
	}

	/** 
	 * @param empAdd 地址 
	 */ 
	public void setEmpAdd(String empAdd){
		this.empAdd = empAdd;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getEmpAdd(){
		return empAdd;
	}

	/** 
	 * @param empQq qq 
	 */ 
	public void setEmpQq(String empQq){
		this.empQq = empQq;
	}

	/** 
	 * @return qq 
	 */ 
	public String getEmpQq(){
		return empQq;
	}

	/** 
	 * @param empFax 传真 
	 */ 
	public void setEmpFax(String empFax){
		this.empFax = empFax;
	}

	/** 
	 * @return 传真 
	 */ 
	public String getEmpFax(){
		return empFax;
	}

	/** 
	 * @param empEmail 邮箱 
	 */ 
	public void setEmpEmail(String empEmail){
		this.empEmail = empEmail;
	}

	/** 
	 * @return 邮箱 
	 */ 
	public String getEmpEmail(){
		return empEmail;
	}

	/** 
	 * @param empBirth 出生日期 格式: yyyy/MM/dd 
	 */ 
	public void setEmpBirth(Date empBirth){
		this.empBirth = empBirth;
	}

	/** 
	 * @return 出生日期 格式: yyyy/MM/dd 
	 */ 
	public Date getEmpBirth(){
		return empBirth;
	}

	/** 
	 * @param empIdentity 身份证 
	 */ 
	public void setEmpIdentity(String empIdentity){
		this.empIdentity = empIdentity;
	}

	/** 
	 * @return 身份证 
	 */ 
	public String getEmpIdentity(){
		return empIdentity;
	}

	/** 
	 * @param empLoc 登录次数 
	 */ 
	public void setEmpLoc(Integer empLoc){
		this.empLoc = empLoc;
	}

	/** 
	 * @return 登录次数 
	 */ 
	public Integer getEmpLoc(){
		return empLoc;
	}

	/** 
	 * @param empStatus 状态，1为可用，0不可用，2为删除, 默认为1 
	 */ 
	public void setEmpStatus(Integer empStatus){
		this.empStatus = empStatus;
	}

	/** 
	 * @return 状态，1为可用，0不可用，2为删除, 默认为1 
	 */ 
	public Integer getEmpStatus(){
		return empStatus;
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
	 * @param empCreated 创建时间 
	 */ 
	public void setEmpCreated(Date empCreated){
		this.empCreated = empCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getEmpCreated(){
		return empCreated;
	}

	/** 
	 * @param empUpdated 最后登录时间 
	 */ 
	public void setEmpUpdated(Date empUpdated){
		this.empUpdated = empUpdated;
	}

	/** 
	 * @return 最后登录时间 
	 */ 
	public Date getEmpUpdated(){
		return empUpdated;
	}

	/** 
	 * @param empEncrypt 加密串 
	 */ 
	public void setEmpEncrypt(String empEncrypt){
		this.empEncrypt = empEncrypt;
	}

	/** 
	 * @return 加密串 
	 */ 
	public String getEmpEncrypt(){
		return empEncrypt;
	}

	/** 
	 * @param empLastIp 最后登录IP 
	 */ 
	public void setEmpLastIp(String empLastIp){
		this.empLastIp = empLastIp;
	}

	/** 
	 * @return 最后登录IP 
	 */ 
	public String getEmpLastIp(){
		return empLastIp;
	}

	/** 
	 * @param empExplain 说明 
	 */ 
	public void setEmpExplain(String empExplain){
		this.empExplain = empExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getEmpExplain(){
		return empExplain;
	}

}
