;
function validFreightType() {
    var name = $("#ft-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var tel = $("#ft-tel").val();
    if (!validNotBlank(tel) && regexp(tel,REGEX_TEL)){
        showMessage("验证提示", "电话格式不正确", false);
        return true;
    }
    if (!validNotBlank(tel) && validLength(tel,50)) {
        showMessage("验证提示", "电话长度超出", false);
        return true;
    }

    var phone = $("#ft-phone").val();
    if (!validNotBlank(phone) && regexp(phone,REGEX_PHONE)){
        showMessage("验证提示", "手机格式不正确", false);
        return true;
    }
    if (!validNotBlank(phone) && validLength(phone,50)) {
        showMessage("验证提示", "手机长度超出", false);
        return true;
    }

    var fax = $("#ft-fax").val();
    if (!validNotBlank(fax) && regexp(fax,REGEX_TEL)){
        showMessage("验证提示", "传真格式不正确", false);
        return true;
    }
    if (!validNotBlank(fax) && validLength(fax,50)) {
        showMessage("验证提示", "传真长度超出", false);
        return true;
    }

    var qq = $("#ft-qq").val();
    if (!validNotBlank(qq) && regexp(qq,REGEX_QQ)){
        showMessage("验证提示", "QQ格式不正确", false);
        return true;
    }
    if (!validNotBlank(qq) && validLength(qq,50)) {
        showMessage("验证提示", "QQ长度超出", false);
        return true;
    }

    var email = $("#ft-email").val();
    if (!validNotBlank(email) && regexp(email,REGEX_EMAIL_ALL)){
        showMessage("验证提示", "邮箱格式不正确", false);
        return true;
    }
    if (!validNotBlank(email) && validLength(email,50)) {
        showMessage("验证提示", "邮箱长度超出", false);
        return true;
    }

    var add = $("#ft-add").val();
    if (!validNotBlank(add) && validLength(add,100)) {
        showMessage("验证提示", "地址长度超出", false);
        return true;
    }

    var explain = $("#ft-explain").val();
    if (!validNotBlank(explain) && validLength(explain,250)) {
        showMessage("验证提示", "说明长度超出", false);
        return true;
    }
    return false;
}