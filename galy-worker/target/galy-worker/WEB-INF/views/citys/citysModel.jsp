<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<script src="${ctx }/static/js/jquery.form.min.js"></script>
<html lang="zh">
<body>
<form id="form" method="post"  enctype="multipart/form-data">
<div class="modal fade addCitys" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"  style='margin-bottom:50px;'>
	<div class="modal-dialog modal-lg motaiPosition" role="document" style="margin-top:5 ;">
		<div class="modal-content" style='width:35%;margin-top: 100px;'>  
			<div class="modal-header" style='padding: 10px;'>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
				<h6 class="modal-title" >城市管理</h6>
			</div>
		<div class="modal-body" style="padding: 0;">
			<div class="modalcontent">
			<ul style='padding: 10px 10px 0px 0px;'>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>城市编码：</div>
					<input type="text" name="remark" id="remark" value="${cityComp.remark}">
				</li>
				<li style='padding: 15px 15px;'>
					<input type="hidden" id="cityId" name="cityId" value="${cityComp.cityId}">
					<div class="mdContentLeft" style='margin-right: 40px;'>城市名称：</div>
					<input type="text" name="cityName" id="cityName" value="${cityComp.cityName}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>状态：</div>
					<input type="radio" name="status" value="1" checked="checked"  ${cityComp.status == '1' ? "checked":"" }>打开&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="status" value="0"  ${cityComp.status == '0' ? "checked":"" }>关闭
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
			url : "${ctx}/citysManage/addCitys",
			type : "post",
			dataType : "json",
			beforeSubmit : function(){
				 var remark = $("#remark").val();
				  var cityName= $("#cityName").val();
					if (remark == "" && remark=="") {
						alert("请输入城市编码");
						return false;
					}
					if(cityName=="" && cityName==""){
						alert("请输入城市名称");
						return false;
					}
					return true;
			},
			success : function(data){
				if(data==1){
					window.location.href="${ctx}/citysManage/JumpCitys/";
					$(".addCitys").modal('hide');
				}else if(data==0){
					alert("城市编码已存在，请重新填写");
				}
			}
		});

   }
</script>