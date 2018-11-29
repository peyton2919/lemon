package cn.peyton.spring.mall.entity;

/**
 * <h3>收藏[商品] 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
public class Collect{
	/** 编号  */
	private Long id;
	/** 商品编号  */
	private String comId;
	/** 顾客编号  */
	private Long cusId;
	/** 收藏状态 1为收藏,0不收藏,默认1  */
	private Integer collStatus;

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
	 * @param comId 商品编号 
	 */ 
	public void setComId(String comId){
		this.comId = comId;
	}

	/** 
	 * @return 商品编号 
	 */ 
	public String getComId(){
		return comId;
	}

	/** 
	 * @param cusId 顾客编号 
	 */ 
	public void setCusId(Long cusId){
		this.cusId = cusId;
	}

	/** 
	 * @return 顾客编号 
	 */ 
	public Long getCusId(){
		return cusId;
	}

	/** 
	 * @param collStatus 收藏状态 1为收藏,0不收藏,默认1 
	 */ 
	public void setCollStatus(Integer collStatus){
		this.collStatus = collStatus;
	}

	/** 
	 * @return 收藏状态 1为收藏,0不收藏,默认1 
	 */ 
	public Integer getCollStatus(){
		return collStatus;
	}

}
