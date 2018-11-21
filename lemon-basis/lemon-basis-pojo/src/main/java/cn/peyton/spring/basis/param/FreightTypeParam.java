package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.FreightType;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.validator.constraints.*;

/**
 *
 * <h3>货运类型参数 传递类[用来展示数据]</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.mall.param.FreightTypeParam.java
 * @createDate: 2018-09-09 23:25
 * @version: 1.0.0
 * </pre>
 */
public final class FreightTypeParam{

    /** 编号  */
    private Integer id;
    /** 名称  */
    @NotBlank(message = "名称不能为空!")
    @Length(max = 50,message = "名称长度超出50个字符!")
    private String name;
    /** 电话  */
    @Telephone
    @Length(max = 50,message = "电话长度超出50个字符!")
    private String tel;
    /** 手机  */
    @Phone
    @Length(max = 50,message = "手机长度超出50个字符!")
    private String phone;
    /** 传真  */
    @Telephone
    @Length(max = 50,message = "传真长度超出50个字符!")
    private String fax;
    /** qq  */
    @Pattern(regexp = Regulation.REGEX_QQ,message = "QQ格式不正确!")
    @Length(max = 50,message = "QQ长度超出50个字符!")
    private String qq;
    /** 邮箱  */
    @Email
    @Length(max = 100,message = "邮箱长度超出100个字符!")
    private String email;
    /** 地址  */
    @Length(max = 100,message = "地址长度超出100个字符!")
    private String add;
    /** 说明  */
    @Length(max = 250,message = "说明长度超出250个字符!")
    private String explain;
    /** 创建时间  */
    private String created;
    /** 最后登录时间  */
    private String updated;

    //================================== Constructor =======================================//

    //================================== Method =======================================//
    /**
     * <h4>对象转成FreightType对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,frtName,frtTel,frtPhone,frtFax,frtQq,frtEmail,frtAdd,frtExplain,frtCreated,frtUpdated]
     * </pre>
     */
    public FreightType convert(){
        FreightType freightType = new FreightType();
        freightType.setId(id);
        freightType.setFrtName(name);
        freightType.setFrtTel(tel);
        freightType.setFrtPhone(phone);
        freightType.setFrtFax(fax);
        freightType.setFrtQq(qq);
        freightType.setFrtEmail(email);
        freightType.setFrtAdd(add);
        freightType.setFrtExplain(explain);
        return freightType;
    }

    /**
     * <h4>FreightType对象转成FreightTypeParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,frtName,frtTel,frtPhone,frtFax,frtQq,frtEmail,frtAdd,frtExplain,frtCreated,frtUpdated]
     * </pre>
     */
    public FreightTypeParam compat(FreightType freightType){
        if(null == freightType){return new FreightTypeParam();}
        this.id = freightType.getId();
        this.name = freightType.getFrtName();
        this.tel = freightType.getFrtTel();
        this.phone = freightType.getFrtPhone();
        this.fax = freightType.getFrtFax();
        this.qq = freightType.getFrtQq();
        this.email = freightType.getFrtEmail();
        this.add = freightType.getFrtAdd();
        this.explain = freightType.getFrtExplain();
        this.created = DateUtil.conventDate2Str(freightType.getFrtCreated());
        this.updated = DateUtil.conventDate2Str(freightType.getFrtUpdated());
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
     * @param fax 传真
     */
    public void setFax(String fax){
        this.fax = fax;
    }

    /**
     * @return 传真
     */
    public String getFax(){
        return fax;
    }

    /**
     * @param qq qq
     */
    public void setQq(String qq){
        this.qq = qq;
    }

    /**
     * @return qq
     */
    public String getQq(){
        return qq;
    }

    /**
     * @param email 邮箱
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * @return 邮箱
     */
    public String getEmail(){
        return email;
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
