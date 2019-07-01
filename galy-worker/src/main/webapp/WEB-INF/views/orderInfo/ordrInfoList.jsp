<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<html lang="zh">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<link rel="stylesheet" type="text/css" href="${ctx }/static/css/routeTable.css" />
	</head>
	<body>
	<form action="${ctx }/orderManage/JumpOrderInfo" method="post">
	<div id='modelHtml'></div>
	<div class="nrheader">
		<a class="sx" href="javascript:;"><span></span></a>
		<div class="nrheaderSearch">
			<select name="search_stateLocal" id="search_stateLocal">
				<option value="">订单状态</option>
				<option value="0" ${param.search_stateLocal eq "0" ? "selected" : "" }>待支付</option>
				<option value="1" ${param.search_stateLocal eq "1" ? "selected" : "" }>支付中 </option>
				<option value="2" ${param.search_stateLocal eq "2" ? "selected" : "" }>正式报名失败</option>
				<option value="3" ${param.search_stateLocal eq "3" ? "selected" : "" }>支付完成</option>
				<option value="4" ${param.search_stateLocal eq "4" ? "selected" : "" }>支付取消</option>
				<option value="5" ${param.search_stateLocal eq "5" ? "selected" : "" }>支付失败</option>
			</select>
			<input type="text" name="search_perName" id="search_perName" placeholder="下单用户" value="${fn:trim(param.search_perName)}"/>
			<button class="btn btn-primary"  type="submit">搜索</button>
			<shiro:hasPermission name="export">
				<button class="btn btn-info" onclick="exportExcel()">导出</button> 
			</shiro:hasPermission>
		</div>
	</div>
	<div class="operation">
	</div>
	<div class="table-condensed">
	<table class="table table-responsive table-striped">
		<thead>
			<tr>
				<th>序号</th>
				<th>平台订单编号</th>
				<th>本地订单编号</th>
				<th>下单用户</th>
				<th>下单用户手机号</th>
				<th>线路名称</th>
				<th>网上预订价格</th>
				<th>出发地址</th>
				<th>支付状态</th>
				<th>创建时间</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageList}" var="vo" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${vo.orderNoPt}</td>
					<td>${vo.orderNoLocal}</td>
					<td>${vo.perName}</td>
					<td>${vo.perTel}</td>
					<td>${vo.routeName}</td>
					<td>${vo.onlinePrice}/元</td>
					<td>${vo.startPlace}</td>
					<td>
						<c:if test="${vo.stateLocal eq '0'}">待支付</c:if>
						<c:if test="${vo.stateLocal eq '1'}">支付中 </c:if>
						<c:if test="${vo.stateLocal eq '2'}"><span style="color:red">正式报名失败</span></c:if>
						<c:if test="${vo.stateLocal eq '3'}">支付完成</c:if>
						<c:if test="${vo.stateLocal eq '4'}">支付取消</c:if>
						<c:if test="${vo.stateLocal eq '5'}">支付失败 </c:if>
					</td>
					<td><fmt:formatDate value="${vo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Start 分页-->
		<tags:pagination page="${pageList}" paginationSize="5" />
	</div>  
	</form>
	</body>
	<script type="text/javascript">
	function exportExcel(){
		var search_perName= document.getElementById("search_perName").value;
		var search_stateLocal=$("#search_stateLocal option:selected").val(); 
		window.location.href="${ctx}/orderManage/exportExcel?perName="+search_perName+"&stateLocal="+search_stateLocal;
		window.event.returnValue=false;
	}
	</script>
</html>
