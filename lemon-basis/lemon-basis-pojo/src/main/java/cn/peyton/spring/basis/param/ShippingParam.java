package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.Shipping;
import cn.peyton.spring.util.DateUtil;

/**
 * <h3></h3>
 * <pre>
 * Author: <a href="http://www.peyton.cn">peyton</a>
 * Email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * ProjectName: lemon
 * PackageName: cn.peyton.spring.mall.param.ShippingParam.java
 * CreateDate: 2018/9/11 15:42
 * Version: 1.0.0
 * </pre>
 */
public final class ShippingParam{

    /** 编号  */
    private Long id;
    /** 顾客编号  */
    //todo 应该改成订单号
    private Long custId;
    /** 名称  */
    private String name;
    /** 电话  */
    private String tel;
    /** 手机  */
    private String phone;
    /** 省份  */
    private String province;
    /** 城市  */
    private String city;
    /** 区/县  */
    private String district;
    /** 地址  */
    private String address;
    /** 邮编  */
    private String zip;
    /** 创建时间  */
    private String created;
    /** 最后登录时间  */
    private String updated;

    //================================== Constructor =======================================//

    //================================== Method =======================================//
    /**
     * <h4>对象转成ShippingInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,custId,shipName,shipTel,shipPhone,shipProvince,shipCity,shipDistrict,shipAddress,shipZip,shipCreated,shipUpdated]
     * </pre>
     */
    public Shipping convert() {
        Shipping shipping = new Shipping();
        shipping.setId(id);
        shipping.setCustId(custId);
        shipping.setShipName(name);
        shipping.setShipTel(tel);
        shipping.setShipPhone(phone);
        shipping.setShipProvince(province);
        shipping.setShipCity(city);
        shipping.setShipDistrict(district);
        shipping.setShipAddress(address);
        shipping.setShipZip(zip);
        shipping.setShipCreated(DateUtil.conventStr2Date(created));
        shipping.setShipUpdated(DateUtil.conventStr2Date(updated));
        return shipping;
    }
    /**
     * <h4>ShippingInfo对象转成ShippingParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,custId,shipName,shipTel,shipPhone,shipProvince,shipCity,shipDistrict,shipAddress,shipZip,shipCreated,shipUpdated]
     * </pre>
     */
    public ShippingParam compat(Shipping shipping) {
        if(null == shipping){return new ShippingParam();}
        this.id = shipping.getId();
        this.custId = shipping.getCustId();
        this.name = shipping.getShipName();
        this.tel = shipping.getShipTel();
        this.phone = shipping.getShipPhone();
        this.province = shipping.getShipProvince();
        this.city = shipping.getShipCity();
        this.district = shipping.getShipDistrict();
        this.address = shipping.getShipAddress();
        this.zip = shipping.getShipZip();
        this.created = DateUtil.conventDate2Str(shipping.getShipCreated());
        this.updated = DateUtil.conventDate2Str(shipping.getShipUpdated());
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
     * @param custId 顾客编号
     */
    public void setCustId(Long custId){
        this.custId = custId;
    }

    /**
     * @return 顾客编号
     */
    public Long getCustId(){
        return custId;
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
     * @param province 省份
     */
    public void setProvince(String province){
        this.province = province;
    }

    /**
     * @return 省份
     */
    public String getProvince(){
        return province;
    }

    /**
     * @param city 城市
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * @return 城市
     */
    public String getCity(){
        return city;
    }

    /**
     * @param district 区/县
     */
    public void setDistrict(String district){
        this.district = district;
    }

    /**
     * @return 区/县
     */
    public String getDistrict(){
        return district;
    }

    /**
     * @param address 地址
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * @return 地址
     */
    public String getAddress(){
        return address;
    }

    /**
     * @param zip 邮编
     */
    public void setZip(String zip){
        this.zip = zip;
    }

    /**
     * @return 邮编
     */
    public String getZip(){
        return zip;
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
     * @param updated 最后登录时间
     */
    public void setUpdated(String updated){
        this.updated = updated;
    }

    /**
     * @return 最后登录时间
     */
    public String getUpdated(){
        return updated;
    }

}
