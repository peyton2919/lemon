//单个文件上传
;
/**
 * <h4>单个文件上传</h4>
 * @param options 包含4个值
 * <pre>
 *  displayDivId : 'upload-single-img-div', //标记 显示图片div层的id<br>
 *  imgId : 'upload-single-img-display', //标记要显示img的id<br>
 *  displayNameId : 'upload-single-img-name', //标记 显示 文件名称 id<br>
 *  fileId : 'upload-single-img-file'  //标记 input type= 'file' 的id<br>
 * </pre>
 */
$.fn.loadUpload = function(options){
    var defaults = {
        displayDivId : 'upload-single-img-div', //标记 显示图片div层的id
        imgId : 'upload-single-img-display', //标记要显示img的id
        displayNameId : 'upload-single-img-name', //标记 显示 文件名称 id
        fileId : 'upload-single-img-file',  //标记 input type= 'file' 的id
        type : 'png,jpg,gif,jpeg,icon,ico'
    };

    var _options = $.extend(defaults, options);
    $(this).click(function (e) {
        var file = document.getElementById(_options.fileId);
        file.value = ''; //重新初始化了file的html
    });

    $("#" + _options.fileId).change(function (e) {
        var file = e.target.files[0] || e.dataTransfer.files[0];
        var name = file.name;
        var ext = subObj(name);
        if (contains(_options.type,ext)){
            if (file) {
                $("#" + _options.displayDivId).show();
                $("#" + _options.displayNameId).val(name);
                var reader = new FileReader();
                reader.onload = function () {
                    $("#" + _options.imgId).attr("src", this.result);
                }
                reader.readAsDataURL(file);
            }
        }
    });

    //移除图片点击事件
    $(".remove-img").click(function (e) {
        $("#" + _options.imgId).attr("src", "");
        $("#" + _options.displayNameId).val("");
        $("#" + _options.displayDivId).hide();
        var file = document.getElementById(_options.fileId);
        file.value = ''; //重新初始化了file的html
    });
};

/**
 * <h4>重置</h4>
 * @param options 包含4个值
 * <pre>
 *  displayDivId : 'upload-single-img-div', //标记 显示图片div层的id<br>
 *  imgId : 'upload-single-img-display', //标记要显示img的id<br>
 *  displayNameId : 'upload-single-img-name', //标记 显示 文件名称 id<br>
 *  fileId : 'upload-single-img-file'  //标记 input type= 'file' 的id<br>
 * </pre>
 */
function imgReset(options) {
    var defaults = {
        displayDivId : 'upload-single-img-div', //标记 显示图片div层的id
        imgId : 'upload-single-img-display', //标记要显示img的id
        displayNameId : 'upload-single-img-name', //标记 显示 文件名称 id
        fileId : 'upload-single-img-file',  //标记 input type= 'file' 的id
        type:'png,jpg,gif,jpeg,icon,ico'
    };
    var _options = $.extend(defaults, options);
    $("#" + _options.imgId).attr("src", "");
    $("#" + _options.displayNameId).val("");
    $("#" + _options.displayDivId).hide();
    var file = document.getElementById(_options.fileId);
    file.value = ''; //重新初始化了file的html
}


//demo 参数的配置 说明与调用方式

// <div class="col-md-12">//1
//     <div class="input-group">
//     <input id="upload-single-img-name" name="imgName" placeholder="图片不能为空" class="form-control" readonly type="text">
//     <label class="input-group-btn">
//     <input id="upload-single-img-file" type="file" name="imgFile" style="left: -9999px; position: absolute; display: none;">
//     <span class="btn btn-default" id="btn-upload-single-img">Browse</span>
//     </label>
//     </div>
//     </div>
//     <%--//图片显示 10 --%>
//     <div class="col-md-12" id="upload-single-img-div" style="display:none">
//     <img id="upload-single-img-display" src="" width="100px" height="100px" >
//     <%--<i class="glyphicon glyphicon-remove red remove-img"--%>
//     <%--style=" position: absolute; top:8px;left: 90px; color: #be0000"></i>--%>
// </div>//15

//说明 1. 第11行 div[id = "upload-single-img-div"] 层用来控制要显示 图片与隐藏图片 [第一个参数]
//     2. 第12行 img[id = "upload-single-img-display"] 用来要展示图片 [第二个参数]
//     3. 第3行 input[type = "text" id = "upload-single-img-nam"] 用来显示图片文件名 [第三个参数]
//     4. 第5行 input[type = "file" id = "upload-single-img-file"] 隐藏文件对象,真正操作就是这个控件 [第四个参数]
//     5. 第16行 [可以随便标签] [id = "btn-upload-single-img"] 这个id 调用 loadUpload 方法就可以执行
//     6. 加载 就用 $('#btn-upload-single-img').loadUpload();
//     7. 注意: 第3行和第5行中的name 值 要和对象属性的名称一致
// ==================================  param类中多添加这两个属性 开始 ================================== //
/** 图片名称 */
// private String imgName;
/** 完整路径 */
// private String completePath;
/** Logo  */
// private MultipartFile imgFile;
// ==================================  param类中多添加这两个属性 结束 ================================== //


//方式一 Jquery实现
// function saveUser2() {
//     var id = $("#id").val().trim();
//     var uname = $("#uname").val().trim();
//     var pwd = $("#pwd").val().trim();
//     var file = document.getElementById("file").files[0];
//     var formData = new FormData();
//     formData.append('id', id);
//     formData.append('uname', uname);
//     formData.append('pwd', pwd);
//     formData.append('file', file);
//
//     $.ajax({
//         url: "/home/about",
//         type: "post",
//         data: formData,
//         contentType: false,
//         processData: false,
//         mimeType: "multipart/form-data",
//         success: function (data) {
//             console.log(data);
//         },
//         error: function (data) {
//             console.log(data);
//         }
//     });
// }
//
// //方式二  原生ajax实现
// function saveUser() {
//     var id = $("#id").val().trim();
//     var uname = $("#uname").val().trim();
//     var pwd = $("#pwd").val().trim();
//     var file = document.getElementById("file").files[0];
//
//     //原生ajax实现文件上传
//     var form = new FormData();
//     form.append("uname", uname); // 可以增加表单数据
//     form.append("id", id);
//     form.append("pwd", pwd);
//     if (file) {
//         form.append("file", file);
//     }
//
//     //得到xhr对象
//     var xhr = null;
//     if (XMLHttpRequest) {
//         xhr = new XMLHttpRequest();
//     } else {
//         xhr = new ActiveXObject("Microsoft.XMLHTTP");
//     }
//
//     xhr.open("post", "/home/about", true);//设置提交方式，url，异步提交
//     xhr.onload = function () {
//         var data = xhr.responseText;    //得到返回值
//         alert(data);
//     }
//     xhr.send(form);
// }






