package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.entity.CommodityCategory;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.util.Lists;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Size;

import java.util.List;

/**
 * <h3>商品分类多层类 参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.param.CommodityCategoryParam.java
 * @createDate: 2018-09-13 22:14
 * @version: 1.0.0
 * </pre>
 */
public final class CommodityCategoryParam {

    /** 编号  */
    private Long id;
    /** 父编号  */
    private Long parentId;
    /** 名称  */
    @NotBlank(message = "名称不能为空!")
    @Length(max = 50,message = "名称长度超出了!")
    private String name;
    /** 商品分类层级  */
    @Length(max = 200,message = "层级长度超出了!")
    private String level;
    /**
     * 排序,按升序
     */
    @NotBlank(message = "排序不能为空!")
    @Size(min = 0, max = 999, message = "排序范围0-999!")
    private Integer seq;
    /** 说明  */
    @Length(max = 100,message = "说明长度超出!")
    private String explain;
    /** 创建时间  */
    private String created;
    /** 更新时间  */
    private String updated;
    /**  子栏目集合 [递归]     */
    private List<CommodityCategoryParam> commodityCategoryList = Lists.newArrayList();

    //================================== Constructor =======================================//

    //================================== Method =======================================//
    /**
     * <h4>对象转成CommodityCategory对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,parentId,cocaName,cocaLevel,cocaSeq,cocaExplain,cocaCreated,cocaUpdated]
     * </pre>
     */
    public CommodityCategory convert(){
        CommodityCategory commodityCategory = new CommodityCategory();
        commodityCategory.setId(id);
        commodityCategory.setParentId(parentId);
        commodityCategory.setCocaName(name);
        commodityCategory.setCocaLevel(level);
        commodityCategory.setCocaSeq(seq);
        commodityCategory.setCocaExplain(explain);
        commodityCategory.setCocaCreated(DateUtil.conventStr2Date(created));
        commodityCategory.setCocaUpdated(DateUtil.conventStr2Date(updated));
        return commodityCategory;
    }

    /**
     * <h4>CommodityCategory对象转成CommodityCategoryParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,parentId,cocaName,cocaLevel,cocaSeq,cocaExplain,cocaCreated,cocaUpdated]
     * </pre>
     */
    public CommodityCategoryParam compat(CommodityCategory commodityCategory){
        if(null == commodityCategory){return new CommodityCategoryParam();}
        this.id = commodityCategory.getId();
        this.parentId = commodityCategory.getParentId();
        this.name = commodityCategory.getCocaName();
        this.level = commodityCategory.getCocaLevel();
        this.seq = commodityCategory.getCocaSeq();
        this.explain = commodityCategory.getCocaExplain();
        this.created = DateUtil.conventDate2Str(commodityCategory.getCocaCreated());
        this.updated = DateUtil.conventDate2Str(commodityCategory.getCocaUpdated());
        return this;
    }

    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @return 编号
     */
    public Long getId(){
        return id;
    }

    /**
     * @param parentId 父编号
     */
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    /**
     * @return 父编号
     */
    public Long getParentId(){
        return parentId;
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
     * @param level 商品分类层级
     */
    public void setLevel(String level){
        this.level = level;
    }

    /**
     * @return 商品分类层级
     */
    public String getLevel(){
        return level;
    }

    /**
     * @param seq 排序,按升序
     */
    public void setSeq(Integer seq){
        this.seq = seq;
    }

    /**
     * @return 排序,按升序
     */
    public Integer getSeq(){
        return seq;
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
     * @return 子栏目集合 [递归]
     */
    public List<CommodityCategoryParam> getCommodityCategoryList() {
        return commodityCategoryList;
    }

    /**
     * @param commodityCategoryList 子栏目集合 [递归]
     */
    public void setCommodityCategoryList(List<CommodityCategoryParam> commodityCategoryList) {
        this.commodityCategoryList = commodityCategoryList;
    }
}
