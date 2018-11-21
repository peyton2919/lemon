package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.SysWebConfig;
import cn.peyton.spring.validator.constraints.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <h3>网站版权配置 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:47
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class WebConfigCopyrightParam {
	/** 编号  */
	private Integer id;
	/** ICP备案信息  */
    @Length(min = 0,max = 500,message = "ICP备案长度不能超过500个字符!")
	private String webIcp;
	/** 版权  */
    @Length(min = 0,max = 250,message = "版权长度不能超过250个字符!")
	private String webCopyRight;
    /** 浏览器上显示的图标  */
    @Length(min = 0,max = 500,message = "浏览器上图标长度不能超过500个字符!")
    private String webLinkIcon;
    /** 图片名称 */
    private String imgName;
	/** 站点描述  */
    @Length(min = 0,max = 500,message = "描述长度不能超过500个字符!")
	private String webDesc;
	/** 说明  */
    @Length(min = 0,max = 500,message = "说明长度不能超过500个字符!")
	private String webExplain;
    /** 完整路径 */
    private String completePath;
    /** Link Icon  */
    private MultipartFile linkIconFile;


	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成SysWebConfig对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webIcp,webCopyRight,webLinkIcon,webDesc,webExplain]
     * </pre>
     */
    public SysWebConfig convert(){
        SysWebConfig sysWebConfig = new SysWebConfig();
        sysWebConfig.setId(id);
        sysWebConfig.setWebIcp(webIcp);
        sysWebConfig.setWebCopyRight(webCopyRight);
        sysWebConfig.setWebLinkIcon(webLinkIcon);
        sysWebConfig.setWebDesc(webDesc);
        sysWebConfig.setWebExplain(webExplain);
        return sysWebConfig;
    }

    /**
     * <h4>SysWebConfig对象转成WebConfigCopyrightParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webIcp,webCopyRight,webLinkIcon,webDesc,webExplain]
     * </pre>
     */
    public WebConfigCopyrightParam compat(SysWebConfig sysWebConfig){
        if(null == sysWebConfig){return new WebConfigCopyrightParam();}
        this.id = sysWebConfig.getId();
        this.webIcp = sysWebConfig.getWebIcp();
        this.webCopyRight = sysWebConfig.getWebCopyRight();
        this.webLinkIcon = sysWebConfig.getWebLinkIcon();;
        this.webDesc = sysWebConfig.getWebDesc();
        this.webExplain = sysWebConfig.getWebExplain();
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
	 * @param webIcp ICP备案信息 
	 */ 
	public void setWebIcp(String webIcp){
		this.webIcp = webIcp;
	}

	/** 
	 * @return ICP备案信息 
	 */ 
	public String getWebIcp(){
		return webIcp;
	}

	/** 
	 * @param webCopyRight 版权 
	 */ 
	public void setWebCopyRight(String webCopyRight){
		this.webCopyRight = webCopyRight;
	}

	/** 
	 * @return 版权 
	 */ 
	public String getWebCopyRight(){
		return webCopyRight;
	}

    /**
     * @param webLinkIcon 浏览器上显示的图标
     */
    public void setWebLinkIcon(String webLinkIcon){
        this.webLinkIcon = webLinkIcon;
    }

    /**
     * @return 浏览器上显示的图标
     */
    public String getWebLinkIcon(){
        return webLinkIcon;
    }

    /**
     * @param imgName 图片名称
     */
    public void setImgName(String imgName) {
        if (webLinkIcon == null || "".equals(webLinkIcon)) {
            this.imgName = imgName;
        } else {
            this.imgName = webLinkIcon.substring(webLinkIcon.lastIndexOf("/") +1);
        }
    }

    /**
     * @return 图片名称
     */
    public String getImgName() {
        if (imgName != null && !"".equals(imgName)) {
            return imgName;
        } else {
            if (webLinkIcon == null || "".equals(webLinkIcon)) {
                return "";
            } else {
                return webLinkIcon.substring(webLinkIcon.lastIndexOf("/") +1);
            }
        }
    }

	/** 
	 * @param webDesc 站点描述 
	 */ 
	public void setWebDesc(String webDesc){
		this.webDesc = webDesc;
	}

	/** 
	 * @return 站点描述 
	 */ 
	public String getWebDesc(){
		return webDesc;
	}

	/** 
	 * @param webExplain 说明 
	 */ 
	public void setWebExplain(String webExplain){
		this.webExplain = webExplain;
	}

	/** 
	 * @return 说明 
	 */ 
	public String getWebExplain(){
		return webExplain;
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
    public MultipartFile getLinkIconFile() {
        return linkIconFile;
    }

    /**
     * @param linkIconFile Logo Image
     */
    public void setLinkIconFile(MultipartFile linkIconFile) {
        this.linkIconFile = linkIconFile;
    }

}
