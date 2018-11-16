<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<title>管理员控制台</title>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="pragma" content="no-cache"/>
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="renderer" content="webkit">
<meta name="description" content="overview &amp; stats"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE;chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="peyton Yu, peyton.cn">

<link rel="shortcut icon" href="/img/sys/headline.ico" type="image/x-icon">

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>

<link rel="stylesheet" type="text/css" href="/assets/css/jquery-ui.min.css" />
<!-- page specific plugin styles -->

<link rel="stylesheet" type="text/css" href="/assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" type="text/css" href="/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
    <link rel="stylesheet" type="text/css" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
<![endif]-->

<link rel="stylesheet" type="text/css" href="/assets/css/ace-skins.min.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/ace-rtl.min.css"/>
<!--[if lte IE 9]>
    <link rel="stylesheet" type="text/css" href="/assets/css/ace-ie.min.css" />
<![endif]-->
<script src="/assets/js/ace-extra.min.js"></script>

<link rel="stylesheet" type="text/css" href="/assets/css/jquery.gritter.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/chosen.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap-datetimepicker.min.css" media="screen" />

<link rel="stylesheet" type="text/css" type="text/css" href="/css/core.css" media="screen" />
<link rel="stylesheet" type="text/css" type="text/css" href="/css/public.css" media="screen" />

<!--[if lte IE 9]>
<link rel="stylesheet" type="text/css" href="/assets/css/ace-ie.min.css"/>
<![endif]-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lte IE 8]>
<script src="/assets/js/html5shiv.min.js"></script>
<script src="/assets/js/respond.min.js"></script>
<![endif]-->

<!--[if !IE]> -->
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
<script src="/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->

<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<script src="/assets/js/bootstrap.min.js"></script>

<script src="/assets/js/jquery-ui.min.js"></script>
<script src="/assets/js/jquery.gritter.min.js"></script>
<script src="/assets/js/chosen.jquery.min.js"></script>

<!-- 针对Surface/桌面Windows 8错误的IE10视口黑客攻击 -->
<script src="/js/diff/ie10-viewport-bug-workaround.js"></script>

<script src="/assets/js/bootstrap-datetimepicker.min.js"></script>
<script src="/js/diff/bootstrap-datetimepicker.zh-CN.js"></script>

<script src="/js/mustache/mustache.min.js"></script>

<script type="text/javascript">
    // 展示提示信息
    function showMessage(title, msg, isSuccess) {
        if (!isSuccess) {
            msg = msg || '';
        } else {
            msg = msg || '操作成功'
        }
        $.gritter.add({
            title: title,
            text: msg != '' ? msg : "服务器处理异常, 建议刷新页面来保证数据是最新的",
            time: '',
            class_name: (isSuccess ? 'gritter-success' : 'gritter-warning') + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
        });
    }

    //去除两边空格
    $.fn.trim = function () {
        return this.replace(/(^\s*)|(\s*$)/g, "");
    };

    /**
     *  清除数据 [ajax 连接时]
     * @param idElement 表单ID [form 的id]
     */
    function clearData(idElement) {
        $(":input",'#' +idElement )
            .not(':button',':submit',':reset',':hidden')
            .val('')
            .removeAttr('checked');
    }

    /**
     *
     * @param idElement
     * @param format
     */
    function datetimeUtil(idElement,format) {
        if (undefined == format || null == format || NaN == format){
            format = "yyyy-MM-dd";
        }
        $(idElement).datetimepicker({
            language:  'zh-CN',
            // beforeShowDay: $.noop,    //在显示日期之前调用的函数
            weekStart: 1,
            todayBtn:  true, //显示今日按钮
            clearBtn:true,// 自定义属性,true 显示 清空按钮 false 隐藏 默认:true
            format: format,//显示格式
            autoclose: true,
            todayHighlight: 1,
            startView: 2,
            minView: "month",//设置只显示到月份
            todayHighlight: false,    //今天高亮
            // showMeridian: 1,
            forceParse: 0 //是否强制转换不符合格式的字符串
        });
    }

    /**
     * <h4>时间 datetimepicker 控件</h4>
     * @param format 时间格式样式 默认 "yyyy-MM-dd"
     */
    $.fn.datetime = function(format){
        if (undefined == format || null == format || NaN == format){
            format = "yyyy-MM-dd";
        }
        this.datetimepicker({
            language:  'zh-CN',
            // beforeShowDay: $.noop,    //在显示日期之前调用的函数
            weekStart: 1,
            todayBtn:  true, //显示今日按钮
            clearBtn:true,// 自定义属性,true 显示 清空按钮 false 隐藏 默认:true
            format: format,//显示格式
            autoclose: true,
            todayHighlight: 1,
            startView: 2,
            minView: "month",//设置只显示到月份
            todayHighlight: false,    //今天高亮
            // showMeridian: 1,
            forceParse: 0 //是否强制转换不符合格式的字符串
        });
    }
    /**
     * <h4>休眠</h4>
     * @param method 休眠后要运行的方法名
     * @param millisecond 休眠时间 [单位:毫秒] [1秒 = 1000 毫秒]
     */
    function sleep(method,millisecond) {
        setTimeout(function () {
            method();
        },millisecond);
    }

    /**
     * <h4>prent字符包含child字符</h4>
     * @param parent 列表字符串[或 Array]
     * @param child 要比对字符中
     * @returns {boolean} child 字符 有在parent字符中出现 就返回true
     */
    function contains(parent,child){
        if (parent == undefined || parent == null){return false;}
        if(parent instanceof Array){
            var length = parent.length;
            for(var i=0;i<length;i++) {
                if (parent[i] == child) {
                    return true;
                }
            }
        }else {
            var splits = parent.split(",");
            var length = splits.length;
            for(var i = 0; i < length; i++) {
                if (splits[i] == child) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <h4>截取字段</h4>
     * @param obj 被截取字段
     * @param regex 最后一个regex字符
     * @returns {string} 最后一个regex字符 后[不含regex字符] 字符
     */
    function subObj(obj,regex) {
        if (obj == undefined || obj == null){return obj;}
        if (regex == undefined || regex == null){regex = ".";}
        return obj.substring(obj.lastIndexOf(regex) + 1);
    }

    /**
     * <h4>验证字符串是否为空</h4>
     * @param str 要验证字符串
     * @returns {boolean}  true为验证不通过
     */
    function existNotBlank(str) {
        if (undefined == str || null == str ||
            "" == str || ""  == str.trim()){
            return true;
        }
        return false;
    }

    /**
     * <h4>刷新 数据 </h4>
     * @param bo 添加true,更新false
     * @param load 初始方法
     * @param search 搜索方法
     */
    function refresh(bo,load,search) {
        if (bo){
            load();
        }else {
            search();
        }
    }

</script>