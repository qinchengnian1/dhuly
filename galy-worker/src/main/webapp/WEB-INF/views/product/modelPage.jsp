<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp" %>
<html lang="zh">
<!-- 下拉列表框 -->
<link rel="stylesheet" href="${ctx }/static/xialaliebiao/styles/chosen.css">
<script src="${ctx }/static/xialaliebiao/js/chosen.jquery.js"></script>
<!-- 图片回显 -->
<script src="${ctx}/static/shangchuang/FileUpload.js"></script>
<!-- 价格日历 -->
<link rel="stylesheet" href="${ctx}/static/calendar-price/dist/css/calendar-price-jquery.min.css">
<!--  富文本编辑器-->
<link rel="stylesheet" href="${ctx }/static/assets/css/font-awesome.css" />
<link rel="stylesheet" href="${ctx }/static/assets/css/ace-fonts.css" />
<link rel="stylesheet" href="${ctx }/static/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
<script src="${ctx }/static/js/jquery.form.min.js"></script>
<script src="${ctx }/static/assets/js/jquery.hotkeys.js"></script>
<script src="${ctx }/static/assets/js/bootstrap-wysiwyg.js"></script>
<!-- ace scripts -->
<script src="${ctx }/static/assets/js/ace/elements.scroller.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.colorpicker.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.fileinput.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.typeahead.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.wysiwyg.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.spinner.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.treeview.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.wizard.js"></script>
<script src="${ctx }/static/assets/js/ace/elements.aside.js"></script>
<script src="${ctx }/static/assets/js/ace/ace.js"></script>

<script type="text/javascript">
var treamList=[];
</script>
<script src="${ctx }/static/calendar-price/src/js/calendar-price-jquery.js"></script>
<script >
var baseUrl = "${ctx }";
</script>
 <body>
