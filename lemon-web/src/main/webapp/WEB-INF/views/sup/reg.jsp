<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>供应商注册</title>
    <jsp:include page="/common/common.jsp"/>
    <script src="/js/defined/register-window.js"></script>
</head>
<body class="no-skin" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<jsp:include page="/pub/index-stick.jsp"/>

<div id="project-content" class="container">

    <div class="col-xs-12 text-center mt20 mb20">
        <h2>注册</h2>
    </div>

    <div class="row">
        <div class="col-xs-6 col-xs-offset-3">
            <form id="supplierForm" name="supplierForm" class="form-horizontal">
                <div class="form-group">
                    <label for="supplier-name" class="col-sm-3 control-label">名称</label>
                    <div class="col-sm-8">
                        <input type="text" name="name" class="form-control" id="supplier-name" placeholder="名称不能为空">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-login-name" class="col-sm-3 control-label">登录名</label>
                    <div class="col-sm-8">
                        <input type="text" name="loginName" class="form-control" id="supplier-login-name"
                               placeholder="登录名不能为空">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-pwd" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" name="pwd" class="form-control" id="supplier-pwd"
                               placeholder="密码不能为空">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-confirm-pwd" class="col-sm-3 control-label">确认密码</label>
                    <div class="col-sm-8">
                        <input type="password" name="confirmPwd" class="form-control" id="supplier-confirm-pwd"
                               placeholder="确认密码不能为空">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-tel" class="col-sm-3 control-label">电话</label>
                    <div class="col-sm-8">
                        <input type="text" name="tel" class="form-control" id="supplier-tel"
                               placeholder="电话可以为空,有输入必需是正确的格式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-phone" class="col-sm-3 control-label">手机</label>
                    <div class="col-sm-8">
                        <input type="text" name="phone" class="form-control" id="supplier-phone"
                               placeholder="手机可以为空,有输入必需是正确的格式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-qq" class="col-sm-3 control-label">QQ</label>
                    <div class="col-sm-8">
                        <input type="text" name="qq" class="form-control" id="supplier-qq"
                               placeholder="QQ可以为空,有输入必需是正确的格式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-email" class="col-sm-3 control-label">邮箱</label>
                    <div class="col-sm-8">
                        <input type="text" name="email" class="form-control" id="supplier-email"
                               placeholder="邮箱可以为空,有输入必需是正确的格式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-fax" class="col-sm-3 control-label">传真</label>
                    <div class="col-sm-8">
                        <input type="text" name="fax" class="form-control" id="supplier-fax"
                               placeholder="传真可以为空,有输入必需是正确的格式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-address" class="col-sm-3 control-label">地址</label>
                    <div class="col-sm-8">
                        <textarea rows="3" name="add" id="supplier-address"
                                  class="form-control" placeholder="地址可以为空"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="supplier-explain" class="col-sm-3 control-label">说明</label>
                    <div class="col-sm-8">
                        <textarea rows="3" name="explain" id="supplier-explain"
                                  class="form-control"  placeholder="说明可以为空"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button id="supplier-add" class="btn btn-default">注册</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

<jsp:include page="/pub/index-footer.jsp"/>
<script src="/js/defined/register-window.js"></script>
<script type="application/javascript">
    
    $(function () {

    });

    $("#supplier-add").click(function (e) {
        e.preventDefault();
        e.stopPropagation();

        update(true, function (data) {
            showMessage("新增供应商", "成功", true);
            // sleep(skipSignIn, 1000);

        }, function (data) {
            showMessage("新增供应商", data.msg, false);
            $("#supplier-add").attr("disabled", false);
        });

    });

    function skipSignIn() {
        window.location.href = "/sign-in-sup.page";
    }

    //更新栏目信息
    function update(isCreate, successCallback, failCallback) {
        if (validSupplier(true)) {
            return;
        }
        $("#supplier-add").attr("disabled", true);
        $.ajax({
            url: isCreate ? "/sup/save.json" : "/sup/update.json",
            data: $("#supplierForm").serializeArray(),
            type: 'POST',
            success: function (result) {
                if (result.status == 200) {
                    if (successCallback) {
                        successCallback(result);
                        skipSignIn();
                    }
                } else {
                    if (failCallback) {
                        failCallback(result);
                    }
                }
            }
        });
    }

</script>
<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/supplier-valid.js"></script>

</body>
</html>