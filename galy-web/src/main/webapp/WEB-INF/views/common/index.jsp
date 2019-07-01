[#include "/include/header.ftl" /]
<style type="text/css">
.input .powered {
	font-size: 11px;
	text-align: right;
	color: #cccccc;
}
</style>
<div class="path">
	关务系统首页
</div>
<table class="input">
	<tr>
		<th>
			系统名称:
		</th>
		<td>
			${systemName}
		</td>
		<th>
			系统版本:
		</th>
		<td>
			${systemVersion}
		</td>
	</tr>
	<tr>
		<td colspan="4">
			&nbsp;
		</td>
	</tr>
	<tr>
		<th>
			JAVA版本:
		</th>
		<td>
			${javaVersion}
		</td>
		<th>
			JAVA路径:
		</th>
		<td>
			${javaHome}
		</td>
	</tr>
	<tr>
		<th>
			操作系统名称:
		</th>
		<td>
			${osName}
		</td>
		<th>
			操作系统构架:
		</th>
		<td>
			${osArch}
		</td>
	</tr>
	<tr>
		<th>
			Servlet信息:
		</th>
		<td>
			${serverInfo}
		</td>
		<th>
			Servlet版本:
		</th>
		<td>
			${servletVersion}
		</td>
	</tr>
	<tr>
		<td colspan="4">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="4">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td class="powered" colspan="4">
			COPYRIGHT © 2013-2016 ECMS ALL RIGHTS RESERVED.
		</td>
	</tr>
</table>

<a href="javascript:;" class="exportButton" mno="999-9999 9999" port="TMP">[接口文档]</a>

<script type="text/javascript">
$().ready( function() {
	$(".exportButton").click( function() {
		var $this = $(this);
		if ($this.hasClass("disabled")) {
			return false;
		}

		var mno = $this.attr("mno");
		var port = $this.attr("port");
		$.ajax({
			url: "${base}/declare/export2",
			type: "POST",
			data: {mno: mno, port: port},
			dataType: "json",
			cache: false,
			success: function(message) {
				$.message(message);
				if (message.type == "success") {
					setTimeout(function() {
						location.href = "${base}/declare/exporthistory";
					}, 3000);
				}
				$this.addClass("disabled");
			}
		});
	});

});

</script>

[#include "/include/footer.ftl" /]
