package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.entity.Inventory;
import cn.peyton.spring.util.DateUtil;

/**
 * <h3>库存主 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 11:44:37
 * @version 1.0.0
 * </pre>
*/
public class InventoryParam{
	/** 编号  */
	private Long id;
	/** 创建时间  */
	private String created;
	/** 颜色编号1:数量,颜色编号2:数量,...颜色编号N:数量  */
	private String detail;
	/** 库存提示，1为提示，0不提示，默认为0  */
	private Integer tip;
	/** 商品名称,用来模糊查找  */
	private String comName;
	/** 总数量  */
	private Integer total;
	/** 仓库编号  */
	private Integer warId;
	/** 商品编号  */
	private String comId;
	/** 说明  */
	private String explain;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成InventoryInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,inveCreated,inveDetail,inveTip,inveComName,inveTotal,warId,comId,inveExplain]
     * </pre>
     */
    public Inventory convert(){
        Inventory inventory = new Inventory();
        inventory.setId(id);
        inventory.setInveCreated(DateUtil.conventStr2Date(created));
        inventory.setInveDetail(detail);
        inventory.setInveTip(tip);
        inventory.setInveComName(comName);
        inventory.setInveTotal(total);
        inventory.setWarId(warId);
        inventory.setComId(comId);
        inventory.setInveExplain(explain);
        return inventory;
    }

    /**
     * <h4>InventoryInfo对象转成InventoryParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,inveCreated,inveDetail,inveTip,inveComName,inveTotal,warId,comId,inveExplain]
     * </pre>
     */
    public InventoryParam compat(Inventory inventory){
        if (null == inventory){return new InventoryParam();}
        this.id = inventory.getId();
        this.created = DateUtil.conventDate2Str(inventory.getInveCreated());
        this.detail = inventory.getInveDetail();
        this.tip = inventory.getInveTip();
        this.comName = inventory.getInveComName();
        this.total = inventory.getInveTotal();
        this.warId = inventory.getWarId();
        this.comId = inventory.getComId();
        this.explain = inventory.getInveExplain();
        return this;
    }

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
	 * @param created 创建时间 
	 */ 
	public void setCreated(String created){
		this.created = created;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public String getCreated(){
		return created;
	}

	/** 
	 * @param detail 颜色编号1:数量,颜色编号2:数量,...颜色编号N:数量 
	 */ 
	public void setDetail(String detail){
		this.detail = detail;
	}

	/** 
	 * @return 颜色编号1:数量,颜色编号2:数量,...颜色编号N:数量 
	 */ 
	public String getDetail(){
		return detail;
	}

	/** 
	 * @param tip 库存提示，1为提示，0不提示，默认为0 
	 */ 
	public void setTip(Integer tip){
		this.tip = tip;
	}

	/** 
	 * @return 库存提示，1为提示，0不提示，默认为0 
	 */ 
	public Integer getTip(){
		return tip;
	}

	/** 
	 * @param comName 商品名称,用来模糊查找 
	 */ 
	public void setComName(String comName){
		this.comName = comName;
	}

	/** 
	 * @return 商品名称,用来模糊查找 
	 */ 
	public String getComName(){
		return comName;
	}

	/** 
	 * @param total 总数量 
	 */ 
	public void setTotal(Integer total){
		this.total = total;
	}

	/** 
	 * @return 总数量 
	 */ 
	public Integer getTotal(){
		return total;
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
	 * @param explain 说明 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getExplain(){
		return explain;
	}

}
