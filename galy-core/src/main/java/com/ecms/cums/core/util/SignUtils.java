package com.ecms.cums.core.util;

import java.security.MessageDigest;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;


/**
 * Created by Administrator on 2017/5/12.
 */
public class SignUtils
{
    private static Logger logger = LogManager.getLogger(SignUtils.class);
    protected static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String sign(Map<String, String> map, String key)
    {
        logger.info("key:"+key);
        if (map == null || map.isEmpty())
        {
            return null;
        }
        Map<String, String> m = new TreeMap<String, String>(
                new Comparator<String>()
                {
                    public int compare(String obj1, String obj2)
                    {
                        // 升序排序
                        return obj1.compareTo(obj2);
                    }
                });

        m.putAll(map);
        String link = "";
        for (Map.Entry<String, String> entity : m.entrySet())
        {
            if (entity.getValue() == null || entity.getValue().equals(""))
            {
                continue;
            }
            if(entity.getKey().equals("sign"))
            {
                continue;
            }
            link += entity.getKey() + "=" + entity.getValue() + "&";
        }
        link += "key=" + key;
        logger.info("link:"+link);
        String sign= getMD5(link);
        logger.info("sign:"+sign);
        return sign;
    }
    public static boolean verfy(Map<String, String> map, String key, String sign)
    {
        if(StringUtils.isEmpty(sign))
        {
            return  false;
        }
        if (map == null || map.isEmpty())
        {
            return false;
        }
        logger.info("sign:"+sign);
        String makeSign=sign(map,key);
        logger.info("makeSign:"+makeSign);
        return sign.toLowerCase().equals(makeSign);
    }
    public static String getMD5(String code)
    {
        try
        {
            byte[] strTemp = code.getBytes("utf-8");
            // 使用MD5创建MessageDigest对象
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++)
            {
                byte b = md[i];
                // System.out.println((int)b);
                // 将没个数(int)b进行双字节加密
                str[k++] = hexDigits[b >> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }
            return new String(str);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static String getSign(Object obj,String key){

    	if(obj == null){
    		return null;
    	}

    	Map<String, String> responseMap = BeanUtils.getMap(obj);

		String sign = sign(responseMap, key);

    	return sign.toUpperCase();
    }


  /* public static void main (String [] args){
      	PayBackNoticeVo  back = new PayBackNoticeVo();
		back.setGroupIds("654564564564_465456465");
		back.setPayPlatform("alipay_wap");
		back.setOut_trade_no("1456468548654889");
		back.setTransaction_id("32432456445632");
		back.setTrade_type("1");
		back.setTrade_state("1");
		back.setPay_time("2018-06-14 10:45:12");
		back.setNotify_time("2018-06-14 10:45:12");
		FAirportLog.logger.info("支付宝回调入参》》》"+net.sf.json.JSONObject.fromObject(back).toString());
		String sign =SignUtils.getSign(back, ResourceUtils.getProperty("weixin_key"));
		back.setSign(sign);
		String buildLink=LinkUtils.buildLink(BeanUtils.getMap(back));
		FAirportLog.logger.info("获取平台支付宝下单请求参数>>>" + buildLink);
		String url = "https://2012422905.pagekite.me/galy-web/payBackNotice?"+buildLink;
		HttpCommandProvider commandProvider = new HttpCommandProvider();
		String returnse= commandProvider.setGetMethod().setUrl(url).send();
    }*/
}
