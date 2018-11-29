package cn.peyton.spring.mall.entity;

/**
 * <h3>关注[商品] 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
public class Attention{
	/** 编号  */
	private Long id;
	/** 商品编号  */
	private String comId;
	/** 顾客编号  */
	private Long cusId;
	/** 关注状态 1为关注,0不关注,默认1  */
	private Integer attStatus;

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
	 * @param attStatus 关注状态 1为关注,0不关注,默认1 
	 */ 
	public void setAttStatus(Integer attStatus){
		this.attStatus = attStatus;
	}

	/** 
	 * @return 关注状态 1为关注,0不关注,默认1 
	 */ 
	public Integer getAttStatus(){
		return attStatus;
	}

}
