package cn.peyton.spring.basis.entity;

/**
 * <h3>付款方式 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:18:20
 * @version 1.0.0
 * </pre>
*/
public class PaymentMode{
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String pamoName;
	/** 说明  */
	private String pamoExplain;

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
	 * @param pamoName 名称 
	 */ 
	public void setPamoName(String pamoName){
		this.pamoName = pamoName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getPamoName(){
		return pamoName;
	}

	/** 
	 * @param pamoExplain 说明 
	 */ 
	public void setPamoExplain(String pamoExplain){
		this.pamoExplain = pamoExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getPamoExplain(){
		return pamoExplain;
	}

}
