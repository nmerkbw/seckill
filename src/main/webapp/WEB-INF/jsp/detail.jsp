<%--<%@page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%--<%@include file="common/tag.jsp" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>秒杀详情页</title>--%>
    <%--<%@include file="common/head.jsp" %>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <%--<div class="panel panel-default text-center">--%>
        <%--<div class="pannel-heading">--%>
            <%--<h1>${seckill.name}</h1>--%>
        <%--</div>--%>

        <%--<div class="panel-body">--%>
            <%--<h2 class="text-danger">--%>
                <%--&lt;%&ndash;显示time图标&ndash;%&gt;--%>
                <%--<span class="glyphicon glyphicon-time"></span>--%>
                <%--&lt;%&ndash;展示倒计时&ndash;%&gt;--%>
                <%--<span class="glyphicon" id="seckill-box"></span>--%>
            <%--</h2>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--&lt;%&ndash;登录弹出层 输入电话&ndash;%&gt;--%>
<%--<div id="killPhoneModal" class="modal fade">--%>

    <%--<div class="modal-dialog">--%>

        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<h3 class="modal-title text-center">--%>
                    <%--<span class="glyphicon glyphicon-phone"> </span>秒杀电话:--%>
                <%--</h3>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<div class="row">--%>
                    <%--<div class="col-xs-8 col-xs-offset-2">--%>
                        <%--<input type="text" name="killPhone" id="killPhoneKey"--%>
                               <%--placeholder="填写手机号^o^" class="form-control">--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="modal-footer">--%>
                <%--&lt;%&ndash;验证信息&ndash;%&gt;--%>
                <%--<span id="killPhoneMessage" class="glyphicon"> </span>--%>
                <%--<button type="button" id="killPhoneBtn" class="btn btn-success">--%>
                    <%--<span class="glyphicon glyphicon-phone"></span>--%>
                    <%--Submit--%>
                <%--</button>--%>
            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>

<%--</body>--%>
<%--&lt;%&ndash;jQery文件,务必在bootstrap.min.js之前引入&ndash;%&gt;--%>
<%--<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>--%>
<%--<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
<%--&lt;%&ndash;使用CDN 获取公共js http://www.bootcdn.cn/&ndash;%&gt;--%>
<%--&lt;%&ndash;jQuery Cookie操作插件&ndash;%&gt;--%>
<%--<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>--%>
<%--&lt;%&ndash;jQuery countDown倒计时插件&ndash;%&gt;--%>
<%--<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>--%>

<%--<script src="/resources/script/seckill.js" type="text/javascript"></script>--%>

<%--<script type="text/javascript">--%>
    <%--$(function () {--%>
        <%--//使用EL表达式传入参数--%>
        <%--seckill.detail.init({--%>
            <%--seckillId:${seckill.seckillId},--%>
            <%--startTime:${seckill.startTime.time},//毫秒--%>
            <%--endTime:${seckill.endTime.time}--%>
        <%--});--%>
    <%--})--%>
<%--</script>--%>
<%--</html>--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>秒杀详情页</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>${seckill.name}</h1>
        </div>
        <div class="panel-body text-center">
            <h2 class="text-danger">
                <!-- 显示time图标-->
                <span class="glyphicon glyphicon-time"></span>
                <!-- 展示倒计时-->
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>
<!-- 登录弹出层，输入电话，模态框（Modal） -->
<div class="modal fade" id="killPhoneModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>秒杀电话：
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey"
                               placeholder="填写手机号" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<!-- jQuery文件，务必在bootstrap.min.js 之前引入 -->
<%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- 倒计时插件-->
<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>

<script src="/resources/script/seckill.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        seckill.detail.init({
            //使用EL表达式传入参数
            seckillId:${seckill.seckillId},
            startTime:${seckill.startTime.time}, //毫秒
            endTime:${seckill.endTime.time}
        });
    });
</script>
</html>