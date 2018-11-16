//事件
;
/**
 * <h4>图片加载时,地址错误或空进 替换默认图片</h4>
 * @param options
 */
$.fn.imgError = function (options) {
    var defaults = {
        defaultImgPath:'/img/default/default-400.jpg'
    };
    var _options = $.extend(defaults, options);
    $(this).error(function () {
        errorLoad($(this));
    });
};

/**
 * <h4>图片加载</h4>
 * @param imgSrc 图片路径
 */
$.fn.imgSimpleLoad = function (imgSrc) {
    if(imgSrc == undefined || imgSrc == null || imgSrc == '' || imgSrc.toLocaleLowerCase() == 'null'){
        $(this).attr("src", "error");
    }else {
        $(this).attr("src", imgSrc);
    }
    $(this).error(function () {
        errorLoad($(this));
    });
};

/**
 * <h4>图片加载</h4>
 * @param imgSrc 图片路径
 * @param displayIdElement 图片所在Div层控件 ID
 * @param nameIdElement input要显示图片名称 控件ID
 */
$.fn.imgLoad = function (imgSrc,displayIdElement,nameIdElement) {
    if(imgSrc == undefined || imgSrc == null ||
        imgSrc == '' || imgSrc.toLocaleLowerCase() == 'null'){return;}

    if (displayIdElement != undefined & displayIdElement != null & displayIdElement != ''){
        $("#" + displayIdElement).show();
    }
    var name = imgSrc.substring(imgSrc.lastIndexOf('/') + 1);
    $("#" + nameIdElement).val(name);
    $(this).attr("src", imgSrc);
    $(this).error(function () {
        errorLoad($(this));
    });
}

/**
 * <h4>错误加载</h4>
 * @param self 控件本身
 */
function errorLoad(self) {
    // var width =  self.attr("width");
    // var height = self.attr("height");

    self.attr("src", '/img/default/default-400.jpg');
    self.onerror = null;
};

/**
 * <h4>像素值 的转换</h4>
 * @param obj img的width或height值
 * @param size 默认值
 * @returns {*} 大小为数字
 */
function convert(obj,size) {
    if (size == undefined || size == null) {size = 200;}
    if (obj == undefined || obj == null) {return size;}
    obj = obj.toLocaleLowerCase();
    var ext = obj.substring(obj.length -2);
    if (ext != 'px') {
    } else {
        obj = obj.substring(0, obj.length - 2);
    }
    var reg = /^\d{4}$/;  //数字值最大9999
    if (reg.test(obj)) {
        return obj;
    }else {
        return size;
    }
};

/**
 * <h4>没找到图片</h4>
 * @param idElement img控件ID
 * @param def 默认图片地址
 */
function notFindImg(idElement) {
    var def = "/img/default/default-400.jpg";
    $("#" + idElement).attr("src", def);
    $("#" + idElement).onerror = null;
}