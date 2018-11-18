package cn.peyton.spring.permission.param;

import cn.peyton.spring.permission.entity.SysCategory;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Pattern;
import cn.peyton.spring.validator.constraints.Size;

import java.util.LinkedList;

/**
 * <h3>栏目参数 传递类[用来展示数据]</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 14:22
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class CategoryParam {
    /** 编号  */
    private Integer id;
    /** 父编号  */
    @NotBlank(message = "父级编号不能为空!")
    private Integer parentId;
    /** 名称  */
    @NotBlank(message = "栏目名称不能为空!")
    @Length(min = 1,max = 50,message = "栏目名称长度在1到50之间")
    private String name;
    /** 地址  */
    @Length(min = 0,max = 250,message = "链接地址长度不能超过250个字!")
    private String url;
    /** 前样式  */
    @Length(min = 0,max = 100,message = "前面样式长度不能超过100个字!")
    private String beforeStyle;
    /** 后样式  */
    @Length(min = 0,max = 100,message = "后面样式长度不能超过100个字!")
    private String afterStyle;
    /** 排序 从小到大排序  */
    @NotBlank(message = "排序不能为空!")
    @Pattern(regexp = Regulation.REGEX_INT,message = "排序格式出错!")
    private Integer seq;
    /** 状态 0 不可用 1 可用 2 删除 默认 1  */
    @NotBlank(message = "状态不能为空!")
    @Size(min = 0,max = 2,message = "状态数值超出")
    private Integer status;
    /** 类目类型 0 顾客 1 供应商 2 员工 3 管理员  */
    @NotBlank(message = "栏目类型不能为空!")
    @Size(min = 0,max = 4,message = "栏目状态超出！")
    private Integer type;
    /** 子栏目集合  */
    private LinkedList<CategoryParam> children;

    /**
     * <h4>对象转成SysCategory对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,parentId,cateName,cateUrl,cateBeforeStyle,cateAfterStyle,cateSeq,cateStatus,cateType]
     * </pre>
     */
    public SysCategory convert(){
        SysCategory sysCategory = new SysCategory();
        sysCategory.setId(id);
        sysCategory.setParentId(parentId);
        sysCategory.setCateName(name);
        sysCategory.setCateUrl(url);
        sysCategory.setCateBeforeStyle(beforeStyle);
        sysCategory.setCateAfterStyle(afterStyle);
        sysCategory.setCateSeq(seq);
        sysCategory.setCateStatus(status);
        sysCategory.setCateType(type);
        return sysCategory;
    }

    /**
     * <h4>SysCategory对象转成CategoryParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,pId,cateName,cateUrl,cateBeforeStyle,cateAfterStyle,cateSeq,cateStatus,cateType]
     * </pre>
     */
    public CategoryParam compat(SysCategory sysCategory){
        if(null == sysCategory){return new CategoryParam();}
        this.setId(sysCategory.getId());
        this.setParentId(sysCategory.getParentId());
        this.setName(sysCategory.getCateName());
        this.setUrl(sysCategory.getCateUrl());
        this.setBeforeStyle(sysCategory.getCateBeforeStyle());
        this.setAfterStyle(sysCategory.getCateAfterStyle());
        this.setSeq(sysCategory.getCateSeq());
        this.setStatus(sysCategory.getCateStatus());
        this.setType(sysCategory.getCateType());
        return this;
    }

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
     * @param parentId 父编号
     */
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }

    /**
     * @return 父编号
     */
    public Integer getParentId(){
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
     * @param url 地址
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * @return 地址
     */
    public String getUrl(){
        return url;
    }

    /**
     * @param beforeStyle 前样式
     */
    public void setBeforeStyle(String beforeStyle){
        this.beforeStyle = beforeStyle;
    }

    /**
     * @return 前样式
     */
    public String getBeforeStyle(){
        return beforeStyle;
    }

    /**
     * @param afterStyle 后样式
     */
    public void setAfterStyle(String afterStyle){
        this.afterStyle = afterStyle;
    }

    /**
     * @return 后样式
     */
    public String getAfterStyle(){
        return afterStyle;
    }

    /**
     * @param seq 排序 从小到大排序
     */
    public void setSeq(Integer seq){
        this.seq = seq;
    }

    /**
     * @return 排序 从小到大排序
     */
    public Integer getSeq(){
        return seq;
    }

    /**
     * @param status 状态 0 不可用 1 可用 2 删除 默认 1
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * @return 状态 0 不可用 1 可用 2 删除 默认 1
     */
    public Integer getStatus(){
        return status;
    }

    /**
     * @param type 类目类型 0 顾客 1 供应商 2 员工 3 管理员
     */
    public void setType(Integer type){
        this.type = type;
    }

    /**
     * @return 类目类型 0 顾客 1 供应商 2 员工 3 管理员
     */
    public Integer getType(){
        return type;
    }

    /**
     * @return 子栏目集合
     */
    public LinkedList<CategoryParam> getChildren() {
        return children;
    }

    /**
     * @param children 子栏目集合
     */
    public void setChildren(LinkedList<CategoryParam> children) {
        this.children = children;
    }
}
