package cn.peyton.spring.usergroup.param;

import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.usergroup.entity.CustomerGrade;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Pattern;

/**
 * <h3>客户等级 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:34:34
 * @version 1.0.0
 * </pre>
*/
public class CustomerGradeParam {
	/** 编号  */
	private Integer id;
	/** 等级名称  */
    @NotBlank(message = "客户等级名称不能为空")
    @Length(max = 50,message = "客户等级长度不能超过50个字符")
	private String name;
	/** 折扣率，默认100为百分之百  */
	@Pattern(regexp = Regulation.REGEX_INT_1_100,message = "折扣率格式不正确")
	private Integer dr;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成CustomerGrade对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cugrName,cugrDr]
     * </pre>
     */
    public CustomerGrade convert(){
        CustomerGrade customerGrade = new CustomerGrade();
        customerGrade.setId(id);
        customerGrade.setCugrName(name);
        customerGrade.setCugrDr(dr);
        return customerGrade;
    }

    /**
     * <h4>CustomerGrade对象转成CustomerGradeParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cugrName,cugrDr]
     * </pre>
     */
    public CustomerGradeParam compat(CustomerGrade customerGrade){
        if(null == customerGrade){
            return new CustomerGradeParam();
        }
        this.id = customerGrade.getId();
        this.name = customerGrade.getCugrName();
        this.dr = customerGrade.getCugrDr();
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
	 * @param name 等级名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 等级名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param dr 折扣率，默认100为百分之百 
	 */ 
	public void setDr(Integer dr){
		this.dr = dr;
	}

	/** 
	 * @return 折扣率，默认100为百分之百 
	 */ 
	public Integer getDr(){
		return dr;
	}

}
