package cn.peyton.spring.tool.sql;
/**
 * <h3></h3>
 * @title: Parameter.java
 * @package cn.peyton.spring.tool
 * @className: Parameter
 * @author Peyton_YU
 * @date 2017年10月5日 上午9:55:46
 */
public class Parameter {

	/** 名称{第一个字母小写}  */
	private String name;
	/** 类型{第一个字母大写}  */
	private String type;
	/** 说明注释  */
	private String explain;
	
	/**
	 * <h4></h4>
	 * @param name 名称{第一个字母小写} 
	 * @param type 类型{第一个字母大写}
	 * @param explain 说明注释
	 */
	public Parameter(String name, String type, String explain) {
		this.name = name;
		this.type = type;
		this.explain = explain;
	}
	/**
	 * <h4></h4>
	 * @return 名称{第一个字母小写}
	 */
	public String getName() {
		return name;
	}
	/**
	 * <h4></h4>
	 * @param name 名称{第一个字母小写}
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <h4></h4>
	 * @return  类型{第一个字母大写}
	 */
	public String getType() {
		return type;
	}
	/**
	 * <h4></h4>
	 * @param type  类型{第一个字母大写}
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * <h4>说明注释</h4>
	 * @return 说明注释
	 */
	public String getExplain() {
		return explain;
	}
	/**
	 * <h4>说明注释</h4>
	 * @param explain 说明注释
	 */
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	
}
