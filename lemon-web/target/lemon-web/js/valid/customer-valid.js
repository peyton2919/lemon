;
/**
 * <h4>客户表单验证</h4>
 * @param vali 为true时表示 要验证密码
 * @returns {boolean} 为true验证没通过
 */
function validCustomer(vali) {
    var name = $("#customer-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }

    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var loginName = $("#customer-login-name").val();
    if (validNotBlank(loginName)){
        showMessage("验证提示", "登录名称不能为空", false);
        return true;
    }
    if (validLength(loginName,50)) {
        showMessage("验证提示", "登录名称长度超出", false);
        return true;
    }

    if (vali){
        var pwd = $("#customer-pwd").val();
        if (validNotBlank(pwd)){
            showMessage("验证提示", "密码不能为空", false);
            return true;
        }
        if (pwd.length < 6){
            showMessage("验证提示", "密码长度最少6位", false);
            return true;
        }
        if (validLength(pwd,30)) {
            showMessage("验证提示", "密码长度超出", false);
            return true;
        }

        var confirmPwd = $("#customer-confirm-pwd").val();

        if (pwd != confirmPwd){
            showMessage("验证提示", "二次输入密码不一致", false);
            return true;
        }
    }

    var tel = $("#customer-tel").val();
    if (!validNotBlank(tel) && regexp(tel,REGEX_TEL)){
        showMessage("验证提示", "电话格式不正确", false);
        return true;
    }
    if (!validNotBlank(tel) && validLength(tel,50)) {
        showMessage("验证提示", "电话长度超出", false);
        return true;
    }

    var phone = $("#customer-phone").val();
    if (!validNotBlank(phone) && regexp(phone,REGEX_PHONE)){
        showMessage("验证提示", "手机格式不正确", false);
        return true;
    }
    if (!validNotBlank(phone) && validLength(phone,50)) {
        showMessage("验证提示", "手机长度超出", false);
        return true;
    }

    var qq = $("#customer-qq").val();
    if (!validNotBlank(qq) && regexp(qq,REGEX_QQ)){
        showMessage("验证提示", "QQ格式不正确", false);
        return true;
    }
    if (!validNotBlank(qq) && validLength(qq,50)) {
        showMessage("验证提示", "QQ长度超出", false);
        return true;
    }

    var email = $("#customer-email").val();
    if (!validNotBlank(email) && regexp(email,REGEX_EMAIL_ALL)){
        showMessage("验证提示", "邮箱格式不正确", false);
        return true;
    }
    if (!validNotBlank(email) && validLength(email,100)) {
        showMessage("验证提示", "邮箱长度超出", false);
        return true;
    }

    var fax = $("#customer-fax").val();
    if (!validNotBlank(fax) && regexp(fax,REGEX_TEL)){
        showMessage("验证提示", "传真格式不正确", false);
        return true;
    }
    if (!validNotBlank(fax) && validLength(fax,50)) {
        showMessage("验证提示", "传真长度超出", false);
        return true;
    }

    var birth = $("#customer-birth").val();
    if (!validNotBlank(birth) && regexp(birth,REGEX_DATE)){
        showMessage("验证提示", "出生日期格式不正确", false);
        return true;
    }
    if (!validNotBlank(birth) && validLength(birth,30)) {
        showMessage("验证提示", "出生日期长度超出", false);
        return true;
    }

    var identity = $("#customer-identity").val();
    if (!validNotBlank(identity) && regexp(identity,REGEX_IDENTITY)){
        showMessage("验证提示", "身份证格式不正确", false);
        return true;
    }
    if (!validNotBlank(identity) && validLength(identity,19)) {
        showMessage("验证提示", "身份证长度超出", false);
        return true;
    }

    var add = $("#customer-add").val();
    if (!validNotBlank(add) && validLength(add,100)) {
        showMessage("验证提示", "地址长度超出", false);
        return true;
    }

    var explain = $("#customer-explain").val();
    if (!validNotBlank(explain) && validLength(explain,250)) {
        showMessage("验证提示", "说明长度超出", false);
        return true;
    }

    var regionId = $("#hidden-region-id").val();
    if (regionId < 1) {
        showMessage("验证提示", "请选择地区", false);
        return true;
    }

    return false;
}