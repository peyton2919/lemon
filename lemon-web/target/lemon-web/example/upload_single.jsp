<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<script src="/js/defined/tools.js"></script>
<script src="/js/defined/image.js"></script>
<script src="/js/defined/upload-single.js"></script>


<div class="control-group" style="width: 400px;">

    <%--  单图片上传 开始   --%>

    <div class="col-md-12">
        <div class="input-group">
            <input id="upload-single-img-name" name="imgName" placeholder="图片不能为空" class="form-control" readonly type="text">
            <label class="input-group-btn">
                <input id="upload-single-img-file" type="file" name="imgFile" style="left: -9999px; position: absolute; display: none;">
                <span class="btn btn-default" id="btn-upload-single-img">Browse</span>
            </label>
        </div>
    </div>
    <%--//图片显示--%>
    <div class="col-md-12" id="upload-single-img-div" style="display:none">
        <img id="upload-single-img-display" src="" width="100px" height="100px" >
        <%--<i class="glyphicon glyphicon-remove red remove-img"--%>
        <%--style=" position: absolute; top:8px;left: 90px; color: #be0000"></i>--%>
    </div>

    <%--  单图片上传 结束  --%>
</div>

<%--
//详细 加载图片 用法
$("#upload-single-img-display").imgLoad(webConfig.webLogoImage,"upload-single-img-div","upload-single-img-name");
--%>


<%--
    需要在对应的 对象实体类 添加三个属性对象
    1. imgName 图片名称 简短型 [aaa.png];
    2. completePath 图片完整路径 [c:\xxx\xxx\xxx\aaa.png] ,处理程序异常时删除掉图片
    3. imgFile MultipartFile文件对象

    /** 图片名称 */
    private String imgName;
    /** 完整路径 */
    private String completePath;
    /** Logo  */
    private MultipartFile imgFile;

    //set and get method
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

    /**
     * @return Image
     */
    public MultipartFile getImgFile() {
        return imgFile;
    }

    /**
     * @param imgFile Image
     */
    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

--%>

<script >
    $(function () {
        //Browse 浏览 点击 事件
        $("#btn-upload-single-img").loadUpload({
            // displayDivId : 'upload-single-img-div', //标记 显示图片div层的id
            // imgId : 'upload-single-img-display', //标记要显示img的id
            // displayNameId : 'upload-single-img-name', //标记 显示 文件名称 id
            // fileId : 'upload-single-img-file'  //标记 input type= 'file' 的id
        });
    });

</script>

<%--
    后台处理方法
    public JsonData updateBase(WebConfigBaseParam param, HttpServletRequest request) {
        String path = PathUtil.getPath("/img/sys/",request);
        MultipartFile file = param.getLogoImgFile();
        String name = param.getImgName();
        //从session中获取图片名称
        Object tName = request.getSession().getAttribute(Constants.SESSION_WEBCONFIG_LOGO_IMAGE.name());
        if (null != tName){
            if (!tName.toString().equals(name)) {
                if ("".equals(file.getOriginalFilename())) {
                    throw new ParamException("Logo图片不能为空");
                }
                name = "logo.ico";
                path = path + name;
                //设置完整路径
                param.setCompletePath(path);
            }
            //设置保存在数据库中的路径 [/img/sys/aaa.png]
            param.setWebLogoImage("/img/sys/" + name);
        }else {
            throw new GlobalException("读取图片数据不正常,请重新加载...");
        }
        if (file.getSize() > 0) {
            try {
                 //保存图片
                ImageUtil.scale(file,path,600,600,true);
            } catch (Exception e) {
                //保存异常删除图片
                FolderOperation.delFile(path);
               throw new GlobalException("图片保存错误!");
            }
        }
        //调用相应的更新方法
        sysWebConfigService.updateBase(param);
        return JsonData.success();
    }
--%>