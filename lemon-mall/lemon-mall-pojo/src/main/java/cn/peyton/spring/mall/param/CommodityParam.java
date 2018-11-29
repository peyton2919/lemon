package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.entity.Commodity;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.util.DecimalUtil;
import cn.peyton.spring.util.StringUtil;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Pattern;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h3>商品 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/23 21:44:35
 * @version 1.0.0
 * </pre>
*/
public final class CommodityParam{
	/** 编号  */
	private String id;
	/** 名称  */
	@NotBlank(message = "名称不能为空")
    @Length(max = 100,message = "名称长度不能超过100个字符")
	private String name;
	/** 型号  */
    @NotBlank(message = "型号不能为空")
    @Length(max = 100,message = "型号长度不能超过100个字符")
	private String model;
	/** 关键词  */
    @NotBlank(message = "关键词不能为空")
    @Length(max = 100,message = "关键词长度不能超过100个字符")
	private String keyword;
	/** 规格  */
    @Length(max = 50,message = "规格长度不能超过50个字符")
	private String format;
	/** 包装  */
    @Length(max = 50,message = "包装长度不能超过50个字符")
	private String pack;
	/** 单位  */
    @Length(max = 10,message = "单位长度不能超过10个字符")
	private String unit;
	/** 成本价  */
    @NotBlank(message = "成本价不能为空")
	@Pattern(regexp = Regulation.REGEX_DECIMAL,message = "成本价格式不正确")
	private String price;
	/** 零售价  */
    @NotBlank(message = "零售价不能为空")
    @Pattern(regexp = Regulation.REGEX_DECIMAL,message = "零售价价格式不正确")
	private String retail;
	/** 批发价  */
    @NotBlank(message = "批发价不能为空")
    @Pattern(regexp = Regulation.REGEX_DECIMAL,message = "批发价价格式不正确")
	private String wholesale;
	/** 主图地址  */
    @Length(max = 150,message = "主图地址长度不能超过150个字符")
	private String mainImg;
	/** 图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用","隔开  */
	private List<String> images;
	/** 是否显示，1为显示，0不显示，默认为1  */
	private Integer status;
	/** 是否可以评论，1可以评论,0不能评论  */
	private boolean comment;
	/** 条形码  */
    @Length(max = 50,message = "条码长度不能超过50个字符")
	private String barCode;
	/** 商品热度点击1次加1  */
	private Integer hot;
	/** 详细  */
	private String detail;
	/** 创建时间  */
	private String created;
	/** 更新时间  */
	private String updated;
	/** 产地编号  */
	private Integer oriId;
	/** 商品分类编号的集合,[0,1,2...]  */
	@NotBlank(message = "请选择商品分类")
	private List<String> cosoId;
	/** 商品类目编号  */
	@NotBlank(message = "请选择左边的商品类目")
	private Long cocaId;
    /** 图片文件集合 */
	private MultipartFile[] files;
    /** 图片名称 */
    @NotBlank(message = "主图片不能为空")
     private String imgName;
    /** 完整路径 */
     private String completePath;
    /** Logo  */
     private MultipartFile imgFile;
     /** 前缀路径  */
     private String  prefixPath;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成CommodityInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,comName,comModel,comKeyword,comFormat,comPack,comUnit,comPrice,comRetail,comWholesale,
     * 	 comMainImg,comImages,comStatus,comComment,comBarCode,comHot,comDetail,
     * 	 comCreated,comUpdated,oriId,cosoId,cocaId]
     * </pre>
     */
    public Commodity convert(){
        Commodity commodity = new Commodity();
        commodity.setId(id);
        commodity.setComName(name);
        commodity.setComModel(model);
        commodity.setComKeyword(keyword);
        commodity.setComFormat(format);
        commodity.setComPack(pack);
        commodity.setComUnit(unit);
        commodity.setComPrice(new BigDecimal(price));
        commodity.setComRetail(new BigDecimal(retail));
        commodity.setComWholesale(new BigDecimal(wholesale));
        commodity.setComMainImg(mainImg);

        commodity.setComStatus(status);
        commodity.setComComment(comment?1:0);
        commodity.setComBarCode(barCode);
        commodity.setComHot(hot);
        commodity.setComDetail(detail);
        commodity.setComCreated(DateUtil.conventStr2Date(created));
        commodity.setComUpdated(DateUtil.conventStr2Date(updated));
        commodity.setOriId(oriId);
        commodity.setCosoId(StringUtil.convertList2Str(cosoId));
        commodity.setCocaId(cocaId);
        return commodity;
    }

    /**
     * <h4>CommodityInfo对象转成CommodityParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,comName,comModel,comKeyword,comFormat,comPack,comUnit,comPrice,comRetail,comWholesale,
     * 	 comMainImg,comImages,comStatus,comComment,comBarCode,comHot,comDetail,
     * 	 comCreated,comUpdated,oriId,cosoId,cocaId]
     * </pre>
     */
    public CommodityParam compat(Commodity commodity){
        if (null == commodity){return new CommodityParam();}
        this.id = commodity.getId();
        this.name = commodity.getComName();
        this.model = commodity.getComModel();
        this.keyword = commodity.getComKeyword();
        this.format = commodity.getComFormat();
        this.pack = commodity.getComPack();
        this.unit = commodity.getComUnit();
        this.price = DecimalUtil.format(commodity.getComPrice());
        this.retail = DecimalUtil.format(commodity.getComRetail());
        this.wholesale = DecimalUtil.format(commodity.getComWholesale());
        this.mainImg = commodity.getComMainImg();
        this.images = StringUtil.splitImagesStr2List(commodity.getComImages());
        this.status = commodity.getComStatus();
        this.comment = commodity.getComComment() == 1 ? true:false;
        this.barCode = commodity.getComBarCode();
        this.hot = commodity.getComHot();
        this.detail = commodity.getComDetail();
        this.created = DateUtil.conventDate2Str(commodity.getComCreated());
        this.updated = DateUtil.conventDate2Str(commodity.getComUpdated());
        this.oriId = commodity.getOriId();
        this.cosoId = StringUtil.splitToListString(commodity.getCosoId());
        this.cocaId = commodity.getCocaId();
        return this;
    }

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
	 * @param model 型号 
	 */ 
	public void setModel(String model){
		this.model = model;
	}

	/** 
	 * @return 型号 
	 */ 
	public String getModel(){
		return model;
	}

	/** 
	 * @param keyword 关键词 
	 */ 
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}

	/** 
	 * @return 关键词 
	 */ 
	public String getKeyword(){
		return keyword;
	}

	/** 
	 * @param format 规格 
	 */ 
	public void setFormat(String format){
		this.format = format;
	}

	/** 
	 * @return 规格 
	 */ 
	public String getFormat(){
		return format;
	}

	/** 
	 * @param pack 包装 
	 */ 
	public void setPack(String pack){
		this.pack = pack;
	}

	/** 
	 * @return 包装 
	 */ 
	public String getPack(){
		return pack;
	}

	/** 
	 * @param unit 单位 
	 */ 
	public void setUnit(String unit){
		this.unit = unit;
	}

	/** 
	 * @return 单位 
	 */ 
	public String getUnit(){
		return unit;
	}

	/** 
	 * @param price 成本价 
	 */ 
	public void setPrice(String price){
		this.price = price;
	}

	/** 
	 * @return 成本价 
	 */ 
	public String getPrice(){
		return price.replace("￥","");
	}

	/** 
	 * @param retail 零售价 
	 */ 
	public void setRetail(String retail){
		this.retail = retail;
	}

	/** 
	 * @return 零售价 
	 */ 
	public String getRetail(){
		return retail.replace("￥","");
	}

	/** 
	 * @param wholesale 批发价 
	 */ 
	public void setWholesale(String wholesale){
		this.wholesale = wholesale;
	}

	/** 
	 * @return 批发价 
	 */ 
	public String getWholesale(){
		return wholesale.replace("￥","");
	}

	/** 
	 * @param mainImg 主图地址 
	 */ 
	public void setMainImg(String mainImg){
		this.mainImg = mainImg;
	}

	/** 
	 * @return 主图地址 
	 */ 
	public String getMainImg(){
		return mainImg;
	}

	/** 
	 * @param images 图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用","隔开 
	 */ 
	public void setImages(List<String> images){
		this.images = images;
	}

	/** 
	 * @return 图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用","隔开 
	 */ 
	public List<String> getImages(){
		return images;
	}

	/** 
	 * @param status 是否显示，1为显示，0不显示，默认为1 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 是否显示，1为显示，0不显示，默认为1 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param comment 是否可以评论，1可以评论,0不能评论 
	 */ 
	public void setComment(boolean comment){
		this.comment = comment;
	}

	/** 
	 * @return 是否可以评论，1可以评论,0不能评论 
	 */ 
	public boolean getComment(){
		return comment;
	}

    /**
	 * @param barCode 条形码 
	 */ 
	public void setBarCode(String barCode){
		this.barCode = barCode;
	}

	/** 
	 * @return 条形码 
	 */ 
	public String getBarCode(){
		return barCode;
	}

	/** 
	 * @param hot 商品热度点击1次加1 
	 */ 
	public void setHot(Integer hot){
		this.hot = hot;
	}

	/** 
	 * @return 商品热度点击1次加1 
	 */ 
	public Integer getHot(){
		return hot;
	}

	/** 
	 * @param detail 详细 
	 */ 
	public void setDetail(String detail){
		this.detail = detail;
	}

	/** 
	 * @return 详细 
	 */ 
	public String getDetail(){
		return detail;
	}

	/** 
	 * @param created 创建时间 
	 */ 
	public void setCreated(String created){
		this.created = created;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public String getCreated(){
		return created;
	}

	/** 
	 * @param updated 更新时间 
	 */ 
	public void setUpdated(String updated){
		this.updated = updated;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public String getUpdated(){
		return updated;
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
	public void setCosoId(List<String> cosoId){
		this.cosoId = cosoId;
	}

	/** 
	 * @return 商品分类编号的集合,[0,1,2...] 
	 */ 
	public List<String> getCosoId(){
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

    /**
     * @return 图片名称
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * @param imgName 图片名称
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * @return 完整路径
     */
    public String getCompletePath() {
        return completePath;
    }

    /**
     * @param completePath 完整路径
     */
    public void setCompletePath(String completePath) {
        this.completePath = completePath;
    }

    /**
     * @return 主图片对象
     */
    public MultipartFile getImgFile() {
        return imgFile;
    }

    /**
     * @param imgFile 主图片对象
     */
    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    /**
     * @return 图片文件对象集合
     */
    public MultipartFile[] getFiles() {
        return files;
    }

    /**
     * @param files 图片文件对象集合
     */
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    /**
     * @return 前缀路径
     */
    public String getPrefixPath() {
        return prefixPath;
    }

    /**
     * @param prefixPath 前缀路径
     */
    public void setPrefixPath(String prefixPath) {
        this.prefixPath = prefixPath;
    }

}
