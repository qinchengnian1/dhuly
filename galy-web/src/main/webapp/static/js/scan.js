function ScanCode(config) {
    var me = this;
    me.selector;

    me.validateCode(config);

};

ScanCode.prototype = {
    constructor: ScanCode,
    init: function (config) {
        var me = this;

        me.validateCode(config);
        /*
		 * config.selector.keypress(function(event){ });
		 */

    },
    validateCode: function (config) {
        var me = this, l = 0;
        $(document).ready(function () {
            var barCode = [];
            $("body").keypress(function (event) {
                me.validata(config, event, l, barCode);
                l = barCode.length;

            });

            /*
			 * $("input").keypress(function(event){ event.stopPropagation();
			 * me.validata(config,event,l,barCode); l = barCode.length;
			 *
			 *
			 *
			 * });
			 */

        });

    },
    turning: function (command, config, code, event) {
        var me = this;
        var jsonpath = SITE_URL + "//static//js//url_mapping.json"
        //var jsonpath = "//wms//static//js//url_mapping.json"
        $.getJSON(jsonpath, function (data) {
            if (command && data[command]) {
                window.location.href = data[command]
            }
            operation(command, event);
        });

    },
    validata: function (config, event, l, barCode) {
        var me = this;
        var c = String.fromCharCode(event.keyCode);
        if (l == 0 && c == "$") {
            barCode.push(c);
        } else {
            if (/^[0-9]*$/.test(c) && (l > 0 && l < 4)) {
                barCode.push(c);
            } else if (c == "$" && l == 4) {
                barCode.push(c);
            } else if (event.keyCode == 13 && l == 5) {
                var command = barCode.join(""), code = $(event.srcElement).val();
                if (event.srcElement.tagName == "INPUT") {
                	code = code.replace(command, "");
                    $(event.srcElement).val(code);
                    //var select = event.target.className;
                    //$("." + select).val(code);
                }
                barCode.length = 0;
                me.turning(command, config, code, event);
                // $("input").unbind();
            } else {
                barCode.length = 0;
                // $("input").unbind();
            }
        }
    }
};
function operation() {
}
