package com.ecms.cums.productvo;

public class ProductJson {
	private String eshop_category_id3;
	private String eshop_category_id2;
	private String eshop_category_id1;
	private Integer box_length;
	private Integer box_width;
	private Integer box_height;
	private Integer content_length;
	private Integer Content_width;
	private Integer content_height;
	private Integer box_weight;
	private Integer weight;
	private Integer expirationdate;
	private String content_standard;
	//系统标签
	private String content_tag;
	//商品
	private String content_name;
	//商品价格
	private float content_price;
	//商品个数
	private String content_unit;
	//自定义编码
	private String self_code;
	//预警数量
	private Integer warn_number;
	//限购数量 最小 默认0
	private Integer min_number;
	//限购数量 最大 默认999999
	private Integer max_number;
	//是否组合拆单 yes 是 no 否
	private String is_combo_split;
	private String order_validity_days;
	//商品类型： 商品 product 、服务 service
	private String content_type;
	//是否为组合商品 yes 组合商品 no单一商品
	private String is_combo;
	/////////////////////////////////////////////
	private String output_tax_rate;
	private String income_tax_rate;
	private String tax_merge_coding;
	//商品库存
	private Integer content_number;
	private String ims_master_id;
	//商品主图片 
	private String content_img;
	private String allow_receive_date;
	private String allow_send_date;
	private String warn_date;
	private String storage_temp;
	private String delivery_cycle;
	private String isfresh;
	private String logistics_type;
	private String content_area;
	private String content_bar;
	private String is_weigh;
	private String is_corpcode;
	private String is_produce_batch;
	private String is_serial;
	private String is_indate;
	private String is_batch;
	private String cost_price;
	private String box_containing_quantity;
	private String provider_id;
	//checkout_kind	是	string	结算方式 微超店铺选项
	private String checkout_kind;
	//box_standard	是	string	箱装数  微超店铺选项
	private String box_standard;
	//credit	是	string	商品积分   积分商品选项
	private String credit;
	//off 下架 hidden 隐藏商品
	private String content_shelf;
	
	
	public String getContent_shelf() {
		return content_shelf;
	}
	public void setContent_shelf(String content_shelf) {
		this.content_shelf = content_shelf;
	}
	public String getEshop_category_id3() {
		return eshop_category_id3;
	}
	public void setEshop_category_id3(String eshop_category_id3) {
		this.eshop_category_id3 = eshop_category_id3;
	}
	public String getEshop_category_id2() {
		return eshop_category_id2;
	}
	public void setEshop_category_id2(String eshop_category_id2) {
		this.eshop_category_id2 = eshop_category_id2;
	}
	public String getEshop_category_id1() {
		return eshop_category_id1;
	}
	public void setEshop_category_id1(String eshop_category_id1) {
		this.eshop_category_id1 = eshop_category_id1;
	}
	public Integer getBox_length() {
		return box_length;
	}
	public void setBox_length(Integer box_length) {
		this.box_length = box_length;
	}
	public Integer getBox_width() {
		return box_width;
	}
	public void setBox_width(Integer box_width) {
		this.box_width = box_width;
	}
	public Integer getBox_height() {
		return box_height;
	}
	public void setBox_height(Integer box_height) {
		this.box_height = box_height;
	}
	public Integer getContent_length() {
		return content_length;
	}
	public void setContent_length(Integer content_length) {
		this.content_length = content_length;
	}
	public Integer getContent_width() {
		return Content_width;
	}
	public void setContent_width(Integer content_width) {
		Content_width = content_width;
	}
	public Integer getContent_height() {
		return content_height;
	}
	public void setContent_height(Integer content_height) {
		this.content_height = content_height;
	}
	public Integer getBox_weight() {
		return box_weight;
	}
	public void setBox_weight(Integer box_weight) {
		this.box_weight = box_weight;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(Integer expirationdate) {
		this.expirationdate = expirationdate;
	}
	public String getContent_standard() {
		return content_standard;
	}
	public void setContent_standard(String content_standard) {
		this.content_standard = content_standard;
	}
	public String getContent_tag() {
		return content_tag;
	}
	public void setContent_tag(String content_tag) {
		this.content_tag = content_tag;
	}
	public String getContent_name() {
		return content_name;
	}
	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}
	public float getContent_price() {
		return content_price;
	}
	public void setContent_price(float content_price) {
		this.content_price = content_price;
	}
	public String getContent_unit() {
		return content_unit;
	}
	public void setContent_unit(String content_unit) {
		this.content_unit = content_unit;
	}
	public String getSelf_code() {
		return self_code;
	}
	public void setSelf_code(String self_code) {
		this.self_code = self_code;
	}
	public Integer getWarn_number() {
		return warn_number;
	}
	public void setWarn_number(Integer warn_number) {
		this.warn_number = warn_number;
	}
	public Integer getMin_number() {
		return min_number;
	}
	public void setMin_number(Integer min_number) {
		this.min_number = min_number;
	}
	public Integer getMax_number() {
		return max_number;
	}
	public void setMax_number(Integer max_number) {
		this.max_number = max_number;
	}
	public String getIs_combo_split() {
		return is_combo_split;
	}
	public void setIs_combo_split(String is_combo_split) {
		this.is_combo_split = is_combo_split;
	}
	public String getOrder_validity_days() {
		return order_validity_days;
	}
	public void setOrder_validity_days(String order_validity_days) {
		this.order_validity_days = order_validity_days;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public String getIs_combo() {
		return is_combo;
	}
	public void setIs_combo(String is_combo) {
		this.is_combo = is_combo;
	}
	public String getOutput_tax_rate() {
		return output_tax_rate;
	}
	public void setOutput_tax_rate(String output_tax_rate) {
		this.output_tax_rate = output_tax_rate;
	}
	public String getIncome_tax_rate() {
		return income_tax_rate;
	}
	public void setIncome_tax_rate(String income_tax_rate) {
		this.income_tax_rate = income_tax_rate;
	}
	public String getTax_merge_coding() {
		return tax_merge_coding;
	}
	public void setTax_merge_coding(String tax_merge_coding) {
		this.tax_merge_coding = tax_merge_coding;
	}
	public Integer getContent_number() {
		return content_number;
	}
	public void setContent_number(Integer content_number) {
		this.content_number = content_number;
	}
	public String getIms_master_id() {
		return ims_master_id;
	}
	public void setIms_master_id(String ims_master_id) {
		this.ims_master_id = ims_master_id;
	}
	public String getContent_img() {
		return content_img;
	}
	public void setContent_img(String content_img) {
		this.content_img = content_img;
	}
	public String getAllow_receive_date() {
		return allow_receive_date;
	}
	public void setAllow_receive_date(String allow_receive_date) {
		this.allow_receive_date = allow_receive_date;
	}
	public String getAllow_send_date() {
		return allow_send_date;
	}
	public void setAllow_send_date(String allow_send_date) {
		this.allow_send_date = allow_send_date;
	}
	public String getWarn_date() {
		return warn_date;
	}
	public void setWarn_date(String warn_date) {
		this.warn_date = warn_date;
	}
	public String getStorage_temp() {
		return storage_temp;
	}
	public void setStorage_temp(String storage_temp) {
		this.storage_temp = storage_temp;
	}
	public String getDelivery_cycle() {
		return delivery_cycle;
	}
	public void setDelivery_cycle(String delivery_cycle) {
		this.delivery_cycle = delivery_cycle;
	}
	public String getIsfresh() {
		return isfresh;
	}
	public void setIsfresh(String isfresh) {
		this.isfresh = isfresh;
	}
	public String getLogistics_type() {
		return logistics_type;
	}
	public void setLogistics_type(String logistics_type) {
		this.logistics_type = logistics_type;
	}
	public String getContent_area() {
		return content_area;
	}
	public void setContent_area(String content_area) {
		this.content_area = content_area;
	}
	public String getContent_bar() {
		return content_bar;
	}
	public void setContent_bar(String content_bar) {
		this.content_bar = content_bar;
	}
	public String getIs_weigh() {
		return is_weigh;
	}
	public void setIs_weigh(String is_weigh) {
		this.is_weigh = is_weigh;
	}
	public String getIs_corpcode() {
		return is_corpcode;
	}
	public void setIs_corpcode(String is_corpcode) {
		this.is_corpcode = is_corpcode;
	}
	public String getIs_produce_batch() {
		return is_produce_batch;
	}
	public void setIs_produce_batch(String is_produce_batch) {
		this.is_produce_batch = is_produce_batch;
	}
	public String getIs_serial() {
		return is_serial;
	}
	public void setIs_serial(String is_serial) {
		this.is_serial = is_serial;
	}
	public String getIs_indate() {
		return is_indate;
	}
	public void setIs_indate(String is_indate) {
		this.is_indate = is_indate;
	}
	public String getIs_batch() {
		return is_batch;
	}
	public void setIs_batch(String is_batch) {
		this.is_batch = is_batch;
	}
	public String getCost_price() {
		return cost_price;
	}
	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}
	public String getBox_containing_quantity() {
		return box_containing_quantity;
	}
	public void setBox_containing_quantity(String box_containing_quantity) {
		this.box_containing_quantity = box_containing_quantity;
	}
	public String getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(String provider_id) {
		this.provider_id = provider_id;
	}
	public String getCheckout_kind() {
		return checkout_kind;
	}
	public void setCheckout_kind(String checkout_kind) {
		this.checkout_kind = checkout_kind;
	}
	public String getBox_standard() {
		return box_standard;
	}
	public void setBox_standard(String box_standard) {
		this.box_standard = box_standard;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	




	
	
		


}
