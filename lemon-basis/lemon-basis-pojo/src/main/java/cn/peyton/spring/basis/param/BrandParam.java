package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.Brand;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 * <h3>品牌 参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
public final class BrandParam {
    /** 编号  */
    private Integer id;
    /** 供应商编号  */
    @NotBlank(message = "供应商不能为空")
    private Long supId;
    /** 品牌LOGO 图片大小120px*60px  */
    @Length(max = 150,message = "品牌图片地址不能超过150个字符")
    private String logo;
    /** 所属地区  */
    @NotBlank(message = "品牌地区不能为空")
    @Length(max = 50,message = "品牌地区不能超过50个字符")
    private String area;
    /** 品牌名称  */
    @NotBlank(message = "名称不能为空")
    @Length(max = 50,message = "名称不能超过50个字符")
    private String name;
    /** 排序 从小到大  */
    @NotBlank(message = "排序不能为空")
    @Size(min = 0,max = 10000,message = "排序大小在0到10000之间")
    private Integer seq;
    /** 状态，1为可用，0不可用，2为删除, 默认为1  */
    private Integer status;
    /** 品牌描述  */
    @Length(max = 50,message = "说明不能超过250个字符")
    private String explain;
    /** 图片名称 */
    private String imgName;
    /** 完整路径 */
    private String completePath;
    /** Image */
    private MultipartFile imgFile;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成BrandInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,supId,brandLogo,brandArea,brandName,brandSeq,brandStatus,brandExplain]
     * </pre>
     */
    public Brand convert(){
        Brand brand = new Brand();
        brand.setId(id);
        brand.setSupId(supId);
        brand.setBrandLogo(logo);
        brand.setBrandArea(area);
        brand.setBrandName(name);
        brand.setBrandStatus(status);
        brand.setBrandExplain(explain);
        brand.setBrandSeq(seq);
        return brand;
    }

    /**
     * <h4>BrandInfo对象转成BrandParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,supId,brandLogo,brandArea,brandName,brandSeq,brandStatus,brandExplain]
     * </pre>
     */
    public BrandParam compat(Brand brand){
        if (null == brand){return new BrandParam();}
        this.id = brand.getId();
        this.supId = brand.getSupId();
        this.logo = brand.getBrandLogo();
        this.area = brand.getBrandArea();
        this.name = brand.getBrandName();
        this.status = brand.getBrandStatus();
        this.explain = brand.getBrandExplain();
        this.seq = brand.getBrandSeq();
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
     * @param supId 供应商编号
     */
    public void setSupId(Long supId){
        this.supId = supId;
    }

    /**
     * @return 供应商编号
     */
    public Long getSupId(){
        return supId;
    }

	/** 
	 * @param name 品牌名称
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 品牌名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param explain 品牌描述
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 品牌描述 
	 */ 
	public String getExplain(){
		return explain;
	}

    /**
     * @return 品牌LOGO 图片大小120px*60px
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo 品牌LOGO 图片大小120px*60px
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return 所属地区
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area 所属地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return 排序 从小到大
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param seq 排序 从小到大
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * @return 状态，1为可用，0不可用，2为删除, 默认为1
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态，1为可用，0不可用，2为删除, 默认为1
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
