<%@	tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="com.github.miemiedev.mybatis.paginator.domain.PageList" required="true"%>
<%@ attribute name="paginationSize" type="java.lang.Integer" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
int current =  page.getPaginator().getPage();
int begin = Math.max(1, current - paginationSize/2);
int end = Math.min(begin + (paginationSize - 1), page.getPaginator().getTotalPages());

request.setAttribute("current", current);
request.setAttribute("begin", begin);
request.setAttribute("end", end);
request.setAttribute("totalPages", page.getPaginator().getTotalPages());
request.setAttribute("totalCount", page.getPaginator().getTotalCount());
%>
<input type="hidden" name="page" id="pageNO_Epage" value="${pageNo}"/>
<div id="page">
		<% if (page.getPaginator().isHasPrePage()){%>
               	<div class="first" onclick="goPage(1)">首页</div>
                <div class="prv" onclick="goPage(${current-1})">«</div>
         <%}else{%>
                <div class="first">首页</div>
				<div class="prv">«</div>
         <%} %>
		<ul class="pagingUl">
			<c:forEach var="i" begin="${begin}" end="${end}">
	            <c:choose>
	                <c:when test="${i == current}">
	                    <li><a href="javascript:" class="activP">${i}</a></li>
	                </c:when>
	                <c:otherwise>
	                    <li ><a href="javascript:" onclick="goPage(${i})">${i}</a></li>
	                </c:otherwise>
	            </c:choose>
	        </c:forEach>
		</ul>
	<% if (page.getPaginator().isHasNextPage()){%>
           <div class="next" onclick="goPage(${current+1})">»</div>
           <div class="last" onclick="goPage(${totalPages})">尾页</div>
    <%}else{%>
           <div class="next">»</div>
           <div class="last">尾页</div>
    <%} %>
		 <div class="zong">共${totalPages}页/共${totalCount}条</div>
</div>
<script>
function goPage(i){
	document.getElementById("pageNO_Epage").value=i;
	if($("#pageNO_Epage").parents("form")[0]){
		$("#pageNO_Epage").parents("form").submit();
	}else{
		document.forms[0].submit();
	}
}
</script>