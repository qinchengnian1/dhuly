(function($){
	$.fn.toUpper = function(e){
		var selector = $(this);
		
		
		selector.on("keyup",function(e){
			
			var value = $(this).val().toUpperCase();	

			selector.val(value);

		});
		
	};

})(jQuery);
