var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
		width: '80%',
		height: '360px',
		themeType: 'simple',
		resizeType: 1,
		filterMode: false,
		imageTabIndex: 1,
		allowPreviewEmoticons: false,
		allowImageUpload: true,
		uploadJson : 'jsp/upload_json.jsp',
        fileManagerJson : 'jsp/file_manager_json.jsp',
		afterBlur: function() {	//上传回调
			this.sync();
			var content = editor.text();
			if(content.length != 0){
				
			}else{
				
			}
		},
		items: [
		    'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
		    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
		    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
		    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
		    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
		    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
		    'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
		    'anchor', 'link', 'unlink', '|', 'about'
		]
	});
});