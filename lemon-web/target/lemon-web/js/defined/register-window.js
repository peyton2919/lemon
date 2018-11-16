;
/**
 * 注册窗体 初始化
 */
function register() {
    //整体窗体高度
    var windowHeight = $(window).outerHeight();
    //导航栏高度
    var navHeight = $("#project-nav").outerHeight();
    //主体框高度
    var contentHeight = $("#project-content").outerHeight();
    //底部 高度
    var footerHeight = $("#project-footer").outerHeight();
    var total = navHeight + contentHeight + footerHeight;
    if (windowHeight -10 >= total){
        $("#project-footer").css("position", "fixed");
        $("#project-footer").css("bottom", "0px");
    }else {
        $("#project-footer").css("position", "");
        $("#project-footer").css("bottom", "");
    }
}

register();

$(window).resize(function () {
    register();
});
