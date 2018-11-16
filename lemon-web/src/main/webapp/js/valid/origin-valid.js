;
function validOrigin() {
    var name = $("#origin-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var explain = $("#origin-explain").val();
    if (!validNotBlank(explain) && validLength(explain,250)) {
        showMessage("验证提示", "说明长度超出", false);
        return true;
    }

    return false;
}