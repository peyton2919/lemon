package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.entity.StorageDetail;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Pattern;

/**
 * <h3>出入库明细 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 11:44:37
 * @version 1.0.0
 * </pre>
*/
public final class StorageDetailParam{
	/** 编号  */
	private Long id;
	/** 数量  */
    @NotBlank(message = "数量不能为空")
	private Integer quantity;
	/** 说明  */
    @Length(max = 250,message = "说明长度不能超过250个字符")
	private String explain;
	/** 入库编号  */
    @NotBlank(message = "入库编号不能为空")
    @Pattern(regexp = Regulation.REGEX_INT,message = "入库编号格式不正确")
	private Long storId;
	/** 颜色编号  */
    @NotBlank(message = "颜色编号不能为空")
    @Pattern(regexp = Regulation.REGEX_INT,message = "颜色编号格式不正确")
	private Integer colId;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成StorageDetail对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,stdeQuantity,stdeExplain,storId,colId]
     * </pre>
     */
    public StorageDetail convert(){
        StorageDetail storageDetail = new StorageDetail();
        storageDetail.setId(id);
        storageDetail.setStdeQuantity(quantity);
        storageDetail.setStdeExplain(explain);
        storageDetail.setStorId(storId);
        storageDetail.setColId(colId);
        return storageDetail;
    }

    /**
     * <h4>StorageDetail对象转成StorageDetailParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,stdeQuantity,stdeExplain,storId,colId]
     * </pre>
     */
    public StorageDetailParam compat(StorageDetail storageDetail){
        if(null == storageDetail){return new StorageDetailParam();}
        this.id = storageDetail.getId();
        this.quantity = storageDetail.getStdeQuantity();
        this.explain = storageDetail.getStdeExplain();
        this.storId = storageDetail.getStorId();
        this.colId = storageDetail.getColId();
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
	 * @param quantity 数量 
	 */ 
	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}

	/** 
	 * @return 数量 
	 */ 
	public Integer getQuantity(){
		return quantity;
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
