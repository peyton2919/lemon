package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.entity.Collect;

/**
 * <h3>收藏[商品] 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
public final class CollectParam{
	/** 编号  */
	private Long id;
	/** 商品编号  */
	private String comId;
	/** 顾客编号  */
	private Long cusId;
	/** 收藏状态 1为收藏,0不收藏,默认1  */
	private Integer status;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成Collect对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,comId,cusId,collStatus]
     * </pre>
     */
    public Collect convert(){
        Collect collect = new Collect();
        collect.setId(id);
        collect.setComId(comId);
        collect.setCusId(cusId);
        collect.setCollStatus(status);
        return collect;
    }

    /**
     * <h4>Collect对象转成CollectParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,comId,cusId,collStatus]
     * </pre>
     */
    public CollectParam compat(Collect collect){
        if(null == collect){
            return new CollectParam();
        }
        this.setId(collect.getId());
        this.setComId(collect.getComId());
        this.setCusId(collect.getCusId());
        this.setStatus(collect.getCollStatus());
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
	 * @param status 收藏状态 1为收藏,0不收藏,默认1 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 收藏状态 1为收藏,0不收藏,默认1 
	 */ 
	public Integer getStatus(){
		return status;
	}

}