<!-- =============================线路管理============================ -->
<form id="form1" method="post"  enctype="multipart/form-data">
<div class="modal fade added" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"  style='margin-bottom:50px;'>
	<div class="modal-dialog modal-lg motaiPosition" role="document" style="margin-top:0 ;">
		<div class="modal-content">  
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
				<h6 class="modal-title">线路管理</h6>
			</div>
		<div class="modal-body" style="padding: 0;">
			<div class="modalheader">
				<div class="modalLeft">
					<dl class="actives"><dt>线路信息</dt>
					</dl>
					<dl><dt>行程信息</dt>
					</dl>
					<dl><dt>其他信息</dt>
					</dl>
				</div>
						
			</div>
			<div id='modelHtmlTwo'></div>
			<div class="modalcontent">
			<ul>
				<li>
					<input type="hidden" value="${product.compId}" name="compId">
					<input type="hidden" value="${product.pId}" name="pId" id="pId">
					<input type="hidden" value="${eId}" name="eId" id="eId">
					<input type="hidden" value="${status}" name="status" id="status">
					<div class="mdContentLeft">线路类别:</div>
					<c:choose>
						<c:when test="${product.pId == '' }">
							<div class="mdContentRight">
								<select name="tId" id="tId" style='width:25%;'>
								<c:forEach var="item" items="${travelTypelist}">
								<option value="${item.tId}"${tId == item.tId ? "selected" : ""}>${item.typeName}</option>
								</c:forEach>
								</select>
							</div>
						</c:when>
						<c:otherwise>
							<div class="mdContentRight">
								<select name="tId" id="tId" style='width:25%;'>
								<c:forEach var="item" items="${travelTypelist}">
								<option value="${item.tId}"${product.tId == item.tId ? "selected" : ""}>${item.typeName}</option>
								</c:forEach>
								</select>
							</div>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<div class="mdContentLeft">产品类别</div>
						<div class="mdContentRight">
						<select name="systemFlag" id="systemFlag" style='width:25%;'>
							    <option value="1" <c:if test="${'1' eq product.systemFlag}">selected</c:if> >国内跟团</option>
								<option value="2" <c:if test="${'2' eq product.systemFlag}">selected</c:if> >境外跟团</option>
								<option value="3" <c:if test="${'3' eq product.systemFlag}">selected</c:if> >周边游</option>
								<option value="4" <c:if test="${'4' eq product.systemFlag}">selected</c:if> >游轮</option>
								<option value="5" <c:if test="${'5' eq product.systemFlag}">selected</c:if> >门票</option>
								<option value="6" <c:if test="${'6' eq product.systemFlag}">selected</c:if> >签证</option>
								<option value="7" <c:if test="${'7' eq product.systemFlag}">selected</c:if> >国内自由</option>
								<option value="8" <c:if test="${'8' eq product.systemFlag}">selected</c:if> >出境自由</option> 
						</select>
					</div>		
				</li>
				<li>
					<div class="mdContentLeft"><font color="red">*</font>线路主标题：</div>
					<div class="mdContentRight"><input type="text" name="routeMain" id="routeMain" value="${product.routeMain}" placeholder="请输入线路名称" style="width: 100%;" /></div>
				</li>
					<li>
					<div class="mdContentLeft">线路副标题：</div>
					<div class="mdContentRight"><input type="text" name="routeSub" id="routeSub" value="${product.routeSub}" placeholder="请输入线路名称" style="width: 100%;" /></div>
				</li>
				<li>
					<div class="mdContentLeft">线路信息：</div>
					<div class="mdContentRight">
						<div class="jy">
							<span><font color="red">*</font>平台编码</span><input type="text" id="ptNo" value="${product.ptNo}" name="ptNo" placeholder="请输入平台编码"/>
						</div>
						<div class="jy mleft">
							<span><font color="red">*</font>出发地</span><input type="text" id="startPlaceId" value="${product.startPlaceId}" name="startPlaceId" value="" placeholder="" />
						</div>
						<div class="jy" >
					<c:choose>
						<c:when test="${product.pId == '' }">
							<span><font color="red">*</font>目的地</span>				
							<select name="destPlaceId" id="destPlaceId"  class="dept_select" style='height: 30px;border: 0;' >
							<c:forEach var="item" items="${productDestList}">
									<option value="${item.destId}"${destPlaceId == item.destId ? "selected" : ""}>${item.destName}</option>
							</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
							<span><font color="red">*</font>目的地</span>				
							<select name="destPlaceId" id="destPlaceId"  class="dept_select" style='height: 30px;border: 0;'>
							<c:forEach var="item" items="${productDestList}">
									<option value="${item.destId}"${product.destPlaceId == item.destId ? "selected" : ""}>${item.destName}</option>
							</c:forEach>
							</select>
						</c:otherwise>
					</c:choose>	
						</div>
						<div class="jy mleft">
							<span>多少元起</span><input type="text" id="price" name="price" value="${product.price}" placeholder="请输入基础价格" />
						</div>
					</div>
				</li>
				<li>
					<div>首页展示：</div>
					<div>
						<div>
							<span>自销</span><input type="radio"  name="agentType" value="1" ${product.agentType == '1' || product.agentType == null ? "checked":"" } />
							<span>推荐</span><input type="radio"  name="agentType" value="2" ${product.agentType == '2' ? "checked":"" }/>
							<span>精品</span><input type="radio"  name="agentType" value="3" ${product.agentType == '3' ? "checked":"" }/>
							<span>人气</span><input type="radio"  name="agentType" value="4" ${product.agentType == '4' ? "checked":"" }/>
						</div>
					</div>
				</li>
				<li>
					<div >首页主图:</div>
					<div >
						<div id="localImag">
						 	<input size="20" type="file" id="Image" name="file" onchange="javascript:setImagePreview();" />
							<img id="preview"  width=-1 height=-1   style="display: none; width: 250px; margin-top: 5px;" src="${imgUrl}/${product.picPath}" />
							<input type="hidden" name="picPath" value="${product.picPath}">
						</div>
					</div>
				</li>
			</ul>
			</div>	
			<div class="modalRight">
				<a href='javascript:;'onclick="submitSAndclose(2)">保存并关闭</a>
				<a href='javascript:;' onclick="submitSAndclose(1)">保存并继续</a>
				<a href='javascript:;' data-dismiss="modal" aria-label="Close">关闭</a>
			</div>	
		</div>
		</div>
	</div>
