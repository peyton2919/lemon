package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.Origin;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;

/**
 * <h3>产地参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.param.OriginParam.java
 * @createDate: 2018/9/13 12:01
 * @version: 1.0.0
 * </pre>
 */
public final class OriginParam {
    /** 编号  */
    private Integer id;
    /** 名称  */
    @NotBlank(message = "名称不能为空")
    @Length(max = 50,message = "名称不能超过50个字符")
    private String name;
    /** 说明  */
    @Length(max = 250,message = "说明长度不能超过250个字符")
    private String explain;

    //================================== Constructor =======================================//

    //================================== Method =======================================//
    /**
     * <h4>对象转成OriginInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,oriName,oriExplain]
     * </pre>
     */
    public Origin convert(){
        Origin origin = new Origin();
        origin.setId(id);
        origin.setOriName(name);
        origin.setOriExplain(explain);
        return origin;
    }

    /**
     * <h4>OriginInfo对象转成OriginParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,oriName,oriExplain]
     * </pre>
     */
    public OriginParam compat(Origin origin){
        if(null == origin){return new OriginParam();}
        this.id = origin.getId();
        this.name = origin.getOriName();
        this.explain = origin.getOriExplain();
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
     * @param explain 描述
     */
    public void setExplain(String explain){
        this.explain = explain;
    }

    /**
     * @return 描述
     */
    public String getExplain(){
        return explain;
    }
}
