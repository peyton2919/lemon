/**
 * 管理员[超级，员工]后台调用
 *  在子页面上设置body class="init-iframe-box" 属性
 *  新建一个 <div class="iframe-child"> [内容...] </div>
 *  在admin.jsp中调用些方法
 */
;
//初始化宽度、高度
initWindow();

//当文档窗口发生改变时 触发
$(window).resize(function(){
    initWindow();
});

function initWindow() {
    var topHeight = $("#navbar").outerHeight(); //头部高度
    var footHeight = $(".ud-footer").outerHeight(); //底部高度
    var windowHeight = $(window).outerHeight(); //整体窗体高度
    //左侧窗体的高度
    var leftWindowHeight = windowHeight - topHeight;
    //设置
    $(".sidebar").height(leftWindowHeight - 15);
    var thisHeight = $("#nav_list").height(leftWindowHeight - 20);
    $(".submenu").height();
    $("#nav_list").children(".submenu").css("height",thisHeight);
    //主窗体的高度
    var mainWindowHeight = leftWindowHeight- footHeight;
    //设置iframe 框架下内的滚动条
    $(".init-iframe-box").height(mainWindowHeight - 18);
    $(".iframe-child").height(mainWindowHeight - 18);
    //
    $("#innerFrame").height(mainWindowHeight - 10);
};

/**
 * <h4>添加或更新</h4>
 * @param isValid 验证方法
 * @param url 保存或更新 链接地址
 * @param formId form表单ID
 * @param addAndUpdateLoadMethod 为true加载load
 * @param load 加载列表方法
 * @param loadSearch 加载搜索列表方法
 * @param successCallback 成功回调
 * @param failCallback 失败回调
 */
function updateObject(isValid,url,formId,addAndUpdateLoadMethod,load,loadSearch,successCallback, failCallback) {
    if (isValid) {
        return;
    }
    $.ajax({
        url: url,
        data: $("#" + formId).serializeArray(),
        type: 'POST',
        success: function (result) {
            if (result.status == 200) {

                if (successCallback) {
                    successCallback(result);
                }
                if (addAndUpdateLoadMethod){
                    load;
                }else{
                    loadSearch;
                }
            } else {
                if (failCallback) {
                    failCallback(result);
                }
            }
        }
    });
}