</div>
</form>
<!-- =============================行程管理============================ -->
<form id="form2" method="post"  enctype="multipart/form-data">
<div class="modal fade addedTwo" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" style='margin-bottom:50px;'>
	<div class="modal-dialog modal-lg motaiPosition"  role="document" style="margin-top:0;">
		<div class="modal-content">  
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
				<h6 class="modal-title">新增线路</h6>
			</div>
		<div class="modal-body" style="padding: 0;">
			<div class="modalheader">
				<div class="modalLeft">
					<dl ><dt>线路信息</dt>
					</dl>
					<dl class="actives"><dt>行程信息</dt>
					</dl>
					<dl><dt>其他信息</dt>
					</dl>
				</div>
						
			</div>
			<div id='modelHtmlTwo'></div>
			<div class="modalcontent">
			<input type="hidden" id="iId" name="iId" value="${bloBs.iId}">
			<input type="hidden"  name="pId" value="${bloBs.pId}">
			<ul>
				<li>
					<div class="mdContentLeft">行程天数:</div>
					<div class="mdContentRight">
						<input type="text" name="jnyDays" id="jnyDays" value="${bloBs.jnyDays}">
					</div>
				</li>
				<li>
					<div class="mdContentLeft">另付费标记:</div>
					<div class="mdContentRight">
						<span>关闭</span><input type="radio" name="ownFlg" value="0" ${bloBs.ownFlg == '0' || bloBs.ownFlg == null ? "checked":"" } />
						<span>打开</span><input type="radio" name="ownFlg" value="1" ${bloBs.ownFlg == '1' ? "checked":"" }/>
					</div>
				</li>
				<li style='display:none;' id='elsePayPrice'>
					<div class="mdContentLeft">另付费说明</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor" id="ownAddMemo">
						${bloBs.ownAddMemo}
					</div>
					</div>
				</li>
				<li>
					<div class="mdContentLeft">线路特色</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor" id="featuresDescription">
						${bloBs.featuresDescription}
					</div>
					</div>
				</li>
				<li>
					<div class="mdContentLeft">报价包含</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor" id="quoteContent">${bloBs.quoteContent}</div>
					</div>
					
				</li>
				<li>
					<div class="mdContentLeft">报价不包含</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor"  id="quoteNoContent">${bloBs.quoteNoContent}</div>
					</div>
					
				</li>
				<li>
					<div class="mdContentLeft">温馨提示</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor" id="memo">${bloBs.memo}</div>
					</div>
					
				</li>
				<li>
					<div class="mdContentLeft">预订须知</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor" id="note">${bloBs.note}</div>
					</div>
					
				</li>
				<li>
					<div class="mdContentLeft">行程信息</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor" id="trvaelEdute">${bloBs.trvaelEdute}</div>
					</div>
					
				</li>
				<li>
					<div class="mdContentLeft">签证材料信息</div>
					<div class="mdContentRight">
					<div class="wysiwyg-editor" id="visaReq">${bloBs.visaReq}</div>
					</div>
				</li>
 				<li>
					<div class="mdContentLeft">添加图片</div>
					<div class="mdContentRight">
						<div class='postImagesWrap'>
							<div >轮播图一:</div>
							<div class="postImages">
					             <span id='sp1' class="btn btn-success fileinput-button">
					                  <b style="color:white;">上传</b>
					                  <input id="Image2"  type="file"  name="fileOne" multiple="multiple" onchange="javascript:setImagePreview2();" accept="image/jpeg" style="-webkit-appearance:none;">                            
					             
					             </span>
					             <div class="uploadPictures">
					                  <img id="preview2"  style="display: none;" src="${imgUrl}/${list.get(0)}">
					                  <input type="hidden" name="picPath" value="${list.get(0)}">      
					             </div>
					         </div>
						</div>
						
						<div class='postImagesWrap'>
							<div >轮播图二:</div>
							<div class="postImages">
					             <span class="btn btn-success fileinput-button">
					                  <b style="color:white;">上传</b>
					                  <input id="Image3" type="file"  name="fileTwo" multiple="multiple" onchange="javascript:setImagePreview3();" accept="image/jpeg" style="-webkit-appearance:none;">                            
					             </span>
					             <div class="uploadPictures">
					                  <img id="preview3" style="display: none;" src="${imgUrl}/${list.get(1)}"/> 
					                   <input type="hidden" name="picPath" value="${list.get(1)}"/>                               
					             </div>
					         </div>
						</div>
						
						<div class='postImagesWrap'>
							<div >轮播图三:</div>
							<div class="postImages">
					             <span class="btn btn-success fileinput-button">
					                  <b style="color:white;">上传</b>
					                  <input id="Image4" type="file"  name="fileThree" multiple="multiple" onchange="javascript:setImagePreview4();" accept="image/jpeg" style="-webkit-appearance:none;">                            
					             </span>
					             <div class="uploadPictures">
					                  <img id="preview4"  style="display: none;" src="${imgUrl }/${list.get(2)}">  
					                   <input type="hidden" name="picPath" value="${list.get(2)}">                             
					             </div>
					         </div>
						</div>
						
						<div class='postImagesWrap'>
							<div >轮播图四:</div>
							<div class="postImages">
					             <span class="btn btn-success fileinput-button">
					                  <b style="color:white;">上传</b>
					                  <input id="Image5"  type="file"  name="fileFour" multiple="multiple" onchange="javascript:setImagePreview5();" accept="image/jpeg" style="-webkit-appearance:none;">                            
					             </span>
					             <div class="uploadPictures">
					                  <img id="preview5"  style="display: none;" src="${imgUrl}/${list.get(3)}">  
					                   <input type="hidden" name="picPath" value="${list.get(3)}">                             
					             </div>
					         </div>
						</div>
						
					</div>
				</li>
			</ul>
			</div>	
			<div class="modalRight">
				<a href='javascript:;'onclick="submitSTwo(2)">保存并关闭</a>
				<a href='javascript:;'onclick="submitSTwo(1)">保存并继续</a>
				<a href='javascript:;'onclick="returnLastStep()">返回上一步</a>
				<a href='javascript:;' data-dismiss="modal" aria-label="Close">关闭</a>
			</div>		
		</div>
		</div>
	</div>
