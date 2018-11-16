;
function validCommodityCategory() {
    var cId = $("#hidden-coca-id").val();
    var pId = $("#coca-parent-id").val();
    if (cId == pId) {
        showMessage("验证提示", "上级名称不能是自身!", false);
        return true;
    }
    var name = $("#coca-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var seq = $("#coca-seq").val();
    if (validNotBlank(seq)){
        showMessage("验证提示", "排序不能为空", false);
        return true;
    }

    if (regexp(seq,REGEX_INT_SIMPLE) && seq >-1 && seq < 1000) {
        showMessage("验证提示", "排序格式出错了!", false);
        return true;
    }

    var explain = $("#coso-explain").val();
    if (!validNotBlank(explain) && validLength(explain,250)) {
        showMessage("验证提示", "说明长度超出", false);
        return true;
    }

    return false;
}