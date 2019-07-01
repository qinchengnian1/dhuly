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
	<div class="nrheader">
		<a class="sx" href="javascript:;"><span></span></a>
		<div class="nrheaderSearch">
			<input type="text" name="search_roleKey" placeholder="角色编码" value="${fn:trim(param.search_roleKey)}"/>
			<input type="text" name="search_roleValue" placeholder="角色名称" value="${fn:trim(param.search_roleValue)}"/>
			<button class="btn btn-primary"  type="submit">搜索</button>
			<!-- <button class="btn btn-info"  type="reset">重置</button> -->
		</div>
	</div>
	<div class="operation">
		<shiro:hasPermission name="roleadd">
			<a href="javascript:;" onclick="addModel()"><img src="${ctx}/static/images/add.png" /><span>添加</span></a>
		</shiro:hasPermission>
		<shiro:hasPermission name="roledelete">
			<a href="javascript:;" onclick="showDialog(3)"><img src="${ctx }/static/images/delete.png " />删除</a>
		</shiro:hasPermission>
	</div>
	<div class="table-condensed">
	<table class="table table-responsive table-striped">
		<thead>
			<tr>
				<th><input type="checkbox" name="chk"id="ckall" onclick="checkEvent('chk','ckall')" /></th>
				<shiro:hasPermission name="roleupdate">
				<th>操作</th>
				</shiro:hasPermission>
				<th>ID</th>
				<th>角色编码</th>
				<th>角色名称</th>
				<th>角色描述</th>
				<th>创建时间</th>
				<shiro:hasPermission name="empower">
				<th>授权</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageList}" var="vo" varStatus="status">
				<tr>
					<td>
					<input type="checkbox"name="chk" value="${vo.id}" />
					<shiro:hasPermission name="roleupdate">
					<td>
						<span style="cursor:hand"  onclick="updateRole(${vo.id})">编辑</span>
					</td>
					</shiro:hasPermission>
					<td>${vo.id}</td>
					<td>${vo.roleKey}</td>
					<td>${vo.roleValue}</td>
					<td>${vo.description}</td>
					<td><fmt:formatDate value="${vo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td> 
					<shiro:hasPermission name="empower">
					<td>
					<span style="cursor:hand"  class="glyphicon glyphicon-menu-hamburger" onclick="authorize('${vo.roleKey}')">授权</span>
					</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Start 分页-->
		<tags:pagination page="${pageList}" paginationSize="5" />
	</div>
	</form>
	<div id="modal-table" class="modal fade" tabindex="-1" data-backdrop="static" style='margin-bottom: 40px;'>
	<div class="modal-dialog">
		<form id="informationForm">
			<div class="modal-content">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						角色授权
					</div>
				</div>
				<div class="modal-body" style="max-height: 450px;overflow-y: scroll;">
					<div id="modal-tip" class="red clearfix"></div>
					<input id="roleKeyId" type="hidden" />
					<div class="widget-box widget-color-blue2">
						<div class="widget-body">
							<div class="widget-main padding-8">
								<!-- <ul id="authorityTree"></ul> -->
								<div id="tree"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer no-margin-top">
					<div class="text-center">
						<button id="submitButton" type="button" class="btn btn-app btn-success btn-xs">
							<i class="ace-icon fa fa-floppy-o bigger-160"></i>
							保存
						</button>
						<button class="btn btn-app btn-pink btn-xs" data-dismiss="modal">
							<i class="ace-icon fa fa-share bigger-160"></i>
							取消
						</button>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</form>
	</div><!-- /.modal-dialog -->
