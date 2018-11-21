package cn.peyton.spring.mall.entity;

/**
 * <h3> 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
public class CommoditySort{
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String cosName;
	/** 说明  */
	private String cosExplain;

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
	 * @param cosName 名称 
	 */ 
	public void setCosName(String cosName){
		this.cosName = cosName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getCosName(){
		return cosName;
	}

	/** 
	 * @param cosExplain 说明 
	 */ 
	public void setCosExplain(String cosExplain){
		this.cosExplain = cosExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getCosExplain(){
		return cosExplain;
	}

}
