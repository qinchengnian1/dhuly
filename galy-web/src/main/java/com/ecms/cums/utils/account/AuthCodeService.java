package com.ecms.cums.utils.account;

import com.ecms.cums.utils.MLSendSMS;
import com.ecms.cums.utils.aliyun.AliyunDysmsUtils;
import com.ecms.cums.utils.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 验证码
 * @author QinChengNian
 */
@Component
public class AuthCodeService {

    private static final Logger logger = LoggerFactory.getLogger(AuthCodeService.class);
    private static final long CODE_EXPIRETIME = 60L;
    public static final String AUTHCODE_CACHE_PERFIX = "accountcenter:authcode:";
    public static final String REG_CACHE_KEY = "accountcenter:authcode:reg";
    public static final String LOGIN_CACHE_KEY = "accountcenter:authcode:login";
    public static final String PASS_MODIFY_CACHE_KEY = "accountcenter:authcode:passmodify";
    public static final String INFO_MODIFY_CACHE_KEY = "accountcenter:authcode:infomodify";
    @Resource
    private RedisUtils redisUtils;

    public AuthCodeService() {
    }

//    public boolean sendCode(String email, String cacheKey, String emailPix) {
//        cacheKey = this.redisUtils.toDynamicKey(cacheKey, email);
//        String code = this.redisUtils.getStrOps().get(cacheKey);
//        if (code != null) {
//            return false;
//        } else {
//            code = AliyunDysmsUtils.generalCode();
//            boolean result = SendEmailUtils.sendEmail(email, emailPix + code);
//            if (result) {
//                this.redisUtils.getStrOps().setWithExpire(cacheKey, code, 180L);
//            }
//
//            return result;
//        }
//    }

    public boolean sendCode(long phone, String cacheKey) {
        cacheKey = this.redisUtils.toDynamicKey(cacheKey, phone);
        String code = this.redisUtils.getStrOps().get(cacheKey);
        if (code != null) {
            return false;
        } else {
            code = AliyunDysmsUtils.generalCode();
//            String errorCode = AliyunDysmsUtils.send(String.valueOf(phone), AliyunDysmsUtils.generalCode());
            if (!MLSendSMS.sendSMS(String.valueOf(phone), code)) {
                logger.error("发送手机验证码出现错误，错误码：" + code + "手机号：" + phone);
                return false;
            } else {
                this.redisUtils.getStrOps().setWithExpire(cacheKey, code, 60L * 2);
                return true;
            }
        }
    }

    public String compareCode(Object account, String cacheKey, String code) {
        if (StringUtils.isEmpty(code)) {
            return "验证码不能为空";
        } else {
            cacheKey = this.redisUtils.toDynamicKey(cacheKey, account);
            String oldCode = this.redisUtils.getStrOps().get(cacheKey);
            if (StringUtils.isEmpty(oldCode)) {
                return "验证码失效，请重新发送";
            } else if (!oldCode.equals(code)) {
                return "验证码匹配错误，请重新输入";
            } else {
                this.redisUtils.deleteKey(new String[]{cacheKey});
                return "YES";
            }
        }
    }

}
