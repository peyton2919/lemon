package cn.peyton.spring.mall.entity;
import java.util.Date;

/**
 * <h3>库存主 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
public class Inventory {
	/** 编号  */
	private Long id;
	/** 创建时间  */
	private Date inveCreated;
	/** 颜色编号1:数量,颜色编号2:数量,...颜色编号N:数量  */
	private String inveDetail;
	/** 库存提示，1为提示，0不提示，默认为0  */
	private Integer inveTip;
	/** 商品名称,用来模糊查找  */
	private String inveComName;
	/** 总数量  */
	private Integer inveTotal;
	/** 仓库编号  */
	private Integer warId;
	/** 商品编号  */
	private String comId;
	/** 说明  */
	private String inveExplain;

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
	 * @param inveCreated 创建时间 
	 */ 
	public void setInveCreated(Date inveCreated){
		this.inveCreated = inveCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getInveCreated(){
		return inveCreated;
	}

	/** 
	 * @param inveDetail 颜色编号1:数量,颜色编号2:数量,...颜色编号N:数量 
	 */ 
	public void setInveDetail(String inveDetail){
		this.inveDetail = inveDetail;
	}

	/** 
	 * @return 颜色编号1:数量,颜色编号2:数量,...颜色编号N:数量 
	 */ 
	public String getInveDetail(){
		return inveDetail;
	}

	/** 
	 * @param inveTip 库存提示，1为提示，0不提示，默认为0 
	 */ 
	public void setInveTip(Integer inveTip){
		this.inveTip = inveTip;
	}

	/** 
	 * @return 库存提示，1为提示，0不提示，默认为0 
	 */ 
	public Integer getInveTip(){
		return inveTip;
	}

	/** 
	 * @param inveComName 商品名称,用来模糊查找 
	 */ 
	public void setInveComName(String inveComName){
		this.inveComName = inveComName;
	}

	/** 
	 * @return 商品名称,用来模糊查找 
	 */ 
	public String getInveComName(){
		return inveComName;
	}

	/** 
	 * @param inveTotal 总数量 
	 */ 
	public void setInveTotal(Integer inveTotal){
		this.inveTotal = inveTotal;
	}

	/** 
	 * @return 总数量 
	 */ 
	public Integer getInveTotal(){
		return inveTotal;
	}

	/** 
	 * @param warId 仓库编号 
	 */ 
	public void setWarId(Integer warId){
		this.warId = warId;
	}

	/** 
	 * @return 仓库编号 
	 */ 
	public Integer getWarId(){
		return warId;
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
	 * @param inveExplain 说明 
	 */ 
	public void setInveExplain(String inveExplain){
		this.inveExplain = inveExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getInveExplain(){
		return inveExplain;
	}

}