</div>
	</body>
	<script type="text/javascript">
	$('#submitButton').on('click', function() {
		var output = '';
		var arr = $('#tree').treeview('getChecked');
        for(var i in arr){
        	if(arr[i].childCode){
        		 output += arr[i].childCode + ",";
       			 for(var j in arr[i].nodes){
           			 if(arr[i].nodes[j].state.checked){
           				 output += arr[i].nodes[j].buttonCode + ","; 
           			 }
           		 }
        	}
        }
        
		if(output == ''){
			$.gritter.add({
                title: "系统信息",
                text: "请展开树勾选菜单",
                class_name: "gritter-info gritter-center"
            });  
			return;
		}
		$.ajax({
			url : "${ctx}/authorityManage/saveRoleAuthority",
			data : {
				menuCode : output
			},
			type : 'POST',
			dataType : 'json',
			complete : function(response) {
				$("#modal-table").modal("toggle");
			}
		}); 
		$('#authorityTree').tree('destroy');
	});
	
	
	
	
	var nodeCheckedSilent = false;
	    		function nodeChecked (event, node){
	    		  if(nodeCheckedSilent){
	    		    return;
	    		  }
	    		  nodeCheckedSilent = true;
	    		  checkAllParent(node);
	    		  checkAllSon(node);
	    		  nodeCheckedSilent = false;
	    		}

	    		var nodeUncheckedSilent = false;
	    		function nodeUnchecked (event, node){
	    		  if(nodeUncheckedSilent)
	    		    return;
	    		  nodeUncheckedSilent = true;
	    		  uncheckAllParent(node);
	    		  uncheckAllSon(node);
	    		  nodeUncheckedSilent = false;
	    		}

	    		//选中全部父节点
	    		function checkAllParent(node){
	    		  $('#tree').treeview('checkNode',node.nodeId,{silent:true});
	    		  var parentNode = $('#tree').treeview('getParent',node.nodeId);
	    		  if(!("nodeId" in parentNode)){
	    		    return;
	    		  }else{
	    		    checkAllParent(parentNode);
	    		  }
	    		}
	    		//取消全部父节点
	    		function uncheckAllParent(node){
	    			if(node.id!="2"){
	    				$('#tree').treeview('uncheckNode',node.nodeId,{silent:true});
	      		  var siblings = $('#tree').treeview('getSiblings', node.nodeId);
	      		  var parentNode = $('#tree').treeview('getParent',node.nodeId);
	      		  if(!("nodeId" in parentNode)) {
	      		    return;
	      		  }
	      		  var isAllUnchecked = true; //是否全部没选中
	      		  for(var i in siblings){
	      		    if(siblings[i].state.checked){
	      		      isAllUnchecked=false;
	      		      break;
	      		    }
	      		  }
	      		  if(isAllUnchecked){
	      		    uncheckAllParent(parentNode);
	      		  }
	    			}

	    		}

	    		//级联选中所有子节点
	    		function checkAllSon(node){
	    		  $('#tree').treeview('checkNode',node.nodeId,{silent:true});
	    		  if(node.nodes!=null&&node.nodes.length>0){
	    		    for(var i in node.nodes){
	    		      checkAllSon(node.nodes[i]);
	    		    }
	    		  }
	    		}
	    		//级联取消所有子节点
	    		function uncheckAllSon(node){
	    		  $('#tree').treeview('uncheckNode',node.nodeId,{silent:true});
	    		  if(node.nodes!=null&&node.nodes.length>0){
	    		    for(var i in node.nodes){
	    		      uncheckAllSon(node.nodes[i]);
	    		    }
	    		  }
	    		}
	function authorize(key){
		   $.post("${ctx}/authorityManage/firstMenu",{
		    	roleKey : key
		    },function(data){
				$('#modal-table').modal('show');
		    	$('#tree').treeview({showCheckbox: true,data: data, multiSelect: true,onNodeChecked:nodeChecked ,onNodeUnchecked:nodeUnchecked});
		        $('#tree').treeview('expandAll', { levels: 5, silent: true });
		    })
	
	
	}
	
	function addModel(){
		$.post("${ctx}/roleManage/queryRole",{},function(data){
			$("#modelHtml").html(data);
			$(".addrole").modal('show');
		}); 
	}
	function updateRole(num){
		var id=num;
		$.post("${ctx}/roleManage/updateRole",{
			id:id
		},function(data){
			$("#modelHtml").html(data);
			$(".addrole").modal('show');
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
	     		$.post("${ctx}/roleManage/toExamine",{
	     			ids:ids,
	     			nums:nums
	     		},function(data){
	     			window.location.href="${ctx}/roleManage/JumpRole/";
	    		});
	     		
	     	}
	     }else{
	     	alert("请至少选中一个！！");
	     }
	}
	
	
	</script>
</html>
