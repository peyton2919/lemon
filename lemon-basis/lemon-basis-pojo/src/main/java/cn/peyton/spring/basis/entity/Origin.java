package cn.peyton.spring.basis.entity;

/**
 * <h3>产地 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
public class Origin {
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String oriName;
	/** 描述  */
	private String oriExplain;

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
	 * @param oriName 名称 
	 */ 
	public void setOriName(String oriName){
		this.oriName = oriName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getOriName(){
		return oriName;
	}

	/** 
	 * @param oriExplain 描述 
	 */ 
	public void setOriExplain(String oriExplain){
		this.oriExplain = oriExplain;
	}

	/** 
	 * @return 描述 
	 */ 
	public String getOriExplain(){
		return oriExplain;
	}

}
