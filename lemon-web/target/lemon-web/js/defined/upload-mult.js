/**
 * <h4>多文件上传</h4>
 * @param ele [string] [生成组件的元素的选择器]
 * @param options [Object] [对组件设置的基本参数]
 * <pre>
 *  <b>options具体参数如下</b><br>
 *  url 图片上传的地址路径 必需<br>
 *  formId 表单Form ID <br>
 *  maxFileSize  上传文件默认1MB ,最大支持[KB] 1KB = 1024B ,1MB = 1024KB<br>
 *  maxFiles  上传的文件数量上限<br>
 *  images 用来回显的图片集合[数组]<br>
 *  oldPictureName 旧图片名称<br>
 *  oldPictureList 旧图片集合<br>
 *  abort 使异步停止默认false不停止<br>
 *  onMessage(res) 消息机制<br>
 *  onSuccess(res) 文件上传成功后的回调 参数为返回的文本 必需<br>
 *  onFailure(res) 文件上传失败后的回调 参数为返回的文本 必需<br>
 * </pre>
 * @return [function] [执行图片上传的函数] 
 * 调用方法
 * uploadMultipart('div', options)
 */
function uploadMultipart(ele,options) {

	//每个图片最大容量
	if(undefined == options.maxFileSize || null == options.maxFileSize ||
		"" == options.maxFileSize || "" == options.maxFileSize.trim()){
		options.maxFileSize = 1048576;
	}
	//最多默认上传10张图片
	if(undefined == options.maxFiles || null == options.maxFiles ||
		"" == options.maxFiles || "" == options.maxFiles.trim()){
		options.maxFiles = 10;
	}

    //暂停机制
    if(undefined == options.abort || null == options.abort ||
        "" == options.abort || "" == options.abort.trim()){
        options.abort = false;
    }
	
    // 判断容器元素合理性并且添加基础元素
    var eleList = document.querySelectorAll(ele);
    if(eleList.length == 0){
        console.log('绑定的元素不存在');
        return;
    }else if(eleList.length > 1){
        console.log('请绑定唯一元素');
        return;
    }else {
        var images = options.images;
        var str = '';
        if (undefined != images && null != images && images.length > 0) {
            var length = images.length;
            for(var i = 0; i< length ; i++) {
                str += '<div class="img-thumb img-item">' +
                    '<img class="thumb-icon old-pictures" src="' + images[i] + '">' +
                    '<a href="javscript:void(0);" class="img-remove" title="删除图片">×</a>'+
                    '</div>';
            }
        }

        eleList[0].innerHTML ='<div id="img-container" >'+
                str +
                '<div class="img-up-add  img-item"> <span class="img-add-icon">+</span> </div>'+
                '<input type="file" name="files" id="img-file-input" multiple>'+
                '</div>';
        ele = eleList[0].querySelector('#img-container');
        ele.files = [];   // 当前上传的文件数组
    }

    // 为添加按钮绑定点击事件，设置选择图片的功能
    var addBtn = document.querySelector('.img-up-add');
	
    addBtn.addEventListener('click',function () {
        document.querySelector('#img-file-input').value = null;
        document.querySelector('#img-file-input').click();
        return false;
    },false);

    // 预览图片
    //处理input选择的图片
    function handleFileSelect(evt) {
        var files = evt.target.files;

        for(var i=0, f; f=files[i];i++){
			if(f.size > options.maxFileSize){
				options.onMessage("文件太大了");
				return;
			}
            // 过滤掉非图片类型文件
            if(!f.type.match('image.*')){
				options.onMessage("上传文件不是图片格式");
                continue;
            }
            // 过滤掉重复上传的图片
            var tip = false;
            for(var j=0; j<(ele.files).length; j++){
                if((ele.files)[j].name == f.name){
                    tip = true;
					options.onMessage("已有相同上传文件名称");
                    break;
                }
            }
            if(!tip){
                // 图片文件绑定到容器元素上
                ele.files.push(f);
                var tips = "文件名:&#10; &nbsp;&nbsp;&nbsp; 【" + f.name + "】  &#10;图片大小:&#10; &nbsp;&nbsp;&nbsp; 【" + f.size + "B】";
                var reader = new FileReader();
                reader.onload = (function (theFile) {
                    return function (e) {
                        var oDiv = document.createElement('div');
                        oDiv.className = 'img-thumb img-item';

                        // 向图片容器里添加元素
                        oDiv.innerHTML = '<img class="thumb-icon" src="' + e.target.result + '" />'+
                                        '<b class="img-tips" title="' + tips + '"></b>'+
                                        '<a href="javscript:void(0);" class="img-remove" title="删除图片">&times;</a>'

						if(ele.files.length == options.maxFiles){
							ele.insertBefore(oDiv, addBtn);
							addBtn.style.display = "none";
						}else{
							ele.insertBefore(oDiv, addBtn);
						}
						
                    };
                })(f);

                reader.readAsDataURL(f);
            }
        }
    }
	
    document.querySelector('#img-file-input').addEventListener('change', handleFileSelect, false);

    // 删除图片
    function removeImg(evt) {
        if(evt.target.className.match(/img-remove/)){
            console.log('3',ele.files);
            // 获取删除的节点的索引
            function getIndex(ele){

                if(ele && ele.nodeType && ele.nodeType == 1) {
                    var oParent = ele.parentNode;
                    var oChilds = oParent.children;
                    for(var i = 0; i < oChilds.length; i++){
                        if(oChilds[i] == ele)
                            return i;
                    }
                }else {
                    return -1;
                }
            }
			
            // 根据索引删除指定的文件对象
            var index = getIndex(evt.target.parentNode);
            ele.removeChild(evt.target.parentNode);
            if(index < 0){
                return;
            }else {
                ele.files.splice(index, 1);
            }
			
			if (ele.files.length < options.maxFiles){
				addBtn.style.display = "block";
			}
			
            console.log('4',ele.files);
			
        }
    }
	
    ele.addEventListener('click', removeImg, false);

    // 上传图片
    function uploadImg() {
        console.log(ele.files);
		var xhr = null;
		// 新浏览器支持，大多浏览器支持
		if (window.XMLHttpRequest){
			xhr = new XMLHttpRequest();
		}else if(window.ActiveXObject){
			// IE5 IE6浏览器支持
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if(null != xhr){
			var formData = null;

            //添加表单数据
			if(undefined != options.formId && null != options.formId &&
				"" != options.formId && "" != options.formId.trim()){
					//$("form").serialize()
				// var formElement = document.forms.namedItem(options.formId);
				formData = new FormData($(options.formId)[0]);
                formData.delete("files");
			}else{
				formData = new FormData();
			}
			for(var i = 0 ; i < ele.files.length; i++){
				formData.append('files', ele.files[i]);
			}
            if (undefined != options.oldPictureName && null != options.oldPictureList) {
                formData.append(options.oldPictureName, options.oldPictureList);
            }
           // document.querySelector('.thumb-icon')

			console.log('1',ele.files);
			console.log('2',formData);

			xhr.onreadystatechange = function (e) {
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						options.onSuccess(xhr.responseText);
					}else {
						options.onFailure(xhr.responseText);
					}
                    //暂停机制
                    if(options.abort){
                        xhr.abort();
                    }
				}
				//暂停机制
				if(options.abort){
				    xhr.abort();
                }
			}

			xhr.open('POST', options.url, true);
			xhr.send(formData);
		}else{
			options.onMessage("创建XMLHttpRequest异常");
		}
    }
    return uploadImg;
}


