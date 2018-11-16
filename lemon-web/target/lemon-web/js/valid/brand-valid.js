;
function validBrand() {
    var name = $("#brand-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

     var seq = $("#brand-seq").val();
    if (validNotBlank(seq)){
        showMessage("验证提示", "排序不能为空", false);
        return true;
    }
    if(regexp(seq,REGEX_INT_SIMPLE)){
        showMessage("验证提示", "排序数据转换错误", false);
        return true;
    }
    if (seq < 0 || seq > 10000) {
        showMessage("验证提示", "排序大小在0到10000之间", false);
        return true;
    }

    var area = $("#brand-area").val();
    if (validNotBlank(area)){
        showMessage("验证提示", "区域不能为空", false);
        return true;
    }
    if (validLength(area,50)) {
        showMessage("验证提示", "区域长度超出", false);
        return true;
    }

    var explain = $("#brand-explain").val();
    if (!validNotBlank(explain) && validLength(explain,250)) {
        showMessage("验证提示", "说明长度超出", false);
        return true;
    }

    return false;
}