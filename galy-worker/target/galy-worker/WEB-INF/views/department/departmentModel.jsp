<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<script src="${ctx }/static/js/jquery.form.min.js"></script>
<html lang="zh">
<body>
<form id="form" method="post"  enctype="multipart/form-data">
<div class="modal fade addDepartment" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"  style='margin-bottom:50px;'>
	<div class="modal-dialog modal-lg motaiPosition" role="document" style="margin-top:5 ;">
		<div class="modal-content" style='width:35%;margin-top: 100px;'>  
			<div class="modal-header" style='padding: 10px;'>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
				<h6 class="modal-title" >部门管理</h6>
			</div>
		<div class="modal-body" style="padding: 0;">
			<div class="modalcontent">
			<ul style='padding: 10px 10px 0px 0px;'>
				<li style='padding: 15px 15px;'>
					<input type="hidden" id="id" name="id" value="${department.id}">
					<div class="mdContentLeft" style='margin-right: 40px;'>部门编号：</div>
					<input type="text" name="departmentKey" id="departmentKey" value="${department.departmentKey}">
				</li>
							<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>部门名称：</div>
					<input type="text" name="departmentValue" id="departmentValue" value="${department.departmentValue}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>说明：</div>
					<textarea style="height:15%;width:359%" name="description" id="description">${department.description}</textarea>
				</li>
			</ul>
			</div>	
			<div class="modalRight">
				<a style='widht: 90px;height:32px;line-height: 32px;' href='javascript:;' onclick="submitDepartment()">保存</a>
				<a style='widht: 90px;height:32px;line-height: 32px;' href='javascript:;' data-dismiss="modal" aria-label="Close">关闭</a>
			</div>	
		</div>
		</div>
	</div>
</div>
</form>
</body>
</html>
<script type="text/javascript">
function submitDepartment(){
	  $("#form").ajaxSubmit({
			url : "${ctx}/departmentManage/addDepartment",
			type : "post",
			dataType : "json",
			data:{
			},
			beforeSubmit : function(){
			var departmentKey=$("#departmentKey").val()
			var departmentValue=$("#departmentValue").val()
			if(departmentKey==""){
				alert("请输入部门编号");
				return false;
			}if(departmentValue==""){
				alert("请输入部门名称");
				return false;
			}
				return true;
			},
			success : function(data){
				if(data==1){
					window.location.href="${ctx}/departmentManage/JumpDepartment/";
					$(".addDepartment").modal('hide');
				}else if(data==0){
					alert("编号已存在，请重新填写");
				}
			}
		});

   }
</script>