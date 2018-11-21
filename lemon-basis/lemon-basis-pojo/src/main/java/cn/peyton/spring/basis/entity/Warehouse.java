package cn.peyton.spring.basis.entity;

/**
 * <h3>仓库 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/10 16:14:27
 * @version 1.0.0
 * </pre>
*/
public class Warehouse {
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String warName;
	/** 电话  */
	private String warTel;
	/** 手机  */
	private String warPhone;
	/** 地址  */
	private String warAdd;
	/** QQ  */
	private String warQq;
	/** 位置  */
	private String warLocation;
	/** 说明  */
	private String warExplain;

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
	 * @param warName 名称 
	 */ 
	public void setWarName(String warName){
		this.warName = warName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getWarName(){
		return warName;
	}

	/** 
	 * @param warTel 电话 
	 */ 
	public void setWarTel(String warTel){
		this.warTel = warTel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getWarTel(){
		return warTel;
	}

	/** 
	 * @param warPhone 手机 
	 */ 
	public void setWarPhone(String warPhone){
		this.warPhone = warPhone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getWarPhone(){
		return warPhone;
	}

	/** 
	 * @param warAdd 地址 
	 */ 
	public void setWarAdd(String warAdd){
		this.warAdd = warAdd;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getWarAdd(){
		return warAdd;
	}

	/** 
	 * @param warQq QQ 
	 */ 
	public void setWarQq(String warQq){
		this.warQq = warQq;
	}

	/** 
	 * @return QQ 
	 */ 
	public String getWarQq(){
		return warQq;
	}

	/** 
	 * @param warLocation 位置 
	 */ 
	public void setWarLocation(String warLocation){
		this.warLocation = warLocation;
	}

	/** 
	 * @return 位置 
	 */ 
	public String getWarLocation(){
		return warLocation;
	}

	/** 
	 * @param warExplain 说明 
	 */ 
	public void setWarExplain(String warExplain){
		this.warExplain = warExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getWarExplain(){
		return warExplain;
	}

}
