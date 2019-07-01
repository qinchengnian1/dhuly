package com.ecms.cums.utils.weixin;

import java.security.MessageDigest;

public class MD5 {

    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public MD5() {
    }

    public static String encode(String origin) {
        return encode(origin, "UTF-8");
    }

    public static String encode(String origin, String charsetName) {
        try {
            String resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest;
            if (charsetName != null && !"".equals(charsetName)) {
                digest = md.digest(resultString.getBytes(charsetName));
            } else {
                digest = md.digest(resultString.getBytes());
            }

            return byteArrayToHexString(digest);
        } catch (Exception var5) {
            return null;
        }
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = b + 256;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
