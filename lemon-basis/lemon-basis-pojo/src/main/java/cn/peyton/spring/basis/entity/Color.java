package cn.peyton.spring.basis.entity;

/**
 * <h3>颜色 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 09:16:50
 * @version 1.0.0
 * </pre>
*/
public class Color {
	/** 编号  */
	private Integer id;
	/** 颜色名称  */
	private String colName;
	/** 颜色代码  */
	private String colCode;

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
	 * @param colName 颜色名称 
	 */ 
	public void setColName(String colName){
		this.colName = colName;
	}

	/** 
	 * @return 颜色名称 
	 */ 
	public String getColName(){
		return colName;
	}

	/** 
	 * @param colCode 颜色代码 
	 */ 
	public void setColCode(String colCode){
		this.colCode = colCode;
	}

	/** 
	 * @return 颜色代码 
	 */ 
	public String getColCode(){
		return colCode;
	}

}
