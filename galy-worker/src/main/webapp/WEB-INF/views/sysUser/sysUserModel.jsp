<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<script src="${ctx }/static/js/jquery.form.min.js"></script>
<html lang="zh">
<body>
<form id="form" method="post"  enctype="multipart/form-data">
<div class="modal fade addSysUser" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"  style='margin-bottom:50px;'>
	<div class="modal-dialog modal-lg motaiPosition" role="document" style="margin-top:5 ;">
		<div class="modal-content" style='width:35%;margin-top: 100px;'>  
			<div class="modal-header" style='padding: 10px;'>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
				<h6 class="modal-title" >后台用户管理</h6>
			</div>
		<div class="modal-body" style="padding: 0;">
			<div class="modalcontent">
			<ul style='padding: 10px 10px 0px 0px;'>
				<li style='padding: 15px 15px;'>
					<input type="hidden" id="id" name="id" value="${sysUser.id}">
					<div class="mdContentLeft" style='margin-right: 40px;'>账号：</div>
					<input type="text" name="userCode" id="userCode" value="${sysUser.userCode}">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>密码：</div>
					<input type="password" name="password" id="password" value="">
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>性别：</div>
					<input type="radio" name="sex" value="0" checked="checked"  ${sysUser.sex == '0' ? "checked":"" }>男&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="1"  ${sysUser.sex == '1' ? "checked":"" }>女
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>所属部门：</div>
					<select name="idCard"  id="idCard" style='width: 170px;outline: none;padding: 3px 0px;'>
							 <option value='请选择'>请选择</option>
							 <c:forEach var="item" items="${departmentlist}">
								<option value="${item.id}" ${sysUser.idCard == item.id ? "selected" : ""}>
									${item.departmentValue}</option>
							</c:forEach>
					</select>
				</li>
				<li style='padding: 15px 15px;'>
					<div class="mdContentLeft" style='margin-right: 40px;'>角色：</div>
					<select name="cardNo"  id="cardNo" style='width: 170px;outline: none;padding: 3px 0px;'>
							 <option value='请选择'>请选择</option>
							 <c:forEach var="item" items="${rolelist}">
								<option value="${item.id}" ${sysUser.cardNo == item.id ? "selected" : ""}>
									${item.roleValue}</option>
							</c:forEach>
					</select>
				</li>
				
				<li style='padding: 15px 15px;'>
					<input type="hidden" name="sysUserCitysid" id="sysUserCitysid" value="${sysUser.cityId}">
					<div class="mdContentLeft" style='margin-right: 40px;'>城市：</div>
					<div>
						<c:forEach var="item" items="${citylist}">
							<input type="checkbox" name="cityId" value="${item.cityId}" />
							${item.cityName}		
						</c:forEach>
					</div>
				</li>
				
			</ul>
			</div>	
			<div class="modalRight">
				<a style='widht: 90px;height:32px;line-height: 32px;' href='javascript:;' onclick="submitSysUser()">保存</a>
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
function submitSysUser(){
	  $("#form").ajaxSubmit({
			url : "${ctx}/sysUserManage/addSysUser",
			type : "post",
			dataType : "json",
			beforeSubmit : function(){
				  var userCode = $("#userCode").val();
				  var password= $("#password").val();
				  var id=$("#id").val();
				  var idCard= $('#idCard option:selected').val();
				  var cardNo= $('#cardNo option:selected').val();
				  var chkArray = document.getElementsByName("cityId");
				  ids = "";
				  for(var i = 0 ; i < chkArray.length ; i ++ )  {
					if ( chkArray[i].checked ) {
						ids += chkArray[i].value+",";
					}
				   }
				   	if(ids==""){
				    	 alert("请至少选中一个城市！！");
				    	 return false;
					}
					if (userCode == "" && userCode=="") {
						alert("请输入账号");
						return false;
					}
					if(password=="" && id==""){
						alert("请输入密码");
						return false;
					}
					if(idCard=="请选择"){
						alert("请选择所属部门");
						return false;
					}
					if(cardNo=="请选择"){
						alert("请选择角色");
						return false;
					}
					return true;
			},
			success : function(data){
				if(data==1){
					window.location.href="${ctx}/sysUserManage/JumpSysUser/";
					$(".addSysUser").modal('hide');
				}else if(data==0){
					alert("用户已存在，请重新填写");
				}
			}
		});

   }
</script>