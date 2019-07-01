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
	<form action="${ctx }/authorityManage/JumpAuthority" method="post">
	<div id='modelHtml'></div>
	<div class="nrheader">
		<a class="sx" href="javascript:;"><span></span></a>
		<div class="nrheaderSearch">
			<input type="text" name="search_menuCode" placeholder="菜单编码" value="${fn:trim(param.search_menuCode)}"/>
			<input type="text" name="search_menuName" placeholder="菜单名称" value="${fn:trim(param.search_menuName)}"/>
			<button class="btn btn-primary"  type="submit">搜索</button>
			<!-- <button class="btn btn-info"  type="reset">重置</button> -->
		</div>
	</div>
	<div class="operation">
		<shiro:hasPermission name="menuadd">
				<a href="javascript:;" onclick="addModel()"><img src="${ctx}/static/images/add.png" /><span>添加</span></a>
		</shiro:hasPermission>
		<shiro:hasPermission name="menudelete">
				<a href="javascript:;" onclick="showDialog(3)"><img src="${ctx }/static/images/delete.png " />删除</a>
		</shiro:hasPermission>
		<%-- <a href="javascript:;" onclick="showDialog(1)"><img src="${ctx }/static/images/piliang.png" />审核通过</a>
		<a href="javascript:;" onclick="showDialog(2)"><img src="${ctx }/static/images/piliang.png" />审核拒绝</a> --%>
	</div>
	<div class="table-condensed">
	<table class="table table-responsive table-striped">
		<thead>
			<tr>
				<th><input type="checkbox" name="chk"id="ckall" onclick="checkEvent('chk','ckall')" /></th>
			<shiro:hasPermission name="menuupdate">
				<th>操作</th>
			</shiro:hasPermission>
				<th>序号</th>
				<th>链接地址</th>
				<th>菜单class属性</th>
				<th>菜单编码</th>
				<th>菜单名称</th>
				<th>父级编码</th>
				<th>排序</th>
				<th>创建时间</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageList}" var="vo" varStatus="status">
				<tr>
					<td>
					<input type="checkbox"name="chk" value="${vo.id}" />
				<shiro:hasPermission name="menuupdate">
					<td>
					<span style="cursor:hand"  onclick="updateAuthority(${vo.id})">编辑</span>
					</td>
				</shiro:hasPermission>
					<td>${status.index+1}</td>
					<td>${vo.dataUrl}</td>
					<td>${vo.menuClass}</td>
					<td>${vo.menuCode}</td>
					<td>${vo.menuName}</td>
					<td>${vo.parentMenucode}</td>
					<td>${vo.sequence}</td>
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
	function addModel(){
		$.post("${ctx}/authorityManage/queryAuthority/",{},function(data){
			$("#modelHtml").html(data);
			$(".addAuthority ").modal('show');
		}); 
	}
	function updateAuthority(num){
		var id=num;
		$.post("${ctx}/authorityManage/updateAuthority",{
			id:id
		},function(data){
			$("#modelHtml").html(data);
			$(".addAuthority").modal('show');
		});
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
	     		$.post("${ctx}/authorityManage/toExamine",{
	     			ids:ids,
	     			nums:nums
	     		},function(data){
	     			window.location.href="${ctx}/authorityManage/JumpAuthority/";
	    		});
	     		
	     	}
	     }else{
	     	alert("请至少选中一个！！");
	     }
	}
	
	</script>
</html>
