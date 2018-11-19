package cn.peyton.spring.usergroup.entity;

import cn.peyton.spring.constant.UserType;
import cn.peyton.spring.def.BaseUser;
import cn.peyton.spring.inf.IUser;

import java.util.Date;

/**
 * <h3>管理员 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 16:05
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class SysAdmin{
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String name;
	/** 密码  */
	private String password;
	/** 状态，1为可用，0不可用，2为删除, 默认为1  */
	private Integer status;
	/** 创建时间  */
	private Date created;
	/** 最后登录时间  */
	private Date updated;
	/** 加密串  */
	private String adminEncrypt;
	/** 最后登录IP  */
	private String lastIp;
	/** 说明  */
	private String adminExplain;

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
	public void setCreated(Date created){
		this.created = created;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getCreated(){
		return created;
	}

	/** 
	 * @param updated 最后登录时间 
	 */ 
	public void setUpdated(Date updated){
		this.updated = updated;
	}

	/** 
	 * @return 最后登录时间 
	 */ 
	public Date getUpdated(){
		return updated;
	}

	/** 
	 * @param adminEncrypt 加密串 
	 */ 
	public void setAdminEncrypt(String adminEncrypt){
		this.adminEncrypt = adminEncrypt;
	}

	/** 
	 * @return 加密串 
	 */ 
	public String getAdminEncrypt(){
		return adminEncrypt;
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
	 * @param adminExplain 说明 
	 */ 
	public void setAdminExplain(String adminExplain){
		this.adminExplain = adminExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getAdminExplain(){
		return adminExplain;
	}

}
