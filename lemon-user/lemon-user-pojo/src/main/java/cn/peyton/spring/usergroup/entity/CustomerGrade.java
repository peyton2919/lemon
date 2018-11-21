package cn.peyton.spring.usergroup.entity;

/**
 * <h3>客户等级 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public class CustomerGrade{
	/** 编号  */
	private Integer id;
	/** 等级名称  */
	private String cugrName;
	/** 折扣率，默认100为百分之百  */
	private Integer cugrDr;

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
	 * @param cugrName 等级名称 
	 */ 
	public void setCugrName(String cugrName){
		this.cugrName = cugrName;
	}

	/** 
	 * @return 等级名称 
	 */ 
	public String getCugrName(){
		return cugrName;
	}

	/** 
	 * @param cugrDr 折扣率，默认100为百分之百 
	 */ 
	public void setCugrDr(Integer cugrDr){
		this.cugrDr = cugrDr;
	}

	/** 
	 * @return 折扣率，默认100为百分之百 
	 */ 
	public Integer getCugrDr(){
		return cugrDr;
	}

}
