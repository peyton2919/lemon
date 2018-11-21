package cn.peyton.spring.mall.entity;

/**
 * <h3>出入库明细 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/13 16:23:47
 * @version 1.0.0
 * </pre>
*/
public class StorageDetail{
	/** 编号  */
	private Long id;
	/** 数量  */
	private Integer stdeQuantity;
	/** 说明  */
	private String stdeExplain;
	/** 入库编号  */
	private Long storId;
	/** 颜色编号  */
	private Integer colId;

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
	 * @param stdeQuantity 数量 
	 */ 
	public void setStdeQuantity(Integer stdeQuantity){
		this.stdeQuantity = stdeQuantity;
	}

	/** 
	 * @return 数量 
	 */ 
	public Integer getStdeQuantity(){
		return stdeQuantity;
	}

	/** 
	 * @param stdeExplain 说明 
	 */ 
	public void setStdeExplain(String stdeExplain){
		this.stdeExplain = stdeExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getStdeExplain(){
		return stdeExplain;
	}

	/** 
	 * @param storId 入库编号 
	 */ 
	public void setStorId(Long storId){
		this.storId = storId;
	}

	/** 
	 * @return 入库编号 
	 */ 
	public Long getStorId(){
		return storId;
	}

	/** 
	 * @param colId 颜色编号 
	 */ 
	public void setColId(Integer colId){
		this.colId = colId;
	}

	/** 
	 * @return 颜色编号 
	 */ 
	public Integer getColId(){
		return colId;
	}

}
