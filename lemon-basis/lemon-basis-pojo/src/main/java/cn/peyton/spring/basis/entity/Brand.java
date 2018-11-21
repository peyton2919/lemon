package cn.peyton.spring.basis.entity;

/**
 * <h3>品牌 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 16:06:05
 * @version 1.0.0
 * </pre>
*/
public class Brand {
    /** 编号  */
    private Integer id;
    /** 供应商编号  */
    private Long supId;
    /** 品牌LOGO 图片大小120px*60px  */
    private String brandLogo;
    /** 所属地区  */
    private String brandArea;
    /** 品牌名称  */
    private String brandName;
    /** 排序 从小到大  */
    private Integer brandSeq;
    /** 状态，1为可用，0不可用，2为删除, 默认为1  */
    private Integer brandStatus;
    /** 品牌描述  */
    private String brandExplain;

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
     * @param brandLogo 品牌LOGO 图片大小120px*60px
     */
    public void setBrandLogo(String brandLogo){
        this.brandLogo = brandLogo;
    }

    /**
     * @return 品牌LOGO 图片大小120px*60px
     */
    public String getBrandLogo(){
        return brandLogo;
    }

    /**
     * @param brandArea 所属地区
     */
    public void setBrandArea(String brandArea){
        this.brandArea = brandArea;
    }

    /**
     * @return 所属地区
     */
    public String getBrandArea(){
        return brandArea;
    }

    /**
     * @param brandSeq 排序 从小到大
     */
    public void setBrandSeq(Integer brandSeq){
        this.brandSeq = brandSeq;
    }

    /**
     * @return 排序 从小到大
     */
    public Integer getBrandSeq(){
        return brandSeq;
    }

    /**
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }

    /**
     * @return 品牌名称
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * @param brandStatus 状态，1为可用，0不可用，2为删除, 默认为1
     */
    public void setBrandStatus(Integer brandStatus){
        this.brandStatus = brandStatus;
    }

    /**
     * @return 状态，1为可用，0不可用，2为删除, 默认为1
     */
    public Integer getBrandStatus(){
        return brandStatus;
    }

    /**
     * @param brandExplain 品牌描述
     */
    public void setBrandExplain(String brandExplain){
        this.brandExplain = brandExplain;
    }

    /**
     * @return 品牌描述
     */
    public String getBrandExplain(){
        return brandExplain;
    }
}
