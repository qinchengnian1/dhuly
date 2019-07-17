package com.ecms.cums.utils.weixin;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信config
 */
@Data
public class WeixinConfig implements Serializable{

    // 正式
//    public static String login_app_id = "wx920ac425a15f7c5b";
//
//    public static String login_app_secret = "28cfe06602949af8e96ec116cad89cbb";
//
//    public static String login_redirect_uri = "http://ly.5138fun.com/galy-web/weixin/authinfo";
//
//    public static String login_repose_code = "code";
//
//    public static String login_scope = "snsapi_userinfo";
//
//    public static String login_state = "123456";
//
//    public static String pay_app_id = "wx920ac425a15f7c5b";
//
//    public static String pay_app_key = "28cfe06602949af8e96ec116cad89cbb";
//
//    // 开放平台
//    //public static String pay_app_id = "wx3ce04b07e42ef99f";
//
//    //public static String pay_app_key = "c986fac31fcb4cbd2733f0b800892e7e";
//
//    public static String pay_mch_id = "1538122081";
//
//    public static String pay_notify_url = "http://ly.5138fun.com/galy-web//paycallback/weixinpay";

    // 测试
    public static String login_app_id = "wxe70d78bc996daed4";

    public static String login_app_secret = "0f6613dc8145bb85ddcf3e38d234300f";

    public static String login_redirect_uri = "http://wacczy.natappfree.cc/web/weixin/authinfo";

    public static String login_repose_code = "code";

    public static String login_scope = "snsapi_userinfo";

    public static String login_state = "123456";

    public static String pay_app_id = "wx3ce04b07e42ef99f";

    public static String pay_app_key = "c986fac31fcb4cbd2733f0b800892e7e";

    public static String pay_mch_id = "";

    public static String pay_notify_url = "http://ly.5138fun.com/galy-web//paycallback/weixinpay";

}
