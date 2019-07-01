	function turnToTheSpecificPage(url) {
		var num = $("#_pageNum").val();
		if (num == "") {
			alert("请输入页数");
			return false;
		}
		url += num;
		window.location.href=url;
	}
