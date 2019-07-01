package com.ecms.cums.model;

import java.util.Date;

/**
 * 订单支付
 */
public class PayOrder {

    private Integer orderId;
    private String orderNo;
    private Integer accountId;
    private String outOrderNo;
    private String goodsName;
    private Integer amount;
    private String extra;
    private byte status;
    private Date createDate;
    private byte payType;
    private String payOrderNo = "";
    private Date payDate;
    private volatile byte notifyNum;

    public PayOrder() {
    }

}
