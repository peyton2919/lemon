package cn.peyton.spring.basis.entity;

import java.util.Date;

/**
 * <h3>货运类型 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 12:07
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class FreightType{
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String frtName;
	/** 电话  */
	private String frtTel;
	/** 手机  */
	private String frtPhone;
	/** 传真  */
	private String frtFax;
	/** qq  */
	private String frtQq;
	/** 邮箱  */
	private String frtEmail;
	/** 地址  */
	private String frtAdd;
	/** 说明  */
	private String frtExplain;
	/** 创建时间  */
	private Date frtCreated;
	/** 最后登录时间  */
	private Date frtUpdated;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


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
	 * @param frtName 名称 
	 */ 
	public void setFrtName(String frtName){
		this.frtName = frtName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getFrtName(){
		return frtName;
	}

	/** 
	 * @param frtTel 电话 
	 */ 
	public void setFrtTel(String frtTel){
		this.frtTel = frtTel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getFrtTel(){
		return frtTel;
	}

	/** 
	 * @param frtPhone 手机 
	 */ 
	public void setFrtPhone(String frtPhone){
		this.frtPhone = frtPhone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getFrtPhone(){
		return frtPhone;
	}

	/** 
	 * @param frtFax 传真 
	 */ 
	public void setFrtFax(String frtFax){
		this.frtFax = frtFax;
	}

	/** 
	 * @return 传真 
	 */ 
	public String getFrtFax(){
		return frtFax;
	}

	/** 
	 * @param frtQq qq 
	 */ 
	public void setFrtQq(String frtQq){
		this.frtQq = frtQq;
	}

	/** 
	 * @return qq 
	 */ 
	public String getFrtQq(){
		return frtQq;
	}

	/** 
	 * @param frtEmail 邮箱 
	 */ 
	public void setFrtEmail(String frtEmail){
		this.frtEmail = frtEmail;
	}

	/** 
	 * @return 邮箱 
	 */ 
	public String getFrtEmail(){
		return frtEmail;
	}

	/** 
	 * @param frtAdd 地址 
	 */ 
	public void setFrtAdd(String frtAdd){
		this.frtAdd = frtAdd;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getFrtAdd(){
		return frtAdd;
	}

	/** 
	 * @param frtExplain 说明 
	 */ 
	public void setFrtExplain(String frtExplain){
		this.frtExplain = frtExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getFrtExplain(){
		return frtExplain;
	}

	/** 
	 * @param frtCreated 创建时间 
	 */ 
	public void setFrtCreated(Date frtCreated){
		this.frtCreated = frtCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getFrtCreated(){
		return frtCreated;
	}

	/** 
	 * @param frtUpdated 最后登录时间 
	 */ 
	public void setFrtUpdated(Date frtUpdated){
		this.frtUpdated = frtUpdated;
	}

	/** 
	 * @return 最后登录时间 
	 */ 
	public Date getFrtUpdated(){
		return frtUpdated;
	}

}
