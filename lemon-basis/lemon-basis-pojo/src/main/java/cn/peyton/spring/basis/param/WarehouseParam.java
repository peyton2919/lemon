package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.Warehouse;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.validator.constraints.*;

/**
 * <h3>仓库参数 传递类[用来展示数据]</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:22
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class WarehouseParam {
    /** 编号  */
    private Integer id;
    /** 名称  */
    @NotBlank(message = "名称不能为空!")
    @Length(max = 50,message = "名称长度超出!")
    private String name;
    /** 电话  */
    @Telephone
    @Length(max = 50,message = "电话长度超出!")
    private String tel;
    /** 手机  */
    @Phone
    @Length(max = 50,message = "手机长度超出!")
    private String phone;
    /** 地址  */
    @Length(max = 100,message = "地址长度超出!")
    private String add;
    /** QQ  */
    @Pattern(regexp = Regulation.REGEX_QQ,message = "QQ格式不正确!")
    @Length(max = 50,message = "QQ长度超出!")
    private String qq;
    /** 位置  */
    @Length(max = 50,message = "位置长度超出!")
    private String location;
    /** 说明  */
    @Length(max = 250,message = "说明长度超出!")
    private String explain;

    //================================== Constructor =======================================//

    //================================== Method =======================================//

    /**
     * <h4>对象转成WarehouseInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,warName,warTel,warPhone,warAdd,warQq,warLocation,warExplain]
     * </pre>
     */
    public Warehouse convert(){
        Warehouse warehouse = new Warehouse();
        warehouse.setId(id);
        warehouse.setWarName(name);
        warehouse.setWarTel(tel);
        warehouse.setWarPhone(phone);
        warehouse.setWarAdd(add);
        warehouse.setWarQq(qq);
        warehouse.setWarLocation(location);
        warehouse.setWarExplain(explain);
        return warehouse;
    }

    /**
     * <h4>WarehouseInfo对象转成WarehouseParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,warName,warTel,warPhone,warAdd,warQq,warLocation,warExplain]
     * </pre>WarehouseParam
     */
    public WarehouseParam compat(Warehouse warehouse){
        if(null == warehouse){return new WarehouseParam();}
        this.setId(warehouse.getId());
        this.setName(warehouse.getWarName());
        this.setTel(warehouse.getWarTel());
        this.setPhone(warehouse.getWarPhone());
        this.setAdd(warehouse.getWarAdd());
        this.setQq(warehouse.getWarQq());
        this.setLocation(warehouse.getWarLocation());
        this.setExplain(warehouse.getWarExplain());
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
     * @param tel 电话
     */
    public void setTel(String tel){
        this.tel = tel;
    }

    /**
     * @return 电话
     */
    public String getTel(){
        return tel;
    }

    /**
     * @param phone 手机
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * @return 手机
     */
    public String getPhone(){
        return phone;
    }

    /**
     * @param add 地址
     */
    public void setAdd(String add){
        this.add = add;
    }

    /**
     * @return 地址
     */
    public String getAdd(){
        return add;
    }

    /**
     * @param qq QQ
     */
    public void setQq(String qq){
        this.qq = qq;
    }

    /**
     * @return QQ
     */
    public String getQq(){
        return qq;
    }

    /**
     * @param location 位置
     */
    public void setLocation(String location){
        this.location = location;
    }

    /**
     * @return 位置
     */
    public String getLocation(){
        return location;
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
}
