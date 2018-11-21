package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.SysWebConfig;
import cn.peyton.spring.validator.constraints.Length;

/**
 * <h3>网站扩展配置 实体类 .</h3>
 * <pre>
 * @Author: <a href="http://www.peyton.cn">peyton</a>
 * @Email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @ProjectName: lemon
 * @PackageName: cn.peyton.spring.permission.param.WebConfigExtParam.java
 * @CreateDate: 2018-09-04 22:51
 * @Version: 1.0.0
 * </pre>
 */
public final class WebConfigExtParam {
    /** 编号  */
    private Integer id;
    /** 关键词设置  */
    @Length(min = 0,max = 500,message = "关键字长度不能超过500个字符!")
    private String webKeyword;
    /** 上传文件目录  */
    @Length(min = 0,max = 100,message = "上传文件目录长度不能超过100个字符!")
    private String webUploadPath;
    /** 网站皮肤  */
    @Length(min = 0,max = 150,message = "皮肤长度不能超过150个字符!")
    private String webSkin;
    /** 统计代码  */
    private String webCensusCode;

//================================== Method =======================================//
    /**
     * <h4>对象转成SysWebConfig对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webKeyword,webUploadPath,webSkin,webCensusCode]
     * </pre>
     */
    public SysWebConfig convert(){
        SysWebConfig sysWebConfig = new SysWebConfig();
        sysWebConfig.setId(id);
        sysWebConfig.setWebKeyword(webKeyword);
        sysWebConfig.setWebUploadPath(webUploadPath);
        sysWebConfig.setWebSkin(webSkin);
        sysWebConfig.setWebCensusCode(webCensusCode);
        return sysWebConfig;
    }

    /**
     * <h4>SysWebConfig对象转成WebConfigExtParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,webKeyword,webUploadPath,webSkin,webCensusCode]
     * </pre>
     */
    public WebConfigExtParam compat(SysWebConfig sysWebConfig){
        if(null == sysWebConfig){return new WebConfigExtParam();}
        this.id = sysWebConfig.getId();
        this.webKeyword = sysWebConfig.getWebKeyword();
        this.webUploadPath = sysWebConfig.getWebUploadPath();
        this.webSkin = sysWebConfig.getWebSkin();
        this.webCensusCode = sysWebConfig.getWebCensusCode();
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
     * @param webKeyword 关键词设置
     */
    public void setWebKeyword(String webKeyword){
        this.webKeyword = webKeyword;
    }

    /**
     * @return 关键词设置
     */
    public String getWebKeyword(){
        return webKeyword;
    }

    /**
     * @param webUploadPath 上传文件目录
     */
    public void setWebUploadPath(String webUploadPath){
        this.webUploadPath = webUploadPath;
    }

    /**
     * @return 上传文件目录
     */
    public String getWebUploadPath(){
        return webUploadPath;
    }

    /**
     * @param webSkin 网站皮肤
     */
    public void setWebSkin(String webSkin){
        this.webSkin = webSkin;
    }

    /**
     * @return 网站皮肤
     */
    public String getWebSkin(){
        return webSkin;
    }

    /**
     * @param webCensusCode 统计代码
     */
    public void setWebCensusCode(String webCensusCode){
        this.webCensusCode = webCensusCode;
    }

    /**
     * @return 统计代码
     */
    public String getWebCensusCode(){
        return webCensusCode;
    }
}
