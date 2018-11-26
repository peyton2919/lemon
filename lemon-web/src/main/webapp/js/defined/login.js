;
/**
 * <h4>登录 </h4>
 * @param url
 * @param formId
 * @param successCallback
 * @param failCallback
 */
function login(url,formId,successCallback, failCallback,completeCallback) {
    $.ajax({
        url: url,
        data: $("#" + formId).serializeArray(),
        type: 'POST',
        success: function (result) {
            if (result.status == 200) {

                if (successCallback) {
                    successCallback(result);
                }
            } else {
                if (failCallback) {
                    failCallback(result);
                }
            }
        },
        complete :function (data) {
            if (completeCallback) {
                completeCallback(data);
            }
        }
    });
}