</div>
</form>
<!-- =============================价格日历============================ -->

<form id="form3" method="post"  enctype="multipart/form-data">
<div class="modal fade addedThree" role="dialog" aria-labelledby="myLargeModalLabel" style='margin-bottom:50px;'>
	<div class="modal-dialog modal-lg motaiPosition" role="document" style="margin-top:0;">
		<div class="modal-content">  
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h6 class="modal-title">新增线路</h6>
			</div>
		<div class="modal-body" style="padding: 0;">
			<div class="modalheader">
				<div class="modalLeft">
					<dl ><dt>线路信息</dt>
					</dl>
					<dl><dt>行程信息</dt>
					</dl>
					<dl class="actives"><dt>其他信息</dt>
					</dl>
				</div>
			</div>
			<div class="container" style='width: 97%;'></div>
			<div id='modelHtmlTwo'></div>
				<div class="modalRight">
				<!-- <a href='javascript:;'onclick="returnLast()">返回上一步</a> -->
			</div>		
		</div>
		</div>
	</div>
</div>
</form>
<script type="text/javascript">
	$(function(){
		$('.dept_select').chosen();
	});
	  function submitSAndclose(num){
		  $("#form1").ajaxSubmit({
				url : "${ctx}/productManage/addProduct",
				type : "post",
				dataType : "json",
				data:{
					'num':num,
				},
				beforeSubmit : function() {
				  var importfile = $("#Image").val();
				  var routeMain= $("#routeMain").val();
				  var ptNo=$("#ptNo").val();
				  var startPlaceId=$("#startPlaceId").val();
				  var price=$("#price").val();
				  var pId=$("#pId").val();
					if (importfile == "" && pId=="" ) {
						alert("请插入一张图片");
						return false;
					}
					if(routeMain==""){
						alert("请输入线路主标题");
						return false;
					}
					if(ptNo==""){
						alert("请输入平台编码");
						return false;
					}
					if(startPlaceId==""){
						alert("请输入出发地");
						return false;
					}
					if(price==""){
						alert("请输入价格");
						return false;
					}
					return true;
				},
				success : function(productList){
					if(num==1){
						var eId=productList.body.eId
							$.post("${ctx}/productManage/updataProducInfo",{
								'status':$("#status").val(),
								'eId':eId
							},function(data){
								if($("#status").val()=="opt"){
								$("#modelHtml").html(data);
								$(".addedThree").modal('hide');
								$(".addedTwo").modal('show');
								$("#preview2").show();
								$("#preview3").show();
								$("#preview4").show();
								$("#preview5").show();
								$("input[name='ownFlg']:checked").val() == '1' ? $('#elsePayPrice').show() : $('#elsePayPrice').hide();
							}else{
								$("#modelHtml").html(data);
								$(".addedThree").modal('hide');
								$(".addedTwo").modal('show');
							}
							});
					}else{
						var eId=productList.body.eId
						window.location.href="${ctx}/productManage/productList/"+eId;
						$(".modal-backdrop").remove();
						$('.added').modal('hide');
						$('.addedTwo').modal('hide');
					}
				}
			});
	     }
	  function submitSTwo(numTwo){
		  var numTwo;
		  $("#form2").ajaxSubmit({
				url : "${ctx}/productManage/addProductInfo",
				type : "post",
				dataType : "json",
				data: {
					'ownAddMemo':$("#ownAddMemo").html(),
	                'featuresDescription':$("#featuresDescription").html(),
	                'quoteContent':$("#quoteContent").html(),
	                'quoteNoContent':$("#quoteNoContent").html(),
	                'memo':$("#memo").html(),
	                'note':$("#note").html(),
	                'trvaelEdute':$("#trvaelEdute").html(),
	                'visaReq':$("#visaReq").html(),
	                'numTwo':numTwo,
	                'eId':$("#eId").val()
	            },
				beforeSubmit : function() {
				  var importfile = $("#Image2").val();
				  var importfile2 = $("#Image3").val();
				  var importfile3= $("#Image4").val();
				  var importfile4 = $("#Image5").val();
				  var jnyDays= $("#jnyDays").val();
				  var iId=$("#iId").val();
				  if(iId==""){
					if (importfile == "" || importfile2=="" || importfile3=="" || importfile4=="" ) {
						alert("请插入一张图片");
						return false;
					}
				  }
				  if(jnyDays==""){
					  alert("请添加行程天数");
					  return false;
				  }
				  return true;
				},
				success : function(productInfoList) {
					if(numTwo=="1"){
							$('.addedTwo').modal('hide');
							$('.addedThree').css('overflow-y','auto');
							$('.addedThree').modal('show');
				           	 $.ajax({
						        url: baseUrl+"/productManage/updataTreamDetail",
						        type: 'POST',
						        success: function(data){
						        	treamList=JSON.parse(data).body.treamDetail;
						        	 var script = document.createElement("script"); 
									 script.src = "${ctx}/static/calendar-price/calendar-price.js";
						             document.body.appendChild(script);
						         	//return list;
						        }
						    });
					}else{
						var eId=productInfoList.body.eId
						window.location.href="${ctx}/productManage/productList/"+eId;
						$(".modal-backdrop").remove();
						$('.added').modal('hide');
						$('.addedTwo').modal('hide');
						$('.addedTwo').modal('hide');
					}
					
				}
			});
	     }
	  
	  function deletePrice(obj){
		  event.preventDefault();
		  event.stopPropagation();
		  var tid=$(obj).parent("p").html().replace('<span onclick="deletePrice(this)">删除</span>','');
		  if(confirm("确认删除吗")){
			  $.ajax({
			        url: baseUrl+"/productManage/deleteTreamDetail?tid="+tid,
			        type: 'POST',
			        success: function(data){
			        	$.ajax({
					        url: baseUrl+"/productManage/updataTreamDetail",
					        type: 'POST',
					        success: function(data){
					        	$('.capricorncd-date-detailed-settings').remove();
					        	treamList=JSON.parse(data).body.treamDetail;
					        	 var script = document.createElement("script"); 
								 script.src = "${ctx}/static/calendar-price/calendar-price.js";
					             document.body.appendChild(script);
					             
					        }
					    });
			        }
			    });
			  }
			  else{
			   return;
			  }

		} 
	  function   deletePriceAll(obj){
		 	event.preventDefault();
		  	var delstartDay =  document.getElementsByName("delstartDay")[0].value;
	    	var delendDay = document.getElementsByName("delendDay")[0].value;
	    	if(delstartDay!="" || delendDay!=""){
			  	if(confirm("确认删除吗")){
					$.ajax({
					    url: baseUrl+"/productManage/deleteTreamDetailAll?delstartDay="+delstartDay+"&delendDay="+delendDay,
					    type: 'POST',
					    success: function(data){
			        	$.ajax({
					        url: baseUrl+"/productManage/updataTreamDetail",
					        type: 'POST',
					        success: function(data){
					        	$('.capricorncd-date-detailed-settings').remove();
					        	treamList=JSON.parse(data).body.treamDetail;
					        	 var script = document.createElement("script"); 
								 script.src = "${ctx}/static/calendar-price/calendar-price.js";
					             document.body.appendChild(script);
					    }
					   });
					 }
						});
					 }else{
					return ;
					} 
	    	}else{
	    		alert("请输入时间");
	    		return ;
	    	}
		} 	
    </script>
    <script type="text/javascript">
    
    //$(".wysiwyg-editor").html("");	
	$(".wysiwyg-editor").ace_wysiwyg({
		toolbar:
		[
			"font",
			null,
			"fontSize",
			null,
			{name:"bold", className:"btn-info"},
			{name:"italic", className:"btn-info"},
			{name:"strikethrough", className:"btn-info"},
			{name:"underline", className:"btn-info"},
			null,
			{name:"insertunorderedlist", className:"btn-success"},
			{name:"insertorderedlist", className:"btn-success"},
			{name:"outdent", className:"btn-purple"},
			{name:"indent", className:"btn-purple"},
			null,
			{name:"justifyleft", className:"btn-primary"},
			{name:"justifycenter", className:"btn-primary"},
			{name:"justifyright", className:"btn-primary"},
			{name:"justifyfull", className:"btn-inverse"},
			null,
			{name:"createLink", className:"btn-pink"},
			{name:"unlink", className:"btn-pink"},
			null,
			{name:"insertImage", className:"btn-success"},
			null,
			"foreColor",
			null,
			{name:"undo", className:"btn-grey"},
			{name:"redo", className:"btn-grey"}
		],
		"wysiwyg": {
			fileUploadError: showErrorAlert
		}
	}).prev().addClass("wysiwyg-style3");
	
	function showErrorAlert(reason, detail) {
		var msg = "";
		if (reason === "unsupported-file-type") {
			msg = "Unsupported format " + detail;
		} else {
		}
		$("<div class='alert'> <button type='button' class='close' data-dismiss='alert'>&times;</button>" + "<strong>File upload error</strong> " + msg + " </div>").prependTo("#alerts");
	}

	function returnLastStep(){
		var status="opt";
		var eId=$("#eId").val();
		$.post("${ctx}/productManage/returnProduc?status="+status+"&eId="+eId,{
		},function(data){
			$("#modelHtml").html(data);
			$(".addedTwo").modal('hide');
			$(".added").modal('show');
			$("#preview").show();
		});
	}
