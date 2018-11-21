package cn.peyton.spring.basis.entity;

/**
 * <h3>地区 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public class Region {
	/** 编号  */
	private Long id;
	/** 名称  */
	private String regiName;
	/** 地区区码  */
	private String regiCode;
	/** 排序,从小到大排序  */
	private Integer regiSeq;
	/** 地区层级  */
	private String regiLevel;
	/** 父级编号，默认顶层为0  */
	private Long parentId;

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
	 * @param regiName 名称 
	 */ 
	public void setRegiName(String regiName){
		this.regiName = regiName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getRegiName(){
		return regiName;
	}

	/** 
	 * @param regiCode 地区区码 
	 */ 
	public void setRegiCode(String regiCode){
		this.regiCode = regiCode;
	}

	/** 
	 * @return 地区区码 
	 */ 
	public String getRegiCode(){
		return regiCode;
	}

	/** 
	 * @param regiSeq 排序,从小到大排序 
	 */ 
	public void setRegiSeq(Integer regiSeq){
		this.regiSeq = regiSeq;
	}

	/** 
	 * @return 排序,从小到大排序 
	 */ 
	public Integer getRegiSeq(){
		return regiSeq;
	}

	/** 
	 * @param regiLevel 地区层级 
	 */ 
	public void setRegiLevel(String regiLevel){
		this.regiLevel = regiLevel;
	}

	/** 
	 * @return 地区层级 
	 */ 
	public String getRegiLevel(){
		return regiLevel;
	}

	/** 
	 * @param parentId 父级编号，默认顶层为0 
	 */ 
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}

	/** 
	 * @return 父级编号，默认顶层为0 
	 */ 
	public Long getParentId(){
		return parentId;
	}

}
