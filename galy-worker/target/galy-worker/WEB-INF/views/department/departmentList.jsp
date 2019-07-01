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
	<form action="${ctx }/departmentManage/JumpDepartment" method="post">
	<div id='modelHtml'></div>
	<div class="nrheader">
		<a class="sx" href="javascript:;"><span></span></a>
		<input type="hidden" name="eId" id="eId" value="${eId}">
		<div class="nrheaderSearch">
			<select name="search_status">
				<option value="">状态</option>
				<option value="1" ${param.search_status eq "1" ? "selected" : "" }>打开</option>
				<option value="0" ${param.search_status eq "0" ? "selected" : "" }>关闭</option>
			</select>
			<input type="text" name="search_departmentKey" placeholder="部门编码" value="${fn:trim(param.search_departmentKey)}"/>
			<input type="text" name="search_departmentValue" placeholder="部门名称" value="${fn:trim(param.search_departmentValue)}"/>
			<button class="btn btn-primary"  type="submit">搜索</button>
<!-- 			<button class="btn btn-info"  type="reset">重置</button>
 -->		</div>
	</div>
	<div class="operation">
		<shiro:hasPermission name="departmentadd">
		<a href="javascript:;" onclick="addModel()"><img src="${ctx}/static/images/add.png" /><span>添加</span></a>
		</shiro:hasPermission>
		<shiro:hasPermission name="departmentproved">
		<a href="javascript:;" onclick="showDialog(1)"><img src="${ctx }/static/images/piliang.png" />审核通过</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="departmentfused">
		<a href="javascript:;" onclick="showDialog(2)"><img src="${ctx }/static/images/piliang.png" />审核拒绝</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="departmentdelete">
		<a href="javascript:;" onclick="showDialog(3)"><img src="${ctx }/static/images/delete.png" />删除</a>
		</shiro:hasPermission>
	</div>
	<div class="table-condensed">
	<table class="table table-responsive table-striped">
		<thead>
			<tr>
				<th><input type="checkbox" name="chk"id="ckall" onclick="checkEvent('chk','ckall')" /></th>
				<shiro:hasPermission name="departmentupdate">
				<th>操作</th>
				</shiro:hasPermission>
				<th>序号</th>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>创建时间</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageList}" var="vo" varStatus="status">
				<tr>
					<td>
					<input type="checkbox"name="chk" value="${vo.id}" />
					<shiro:hasPermission name="departmentupdate">
					<td>
					<span style="cursor:hand"  onclick="updateDepartment(${vo.id})">编辑</span>
					</td>
					</shiro:hasPermission>
					<td>${status.index+1}</td>
					<td>${vo.departmentKey}</td>
					<td>${vo.departmentValue}</td>
					<td><fmt:formatDate value="${vo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<c:if test="${vo.status eq '1'}">打开</c:if>
						<c:if test="${vo.status eq '0'}"><span style="color:red">关闭</span></c:if>
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
		$.post("${ctx}/departmentManage/queryDepartment/",{},function(data){
			$("#modelHtml").html(data);
			$(".addDepartment").modal('show');
		}); 
	}
	function updateDepartment(num){
		var id=num;
		$.post("${ctx}/departmentManage/updateDepartment",{
			id:id
		},function(data){
			$("#modelHtml").html(data);
			$(".addDepartment").modal('show');
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
	     		$.post("${ctx}/departmentManage/toExamine",{
	     			ids:ids,
	     			nums:nums
	     		},function(data){
	     			window.location.href="${ctx}/departmentManage/JumpDepartment/";
	    		});
	     		
	     	}
	     }else{
	     	alert("请至少选中一个！！");
	     }
	}
	
	</script>
</html>
