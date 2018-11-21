<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户注册</title>
    <jsp:include page="/common/common.jsp"/>
    <link rel="stylesheet" type="text/css" href="/ztree/zTreeStyle.css">

</head>
<body class="no-skin" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<jsp:include page="/pub/index-stick.jsp"/>

<div id="project-content" class="container">

    <div class="row col-sm-12 text-center mb20 mt20">
        <h2>注册</h2>
    </div>

    <div class="col-sm-2 col-sm-offset-2">
        <div  id="treeRegion" class="ztree"></div>
    </div>

    <div class="col-sm-6">
        <form id="customerForm" name="customerForm" class="form-horizontal">
            <input type="hidden" id="hidden-region-id" name="regiId">
            <div class="form-group">
                <label for="customer-name" class="col-sm-3 control-label">名称</label>
                <div class="col-sm-8">
                    <input type="text" name="name" class="text form-control" id="customer-name"
                           placeholder="名称不能为空">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-login-name" class="col-sm-3 control-label">登录名</label>
                <div class="col-sm-8">
                    <input type="text" name="loginName" class="text form-control" id="customer-login-name"
                           placeholder="登录名不能为空">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-pwd" class="col-sm-3 control-label">密码</label>
                <div class="col-sm-8">
                    <input type="password" name="pwd" class="text form-control" id="customer-pwd"
                           placeholder="密码不能为空">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-confirm-pwd" class="col-sm-3 control-label">确认密码</label>
                <div class="col-sm-8">
                    <input type="password" name="confirmPwd" class="text form-control" id="customer-confirm-pwd"
                           placeholder="确认密码不能为空">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-tel" class="col-sm-3 control-label">电话</label>
                <div class="col-sm-8">
                    <input type="text" name="tel" class="text form-control" id="customer-tel"
                           placeholder="电话可以为空,有输入必需是正确的格式">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-phone" class="col-sm-3 control-label">手机</label>
                <div class="col-sm-8">
                    <input type="text" name="phone" class="text form-control" id="customer-phone"
                           placeholder="手机可以为空,有输入必需是正确的格式">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-qq" class="col-sm-3 control-label">QQ</label>
                <div class="col-sm-8">
                    <input type="text" name="qq" class="text form-control" id="customer-qq"
                           placeholder="QQ可以为空,有输入必需是正确的格式">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-email" class="col-sm-3 control-label">邮箱</label>
                <div class="col-sm-8">
                    <input type="text" name="email" class="text form-control" id="customer-email"
                           placeholder="邮箱可以为空,有输入必需是正确的格式">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-fax" class="col-sm-3 control-label">传真</label>
                <div class="col-sm-8">
                    <input type="text" name="fax" class="text form-control" id="customer-fax"
                           placeholder="传真可以为空,有输入必需是正确的格式">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-identity" class="col-sm-3 control-label">身份证</label>
                <div class="col-sm-8">
                    <input type="text" name="identity" class="text form-control" id="customer-identity"
                           placeholder="身份证可以为空,有输入必需是正确的格式">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-birth" class="col-sm-3 control-label">出生日期</label>
                <div class="col-sm-8">
                    <input type="text" name="birth" class="text form-control" id="customer-birth"
                           placeholder="出生日期可以为空,有输入必需是正确的格式">
                </div>
            </div>

            <div class="form-group">
                <label for="customer-grade-id" class="col-sm-3 control-label">客户等级</label>
                <div class="col-sm-8">
                    <select id="customer-grade-id" name="cugrId" data-placeholder="选择等级"
                            class="text form-control"></select>
                </div>
            </div>

            <div class="form-group">
                <label for="customer-address" class="col-sm-3 control-label">地址</label>
                <div class="col-sm-8">
                    <textarea rows="3" name="add" id="customer-address"
                              class="text form-control" placeholder="地址可以为空"></textarea>
                </div>
            </div>

            <div class="form-group">
                <label for="customer-explain" class="col-sm-3 control-label">说明</label>
                <div class="col-sm-8">
                    <textarea rows="3" name="explain" id="customer-explain"
                              class="text form-control"  placeholder="说明可以为空"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <button id="customer-add" class="btn btn-default">注册</button>
                </div>
            </div>
        </form>
    </div>

</div>

<jsp:include page="/pub/index-footer.jsp"/>

<script type= "application/javascript">

    $(function() {

        var optionCustomerGradeStr = "";
        var treeObj;
        var lastClickRegionId = -1;

        // ==============================  tree 的基础配置 开始  ============================== //
        /**
         * <h4>加载选中的商品类目</h4>
         * @param regionId 商品类目编号
         */
        function loadSelectNode(regionId){
            var node = treeObj.getNodeByParam("id",regionId);
            //为什么设置了checked=true，可是等树显示的时候节点仍然没有选中
            node.checked=true;
            treeObj.selectNode(node);
        }

        // tree 在...之前 点击 事件
        function onBeforeClick(treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeRegion");
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
                return false;
            } else {
                lastClickRegionId = treeNode.id;
                $("#hidden-region-id").val(lastClickRegionId);
                return true;
            }
        }

        //树 基础设置
        var setting = {
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable:true,
                    idKey: "id",
                    pIdKey: "parentId",
                    rootPId: ""
                }
            },
            callback: {
                beforeClick: onBeforeClick,
            }
        };
        // ==============================  tree 的基础配置 结束  ============================== //

        load();

        function load() {

            $.ajax({
                url : "/cus/detail.json",
                cache : false,
                async : false,
                success : function (response) {
                    if (response.status == 200) {
                        var regionList = response.data.regionList;
                        var customerGradeList = response.data.customerGradeList;

                        $("#customerForm")[0].reset();
                        optionCustomerGradeStr = "";
                        renderCustomerGradeSelect(customerGradeList);
                        $("#customer-grade-id").html(optionCustomerGradeStr);
                        $("#customer-birth").datetime();
                        treeObj = $.fn.zTree.init($("#treeRegion"),setting,regionList);
                    }else {
                        showMessage("提示", "数据加载出错了...", false);
                    }
                }
            });

        }

        $("#customer-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();

            updateCustomer(true,function (data) {
                showMessage("注册客户", "注册客户成功", true);
            },function (data) {
                showMessage("注册客户", data.msg, false);
            });
        });

        //更新客户信息
        function updateCustomer(isCreate, successCallback, failCallback) {

            if (validCustomer(true)){
                return;
            }

            $.ajax({
                url: isCreate ? "/cus/save.json" : "",
                data: $("#customerForm").serializeArray(),
                type: 'POST',
                success: function(result) {
                    if (result.status == 200) {
                        if (successCallback) {
                            successCallback(result);
                            window.location.href = "/regchanagesuccess.json";
                        }
                    } else {
                        if (failCallback) {
                            failCallback(result);
                        }
                    }
                }
            });
        }

        function renderCustomerGradeSelect(customerGradeList) {
            if(customerGradeList && customerGradeList.length > 0) {
                $(customerGradeList).each(function (i ,customerGrade) {
                    optionCustomerGradeStr += Mustache.render("<option value='{{id}}'>{{name}}</option>",
                        {id: customerGrade.id, name: customerGrade.name});
                });
            }
        }

    });

</script>

<script src="/js/defined/register-window.js"></script>
<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/customer-valid.js"></script>
<script src="/ztree/jquery.ztree.all.min.js"></script>

</body>
</html>