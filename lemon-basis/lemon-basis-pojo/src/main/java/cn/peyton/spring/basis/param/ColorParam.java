package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.Color;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;

/**
 * <h3>颜色参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.param.ColorParam.java
 * @createDate: 2018/9/13 12:01
 * @version: 1.0.0
 * </pre>
 */
public final class ColorParam {

    /** 编号  */
    private Integer id;
    /** 颜色名称  */
    @NotBlank(message = "名称不能为空")
    @Length(max = 50,message = "名称长度不能超过50个字符")
    private String name;
    /** 颜色代码  */
    @Length(max = 20,message = "颜色代码长度不能超过20个字符")
    private String code;

    //================================== Constructor =======================================//

    //================================== Method =======================================//
    /**
     * <h4>对象转成ColorInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,colName,colCode]
     * </pre>
     */
    public Color convert(){
        Color color = new Color();
        color.setId(id);
        color.setColName(name);
        color.setColCode(code);
        return color;
    }

    /**
     * <h4>ColorInfo对象转成ColorParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,colName,colCode]
     * </pre>
     */
    public ColorParam compat(Color color){
        if(null == color){return new ColorParam();}
        this.id = color.getId();
        this.name = color.getColName();
        this.code = color.getColCode();
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
     * @param name 颜色名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return 颜色名称
     */
    public String getName(){
        return name;
    }

    /**
     * @param code 颜色代码
     */
    public void setCode(String code){
        this.code = code;
    }

    /**
     * @return 颜色代码
     */
    public String getCode(){
        return code;
    }
}
