package com.ecms.cums.web.mvc;

import com.ecms.cums.utils.HttpUtils;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        String url ="http://192.168.199.212:8080/web/login/getLoginAuthCode";
        HashMap<String, String> map = new HashMap<>();
        map.put("telephone", "15810814521");
        System.out.println(HttpUtils.sendHttpPost(url, map));
    }

}
