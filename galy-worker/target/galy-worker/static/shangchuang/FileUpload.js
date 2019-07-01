//1
function setImagePreview() {
var docObj = document.getElementById("Image");
var docObjStr = docObj.value;
if (docObjStr.indexOf(".png") >= 0 || docObjStr.indexOf(".jpg") >= 0
		|| docObjStr.indexOf(".gif") >= 0
		|| docObjStr.indexOf(".PNG") >= 0
		|| docObjStr.indexOf(".JPG") >= 0
		|| docObjStr.indexOf(".GIF") >= 0) {
	var imgObjPreview = document.getElementById("preview");
	$('#preview').show();
	if (docObj.files && docObj.files[0]) { //火狐下，直接设img属性??
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '250px';
		imgObjPreview.style.marginTop = '5px';
		//imgObjPreview.style.height = '25px';
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		return true;
	}
}
docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
return false;
}
//清空图片
function clearImg() {
	var docObj = document.getElementById("Image");
	docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
	var imgObjPreview = document.getElementById("preview");
	imgObjPreview.style.display = 'none';
	imgObjPreview.style.width = '-1px';
	imgObjPreview.style.height = '-1px';
}
//2
function setImagePreview2() {
	var docObj = document.getElementById("Image2");
	var docObjStr = docObj.value;
	if (docObjStr.indexOf(".png") >= 0 || docObjStr.indexOf(".jpg") >= 0
			|| docObjStr.indexOf(".gif") >= 0
			|| docObjStr.indexOf(".PNG") >= 0
			|| docObjStr.indexOf(".JPG") >= 0
			|| docObjStr.indexOf(".GIF") >= 0) {
		var imgObjPreview = document.getElementById("preview2");
		$('#preview2').show();
		if (docObj.files && docObj.files[0]) { //火狐下，直接设img属性??
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '250px';
			imgObjPreview.style.marginTop = '5px';
			//imgObjPreview.style.height = '25px';
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			return true;
		}
	}
	docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
	return false;
	}
	//清空图片
	function clearImg2() {
		var docObj = document.getElementById("Image2");
		docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
		var imgObjPreview = document.getElementById("preview");
		imgObjPreview.style.display = 'none';
		imgObjPreview.style.width = '-1px';
		imgObjPreview.style.height = '-1px';
	}
	//3
	function setImagePreview3() {
		var docObj = document.getElementById("Image3");
		var docObjStr = docObj.value;
		if (docObjStr.indexOf(".png") >= 0 || docObjStr.indexOf(".jpg") >= 0
				|| docObjStr.indexOf(".gif") >= 0
				|| docObjStr.indexOf(".PNG") >= 0
				|| docObjStr.indexOf(".JPG") >= 0
				|| docObjStr.indexOf(".GIF") >= 0) {
			var imgObjPreview = document.getElementById("preview3");
			$('#preview3').show();
			if (docObj.files && docObj.files[0]) { //火狐下，直接设img属性??
				imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = '250px';
				imgObjPreview.style.marginTop = '5px';
				//imgObjPreview.style.height = '25px';
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
				return true;
			}
		}
		docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
		return false;
		}
		//清空图片
		function clearImg3() {
			var docObj = document.getElementById("Image3");
			docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
			var imgObjPreview = document.getElementById("preview");
			imgObjPreview.style.display = 'none';
			imgObjPreview.style.width = '-1px';
			imgObjPreview.style.height = '-1px';
		}
		
		//4
		function setImagePreview4() {
			var docObj = document.getElementById("Image4");
			var docObjStr = docObj.value;
			if (docObjStr.indexOf(".png") >= 0 || docObjStr.indexOf(".jpg") >= 0
					|| docObjStr.indexOf(".gif") >= 0
					|| docObjStr.indexOf(".PNG") >= 0
					|| docObjStr.indexOf(".JPG") >= 0
					|| docObjStr.indexOf(".GIF") >= 0) {
				var imgObjPreview = document.getElementById("preview4");
				if (docObj.files && docObj.files[0]) { //火狐下，直接设img属性??
					imgObjPreview.style.display = 'block';
					imgObjPreview.style.width = '250px';
					imgObjPreview.style.marginTop = '5px';
					//imgObjPreview.style.height = '25px';
					imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
					return true;
				}
			}
			docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
			return false;
			}
			//清空图片
			function clearImg4() {
				var docObj = document.getElementById("Image4");
				$('#preview4').show();
				docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
				var imgObjPreview = document.getElementById("preview");
				imgObjPreview.style.display = 'none';
				imgObjPreview.style.width = '-1px';
				imgObjPreview.style.height = '-1px';
			}
			
			//5
			function setImagePreview5() {
				var docObj = document.getElementById("Image5");
				var docObjStr = docObj.value;
				if (docObjStr.indexOf(".png") >= 0 || docObjStr.indexOf(".jpg") >= 0
						|| docObjStr.indexOf(".gif") >= 0
						|| docObjStr.indexOf(".PNG") >= 0
						|| docObjStr.indexOf(".JPG") >= 0
						|| docObjStr.indexOf(".GIF") >= 0) {
					var imgObjPreview = document.getElementById("preview5");
					if (docObj.files && docObj.files[0]) { //火狐下，直接设img属性??
						imgObjPreview.style.display = 'block';
						imgObjPreview.style.width = '250px';
						imgObjPreview.style.marginTop = '5px';
						//imgObjPreview.style.height = '25px';
						imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
						return true;
					}
				}
				docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
				return false;
				}
				//清空图片
				function clearImg5() {
					var docObj = document.getElementById("Image5");
					docObj.outerHTML = docObj.outerHTML.replace(/(value=\").+\"/i, "$1\"");
					var imgObjPreview = document.getElementById("preview");
					$('#preview5').show();
					imgObjPreview.style.display = 'none';
					imgObjPreview.style.width = '-1px';
					imgObjPreview.style.height = '-1px';
				}
