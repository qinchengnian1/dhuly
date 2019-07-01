package com.ecms.cums.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2017/5/15.
 */
public class LinkUtils
{
    private static Logger logger = LogManager.getLogger(LinkUtils.class);

    public static String buildLink(Map<String, String> request)
    {
        if (request == null || request.isEmpty())
        {
            return null;
        }
        else
        {
            String link = "";
            for (Map.Entry<String, String> entry : request.entrySet())
            {
                if (StringUtils.isEmpty(entry.getValue()))
                {
                    link += entry.getKey() + "=&";
                }
                else
                {
                    try
                    {
                        link += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "utf-8") + "&";
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        return null;
                    }
                }
            }
            if (link.equals(""))
            {
                return null;
            }
            else
            {
                return link.substring(0, link.length() - 1);
            }
        }
    }


    public static String buildLinkNoURLEncoderNoFilter(Map<String, String> request)
    {
        if (request == null || request.isEmpty())
        {
            return null;
        }
        else
        {
            String link = "";
            for (Map.Entry<String, String> entry : request.entrySet())
            {
                if (StringUtils.isEmpty(entry.getValue()))
                {
                    link += entry.getKey() + "=&";
                }
                else
                {
                    link += entry.getKey() + "=" + entry.getValue() + "&";
                }
            }
            logger.info("构造无加密连接：" + link);
            if (link.equals(""))
            {
                return null;
            }
            else
            {
                String r = link.substring(0, link.length() - 1);
                logger.info("最终构造无过滤无加密连接：" + r);
                return r;
            }
        }
    }

    public static String buildLinkNoURLEncoder(Map<String, String> request)
    {
        if (request == null || request.isEmpty())
        {
            return null;
        }
        else
        {
            String link = "";
            for (Map.Entry<String, String> entry : request.entrySet())
            {
                if (StringUtils.isEmpty(entry.getValue()))
                {
                    continue;
                }
                else
                {
                    link += entry.getKey() + "=" + entry.getValue() + "&";
                }
            }
            logger.info("构造无加密连接：" + link);
            if (link.equals(""))
            {
                return null;
            }
            else
            {
                String r = link.substring(0, link.length() - 1);
                logger.info("最终构造无加密连接：" + r);
                return r;
            }
        }
    }


    public static Map<String, String> getMapByDeepLink(String link) throws UnsupportedEncodingException
    {
        if (org.apache.commons.lang3.StringUtils.isEmpty(link))
        {
            return null;
        }
        else
        {
            String[] lks = link.split("&");
            if (lks == null || lks.length <= 0)
            {
                return null;
            }
            else
            {
                Map<String, String> map = new HashMap<String, String>();
                for (String str : lks)
                {
                    String[] s = str.split("=");
                    if (s != null && s.length == 2)
                    {
                        if (!org.apache.commons.lang3.StringUtils.isEmpty(s[0]))
                        {
                            map.put(s[0], URLDecoder.decode(s[1], "utf-8"));
                        }
                    }
                }
                if (map.size() > 0)
                {
                    return map;
                }
                else
                {
                    return null;
                }
            }
        }
    }
}
