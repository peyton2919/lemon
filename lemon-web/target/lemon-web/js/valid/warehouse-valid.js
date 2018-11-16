;
function validWarehouse() {
    var name = $("#wh-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var tel = $("#wh-tel").val();
    if (!validNotBlank(tel) && regexp(tel,REGEX_TEL)){
        showMessage("验证提示", "电话格式不正确", false);
        return true;
    }
    if (!validNotBlank(tel) && validLength(tel,50)) {
        showMessage("验证提示", "电话长度超出", false);
        return true;
    }

    var phone = $("#wh-phone").val();
    if (!validNotBlank(phone) && regexp(phone,REGEX_PHONE)){
        showMessage("验证提示", "手机格式不正确", false);
        return true;
    }
    if (!validNotBlank(phone) && validLength(phone,50)) {
        showMessage("验证提示", "手机长度超出", false);
        return true;
    }

    var qq = $("#wh-qq").val();
    if (!validNotBlank(qq) && regexp(qq,REGEX_QQ)){
        showMessage("验证提示", "QQ格式不正确", false);
        return true;
    }
    if (!validNotBlank(qq) && validLength(qq,50)) {
        showMessage("验证提示", "QQ长度超出", false);
        return true;
    }

    var location = $("#wh-location").val();
    if (!validNotBlank(location) && validLength(location,100)) {
        showMessage("验证提示", "位置长度超出", false);
        return true;
    }

    var add = $("#wh-add").val();
    if (!validNotBlank(add) && validLength(add,100)) {
        showMessage("验证提示", "地址长度超出", false);
        return true;
    }

    var explain = $("#wh-explain").val();
    if (!validNotBlank(explain) && validLength(explain,250)) {
        showMessage("验证提示", "说明长度超出", false);
        return true;
    }
    return false;
}