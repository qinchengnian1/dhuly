package com.ecms.cums.utils.account;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户工具类
 * @author QinChengNian
 */
public class AccountUtils {

    private static Pattern phonePattern = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");
    private static Pattern emailPattern = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    private static Pattern accountIdPattern = Pattern.compile("^\\d{19}$");
    private static Pattern passwordPattern = Pattern.compile("^[A-Za-z0-9-~!@#$%^&*()_+{}|:<>?;',.]{5,15}");

    public AccountUtils() {
    }

    /**
     * 验证密码
     * @param password
     * @return
     */
    public static boolean regxPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return true;
        } else {
            Matcher matcher = passwordPattern.matcher(password);
            return !matcher.matches();
        }
    }

    /**
     * 验证用户
     * @param account
     * @return
     */
    public static String regxAccount(String account) {
        if (!StringUtils.isEmpty(account)) {
            Matcher matcher = phonePattern.matcher(account);
            if (matcher.matches()) {
                return "phone";
            }

            matcher = emailPattern.matcher(account);
            if (matcher.matches()) {
                return "email";
            }

            if (regxAccountId(account)) {
                return "id";
            }
        }

        return "NO";
    }

    /**
     * 验证账号id
     * @param account
     * @return
     */
    public static boolean regxAccountId(String account) {
        Long accountId = null;

        try {
            accountId = Long.parseUnsignedLong(account, 36);
            Matcher matcher = accountIdPattern.matcher(String.valueOf(accountId));
            return matcher.matches();
        } catch (Exception var3) {
            return false;
        }
    }

    /**
     * 验证手机
     * @param phone
     * @return
     */
    public static boolean regxPhone(String phone) {
        if (phone == null) {
            return false;
        } else {
            Matcher matcher = phonePattern.matcher(phone);
            return matcher.matches();
        }
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean regxEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        } else {
            Matcher matcher = emailPattern.matcher(email);
            return matcher.matches();
        }
    }

    /**
     * 拼接url参数
     * @param map
     * @param url
     * @return
     */
    public static String getUrlStr(Map<String, Object> map, String url) {
        StringBuffer stringBuffer = new StringBuffer(url);
        Iterator it = map.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry)it.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            stringBuffer.append(key + "=" + value + "&");
        }

        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    /**
     * 格式化昵称
     * @param nickName
     * @return
     */
    public static String formatNickName(String nickName) {
        return StringUtils.isNotBlank(nickName) ? nickName.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "") : nickName;
    }

}
