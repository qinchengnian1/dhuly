<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/tag.jsp"%>
<link rel="stylesheet" href="${ctx }/static/jiagerili/css/jiagerili.css">
<script src="${ctx }/static/jiagerili/js/jiagerili.js"></script>
<html lang="zh">
<body>
	<div class="modal fade addedFour" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" style='margin-bottom: 50px;'>
		<div class="modal-dialog modal-lg motaiPosition" role="document"
			style="margin-top: 0;">
			<div class="modal-content">
			<!-- ================================================================== -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h6 class="modal-title">查看详情</h6>
				</div>
				
				<!-- ================================================================== -->
				<div class="modal-body" style="padding: 0;">
					<div class="modalheader">
						<div class="modalLeft">
							<dl class="actives">
								<dt>线路管理</dt>
							</dl>
						</div>
					</div>
					<div id='modelHtmlTwo'></div>
					<div class="modalcontent">
						<ul>
							<li>
								<div class="mdContentLeft">线路类别:</div>
								<div class="mdContentRight" style="background: #778899">
									<c:forEach var="item" items="${travelTypelist}">
										<c:if test="${item.tId eq product.tId}">${item.typeName}</c:if>
									</c:forEach>
								</div>
								<div class="mdContentLeft">产品类别：</div>
								<div class="mdContentRight" style="background: #778899">
									<c:if test="${product.systemFlag eq '1'}">国内跟团</c:if>
									<c:if test="${product.systemFlag eq '2'}">处境跟团</c:if>
									<c:if test="${product.systemFlag eq '3'}">周边游</c:if>
									<c:if test="${product.systemFlag eq '4'}">游轮</c:if>
									<c:if test="${product.systemFlag eq '5'}">门票</c:if>
									<c:if test="${product.systemFlag eq '6'}">签证</c:if>
									<c:if test="${product.systemFlag eq '7'}">国内自由</c:if>
									<c:if test="${product.systemFlag eq '8'}">出境自由</c:if>
								</div>
							</li>
							<li>
								<div class="mdContentLeft">线路主标题：</div>
								<div class="mdContentRight">${product.routeMain}</div>
							</li>
							<li>
								<div class="mdContentLeft">线路副标题：</div>
								<div class="mdContentRight">${product.routeSub}</div>
							</li>
							<li>
								<div class="mdContentLeft">线路信息：</div>
								<div class="mdContentRight">
									<div class="jy">
										<span><font color="red">*</font>平台编码</span> ${product.ptNo}
									</div>
									<div class="jy mleft">
										<span><font color="red">*</font>出发地</span>
										${product.startPlaceId}
									</div>
									<div class="jy">
										<span><font color="red">*</font>目的地</span>
										<c:forEach var="item" items="${productDestList}">
											<c:if test="${item.destId eq product.destPlaceId}">${item.destName}</c:if>
										</c:forEach>
									</div>
									<div class="jy mleft">
										<span>多少元起</span> ${product.price}
									</div>
								</div>
							</li>
							<li>
								<div>首页展示：</div>
								<div>
									<div>
										<c:if test="${product.agentType eq '1'}">自销</c:if>
										<c:if test="${product.agentType eq '2'}">推荐</c:if>
										<c:if test="${product.agentType eq '3'}">精品</c:if>
										<c:if test="${product.agentType eq '4'}">人气</c:if>
									</div>
								</div>
							</li>
							<li>
								<div>首页主图:</div>
								<div>
									<div id="localImag">${product.picPath}</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<!-- ================================================================== -->
				<div class="modal-body" style="padding: 0;">
					<div class="modalheader">
						<div class="modalLeft">
							<dl class="actives">
								<dt>行程管理</dt>
							</dl>
						</div>
					</div>
					<div id='modelHtmlTwo'></div>
					<div class="modalcontent">
						<ul>
							<li>
								<div class="mdContentLeft">行程天数:</div>
								<div class="mdContentRight" style="background: #778899">
									${productInfoList.jnyDays}
								</div>
								<div class="mdContentLeft">线路特色：</div>
								<div class="mdContentRight" style="background: #778899">
									${productInfoList.featuresDescription}
								</div>
							</li>
							<li>
								<div class="mdContentLeft">报价包含：</div>
								<div class="mdContentRight">${productInfoList.quoteContent}</div>
							</li>
							<li>
								<div class="mdContentLeft">报价不包含：</div>
								<div class="mdContentRight">${productInfoList.quoteNoContent}</div>
							</li>
							<li>
								<div class="mdContentLeft">温馨提示：</div>
								<div class="mdContentRight">${productInfoList.memo}</div>
							</li>
							<li>
								<div class="mdContentLeft">行程详情：</div>
								<div class="mdContentRight">${productInfoList.trvaelEdute}</div>
							</li>
							<li>
								<div class="mdContentLeft">签证材料信息：</div>
								<div class="mdContentRight">${productInfoList.visaReq}</div>
							</li>
						</ul>
					</div>
				</div>
			<!-- ==================================================================-->
					<div class="modal-body" style="padding: 0;">
					<div class="modalheader">
						<div class="modalLeft">
							<dl class="actives">
								<dt>价格日历</dt>
							</dl>
						</div>
					</div>
					<div id='modelHtmlTwo'></div>
					<div class="modalcontent">
						<div id="date" class="select-date">
						</div>
					</div>
				</div>
						<!-- ==================================================================-->
			
			
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
	
	
	
	</script>
	
	
</html>