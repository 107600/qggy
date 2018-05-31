<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

<head>
    <meta charset="utf-8">
    <title>确认充值信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description"
          content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/weui/lib/weui.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/weui/css/jquery-weui.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/weui/css/jquery-weui.css">

</head>

<body>
<header class="demos-header">
    <h1 class="demos-title" style="text-align: center">确认充值信息</h1>
</header>

<div class="weui-form-preview">
    <div class="weui-form-preview__bd">

        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">充值前现金账户余额</label>
            <span class="weui-form-preview__value">${sessionScope.user.xianjin}</span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">充值金额</label>
            <span class="weui-form-preview__value">${money}</span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">充值后现金账户余额</label>
            <span class="weui-form-preview__value">${xianjin}</span>
        </div>



    </div>
</div>

<div class="weui-footer">

</div>

<div
        style="width: 80%; margin-left: 10%;margin-top: 0.2rem;margin-bottom: 0.2rem;">
    <a href="javascript:;" id="submit-btn" class="weui-btn weui-btn_warn">确认支付</a>
</div>
<input type="hidden" value=${wxJsApiParam} id="wxJsApiParam" >


</body>
<script type="text/javascript">
    var jsonParam=document.getElementById("wxJsApiParam").value;
    $(function() {
        $('#submit-btn')
            .click(
                function(event) {
                    $.ajax({
                        url : "${pageContext.request.contextPath}/phone/user/basicinfo/trade/czinsert.action",
                        data : {},
                        type : "get",
                        dataType : "json",
                        //很重要!!!.  预期服务器返回的数据类型
                        error : function(data) {
                            alert("订单发起错误，请重新支付");
                            alert(data);
                        },
                        success : function(data) {
                            //只有后台预插入成功才会调用微信支付
                            callpay(data[0].id);
                        }
                    });
                }
            );
    });
</script>
<script type="text/javascript">
    //var json = ${wxJsApiParam};必须在同一行
    var json = ${wxJsApiParam};
    //alert("["+JSON.stringify(json)+"]");
    function jsApiCall(id) {
        WeixinJSBridge
            .invoke('getBrandWCPayRequest',
                json,//josn串
                function(res) {
                    WeixinJSBridge.log(res.err_msg);
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                        window.location.href = "http://qingguocloud.com/qggy/phone/public/basicinfo/trade/czsucess.action?id="+id;
                    }
                });
    }
    function callpay(id) {
        if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', jsApiCall,
                    false);
            } else if (document.attachEvent) {
                document.attachEvent('WeixinJSBridgeReady', jsApiCall);
                document.attachEvent('onWeixinJSBridgeReady', jsApiCall);
            }
        } else {
            jsApiCall(id);
        }
    }
</script>

</html>

