<%@	tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="id" type="java.lang.String" required="false"%>
<%@ attribute name="dictCode" type="java.lang.String" required="false"%>
<%@ attribute name="dictValue" type="java.lang.String" required="false"%>
<%@ attribute name="list" type="java.util.List" required="false"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setAttribute("dictValue", dictValue);
    request.setAttribute("list", list);
%>
	<c:forEach items="${list}" var="dic">
		<c:if test="${dictValue eq dic.dictValue}">
				${dic.dictName}
		</c:if>
	</c:forEach>
