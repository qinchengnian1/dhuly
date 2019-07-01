<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../common/tag.jsp" %>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link rel="stylesheet" type="text/css" href="${ctx }/static/css/routeTable.css"/>
</head>
<body>
<form action="${ctx }/sysUserManage/JumpRegisterUser" method="post">
    <div id='modelHtml'></div>
    <div class="nrheader">
        <a class="sx" href="javascript:;"><span></span></a>
        <div class="nrheaderSearch">
            <input type="text" name="search_telphone" placeholder="手机号" value="${fn:trim(param.search_telphone)}"/>
            <button class="btn btn-primary" type="submit">搜索</button>
            <!-- <button class="btn btn-info"  type="reset">重置</button> -->
        </div>
    </div>
    <%--<div class="operation">--%>
    <%--<shiro:hasPermission name="sysUseradd">--%>
    <%--<a href="javascript:;" onclick="addModel()"><img src="${ctx}/static/images/add.png" /><span>添加</span></a>--%>
    <%--</shiro:hasPermission>--%>
    <%--<shiro:hasPermission name="sysUserproved">--%>
    <%--<a href="javascript:;" onclick="showDialog(1)"><img src="${ctx }/static/images/piliang.png" />审核通过</a>--%>
    <%--</shiro:hasPermission>--%>
    <%--<shiro:hasPermission name="sysUserfused">--%>
    <%--<a href="javascript:;" onclick="showDialog(2)"><img src="${ctx }/static/images/piliang.png" />审核拒绝</a>--%>
    <%--</shiro:hasPermission>--%>
    <%--<shiro:hasPermission name="sysUserdelete">--%>
    <%--<a href="javascript:;" onclick="showDialog(3)"><img src="${ctx }/static/images/delete.png " />删除</a>--%>
    <%--</shiro:hasPermission>--%>
    <%--</div>--%>
    <div class="table-condensed">
        <table class="table table-responsive table-striped">
            <thead>
            <tr>
                <%--<th><input type="checkbox" name="chk"id="ckall" onclick="checkEvent('chk','ckall')" /></th>--%>
                <%--<shiro:hasPermission name="sysUserupdate">--%>
                <%--<th>操作</th>--%>
                <%--</shiro:hasPermission>--%>
                <th>ID</th>
                <th>用户名</th>
                <th>昵称</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>身份证</th>
                <th>地址</th>
                <th>性别</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty pageList}">
                <c:forEach items="${pageList}" var="vo" varStatus="status">
                    <tr>
                        <td>${vo.userId == null ? "" : vo.userId}</td>
                        <td>${vo.userName == null ? "" : vo.userName}</td>
                        <td>${vo.nickName == null ? "" : vo.nickName}</td>
                        <td>${vo.telphone == null ? "" : vo.telphone}</td>
                        <td>${vo.email == null ? "" : vo.email}</td>
                        <td>${vo.idcard}</td>
                        <td>${vo.address}</td>
                        <td>
                            <c:if test="${vo.sex=='0'}">男</c:if>
                            <c:if test="${vo.sex=='1'}">女</c:if>
                        </td>
                        <td><fmt:formatDate value="${vo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <!-- Start 分页-->
        <tags:pagination page="${pageList}" paginationSize="5"/>
    </div>
</form>
</body>
<%--<script type="text/javascript">--%>
<%--function addModel(){--%>
<%--$.post("${ctx}/sysUserManage/querySysUser/",{},function(data){--%>
<%--$("#modelHtml").html(data);--%>
<%--$(".addSysUser").modal('show');--%>
<%--}); --%>
<%--}--%>
<%--function updateSysUser(num){--%>
<%--var id=num;--%>
<%--$.post("${ctx}/sysUserManage/updateSysUser",{--%>
<%--id:id--%>
<%--},function(data){--%>
<%--$("#modelHtml").html(data);--%>
<%--$(".addSysUser").modal('show');--%>
<%--//获得所要回显的值，此处为：100,1001,200,1400--%>
<%--var checkeds = $("#sysUserCitysid").val();--%>
<%--//拆分为字符串数组--%>
<%--var checkArray =checkeds.split(",");--%>
<%--//获得所有的复选框对象--%>
<%--var checkBoxAll = $("input[name='cityId']"); --%>
<%--//获得所有复选框（新闻,微信,论坛，问答，博客，平媒）的value值，然后，用checkArray中的值和他们比较，如果有，则说明该复选框被选中--%>
<%--for(var i=0;i<checkArray.length;i++){--%>
<%--//获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中--%>
<%--$.each(checkBoxAll,function(j,checkbox){--%>
<%--//获取复选框的value属性--%>
<%--var checkValue=$(checkbox).val();--%>
<%--if(checkArray[i]==checkValue){--%>
<%--$(checkbox).attr("checked",true);--%>
<%--}--%>
<%--})--%>
<%--} --%>
<%--});--%>
<%--}--%>
<%--function checkEvent(name, allCheckId) { --%>
<%--var allCk = document.getElementById(allCheckId); --%>
<%--if (allCk.checked == true) checkAll(name); --%>
<%--else checkAllNo(name); --%>
<%--} --%>
<%--//全选 --%>
<%--function checkAll(name) { --%>
<%--var names = document.getElementsByName(name); --%>
<%--var len = names.length; --%>
<%--if (len > 0) { --%>
<%--var i = 0; --%>
<%--for (i = 0; i < len; i++) --%>
<%--names[i].checked = true; --%>
<%--} --%>
<%--} --%>
<%--//全不选 --%>
<%--function checkAllNo(name) {--%>
<%--var names = document.getElementsByName(name); --%>
<%--var len = names.length; --%>
<%--if (len > 0) { --%>
<%--var i = 0; --%>
<%--for (i = 0; i < len; i++) --%>
<%--names[i].checked = false; --%>
<%--} --%>
<%--} --%>
<%--function showDialog(nums){--%>
<%--var status=nums;--%>
<%--var chkArray = document.getElementsByName("chk");--%>
<%--ids = "";--%>
<%--for(var i = 0 ; i < chkArray.length ; i ++ )  {--%>
<%--if ( chkArray[i].checked ) {--%>
<%--ids += chkArray[i].value+",";--%>
<%--}--%>
<%--}--%>
<%--if(ids.length > 0 ){--%>
<%--if(confirm("确定要操作吗？")){--%>
<%--$.post("${ctx}/sysUserManage/toExamine",{--%>
<%--ids:ids,--%>
<%--nums:nums--%>
<%--},function(data){--%>
<%--window.location.href="${ctx}/sysUserManage/JumpSysUser/";--%>
<%--});--%>
<%--}--%>
<%--}else{--%>
<%--alert("请至少选中一个！！");--%>
<%--}--%>
<%--}--%>

<%--</script>--%>
</html>
