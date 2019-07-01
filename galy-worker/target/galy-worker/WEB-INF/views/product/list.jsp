<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${ctx }/static/css/routeTable.css" />
	</head>
	<body>
		<div id="routeTable">
		<div id='modelHtml'></div>
		<form action="${ctx }/productManage/productList/${eId}" method="post">
			<div class="nrheader">
				<a class="sx" href="javascript:;"><span></span></a>
				<input type="hidden" name="eId" id="eId" value="${eId}">
				<div class="nrheaderSearch">
					<select name="search_agentType" id="search_agentType">
						<option value="">推荐类别</option>
						<option value="1" ${param.search_agentType eq "1" ? "selected" : "" }>自销</option>
						<option value="2" ${param.search_agentType eq "2" ? "selected" : "" }>推荐</option>
						<option value="3" ${param.search_agentType eq "3" ? "selected" : "" }>精品</option>
						<option value="4" ${param.search_agentType eq "4" ? "selected" : "" }>人气</option>
					</select>
					<select name="search_systemFlag" id="search_systemFlag">
						<option value="">线路类别</option>
						<option value="1" ${param.search_systemFlag eq "1" ? "selected" : "" }>国内</option>
						<option value="2" ${param.search_systemFlag eq "2" ? "selected" : "" }>出境</option>
					</select>
					<select name="search_status" id="search_status">
						<option value="">状态</option>
						<option value="1" ${param.search_status eq "1" ? "selected" : "" }>打开</option>
						<option value="0" ${param.search_status eq "0" ? "selected" : "" }>关闭</option>
					</select>
					<input type="text" name="search_routeMain" id="search_routeMain" placeholder="线路名称" value="${fn:trim(param.search_routeMain)}"/>
					<button class="btn btn-primary"  type="submit">搜索</button>
					<shiro:hasPermission name="lineexport">
					<button class="btn btn-info"  onclick="exportExcel()">导出</button> 
					</shiro:hasPermission>
					
				</div>
			</div>
			<div class="operation">
			<shiro:hasPermission name="lineadd">
				<a href="javascript:;" onclick="addModel()"><img src="${ctx}/static/images/add.png" /><span>添加</span></a>
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
							<th>序号</th>
							<th>线路编号</th>
							<th>线路名称</th>
							<th>线路类别</th>
							<th>推荐类别</th>
							<th>价格</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageList }" var="vo" varStatus="status">
							<tr>
								<td>
								<input type="checkbox"name="chk" value="${vo.pId}" />
								<td>
								<shiro:hasPermission name="linepreview">
								<span style="cursor:hand"  onclick="preview(${vo.pId})">预览</span>
								</shiro:hasPermission>
								<shiro:hasPermission name="lineaupdate">
								<span style="cursor:hand"  onclick="updateProduc(${vo.pId})">编辑</span>
								</shiro:hasPermission>
								</td>
								<td>${status.index+1}</td>
								<td>${vo.ptNo}</td>
								<td>${vo.routeMain}</td>
								<td>
									<c:if test="${vo.systemFlag eq '1'}">国内跟团</c:if>
									<c:if test="${vo.systemFlag eq '2'}">境外跟团</c:if>
									<c:if test="${vo.systemFlag eq '3'}">周边游</c:if>
									<c:if test="${vo.systemFlag eq '4'}">游轮</c:if>
									<c:if test="${vo.systemFlag eq '5'}">门票</c:if>
									<c:if test="${vo.systemFlag eq '6'}">签证</c:if>
									<c:if test="${vo.systemFlag eq '7'}">国内自由</c:if>
									<c:if test="${vo.systemFlag eq '8'}">出境自由</c:if>
								</td>
								<td>
									<c:if test="${vo.agentType eq '1'}">自销</c:if>
									<c:if test="${vo.agentType eq '2'}">推荐</c:if>
									<c:if test="${vo.agentType eq '3'}">精品</c:if>
									<c:if test="${vo.agentType eq '4'}">人气</c:if>
								</td>
								<td>${vo.price }/元起</td>
								<td>
									<c:if test="${vo.status eq '1'}">打开</c:if>
									<c:if test="${vo.status eq '0'}"><span style="color:red">关闭</span></c:if>
								</td>
								<%-- <td><fmt:formatDate value="${vo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- Start 分页-->
				<tags:pagination page="${pageList}" paginationSize="5" />
			</div>
			</form>
		</div>
	</body>
<script type="text/javascript">
	function exportExcel(){
		var search_routeMain= document.getElementById("search_routeMain").value;
		var search_systemFlag=$("#search_systemFlag option:selected").val(); 
		var search_agentType=$("#search_agentType option:selected").val(); 
		var search_status=$("#search_status option:selected").val(); 
		window.location.href="${ctx}/productManage/exportExcel/${eId}?routeMain="+search_routeMain+"&systemFlag="+search_systemFlag+"&agentType="+search_agentType+"&status="+search_status;
		window.event.returnValue=false;
	}
	function addModel(){
		$(".dropdown-toggle").dropdown('toggle');
		$(".wysiwyg-toolbar").dropdown('toggle');
		$.post("${ctx}/productManage/queryTravel/${eId}",{},function(data){
			$("#modelHtml").html(data);
			$(".added").modal('show');
		}); 
	}
	
	function viewTheDetails(id){
		$.post("${ctx}/productManage/viewTheDetails?id="+id,{},function(data){
			$("#modelHtml").html(data);
			$(".addedFour").modal('show');
		}); 
	}
	//查看详情
	function preview(pId){
		window.location.href="http://ly.5138fun.com/ly/h5/productDetails/localProductDetails-pc.html?pId="+pId;
	}
	function checkEvent(name, allCheckId) { 
		var allCk = document.getElementById(allCheckId); 
		if (allCk.checked == true) checkAll(name); 
		else checkAllNo(name); 
	} 
	function updateProduc(pId){
		var status="opt";
		var eId=$("#eId").val();
		$.post("${ctx}/productManage/updateProduc?pId="+pId+"&status="+status+"&eId="+eId,{
		},function(data){
			$("#modelHtml").html(data);
			$(".added").modal('show');
			$("#preview").show();
		});
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
		 var eid=$("#eId").val();
	  	 var chkArray = document.getElementsByName("chk");
	  	 ids = "";
	     for(var i = 0 ; i < chkArray.length ; i ++ )  {
			     if ( chkArray[i].checked ) {
					ids += chkArray[i].value+",";
				}
	     }
	     if(ids.length > 0 ){
	     	if(confirm("确定要审核吗？")){
	     		$.post("${ctx}/productManage/toExamine?ids="+ids+"&nums="+nums+"&eId="+eid,{
	     			
	     		},function(data){
	     			
		     	window.location.href = "${ctx }/productManage/productList/${eId}";
	    		});
	     		
	     	}
	     }else{
	     	alert("请至少选中一个！！");
	     }
	}
</script>
</html>
