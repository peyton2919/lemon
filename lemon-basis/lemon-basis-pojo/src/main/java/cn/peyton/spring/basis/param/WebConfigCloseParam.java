package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.SysWebConfig;
import cn.peyton.spring.validator.constraints.*;

/**
 * <h3>网站关闭配置 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:47
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class WebConfigCloseParam {
	/** 编号  */
	private Integer id;

	/** 关闭提示  */
    @Length(min = 0,max = 500,message = "关闭提示长度不能超过500个字符!")
	private String webCloseTip;

	/** 配置状态是否可用 1 可用, 0 不可用  */
	@NotBlank(message = "状态不能为空!")
    @Size(min = 0,max = 1,message = "状态数值超出!")
	private Integer webStatus;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成SysWebConfig对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webCloseTip,webStatus]
     * </pre>
     */
    public SysWebConfig convert(){
        SysWebConfig sysWebConfig = new SysWebConfig();
        sysWebConfig.setId(id);
        sysWebConfig.setWebCloseTip(webCloseTip);
        sysWebConfig.setWebStatus(webStatus);
        return sysWebConfig;
    }

    /**
     * <h4>SysWebConfig对象转成WebConfigCloseParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webCloseTip,webStatus]
     * </pre>
     */
    public WebConfigCloseParam compat(SysWebConfig sysWebConfig){
        if(null == sysWebConfig){return new WebConfigCloseParam();}
        this.id = sysWebConfig.getId();
        this.webCloseTip = sysWebConfig.getWebCloseTip();
        this.webStatus = sysWebConfig.getWebStatus();
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
	 * @param webCloseTip 关闭提示 
	 */ 
	public void setWebCloseTip(String webCloseTip){
		this.webCloseTip = webCloseTip;
	}

	/** 
	 * @return 关闭提示 
	 */ 
	public String getWebCloseTip(){
		return webCloseTip;
	}

	/** 
	 * @param webStatus 配置状态是否可用 1 可用, 0 不可用 
	 */ 
	public void setWebStatus(Integer webStatus){
		this.webStatus = webStatus;
	}

	/** 
	 * @return 配置状态是否可用 1 可用, 0 不可用 
	 */ 
	public Integer getWebStatus(){
		return webStatus;
	}

}
