;
function validPaymentMode() {
    var name = $("#payment-mode-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var explain = $("#payment-mode-explain").val();
    if (!validNotBlank(explain) && validLength(explain,100)) {
        showMessage("验证提示", "说明字符长度不能超过100个字符", false);
        return true;
    }
    return false;
}