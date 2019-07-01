<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<form id="editOrgForm">
	<input id="vorgizationid" name="vorgizationid" type="hidden" value="${org.vorgizationid }">
	<div class="modal-content">
		<div class="modal-header no-padding">
		</div>
       <div class="panel panel-default">
	   	  <div class="panel-heading">添加线路 </div>
			 <div class="panel-body">
				<table class="table table-striped table-bordered table-hover" style="width:100%;">
						<tr>
							<td>线路名称：</td>
							<td><input type="text" name="userName"></td>
							<td>线路主标题：</td>
							<td><input type="text" name="routeMain"></td>
							<td>线路副标题：</td>
							<td><input type="text" name="routeSub"></td>
							<td>线路类型：</td>
							<td>
								<select>
									<option>--请选择--</option>
									<option>国内</option>
									<option>出境</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>平台id(sku)：</td>
							<td><input type="text" name="ptId"></td>
							<td>价格：</td>
							<td><input type="text" name="price"></td>
							<td>是否推荐：</td>
							<td>
								<input type="radio" name="agentType">是
								<input type="radio" name="agentType">否
							</td>
							<td>上传图片：</td>
							<td><input type="text" name="routeSub"></td>
						</tr>
						<tr>
							<td>供应商：</td>
							<td>
								<select>
									<option>--请选择--</option>
									<option>国旅</option>
								</select>
							</td>
							<td>出发城市：</td>
							<td>
								<select>
									<option>--请选择--</option>
									<option>国旅</option>
								</select>
							</td>
							<td>到达城市：</td>
							<td>
								<select>
									<option>--请选择--</option>
									<option>国旅</option>
								</select>
							</td>
						</tr>
				 </table>
			 </div>
		  </div>
		  <div class="modal-footer no-margin-top">
			<div class="text-center">
				<a href="javascript:void(0)" class="btn btn-app btn-success btn-xs" onclick="saveInfo(this)">
					<i class="ace-icon fa fa-floppy-o bigger-160"></i>
						下一步
				</a>
				<button class="btn btn-app btn-pink btn-xs" data-dismiss="modal">
					<i class="ace-icon fa fa-share bigger-160"></i>
						取消
				</button>
			</div>
		 </div>
	</div>
</form>
<script>
function alertMes(obj){
	$.gritter.add({
        title: "错误提示",
        text: obj,
        time: 1000,
        speed: 10,
        class_name: "gritter-error gritter-center"
    });
}
/*保存产品信息*/
var flag = true;
function saveInfo(obj){
	if($("#orgSourceId").val()==""){
		alertMes("请选择组织来源");
		return false;
	}
	if($("#organizationTypeId").val()==""){
		alertMes("请选择组织类型");
		return false;
	}

	if(!isNumber($("#busnisstime").val())){
		alertMes("营业期限必须为整数");
		return false;
	}
	if(checkFormBeforSubmit("editOrgForm")){
		if(flag){
			flag = false;
			$(obj).find("i").addClass("ace-icon fa fa-spinner fa-spin white bigger-225");
			var dataStr = $("#editOrgForm").serialize();
			$.post("${contextPath}/sys/orgMangement/orgSubmit/${timestamp}",dataStr,function(data){
				flag = true;
				data = eval(data);
				if("1"==data.header.res){
					$.gritter.add({
			            title: "系统提示",
			            text: data.header.resCode,
			            time: 1000,
			            speed: 10,
			            class_name: "gritter-success gritter-center"
			        });
				}else{
					$.gritter.add({
			            title: "错误提示",
			            text: data.header.resCode,
			            time: 1000,
			            speed: 10,
			            class_name: "gritter-error gritter-center"
			        });
				}
				$("#modal-table").modal("hide");
				jQuery("#grid-table").trigger("reloadGrid");
			});
		}
	}
}
$('.date-picker').datepicker({
	format : 'yyyy-mm-dd',
	autoclose : true,
    language: 'zh-CN'
});
</script>