package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.entity.CommoditySort;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;

/**
 * <h3>商品分类 参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
public final class CommoditySortParam {
	/** 编号  */
	private Integer id;
	/** 名称  */
    @NotBlank(message = "名称不能为空")
    @Length(max = 50,message = "名称不能超过50个字符")
	private String name;
	/** 说明  */
    @Length(max = 250,message = "说明长度不能超过250个字符")
	private String explain;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成CommoditySort对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cosName,cosExplain]
     * </pre>
     */
    public CommoditySort convert(){
        CommoditySort commoditySort = new CommoditySort();
        commoditySort.setId(id);
        commoditySort.setCosName(name);
        commoditySort.setCosExplain(explain);
        return commoditySort;
    }

    /**
     * <h4>CommoditySort对象转成CommoditySortParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cosName,cosExplain]
     * </pre>
     */
    public CommoditySortParam compat(CommoditySort commoditySort){
        if(null == commoditySort){return new CommoditySortParam();}
        this.id = commoditySort.getId();
        this.name = commoditySort.getCosName();
        this.explain = commoditySort.getCosExplain();
        return this;
    }

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
	 * @param name 名称
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getName(){
		return name;
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
