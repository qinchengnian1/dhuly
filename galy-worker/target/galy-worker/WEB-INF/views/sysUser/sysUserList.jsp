<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../common/tag.jsp" %>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link rel="stylesheet" type="text/css" href="${ctx }/static/css/routeTable.css"/>
</head>
<body onload="checkedCitysid()">
<form action="${ctx }/sysUserManage/JumpSysUser" method="post">
    <div id='modelHtml'></div>
    <div class="nrheader">
        <a class="sx" href="javascript:;"><span></span></a>
        <div class="nrheaderSearch">
            <input type="text" name="search_userCode" placeholder="账号" value="${fn:trim(param.search_userCode)}"/>
            <button class="btn btn-primary" type="submit">搜索</button>
            <!-- <button class="btn btn-info"  type="reset">重置</button> -->
        </div>
    </div>
    <div class="operation">
        <shiro:hasPermission name="sysUseradd">
            <a href="javascript:;" onclick="addModel()"><img src="${ctx}/static/images/add.png"/><span>添加</span></a>
        </shiro:hasPermission>
        <shiro:hasPermission name="sysUserproved">
            <a href="javascript:;" onclick="showDialog(1)"><img src="${ctx }/static/images/piliang.png"/>审核通过</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="sysUserfused">
            <a href="javascript:;" onclick="showDialog(2)"><img src="${ctx }/static/images/piliang.png"/>审核拒绝</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="sysUserdelete">
            <a href="javascript:;" onclick="showDialog(3)"><img src="${ctx }/static/images/delete.png "/>删除</a>
        </shiro:hasPermission>
    </div>
    <div class="table-condensed">
        <table class="table table-responsive table-striped">
            <thead>
            <tr>
                <th><input type="checkbox" name="chk" id="ckall" onclick="checkEvent('chk','ckall')"/></th>
                <shiro:hasPermission name="sysUserupdate">
                    <th>操作</th>
                </shiro:hasPermission>
                <th>ID</th>
                <th>账号</th>
                <th>性别</th>
                <th>创建时间</th>
                <th>状态</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageList}" var="vo" varStatus="status">
                <tr>
                    <td>
                        <input type="checkbox" name="chk" value="${vo.id}"/>
                        <shiro:hasPermission name="sysUserupdate">
                    <td>
                        <span style="cursor:hand" onclick="updateSysUser(${vo.id})">编辑</span>
                    </td>
                    </shiro:hasPermission>
                    <td>${vo.id}</td>
                    <td>${vo.userCode}</td>
                    <td>
                        <c:if test="${vo.sex=='0'}">男</c:if>
                        <c:if test="${vo.sex=='1'}">女</c:if>
                    </td>
                    <td><fmt:formatDate value="${vo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <c:if test="${vo.status=='0'}"><span style="color:red">关闭</span></c:if>
                        <c:if test="${vo.status=='1'}">打开</c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!-- Start 分页-->
        <tags:pagination page="${pageList}" paginationSize="5"/>
    </div>
</form>
</body>
<script type="text/javascript">
    function addModel() {
        $.post("${ctx}/sysUserManage/querySysUser/", {}, function (data) {
            $("#modelHtml").html(data);
            $(".addSysUser").modal('show');
        });
    }

    function updateSysUser(num) {
        var id = num;
        $.post("${ctx}/sysUserManage/updateSysUser", {
            id: id
        }, function (data) {
            $("#modelHtml").html(data);
            $(".addSysUser").modal('show');
            //获得所要回显的值，此处为：100,1001,200,1400
            var checkeds = $("#sysUserCitysid").val();
            //拆分为字符串数组
            var checkArray = checkeds.split(",");
            //获得所有的复选框对象
            var checkBoxAll = $("input[name='cityId']");
            //获得所有复选框（新闻,微信,论坛，问答，博客，平媒）的value值，然后，用checkArray中的值和他们比较，如果有，则说明该复选框被选中
            for (var i = 0; i < checkArray.length; i++) {
                //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
                $.each(checkBoxAll, function (j, checkbox) {
                    //获取复选框的value属性
                    var checkValue = $(checkbox).val();
                    if (checkArray[i] == checkValue) {
                        $(checkbox).attr("checked", true);
                    }
                })
            }
        });
    }

    function checkEvent(name, allCheckId) {
        var allCk = document.getElementById(allCheckId);
        if (allCk.checked == true) checkAll(name);
        else checkAllNo(name);
    }

    //全选
    function checkAll(name) {
        var names = document.getElementsByName(name);
        var len = names.length;
        if (len > 0) {
            var i = 0;
            for (i = 0; i < len; i++)
                names[i].checked = true;
        }
    }

    //全不选
    function checkAllNo(name) {
        var names = document.getElementsByName(name);
        var len = names.length;
        if (len > 0) {
            var i = 0;
            for (i = 0; i < len; i++)
                names[i].checked = false;
        }
    }

    function showDialog(nums) {
        var status = nums;
        var chkArray = document.getElementsByName("chk");
        ids = "";
        for (var i = 0; i < chkArray.length; i++) {
            if (chkArray[i].checked) {
                ids += chkArray[i].value + ",";
            }
        }
        if (ids.length > 0) {
            if (confirm("确定要操作吗？")) {
                $.post("${ctx}/sysUserManage/toExamine", {
                    ids: ids,
                    nums: nums
                }, function (data) {
                    window.location.href = "${ctx}/sysUserManage/JumpSysUser/";
                });
            }
        } else {
            alert("请至少选中一个！！");
        }
    }

</script>
</html>
