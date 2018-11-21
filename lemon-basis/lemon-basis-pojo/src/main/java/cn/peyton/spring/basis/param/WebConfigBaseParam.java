package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.SysWebConfig;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.validator.constraints.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <h3>网站基础配置 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:46
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class WebConfigBaseParam {
	/** 编号  */
	private Integer id;
	/** 标题  */
	@NotBlank(message = "网站标题不能为空!")
	@Length(min = 0,max = 150,message = "网站标题长度不能超过150个字符!")
	private String webTitle;
	/** 链接地址  */
    @NotBlank(message = "链接地址不能为空!")
    @Length(min = 0,max = 250,message = "链接地址长度不能超过250个字符!")
	private String webLink;
	/** 电子邮件  */
    @NotBlank(message = "邮箱不能为空!")
	@Email
    @Length(min = 0,max = 100,message = "邮箱长度不能超过150个字符!")
	private String webEmail;
	/** logo图片链接地址  */
    @NotBlank(message = "logo链接不能为空!")
    @Length(min = 0,max = 250,message = "logo链接地址长度不能超过250个字符!")
	private String webLogoImage;
    /** 图片名称 */
    private String imgName;
	/** 地址  */
    @NotBlank(message = "地址不能为空!")
    @Length(min = 0,max = 100,message = "地址长度不能超过100个字符!")
	private String webAdd;
	/** 电话  */
    @NotBlank(message = "电话不能为空!")
	@Telephone
    @Length(min = 0,max = 50,message = "电话长度不能超过50个字符!")
	private String webTel;
	/** 手机  */
    @NotBlank(message = "手机不能为空!")
	@Phone
    @Length(min = 0,max = 50,message = "手机长度不能超过50个字符!")
	private String webPhone;
	/** 传真  */
    @NotBlank(message = "传真不能为空!")
	@Telephone
    @Length(min = 0,max = 50,message = "传真长度不能超过50个字符!")
	private String webFax;
	/** 站点名称  */
    @NotBlank(message = "站点名称不能为空!")
    @Length(min = 0,max = 150,message = "站点名称长度不能超过150个字符!")
	private String webName;
    /** 创建时间  */
    private String webCreated;
    /** 最后登录时间  */
    private String webUpdated;

    /** 完整路径 */
    private String completePath;
    /** Logo  */
    private MultipartFile logoImgFile;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成SysWebConfig对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webTitle,webLink,webEmail,webLogoImage,webAdd,webTel,webPhone,webFax,webName]
     * </pre>
     */
    public SysWebConfig convert(){
        SysWebConfig sysWebConfig = new SysWebConfig();
        sysWebConfig.setId(id);
        sysWebConfig.setWebTitle(webTitle);
        sysWebConfig.setWebLink(webLink);
        sysWebConfig.setWebEmail(webEmail);
        sysWebConfig.setWebLogoImage(webLogoImage);
        sysWebConfig.setWebAdd(webAdd);
        sysWebConfig.setWebTel(webTel);
        sysWebConfig.setWebPhone(webPhone);
        sysWebConfig.setWebFax(webFax);
        sysWebConfig.setWebName(webName);
        return sysWebConfig;
    }

    /**
     * <h4>SysWebConfig对象转成WebConfigBaseParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webTitle,webLink,webEmail,webLogoImage,webAdd,webTel,webPhone,webFax,webName]
     * </pre>
     */
    public WebConfigBaseParam compat(SysWebConfig sysWebConfig){
        if(null == sysWebConfig){return new WebConfigBaseParam();}
        this.id = sysWebConfig.getId();
        this.webTitle = sysWebConfig.getWebTitle();
        this.webLink = sysWebConfig.getWebLink();
        this.webEmail = sysWebConfig.getWebEmail();
        this.webLogoImage = sysWebConfig.getWebLogoImage();
        this.webAdd = sysWebConfig.getWebAdd();
        this.webTel = sysWebConfig.getWebTel();
        this.webPhone = sysWebConfig.getWebPhone();
        this.webFax = sysWebConfig.getWebFax();
        this.webName = sysWebConfig.getWebName();
        this.webCreated = DateUtil.conventDate2Str(sysWebConfig.getWebCreated());
        this.webUpdated = DateUtil.conventDate2Str(sysWebConfig.getWebUpdated());
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
	 * @param webTitle 标题 
	 */ 
	public void setWebTitle(String webTitle){
		this.webTitle = webTitle;
	}

	/** 
	 * @return 标题 
	 */ 
	public String getWebTitle(){
		return webTitle;
	}

	/** 
	 * @param webLink 链接地址 
	 */ 
	public void setWebLink(String webLink){
		this.webLink = webLink;
	}

	/** 
	 * @return 链接地址 
	 */ 
	public String getWebLink(){
		return webLink;
	}

	/** 
	 * @param webEmail 电子邮件 
	 */ 
	public void setWebEmail(String webEmail){
		this.webEmail = webEmail;
	}

	/** 
	 * @return 电子邮件 
	 */ 
	public String getWebEmail(){
		return webEmail;
	}

	/** 
	 * @param webLogoImage logo图片链接地址 
	 */ 
	public void setWebLogoImage(String webLogoImage){
	    this.webLogoImage = webLogoImage;
	}

	/** 
	 * @return logo图片链接地址 
	 */ 
	public String getWebLogoImage(){
		return webLogoImage;
	}

    /**
     * @param imgName 图片名称
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * @return 图片名称
     */
    public String getImgName() {
        return imgName;
    }

    /**
	 * @param webAdd 地址 
	 */ 
	public void setWebAdd(String webAdd){
		this.webAdd = webAdd;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getWebAdd(){
		return webAdd;
	}

	/** 
	 * @param webTel 电话 
	 */ 
	public void setWebTel(String webTel){
		this.webTel = webTel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getWebTel(){
		return webTel;
	}

	/** 
	 * @param webPhone 手机 
	 */ 
	public void setWebPhone(String webPhone){
		this.webPhone = webPhone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getWebPhone(){
		return webPhone;
	}

	/** 
	 * @param webFax 传真 
	 */ 
	public void setWebFax(String webFax){
		this.webFax = webFax;
	}

	/** 
	 * @return 传真 
	 */ 
	public String getWebFax(){
		return webFax;
	}

	/** 
	 * @param webName 站点名称 
	 */ 
	public void setWebName(String webName){
		this.webName = webName;
	}

	/** 
	 * @return 站点名称 
	 */ 
	public String getWebName(){
		return webName;
	}

    /**
     * @return complete
     */
    public String getCompletePath() {
        return completePath;
    }

    /**
     * @param completePath complete
     */
    public void setCompletePath(String completePath) {
        this.completePath = completePath;
    }

    /**
     * @return Logo Image
     */
    public MultipartFile getLogoImgFile() {
        return logoImgFile;
    }

    /**
     * @param logoImgFile Logo Image
     */
    public void setLogoImgFile(MultipartFile logoImgFile) {
        this.logoImgFile = logoImgFile;
    }

    /**
     * @param webCreated 创建时间
     */
    public void setWebCreated(String webCreated){
        this.webCreated = webCreated;
    }

    /**
     * @return 创建时间
     */
    public String getWebCreated(){
        return webCreated;
    }

    /**
     * @param webUpdated 最后登录时间
     */
    public void setWebUpdated(String webUpdated){
        this.webUpdated = webUpdated;
    }

    /**
     * @return 最后登录时间
     */
    public String getWebUpdated(){
        return webUpdated;
    }
}
