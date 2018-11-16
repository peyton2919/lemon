;
function validCustomerGrade() {
    var name = $("#customer-grade-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "名称不能为空", false);
        return true;
    }
    if (validLength(name,50)) {
        showMessage("验证提示", "名称长度超出", false);
        return true;
    }

    var dr = $("#customer-grade-dr").val();
    if (!validNotBlank(dr) && regexp(dr,REGEX_INT_1_100)) {
        showMessage("验证提示", "折扣率只能为1-100之间的数", false);
        return true;
    }
    return false;
}