package cn.peyton.spring.basis.entity;

import java.util.Date;

/**
 * <h3>网站基础配置 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class SysWebConfig{
	/** 编号  */
	private Integer id;
	/** 标题  */
	private String webTitle;
	/** 链接地址  */
	private String webLink;
	/** 电子邮件  */
	private String webEmail;
	/** logo图片链接地址  */
	private String webLogoImage;
	/** 地址  */
	private String webAdd;
	/** 电话  */
	private String webTel;
	/** 手机  */
	private String webPhone;
	/** 传真  */
	private String webFax;
	/** ICP备案信息  */
	private String webIcp;
	/** 版权  */
	private String webCopyRight;
	/** 站点名称  */
	private String webName;
	/** 关键词设置  */
	private String webKeyword;
	/** 浏览器上显示的图标  */
	private String webLinkIcon;
	/** 关闭提示  */
	private String webCloseTip;
	/** 上传文件目录  */
	private String webUploadPath;
	/** 网站皮肤  */
	private String webSkin;
	/** 统计代码  */
	private String webCensusCode;
	/** 配置状态是否可用 1 可用, 0 不可用  */
	private Integer webStatus;
	/** 站点描述  */
	private String webDesc;
	/** 说明  */
	private String webExplain;
	/** 创建时间  */
	private Date webCreated;
	/** 最后登录时间  */
	private Date webUpdated;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


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
	 * @param webKeyword 关键词设置 
	 */ 
	public void setWebKeyword(String webKeyword){
		this.webKeyword = webKeyword;
	}

	/** 
	 * @return 关键词设置 
	 */ 
	public String getWebKeyword(){
		return webKeyword;
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
	 * @param webUploadPath 上传文件目录 
	 */ 
	public void setWebUploadPath(String webUploadPath){
		this.webUploadPath = webUploadPath;
	}

	/** 
	 * @return 上传文件目录 
	 */ 
	public String getWebUploadPath(){
		return webUploadPath;
	}

	/** 
	 * @param webSkin 网站皮肤 
	 */ 
	public void setWebSkin(String webSkin){
		this.webSkin = webSkin;
	}

	/** 
	 * @return 网站皮肤 
	 */ 
	public String getWebSkin(){
		return webSkin;
	}

	/** 
	 * @param webCensusCode 统计代码 
	 */ 
	public void setWebCensusCode(String webCensusCode){
		this.webCensusCode = webCensusCode;
	}

	/** 
	 * @return 统计代码 
	 */ 
	public String getWebCensusCode(){
		return webCensusCode;
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
	 * @param webCreated 创建时间 
	 */ 
	public void setWebCreated(Date webCreated){
		this.webCreated = webCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getWebCreated(){
		return webCreated;
	}

	/** 
	 * @param webUpdated 最后登录时间 
	 */ 
	public void setWebUpdated(Date webUpdated){
		this.webUpdated = webUpdated;
	}

	/** 
	 * @return 最后登录时间 
	 */ 
	public Date getWebUpdated(){
		return webUpdated;
	}

}
