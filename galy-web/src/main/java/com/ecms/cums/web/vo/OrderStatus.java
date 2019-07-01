package com.ecms.cums.web.vo;

public enum OrderStatus {
    REQ(0),
    PAY_SUCCESS(1),
    PAY_FAILTURE(2),
    INVALID(3),
    NOTIFY(4);

    private int value;

    public static OrderStatus valueOf(int value) {
        switch(value) {
            case 0:
                return REQ;
            case 1:
                return PAY_SUCCESS;
            case 2:
                return PAY_FAILTURE;
            case 3:
                return INVALID;
            case 4:
                return NOTIFY;
            default:
                return null;
        }
    }

    private OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}