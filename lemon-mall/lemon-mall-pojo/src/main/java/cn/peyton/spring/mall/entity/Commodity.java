package cn.peyton.spring.mall.entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <h3>商品 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/23 21:44:35
 * @version 1.0.0
 * </pre>
*/
public class Commodity {
	/** 编号  */
	private String id;
	/** 名称  */
	private String comName;
	/** 型号  */
	private String comModel;
	/** 关键词  */
	private String comKeyword;
	/** 规格  */
	private String comFormat;
	/** 包装  */
	private String comPack;
	/** 单位  */
	private String comUnit;
	/** 成本价  */
	private BigDecimal comPrice;
	/** 零售价  */
	private BigDecimal comRetail;
	/** 批发价  */
	private BigDecimal comWholesale;
	/** 主图地址  */
	private String comMainImg;
	/** 图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用","隔开  */
	private String comImages;
	/** 是否显示，1为显示，0不显示，默认为1  */
	private Integer comStatus;
	/** 是否可以评论，1可以评论,0不能评论  */
	private Integer comComment;
	/** 条形码  */
	private String comBarCode;
	/** 商品热度点击1次加1  */
	private Integer comHot;
	/** 详细  */
	private String comDetail;
	/** 创建时间  */
	private Date comCreated;
	/** 更新时间  */
	private Date comUpdated;
	/** 产地编号  */
	private Integer oriId;
	/** 商品分类编号的集合,[0,1,2...]  */
	private String cosoId;
	/** 商品类目编号  */
	private Long cocaId;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(String id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public String getId(){
		return id;
	}

	/** 
	 * @param comName 名称 
	 */ 
	public void setComName(String comName){
		this.comName = comName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getComName(){
		return comName;
	}

	/** 
	 * @param comModel 型号 
	 */ 
	public void setComModel(String comModel){
		this.comModel = comModel;
	}

	/** 
	 * @return 型号 
	 */ 
	public String getComModel(){
		return comModel;
	}

	/** 
	 * @param comKeyword 关键词 
	 */ 
	public void setComKeyword(String comKeyword){
		this.comKeyword = comKeyword;
	}

	/** 
	 * @return 关键词 
	 */ 
	public String getComKeyword(){
		return comKeyword;
	}

	/** 
	 * @param comFormat 规格 
	 */ 
	public void setComFormat(String comFormat){
		this.comFormat = comFormat;
	}

	/** 
	 * @return 规格 
	 */ 
	public String getComFormat(){
		return comFormat;
	}

	/** 
	 * @param comPack 包装 
	 */ 
	public void setComPack(String comPack){
		this.comPack = comPack;
	}

	/** 
	 * @return 包装 
	 */ 
	public String getComPack(){
		return comPack;
	}

	/** 
	 * @param comUnit 单位 
	 */ 
	public void setComUnit(String comUnit){
		this.comUnit = comUnit;
	}

	/** 
	 * @return 单位 
	 */ 
	public String getComUnit(){
		return comUnit;
	}

	/** 
	 * @param comPrice 成本价 
	 */ 
	public void setComPrice(BigDecimal comPrice){
		this.comPrice = comPrice;
	}

	/** 
	 * @return 成本价 
	 */ 
	public BigDecimal getComPrice(){
		return comPrice;
	}

	/** 
	 * @param comRetail 零售价 
	 */ 
	public void setComRetail(BigDecimal comRetail){
		this.comRetail = comRetail;
	}

	/** 
	 * @return 零售价 
	 */ 
	public BigDecimal getComRetail(){
		return comRetail;
	}

	/** 
	 * @param comWholesale 批发价 
	 */ 
	public void setComWholesale(BigDecimal comWholesale){
		this.comWholesale = comWholesale;
	}

	/** 
	 * @return 批发价 
	 */ 
	public BigDecimal getComWholesale(){
		return comWholesale;
	}

	/** 
	 * @param comMainImg 主图地址 
	 */ 
	public void setComMainImg(String comMainImg){
		this.comMainImg = comMainImg;
	}

	/** 
	 * @return 主图地址 
	 */ 
	public String getComMainImg(){
		return comMainImg;
	}

	/** 
	 * @param comImages 图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用","隔开 
	 */ 
	public void setComImages(String comImages){
		this.comImages = comImages;
	}

	/** 
	 * @return 图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用","隔开 
	 */ 
	public String getComImages(){
		return comImages;
	}

	/** 
	 * @param comStatus 是否显示，1为显示，0不显示，默认为1 
	 */ 
	public void setComStatus(Integer comStatus){
		this.comStatus = comStatus;
	}

	/** 
	 * @return 是否显示，1为显示，0不显示，默认为1 
	 */ 
	public Integer getComStatus(){
		return comStatus;
	}

	/** 
	 * @param comComment 是否可以评论，1可以评论,0不能评论 
	 */ 
	public void setComComment(Integer comComment){
		this.comComment = comComment;
	}

	/** 
	 * @return 是否可以评论，1可以评论,0不能评论 
	 */ 
	public Integer getComComment(){
		return comComment;
	}

	/** 
	 * @param comBarCode 条形码 
	 */ 
	public void setComBarCode(String comBarCode){
		this.comBarCode = comBarCode;
	}

	/** 
	 * @return 条形码 
	 */ 
	public String getComBarCode(){
		return comBarCode;
	}

	/** 
	 * @param comHot 商品热度点击1次加1 
	 */ 
	public void setComHot(Integer comHot){
		this.comHot = comHot;
	}

	/** 
	 * @return 商品热度点击1次加1 
	 */ 
	public Integer getComHot(){
		return comHot;
	}

	/** 
	 * @param comDetail 详细 
	 */ 
	public void setComDetail(String comDetail){
		this.comDetail = comDetail;
	}

	/** 
	 * @return 详细 
	 */ 
	public String getComDetail(){
		return comDetail;
	}

	/** 
	 * @param comCreated 创建时间 
	 */ 
	public void setComCreated(Date comCreated){
		this.comCreated = comCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getComCreated(){
		return comCreated;
	}

	/** 
	 * @param comUpdated 更新时间 
	 */ 
	public void setComUpdated(Date comUpdated){
		this.comUpdated = comUpdated;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public Date getComUpdated(){
		return comUpdated;
	}

	/** 
	 * @param oriId 产地编号 
	 */ 
	public void setOriId(Integer oriId){
		this.oriId = oriId;
	}

	/** 
	 * @return 产地编号 
	 */ 
	public Integer getOriId(){
		return oriId;
	}

	/** 
	 * @param cosoId 商品分类编号的集合,[0,1,2...] 
	 */ 
	public void setCosoId(String cosoId){
		this.cosoId = cosoId;
	}

	/** 
	 * @return 商品分类编号的集合,[0,1,2...] 
	 */ 
	public String getCosoId(){
		return cosoId;
	}

	/** 
	 * @param cocaId 商品类目编号 
	 */ 
	public void setCocaId(Long cocaId){
		this.cocaId = cocaId;
	}

	/** 
	 * @return 商品类目编号 
	 */ 
	public Long getCocaId(){
		return cocaId;
	}

}
