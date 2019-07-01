<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
 <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
  <link rel="icon" href="static/login/images/guoan.ico" type="image/x-icon" />
 <link rel="stylesheet" type="text/css" href="static/login/css/login.css"/>
 <script src="${ctx }/static/js/jquery-1.10.2.min.js"></script>
	<div class="content-box">
		<div class="login-box">
			<h2>用户登录</h2>
			<ul>
				<li><img src="${ctx }/static/login/images/userName.png"/><input type="text" autofocus="autofocus" name="username" id="username" value="admin" placeholder="请输入账号" /></li>
				<li><img src="${ctx }/static/login/images/psw.png"/><input type="password" name="password" id="password" value="123456" placeholder="请输入密码" /></li>
			</ul>
			<div class="loginBtn-box"><button class="loginBtn" value="登录" id="form">确认登录</button></div>
		</div>
	</div>
<script type="text/javascript">
	window.onload = function(){
		if(window.parent.window != window){
			window.top.location = "${ctx}/sys/sysuser/home";
		}
	};
	$("#form").on('click',function(){
		$.get("${ctx }/sys/sysuser/login",{
			username:$("#username").val(),
			password:$("#password").val()
		},function(data){
			data = eval('('+data+')');
			if("0"!=data.header.resCode){
				alert(data.header.repDes);
			}else{
				window.location.href = "${ctx}/sys/sysuser/home";
			}
		});
	});

</script>
