<%@	tag pageEncoding="UTF-8"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="name" type="java.lang.String" required="false"%>
<%@ attribute name="seletedIndex" type="java.lang.String" required="false"%>
<%@ attribute name="onchange" type="java.lang.String" required="false"%>
<%@ attribute name="dictCode" type="java.lang.String" required="false"%>
<%@ attribute name="dictValue" type="java.lang.String" required="false"%>
<%@ attribute name="pleaseSelect" type="java.lang.String" required="false"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>


<select id="${id}" size="1" name="${name}" onchange="${onchange}" class="combox">
	<c:if test="${pleaseSelect=='yes'}">
		<option value="">????</option>
	</c:if>
</select>

<script type="text/javascript">
	var dictCode=<%=dictCode%>
	var dictValue=<%=dictValue%>
	var id = "${id}";
	var v="";
	$.ajax({
		async:false,
		cache:false,
		type: 'POST',
		dataType: "json",
		url:"${ctx}"+"/dict/ajax/querydict/"+dictCode+"/"+dictValue,	
		success:function (data) {
			for(var i in data){
				v=data[i].dictValue;
				$("<option id="+dictCode+id+v+" value="+v+">"+data[i].dictName+"</option>").appendTo("#${id}");
			}
			try{
				document.getElementById("${seletedIndex}").selected=true;
			}catch (e) {
				// TODO: handle exception
			}
			
	     },
	    error: function (msg) {
	    	alert('???????????????????????????????????????????');
	     }
	});
</script>
