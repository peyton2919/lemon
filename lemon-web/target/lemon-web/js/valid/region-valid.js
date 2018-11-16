;
function validRegion() {
    var name = $("#region-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

     var seq = $("#region-seq").val();
    if (validNotBlank(seq)){
        showMessage("验证提示", "排序不能为空", false);
        return true;
    }
    if (regexp(seq,REGEX_INT_SIMPLE)) {
        showMessage("验证提示", "排序格式不正确", false);
        return true;
    }

    var code = $("#region-code").val();
    if (!validNotBlank(code) && validLength(code,20)) {
        showMessage("验证提示", "区码长度超出", false);
        return true;
    }

    return false;
}