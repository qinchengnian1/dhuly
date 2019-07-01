<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
 <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
  <link rel="icon" href="static/login/images/guoan.ico" type="image/x-icon" />
 <link rel="stylesheet" type="text/css" href="static/login/css/login.css"/>
 <script src="${ctx }/static/js/jquery-1.10.2.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>豆会玩旅游后台</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="robots" content="index,follow">
		<link rel="icon" href="${ctx }/static/images/guoan.ico" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="${ctx }/static/css/index.css"/>
		<link rel="stylesheet" type="text/css" href="${ctx }/static/bootstrap-3.3.7-dist/css/bootstrap.css"/>
	</head>
	<body>
		<!-- dialog -->
		<div class="dialog" id="J_dialog">
			<div class="dialog-hd">
				<h3><i class="icon icon-user-edit"></i> 资料设置</h3>
				<i class="dialog-close"></i>
			</div>
			<div class="dialog-tab" id="J_dialogTab">
				<h4 class="active"><i class="icon icon-user-head"></i> 头像设置</h4>
				<h4><i class="icon icon-lock"></i> 修改密码</h4>
				<h4><i class="icon icon-user-data"></i> 我的资料</h4>
			</div>
		</div>
		<!-- dialog -->

		<!-- header -->
		<div class="header">
			<div class="topbar undefined">
				<div class="cpy">
					<p>豆会玩旅游后台</p>
				</div>
				<div class="erp-dropdown pull-right">
					<a class="dropdown-toggle" href="javascript:void(0)">
						<span class="erp-logo"></span>
						<i class="caret"></i>
					</a>
					<div class="dropdown-box2" style="right:-1px;">
						<ul>
							<li>
								<a href="http://browser.qq.com/" target="_blank">推荐浏览器下载</a>
							</li>
						</ul>
					</div>
				</div>
				<!-- 更多系统相关 -->
				<div style="height:30px; margin-left:200px; margin-right:320px;">
					<p style=" display:block; width:100%; margin:0; padding:0; height:30px; line-height:30px; font-family:&#39;Microsoft Yahei&#39;; font-size:12px; color:red;" title=""></p>
				</div>
			</div>
			<div class="navbar">
				<!-- 用户模块 -->
				<div class="user-box">
					<a class="hd" href="javascript:void(0)">
						<p class="user-head" id="J_topUserHead"><img id="" src="${ctx }/static/images/header.png" ></p>
						<!-- <p class="user-name" href="javascript:void(0)"><span id="index_my_username"></span> <i class="caret"></i></p> -->
					</a>
					<div class="bd">
						<div class="user-operate" id="J_operateMenu">
							<p>
								<a class="user-btn" href="javascript:void(0);">头像设置</a>
							</p>
							<p>
								<a class="user-btn" href="javascript:void(0);">修改密码</a>
							</p>
							<p>
								<a class="user-btn" href="javascript:void(0);">我的资料</a>
							</p>
							<p>
								<a class="user-btn" href="javascript:void(0);">微信绑定</a>
							</p>
							<p>
								<a class="user-btn" id="btn_logout" href="javascript:void(0);" data-from="undefined">退出系统</a>
							</p>
						</div>
					</div>
				</div>
				<!-- citycompid -->
				<div class="exitLogon">
				<select name="cityid"  id="cityid"  onchange="getStaff()" style='width: 170px;outline: none;padding: 3px 0px;'>
							 <c:forEach var="item" items="${cityList}">
								<option value="${item.cityId}" ${citycompid == item.cityId ? "selected" : ""}>
									${item.cityName}</option>
							</c:forEach>
					</select>
					<button class="btn btn-success" id="signout">退出登录</button>
				</div>
			</div>
		</div>
		<!-- header -->

		<!-- container -->
		<div class="container clearfix" style="width:100%;padding:0;height: 100%;">
			<div class="side-navbar" id="J_sideNav" style="height: 100%;">
				<div id="menu_33XY3G2SCUUG" class="show">
					<h3 class="hd"><span class="text">控台中心</span><a class="menu-btn" href="javascript:void(0)" title="收缩导航"><i class="icon icon-menu"></i></a></h3>
					<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 459px;">
					<ul class="side-nav" style="height: 459px; overflow: hidden; width: auto;">
					<c:forEach var="authority" items="${authorityList}" varStatus="status">
	                	<c:if test="${authority.authorityEntity.size() > 0}">
		                    <li class="nav-item ">
		                        <a class="nav-link" href="#index${status.index+1 }" data-toggle="collapse" aria-expanded="false" aria-controls="index${status.index+1 }">
		                            <i class="<c:out value='${authority.menuClass}'/>"  ></i>
		                            <span class="text"><c:out value="${authority.menuName}"/></span>
		                            <b class="arrow fa fa-angle-down"></b>
		                        </a>
		                      </li>
		                        <div class="collapse navBarContent" id="index${status.index+1 }" >
		                        	<ul>
		                        	<c:forEach var="subAuthorityList" items="${authority.authorityEntity}">
			                        <li  class="navBarLi">
		                                <a href="javascript:;"  data-url="${ctx}/${subAuthorityList.dataUrl}" >
		                                    <i class="<c:out value='${subAuthorityList.menuClass}'/>"></i><c:out value="${subAuthorityList.menuName}"/>
		                                </a>
		                            </li>
		                            </c:forEach>
		                            </ul>
		         				</div>
		                  
		                </c:if>
                    </c:forEach>
                </ul>
				</div>
			</div>
			</div>
			<div class="workspace" id="J_workspace" style="height: 100%;padding-left: 0;">
				<iframe src="${ctx }/sys/sysuser/navContent" frameborder="0" width="100%" height="100%" id="iframe_frames"></iframe>
			</div>
		</div>
	</body>
	<script src="${ctx }/static/js/jquery-3.2.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${ctx }/static/js/jquery.slimscroll.js" type="text/javascript" charset="utf-8"></script>
	<script src="${ctx }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$('.navBarLi').on('click',function(){
			console.log($(this)[0].children[0].dataset.url)
			var url = $(this)[0].children[0].dataset.url
			$("#iframe_frames").attr('src',url);
		});
		$("#signout").on('click',function(){
			window.location.href = "${ctx}/sys/sysuser/logout";
		});

		function getStaff(){
			 var cityid= $('#cityid option:selected').val();
			window.location.href = "${ctx}/sys/sysuser/home?citysid="+cityid;
		}


		
		
	</script>
</html>