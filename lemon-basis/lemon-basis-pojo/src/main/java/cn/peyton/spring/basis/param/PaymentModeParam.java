package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.PaymentMode;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;

/**
 * <h3>付款方式 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:34:34
 * @version 1.0.0
 * </pre>
*/
public class PaymentModeParam{
	/** 编号  */
	private Integer id;
	/** 名称  */
	@NotBlank(message = "付款方式名称不能为空")
    @Length(max = 50,message = "付款方式长度不能超过50个字符")
	private String name;
	/** 说明  */
    @Length(max = 100,message = "付款方式说明长度不能超过100个字符")
	private String explain;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成PaymentMode对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,pamoName,pamoExplain]
     * </pre>
     */
    public PaymentMode convert(){
        PaymentMode paymentMode = new PaymentMode();
        paymentMode.setId(id);
        paymentMode.setPamoName(name);
        paymentMode.setPamoExplain(explain);
        return paymentMode;
    }
    /**
     * <h4>PaymentMode对象转成PaymentModeParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,pamoName,pamoExplain]
     * </pre>
     */
    public PaymentModeParam compat(PaymentMode paymentMode){
        if(null == paymentMode){
            return new PaymentModeParam();
        }
        this.id = paymentMode.getId();
        this.name = paymentMode.getPamoName();
        this.explain = paymentMode.getPamoExplain();
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
