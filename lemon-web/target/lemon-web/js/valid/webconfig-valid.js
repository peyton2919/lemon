;
/**
 * <h4>基础验证</h4>
 * @returns {boolean} 验证没通过为true
 */
function validBase() {
    var name = $("#web-name").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "网站名称不能为空", false);
        return true;
    }
    if (validLength(name,150)) {
        showMessage("验证提示", "网站名称长度超出", false);
        return true;
    }

    var title = $("#web-title").val();
    if (validNotBlank(title)){
        showMessage("验证提示", "网站标题不能为空", false);
        return true;
    }
    if (validLength(title,150)) {
        showMessage("验证提示", "网站标题长度超出", false);
        return true;
    }

    var tel = $("#web-tel").val();
    if (validNotBlank(tel)){
        showMessage("验证提示", "电话不能为空", false);
        return true;
    }
    if (validLength(tel,50)) {
        showMessage("验证提示", "电话长度超出", false);
        return true;
    }
    if (regexp(tel,REGEX_TEL)){
        showMessage("验证提示", "电话格式不正确", false);
        return true;
    }

    var email = $("#web-email").val();
    if (validNotBlank(email)){
        showMessage("验证提示", "邮箱不能为空", false);
        return true;
    }
    if (validLength(email,50)) {
        showMessage("验证提示", "邮箱长度超出", false);
        return true;
    }
    if (regexp(email,REGEX_EMAIL_ALL)){
        showMessage("验证提示", "邮箱格式不正确", false);
        return true;
    }

    var phone = $("#web-phone").val();
    if (validNotBlank(phone)){
        showMessage("验证提示", "手机不能为空", false);
        return true;
    }
    if (validLength(phone,50)) {
        showMessage("验证提示", "手机长度超出", false);
        return true;
    }
    if (regexp(phone,REGEX_PHONE)){
        showMessage("验证提示", "手机格式不正确", false);
        return true;
    }

    var link = $("#web-link").val();
    if (validNotBlank(link)){
        showMessage("验证提示", "链接地址不能为空", false);
        return true;
    }
    if (validLength(link,250)) {
        showMessage("验证提示", "链接地址长度超出", false);
        return true;
    }

    var fax = $("#web-fax").val();
    if (validNotBlank(name)){
        showMessage("验证提示", "传真不能为空", false);
        return true;
    }
    if (validLength(fax,50)) {
        showMessage("验证提示", "传真长度超出", false);
        return true;
    }
    if (regexp(fax,REGEX_TEL)){
        showMessage("验证提示", "传真格式不正确", false);
        return true;
    }
    var add = $("#web-add").val();
    if (validNotBlank(add)){
        showMessage("验证提示", "地址不能为空", false);
        return true;
    }
    if (validLength(add,100)) {
        showMessage("验证提示", "地址长度超出", false);
        return true;
    }
    return false;
}

/**
 * <h4>扩展验证</h4>
 * @returns {boolean} 验证没通过为true
 */
function validExt() {
    var uploadPath = $("#web-upload-path").val();
    if (!validNotBlank(uploadPath) && uploadPath.length > 100){
        showMessage("验证提示", "文件目录长度超出", false);
        return true;
    }
    var skin = $("#web-skin").val();
    if (!validNotBlank(skin) && skin.length > 150){
        showMessage("验证提示", "皮肤字符长度超出", false);
        return true;
    }
    var keyword = $("#web-keyword").val();
    if (!validNotBlank(keyword) && keyword.length > 500){
        showMessage("验证提示", "关键字长度超出", false);
        return true;
    }
    return false;
}

/**
 * <h4>版权验证</h4>
 * @returns {boolean} 验证没通过为true
 */
function validCopyRight() {
    var copyRight = $("#web-copy-right").val();
    if (!validNotBlank(copyRight) && copyRight.length > 250){
        showMessage("验证提示", "版权长度超出", false);
        return true;
    }
    var icp = $("#web-icp").val();
    if (!validNotBlank(icp) && icp.length > 500){
        showMessage("验证提示", "ICP备案长度超出", false);
        return true;
    }
    var desc = $("#web-desc").val();
    if (!validNotBlank(desc) && desc.length > 500){
        showMessage("验证提示", "描述长度超出", false);
        return true;
    }
    var explain = $("#web-explain").val();
    if (!validNotBlank(explain) && explain.length > 500){
        showMessage("验证提示", "说明长度超出", false);
        return true;
    }
    return false;
}

/**
 * <h4>关闭验证</h4>
 * @returns {boolean} 验证没通过为true
 */
function validClose() {
    var closeTip = $("#web-close-tip").val();
    if (!validNotBlank(closeTip) && closeTip.length > 500){
        showMessage("验证提示", "关闭提示长度超出", false);
        return true;
    }
    return false;
    
}