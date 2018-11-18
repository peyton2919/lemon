package cn.peyton.spring.usergroup.entity;

/**
 * <h3>职务 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 14:07:07
 * @version 1.0.0
 * </pre>
*/
public class SysPost{
	/** 编号  */
	private Integer id;
	/** 职务名称  */
	private String postName;
	/** 职务描述  */
	private String postExplain;

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
	 * @param postName 职务名称 
	 */ 
	public void setPostName(String postName){
		this.postName = postName;
	}

	/** 
	 * @return 职务名称 
	 */ 
	public String getPostName(){
		return postName;
	}

	/** 
	 * @param postExplain 职务描述 
	 */ 
	public void setPostExplain(String postExplain){
		this.postExplain = postExplain;
	}

	/** 
	 * @return 职务描述 
	 */ 
	public String getPostExplain(){
		return postExplain;
	}

}
