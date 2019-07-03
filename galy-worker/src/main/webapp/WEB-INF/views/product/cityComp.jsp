<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
	<title>城市供应商管理</title>
	<link rel="stylesheet" type="text/css" href="${ctx }/static/css/routeManagement.css"/>
</head>
<body>
	<div id="routeManagement">
		<div class="routeType">
			<h5>城市供应商</h5>
			<!-- <div class="search">
				<input class="form-control" type="text" name="" id="" value="" placeholder="请输入关键字" />
				<button class="btn btn-primary">搜索</button>
			</div> -->
			<div class="routeTypeContent">
				<ul>
					<c:forEach items="${cityList}" var="vo" varStatus="status">
						<li>
						   <a data-toggle="collapse" href="#domestic_${status.index+1}" aria-expanded="false" aria-controls="domestic_${status.index+1 }">${vo.cityName }</a>
						</li>
						<div class="collapse navBarContent" id="domestic_${status.index+1 }">
						 	<ul>
						 		<c:forEach items="${vo.eShop }" var="so">
									<li class="navBarLi"><a href="javascript:;" date-url="${ctx }/productManage/productList/${so.eId}">${so.eName }</a></li>
						 		</c:forEach>
						 	</ul>
						</div>
					</c:forEach>
				</ul>
				<p>&nbsp;</p>
			</div>
		</div>
		<div class="content">
			<iframe src="${ctx }/productManage/chooseDefultPage" frameborder="0" width="100%" height="100%" id="iframe_cityComp"></iframe>
		</div>
	</div>
</body>
	<script type="text/javascript">
		$('.navBarLi').on('click',function(){
			var url = $(this).find('a').attr("date-url");
			$("#iframe_cityComp").attr('src',url);
		});
	</script>
</html>