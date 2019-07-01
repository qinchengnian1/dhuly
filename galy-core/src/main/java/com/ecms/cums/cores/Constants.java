package com.ecms.cums.cores;

/**
 * @ClassName: Constants
 * @Description: 常量类
 * @author: zJin
 * @date: 2018年3月9日 下午5:45:24
 */

public final class Constants {
	 private Constants() {
	        // hide me
	 }

	 /**
	  * 国旅账户（正式）
	  */
	 public static final String guolv_username = "citsgasq";
	 /**
	  * 国旅密钥（正式）
	  */
	 public static final String guolv_secret_key = "r84j6bs9";
	 /**
	  * 渠道（正式）
	  */
	 public static final String channelsource = "05";
	 /**
	  * 国旅站点名或域名（正式）
	  */
	 public static final String server_name = "www.cits.cn";
	 /**
	  * 国旅url(正式)
	  */
	 public static final String guolv_url = "http://api.cits.cn/cits-json/api.html";

	 /**
	  * 国旅E店
	  */
	 public static final String guolv_e_shop = "E180036303949724743";

	 /**
	  * 国旅e店key
	  */
	 public static final String guolv_e_key="9cf6a0f0e8b5e9b3a94ce50a9895b45f";

	 /**
	  * 国旅无参加密
	  */
	 public static final String noParam = "RmfiP+V3Jl0=";
	 /**
	  * 平台下单接口链接（正式）
	  */
	 public static final String pt_create_order_url = "https://gasq-web-order.guoanshequ.com/gasq-web-order/order/insert";
	// public static final String pt_create_order_url = "https://gasq-web-order.guoanshequ.wang/gasq-web-order/order/insert";

	 //平台测试优惠卷接口
	 public static final String pt_querydiscountCoupon = "https://gasq-web-rule.guoanshequ.com/gasq-web-rule/cardCoupon/listForShoppingCart";
	 //平台测试聚合支付接口
	 public static final String pt_juhepay = "https://gasq-web-thirdparty.guoanshequ.com/gasq-web-thirdparty/payment/charge";

	 public static final String employeeListByStroe = "https://gasq-web-employee.guoanshequ.com/gasq-web-employee/employee/listbystore";
	 /**
	  * 环境平台私钥
	  */
	 public static final String pt_secret_key = "4be3fed9-40df-4037-85f7-aaebf75aef34";
	 //平台测试私钥
	 //public static final String pt_secret_key = "e76976e4-50e0-478b-9c76-0a537b4cc165";
	 /**
	  * 平台appid
	  */
	 public static final String pt_appId = "government";

	 /**
	  * 平台url上传接口(正式)
	  */
	 public static final String Eshop_key= "https://openapi.guoanshequ.com/openapi/";
     //public static final String Eshop_key= "http://10.16.33.9:8081/openapi/";
	 /**
	  * 获取国内参团热门目的地接口
	  */
	 public static final String DomesticGroupHotDest_key = "Domestic_HotDest";
	 /**
	  * 查询国内参团所属区域列表接口
	  */
	 public static final String DomesticGroupDestArea_key = "Domestic_DestArea";
	 /**
	  * 查询国内参团可用出发地列表接口
	  */
	 public static final String DomesticGroupStartPlace_key = "Domestic_StartPlace";
	 /**
	  * 查询国内参团推荐线路列表接口
	  */
	 public static final String DomesticGroupRecommendRoute_key = "Domestic_RecommendRoute";

	 /**
	  * 订单详情查询接口
	  */
	 public static final String orderQuery = "orderManage/orderQuery";
	 /**
	  * e店上架/下架商品方法
	  */
	 public static final String updateProShelfState="proManage/updateProShelfState";


	 /**
	  * 商品上传
	  */

	 public static final String  addGoods="proManage/addGoods";

	 /**
	  * e店更新商品库存
	  */
	 public static final String updateProInventory="proManage/updateProInventory";
	 /**
	  * 获取出境参团热门目的地
	  */
	 public static final String OutboundGroupHotDest="Outbound_HotDest";
	 /**
	  * 查询出境参团所属区域列表
	  */
	 public static final String OutboundGroupDestArea="Outbound_DestArea";
	 /**
	  * 出境参团可用出发地列表
	  */
	 public static final String OutboundGroupStartPlace="Outbound_StartPlace";
	 /**
	  * 查询出境参团推荐线路列表
	  */
	 public static final String OutboundGroupRecommendRoute="Outbound_RecommendRoute";
	 /**
	  * 查询出境参团线路列表
	  */
	 public static final String OutboundGroupRoutes="Outbound_Routes";
	 /**
	  * 查询聚合页二次过滤的出境跟团游出发地
	  */
	 public static final String OutboundGroupFilterStartPlace="Outbound_FilterStartPlace";
	 /**
	  * 查询聚合页二次过滤的出境跟团游目的地
	  */
	 public static final String OutboundGroupFilterDestination="Outbound_FilterDestination";
	 /**
	  * 获取出境参团线路详细接口
	  */
	 public static final String OutboundRouteDetail="Outbound_Detail";
	 /**
	  * 机票身份标识用户名
	  */
	 public static final String airportCId = "CE128E393C1364EBFCDEC5F5FC78FE8E";

	 public static final String airportUrl = "http://139.196.235.76:9610/laidanyun/";

	 /**
	  * 获取国内自由行热门目的地接口
	  */
	 public static final String  DomesticFreeHotDest_key="FreeHot_Dest";


}
