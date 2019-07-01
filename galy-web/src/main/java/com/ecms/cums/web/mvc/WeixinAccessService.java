package com.ecms.cums.web.mvc;

import com.alibaba.fastjson.JSONObject;
import com.ecms.cums.model.User;
import com.ecms.cums.services.UserService;
import com.ecms.cums.utils.*;
import com.ecms.cums.utils.account.AccountUtils;
import com.ecms.cums.utils.account.AppKeyProperties;
import com.ecms.cums.utils.redis.RedisUtils;
import com.ecms.cums.web.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WeixinAccessService extends BaseController {
//    private static final String WEIXIN_MSG_DECODING = "昵称解码错误";
//    private static final String WEIXIN_MSG_CALLBACKURL_ERROR = "获取微信回调地址错误";
//    private static final String WEIXIN_ACCOUNT_INFO = "https://api.weixin.qq.com/sns/userinfo?";
//    private static final String WEIXIN_ORDINARY_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?";
//    private static final String WEIXIN_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";
//    private static final String WEIXIN_ORDINARY_USERINFO = "https://api.weixin.qq.com/cgi-bin/user/info?";
//    private static final String WEIXIN_AUTH_CODEGUIDLE = "https://open.weixin.qq.com/connect/oauth2/authorize?";
//    private static final String WEIIXN_CODE_PARAMPIX_MODE = "#wechat_redirect";
//    private static final String WEIXIN_TOKEN_CACAHE_PERFIX = "accountcenter:weixin:token";
    @Resource
    private RedisUtils redisUtils;
    private static final Logger logger = LoggerFactory.getLogger(LoginIntegerController.class);

    @Autowired
    private UserService userService;

    public WeixinAccessService() {
    }

    @RequestMapping("weixin/getcode")
    public Result<Object> gameServiceGuidleAuthUrl(String url) {
        try {
            url = URLEncoder.encode(url, "UTF-8");
            Map<String, Object> codeMap = new HashMap();
            codeMap.put("appid", WeixinAccessService.WeixinConfig.appid);
            codeMap.put("scope", WeixinAccessService.WeixinConfig.scope);
            codeMap.put("redirect_uri", url);
            codeMap.put("state", WeixinAccessService.WeixinConfig.state);
            String codeUrl = AccountUtils.getUrlStr(codeMap, "https://open.weixin.qq.com/connect/oauth2/authorize?");
            codeUrl = codeUrl + "#wechat_redirect";

            return new ResultUtil<>().setSuccessMsg(codeUrl);
        } catch (UnsupportedEncodingException var4) {
            return new ResultUtil<>().setErrorMsg("回调地址错误");
        }
    }

    // 发送回调地址
    @RequestMapping("/weixin/guidleauth")
    public RedirectView appGuidleAuthUrl(String url) {
        RedirectView view = new RedirectView();
        try {
            url = URLEncoder.encode(WeixinAccessService.WeixinConfig.redictUrl, "utf-8");
        } catch (UnsupportedEncodingException var5) {
            logger.error("url encode错误", var5);
        }
        Map<String, Object> codeMap = new HashMap();
        codeMap.put("appid", WeixinAccessService.WeixinConfig.appid);
        codeMap.put("scope", WeixinAccessService.WeixinConfig.scope);
        codeMap.put("redirect_uri", url);
        codeMap.put("state", WeixinAccessService.WeixinConfig.state);
        codeMap.put("response_type", "code");
        String codeUrl = AccountUtils.getUrlStr(codeMap, "https://open.weixin.qq.com/connect/oauth2/authorize?");
        codeUrl = codeUrl + "#wechat_redirect";
        view.setUrl(codeUrl);
        return view;
    }

        // 测试验证
    @RequestMapping("/weixin/authinfoReg")
    public String appGuidleAuthUrl(String url, String echostr) {
        return echostr;
    }

    // 回调接口
    @RequestMapping("/weixin/authinfo")
    public Result<Object> authLogin(String code) {
        String result = this.getAccessToken(code);
        if (this.result(result).equals("NO")) {
            return new ResultUtil<>().setErrorMsg("获取code失败");
        } else {
            JSONObject jsonObj = JSONObject.parseObject(result);
            return this.weixinReg(jsonObj.getString("access_token"), jsonObj.getString("openid"));
        }
    }

    // 通过code获取授权touken
    private String getAccessToken(String code) {
        Map<String, Object> tokenMap = new HashMap();
        tokenMap.put("appid", WeixinAccessService.WeixinConfig.appid);
        tokenMap.put("secret", WeixinAccessService.WeixinConfig.appsercte);
        tokenMap.put("code", code);
        tokenMap.put("grant_type", "authorization_code");
        String tokenUrl = AccountUtils.getUrlStr(tokenMap, "https://api.weixin.qq.com/sns/oauth2/access_token?");
        return HttpUtils.sendHttpGet(tokenUrl);
    }

    // 微信登录 获取信息
    private Result<Object> weixinReg(String token, String openid) {
        String result = this.getAuthInfo(token, openid);
        if ("NO".equals(this.result(result))) {
            return new ResultUtil<>().setErrorMsg("登录失败");
        } else {
            User entity;
            try {
                entity = this.buildAuthCreatMap(result);
            } catch (Exception var6) {
                var6.printStackTrace();
                return new ResultUtil<>().setErrorMsg("昵称解码错误");
            }
            return new ResultUtil<>().setData(userService.builderInfoMap(entity));
        }
    }

    /**
     * 根据授权token和openId获取用户信息
     * @param token
     * @param openid
     * @return
     */
    private String getAuthInfo(String token, String openid) {
        Map<String, Object> infoMap = new HashMap();
        infoMap.put("access_token", token);
        infoMap.put("openid", openid);
        infoMap.put("lang", "zh_CN");
        String infoUrl = AccountUtils.getUrlStr(infoMap, "https://api.weixin.qq.com/sns/userinfo?");
        String result = HttpUtils.sendHttpGet(infoUrl);
        return result;
    }

    // 构造用户信息
    private User buildAuthCreatMap(String result) throws Exception {
        Map<String, Object> map = new HashMap();
        JSONObject jsonObj = JSONObject.parseObject(result);
        String weixin = jsonObj.getString("unionid");
        if (StringUtils.isEmpty(weixin)) {
            weixin = jsonObj.getString("openid");
        }
        User entity = null;
        Integer key = this.userService.checkUserLoginByOpenId(weixin);
        if (key != 0) {
            entity = this.userService.getUserInfoByPrimaryKey(key);
        }
        String nickname = jsonObj.getString("nickname");
        String headImgUrl = jsonObj.getString("headimgurl");
        byte sex = jsonObj.getByteValue("sex");
        if (!StringUtils.isEmpty(nickname)) {
            nickname = new String(nickname.getBytes("ISO-8859-1"), "utf-8");
        }
        if (StringUtils.isEmpty(headImgUrl)) {
            headImgUrl = "";
        }
        if (entity == null) {
            entity = new User();
            entity.setOpenId(weixin);
            entity.setNickName(nickname);
            entity.setHeadUrl(headImgUrl);
            entity.setSex(sex + "");
            this.userService.insertUser(entity);
        } else {
            if (entity.getNickName() != null && !entity.getNickName().equals(nickname)) {
                entity.setNickName(nickname);
            }
            if (entity.getHeadUrl() != null && !entity.getHeadUrl().equals(nickname)) {
                entity.setHeadUrl(headImgUrl);
            }
            if (entity.getSex() != null && !entity.getHeadUrl().equals(sex)) {
                entity.setSex(sex + "");
            }
            userService.updateUserInfo(entity);
        }
        return entity;
    }

    /**
     * 回去unionId
     * @param token
     * @param openId
     * @return
     */
    private String getUnionId(String token, String openId) {
        Map<String, Object> regMap = new HashMap();
        regMap.put("access_token", token);
        regMap.put("openid", openId);
        String url = AccountUtils.getUrlStr(regMap, "https://api.weixin.qq.com/cgi-bin/user/info?");
        token = HttpUtils.sendHttpGet(url);
        JSONObject jsonObj = JSONObject.parseObject(token);
        return jsonObj.getString("unionid");
    }

    // 获取普通access_toke
    private String getToken() {
        String token = this.redisUtils.getStrOps().get("accountcenter:weixin:token");
        return StringUtils.isEmpty(token) ? this.getTokenValue() : token;
    }

    // 获取普通access_toke
    private String getTokenValue() {
        Map<String, Object> regMap = new HashMap();
        regMap.put("grant_type", "client_credential");
        regMap.put("appid", WeixinConfig.appid);
        regMap.put("secret", WeixinConfig.appsercte);
        String url = AccountUtils.getUrlStr(regMap, "https://api.weixin.qq.com/cgi-bin/token?");
        String result = HttpUtils.sendHttpGet(url);
        JSONObject jsonObj = JSONObject.parseObject(result);
        result = jsonObj.getString("access_token");
        if (StringUtils.isEmpty(result)) {
            return null;
        } else {
            this.redisUtils.getStrOps().setWithExpire("accountcenter:weixin:token", result, 7200L);
            return result;
        }
    }

    private String result(String result) {
        if (StringUtils.isEmpty(result)) {
            return "NO";
        } else {
            JSONObject jsonObject = JSONObject.parseObject(result);
            return StringUtils.isEmpty(jsonObject.getString("errcode")) ? "YES" : "NO";
        }
    }

    @Component
    private static class WeixinConfig {
        private static String appid = AppKeyProperties.get("weixin.appid");
        private static String scope = AppKeyProperties.get("weixin.scope");
        private static String state = AppKeyProperties.get("weixin.state");
        private static String appsercte = AppKeyProperties.get("weixin.secret");
        private static String redictUrl = AppKeyProperties.get("weixin.redirect_uri");

        private WeixinConfig() {
        }

    }
}