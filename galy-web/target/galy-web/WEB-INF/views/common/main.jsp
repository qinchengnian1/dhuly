<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>CUMS - Powered By ECMS</title>
<meta name="author" content="ECMS Team" />
<meta name="copyright" content="ECMS" />
<link href="${base}/static/admin/css/common.css" rel="stylesheet" type="text/css" />
<link href="${base}/static/admin/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/static/admin/js/jquery.js"></script>
<style type="text/css">
*{
	font: 12px tahoma, Arial, Verdana, sans-serif;
}
html, body {
	width: 100%;
	height: 100%;
	overflow: hidden;
}
</style>
<script type="text/javascript">
$().ready(function() {

	var $nav = $("#nav a:not(:last)");
	var $menu = $("#menu dl");
	var $menuItem = $("#menu a");

	$nav.click(function() {
		var $this = $(this);
		$nav.removeClass("current");
		$this.addClass("current");
		var $currentMenu = $($this.attr("href"));
		$menu.hide();
		$currentMenu.show();
		return false;
	});

	$menuItem.click(function() {
		var $this = $(this);
		$menuItem.removeClass("current");
		$this.addClass("current");
	});

});
</script>
</head>
<body>
	<script type="text/javascript">
		if (self != top) {
			top.location = self.location;
		};
	</script>
	<table class="main">
		<tr>
			<th class="logo">
				<a href="main">
					<span style="font-size:24px;font-weight:900;">国安旅游系统</span>
				</a>
			</th>
			<th>
				<div id="nav" class="nav">
					<ul>
						<li>
							<a href="#system">系统</a>
						</li>
						<li>
							<a href="${base}/main">首页</a>
						</li>
					</ul>
				</div>
				<div class="link">
					<strong>nologin</strong>
					您好!
					<a href="#">[修改密码]</a>
					<a href="#" target="_top">[注销]</a>
				</div>
			</th>
		</tr>
		<tr>
			<td id="menu" class="menu">
				<dl id="system">
					<dt>系统设置</dt>
					<dd>
						<a href="${base}/setting/edit" target="iframe">系统设置</a>
					</dd>
				</dl>
			</td>
			<td>
				<iframe id="iframe" name="iframe" src="index" frameborder="0"></iframe>
			</td>
		</tr>
	</table>
</body>
</html>