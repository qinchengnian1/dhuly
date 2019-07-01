function ecmsPrint(config){
	var me = this;
	me.appendObject();
	me.init(config);
};
ecmsPrint.prototype = {
	constructor : ecmsPrint,
	init:function(config){
		var me = this, 
		data = config.data,
		modelname = config.modelname,
		str = "",i = 1;
		$.each(data,function(k,v){
			if(i==1)
				str = "'"+ k +"'"+":"+"'"+ v+"'";
			else
				str += ",'"+ k +"'"+":"+"'"+ v+"'";
			i++;
		});
		str = "{"+str+"}";
		/*"{'BARCODE':'q','USERID':'1','EXPRESSID':'2'}"*/
		var activeX = document.getElementById("ecmsPlugins");
		activeX.Print(JSON.stringify(data),modelname);
	},
	appendObject:function(){
		var str = "<object id=\"ecmsPlugins\" "+
				"classid=\"clsid:E32BB17E-92A0-44A3-B332-F2CD25A7654E\" "+
				"codebase=\"ECMSPlugins.CAB#version=1,0,0\" "+
				"style=\"display: none;\"></object>";
		$("body").append(str);
	}
};
var t;
(function($){
	$.fn.getWeight = function(time,isStop){
		var selector = $(this);
		
		if(isStop){
			window.clearInterval(t);
		}else{
			t = setInterval(weight,time);
		}
			
		if($("object").length==0){
			var str = "<object id=\"ecmsPlugins\" "+
				"classid=\"clsid:E32BB17E-92A0-44A3-B332-F2CD25A7654E\" "+
				"codebase=\"ECMSPlugins.CAB#version=1,0,0\" "+
				"style=\"display: none;\"></object>";
			$("body").append(str);
		}
		
		
		function weight(){

			var activeX = document.getElementById("ecmsPlugins");
			var weight = activeX.GetWeight();
			selector.val(weight);
			
		}
	};

})(jQuery);