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
	<form action="${ctx }/roleManage/JumpRole" method="post">
	<div id='modelHtml'></div>
	<div class="operation">
		<shiro:hasPermission name="roleadd">
			<a href="javascript:;" onclick="addModel()"><img src="${ctx}/static/images/add.png" /><span>添加</span></a>
		</shiro:hasPermission>
		<shiro:hasPermission name="roledelete">
			<a href="javascript:;" onclick="showDialog(3)"><img src="${ctx }/static/images/delete.png " />删除</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="lineapproved"> 
			<a href="javascript:;" onclick="showDialog(1)"><img src="${ctx }/static/images/piliang.png" />审核通过</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="linerefused">
			<a href="javascript:;" onclick="showDialog(2)"><img src="${ctx }/static/images/piliang.png" />审核拒绝</a>
		</shiro:hasPermission>	
	</div>
	<div class="table-condensed">
	<table class="table table-responsive table-striped">
		<thead>
			<tr>
				<th><input type="checkbox" name="chk"id="ckall" onclick="checkEvent('chk','ckall')" /></th>
				<th>操作</th>
				<th>ID</th>
				<th>城市编码</th>
				<th>城市名称</th>
				<th>状态</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageList}" var="vo" varStatus="status">
					<tr>
					<td>
					<input type="checkbox"name="chk" value="${vo.cityId}" />
					</td>
					<td><span style="cursor:hand"  onclick="updateCitys(${vo.cityId})">编辑</span></td>
					<td>${vo.cityId}</td>
					<td>${vo.remark}</td>
					<td>${vo.cityName}</td>
					<td>
					<c:if test="${vo.status=='0'}"><span style="color:red">关闭</span></c:if>
					<c:if test="${vo.status=='1'}">打开</c:if>
					</td>
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
	function addModel(){
		$.post("${ctx}/citysManage/queryCitys/",{},function(data){
			$("#modelHtml").html(data);
			$(".addCitys ").modal('show');
		}); 
	}
	function updateCitys(num){
		var id=num;
		$.post("${ctx}/citysManage/updateCitys",{
			id:id
		},function(data){
			$("#modelHtml").html(data);
			$(".addCitys").modal('show');
		});
	}
	function showDialog(nums){
		var status=nums;
	  	 var chkArray = document.getElementsByName("chk");
	  	 ids = "";
	     for(var i = 0 ; i < chkArray.length ; i ++ )  {
			     if ( chkArray[i].checked ) {
					ids += chkArray[i].value+",";
				}
	     }
	     if(ids.length > 0 ){
	     	if(confirm("确定要操作吗？")){
	     		$.post("${ctx}/citysManage/toExamine",{
	     			ids:ids,
	     			nums:nums
	     		},function(data){
	     			window.location.href="${ctx}/citysManage/JumpCitys/";
	    		});
	     		
	     	}
	     }else{
	     	alert("请至少选中一个！！");
	     }
	}
	function checkEvent(name, allCheckId) { 
		var allCk = document.getElementById(allCheckId); 
		if (allCk.checked == true) checkAll(name); 
		else checkAllNo(name); 
	} 
	   //全选 
	function checkAll(name) { 
		var names = document.getElementsByName(name); 
		var len = names.length; 
		if (len > 0) { 
			var i = 0; 
		for (i = 0; i < len; i++) 
			names[i].checked = true; 
		} 
	} 
  //全不选 
	function checkAllNo(name) {
		var names = document.getElementsByName(name); 
		var len = names.length; 
		if (len > 0) { 
			var i = 0; 
		for (i = 0; i < len; i++) 
			names[i].checked = false; 
		} 
	} 
	
	</script>
</html>