/* 	function returnLast(){
		$.post("${ctx}/productManage/updataProducInfo",{
			'status':$("#status").val(),
			'eId':$("#eId").val()
		},function(data){
			if($("#status").val()=="opt"){
				$("#modelHtml").html(data);
				$(".addedThree").modal('hide');
				$(".addedTwo").modal('show');
				$("#preview2").show();
				$("#preview3").show();
				$("#preview4").show();
				$("#preview5").show();
				$("input[name='ownFlg']:checked").val() == '1' ? $('#elsePayPrice').show() : $('#elsePayPrice').hide();
			}else{
				$("#modelHtml").html(data);
				$(".addedThree").modal('hide');
				$(".addedTwo").modal('show');
			}
		});
	} */
	$("#ptNo").blur(function() {
		var ptNo = $("#ptNo").val();
		if (ptNo != "") {
			$.post("${ctx}/productManage/findProducByPtNo?ptNo="+ptNo, {}, function(data) {
			data = eval('(' + data + ')');
			if (data == 1) {
				alert("平台编号重复，请重新填写");
				$("#ptNo").val("");
				return false;
			}
		})
		}

	});
	$('.close').on('click',function(){
		$(".modal-backdrop").remove();
	})
	$('input:radio[name="ownFlg"]').change(function(){
        if($(this).val() == '1') 
             $('#elsePayPrice').show();
        else  
        	$('#elsePayPrice').hide();
     }); 
</script>
</body>
 </html>