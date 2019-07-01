<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<script src="${ctx }/static/js/jquery.form.min.js"></script>
<html lang="zh">
<body>
<form id="form" method="post"  enctype="multipart/form-data">
<div class="modal fade addAuthority" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"  style='margin-bottom:50px;'>
	<div class="modal-dialog modal-lg motaiPosition" role="document" style="margin-top:5 ;">
		<div class="modal-content" style='width:35%;margin-top: 100px;'>  
			<div class="modal-header" style='padding: 10px;'>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
				<h6 class="modal-title" >线路管理</h6>
			</div>
		<div class="modal-body" style="padding: 0;">
			<div class="modalcontent">
			<ul style='padding: 10px 10px 0px 0px;'>
				<li style='padding: 15px 15px;'>
					<input type="hidden" id="id" name="id" value="${authority.id}">
					<div class="mdContentLeft" style='margin-right: 40px;'>链接地址：</div>
					<input type="text" name="dataUrl" id="dataUrl" value="${authority.dataUrl}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>菜单class属性：</div>
					<input type="text" name="menuClass" id="menuClass" value="${authority.menuClass}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>菜单编码：</div>
					<input type="text" name="menuCode" id="menuCode" value="${authority.menuCode}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>菜单名称：</div>
					<input type="text" name="menuName" id="menuName" value="${authority.menuName}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>父级编码：</div>
					<input type="text" name="parentMenucode" id="parentMenucode" value="${authority.parentMenucode}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>排序：</div>
					<input type="text" name="sequence" id="sequence" value="${authority.sequence}">
				</li>
			</ul>
			</div>	
			<div class="modalRight">
				<a style='widht: 90px;height:32px;line-height: 32px;' href='javascript:;' onclick="submitAuthority()">保存</a>
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
function submitAuthority(){
	  $("#form").ajaxSubmit({
			url : "${ctx}/authorityManage/addAuthority",
			type : "post",
			dataType : "json",
			beforeSubmit : function(){
			},
			success : function(data){
				if(data==1){
					window.location.href="${ctx}/authorityManage/JumpAuthority/";
					$(".addAuthority").modal('hide');
				}else if(data==0){
					alert("菜单编码已存在，请重新填写");
				}
			}
		});

   }
</script>