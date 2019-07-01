package com.ecms.cums.utils.weixin;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.DataInputStream;
import java.io.IOException;

public class HttpProtocolUtils {

    public HttpProtocolUtils() {
    }

    public static String getRemortIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (StringUtils.contains(ip, ",")) {
            ip = StringUtils.substringBefore(ip, ",");
        }

        return ip;
    }

    public static String parseInputStream(HttpServletRequest req) throws IOException {
        byte[] bytes = new byte[req.getContentLength()];
        DataInputStream dis = new DataInputStream(req.getInputStream());
        Throwable var3 = null;

        try {
            dis.readFully(bytes);
        } catch (Throwable var12) {
            var3 = var12;
            throw var12;
        } finally {
            if (dis != null) {
                if (var3 != null) {
                    try {
                        dis.close();
                    } catch (Throwable var11) {
                        var3.addSuppressed(var11);
                    }
                } else {
                    dis.close();
                }
            }

        }
        return new String(bytes, "UTF-8");
    }

}
