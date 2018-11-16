;
function validColor() {
    var name = $("#color-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var code = $("#color-code").val();
    if (!validNotBlank(code) && validLength(code,20)) {
        showMessage("验证提示", "代码长度超出", false);
        return true;
    }

    return false;
}