package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.entity.Attention;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;

/**
 * <h3>关注[商品] 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/29 16:34:23
 * @version 1.0.0
 * </pre>
*/
public final class AttentionParam{
	/** 编号  */
	private Long id;
	/** 商品编号  */
	@NotBlank(message = "商品编号不存在")
    @Length(message = "商品长度超出",max = 50)
	private String comId;
	/** 顾客编号  */
	private Long cusId;
	/** 关注状态 1为关注,0不关注,默认1  */
	private Integer status;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成Attention对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,comId,cusId,attStatus]
     * </pre>
     */
    public Attention convert(){
        Attention attention = new Attention();
        attention.setId(id);
        attention.setComId(comId);
        attention.setCusId(cusId);
        attention.setAttStatus(status);
        return attention;
    }

    /**
     * <h4>Attention对象转成AttentionParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,comId,cusId,attStatus]
     * </pre>
     */
    public AttentionParam compat(Attention attention){
        if(null == attention){
            return new AttentionParam();
        }
        this.setId(attention.getId());
        this.setComId(attention.getComId());
        this.setCusId(attention.getCusId());
        this.setStatus(attention.getAttStatus());
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
	 * @param status 关注状态 1为关注,0不关注,默认1 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 关注状态 1为关注,0不关注,默认1 
	 */ 
	public Integer getStatus(){
		return status;
	}

}
