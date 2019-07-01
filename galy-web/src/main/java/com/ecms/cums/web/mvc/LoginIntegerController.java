package com.ecms.cums.web.mvc;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ecms.cums.utils.*;
import com.ecms.cums.utils.account.AccountUtils;
import com.ecms.cums.utils.account.AuthCodeService;
import com.ecms.cums.web.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ecms.cums.model.User;
import com.ecms.cums.services.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * @ClassName: LoginIntegerController
 * @Description: 登录验证接口
 * @author: zJin
 * @date: 2018年3月12日 上午10:51:30
 */
@Controller
@RequestMapping("/login")
public class LoginIntegerController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginIntegerController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthCodeService authCodeService;


    /**
     * 请求登陆验证码
     * @param telephone
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getLoginAuthCode")
    public Result<Object> reqAuthCodeForLogin(Long telephone) {
        if (!AccountUtils.regxPhone(telephone + "")) {
            return new ResultUtil<>().setErrorMsg("手机号不合法，请输入正确得手机号");
        }
        Integer flag = userService.checkUserLogin(telephone.toString());
        if (flag == 0) {
            userService.insertUserTelephone(telephone.toString());
        }
        return !this.authCodeService.sendCode(telephone.longValue(), "accountcenter:authcode:login") ? new ResultUtil<>().setErrorMsg("验证码发送频繁，请稍后再试") : new ResultUtil<>().setSuccessMsg("发送成功");
    }

    /**
     * @throws Exception
     * @Title: checkLogin
     * @Description: 验证用户是否登录  通过用户名 邮箱 登录则不操作，未登录更新本地数据库 保持与平台用户信息同步
     * @return: void
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/checkLogin")
    public Result<Object> checkLogin(@RequestParam Map<String, Object> map) throws Exception {
        try {
            JSONObject param = new JSONObject(map);
            String telephone = param.getString("telephone");
            String authCode = param.getString("authCode");
            if (!AccountUtils.regxPhone(telephone)) {
                return new ResultUtil<>().setErrorMsg("手机号不合法，请输入正确得手机号");
            }
            Integer flag = userService.checkUserLogin(telephone);
            if (flag == 0) {
                flag = userService.insertUserTelephone(telephone);
            }
            String result = this.authCodeService.compareCode(Long.parseLong(telephone), "accountcenter:authcode:login", authCode);
            if (!"YES".equals(result)) {
                return new ResultUtil<>().setErrorMsg("验证码错误");
            } else {
                User us = userService.getUserInfoByPrimaryKey(flag);
                return new ResultUtil<>().setData(userService.builderInfoMap(us));
            }
        } catch (Exception e) {
            return new ResultUtil<>().setErrorMsg("解析异常");
        }
    }

    /**
     * @param request
     * @param response
     * @Title: insertUserInfo
     * @Description: 插入用户信息（邮箱，地址等信息）
     * @return: void
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST, consumes = "application/json")
    public void insertUserInfo(HttpServletRequest request, HttpServletResponse response) {
        String reqJSON = null;
        try {
            reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
            logger.info("报案请求参数>>>" + reqJSON);
            JSONObject param = JSONObject.parseObject(reqJSON);
            JSONObject body = param.getJSONObject("body");
            Gson gson = new Gson();
            User user = gson.fromJson(body.toString(), User.class);
            //更新用户信息
            if (null == user.getUserId()) {
                this.getErrorResponse(response, "用户id不能为空");
                return;
            }
            Boolean ifSuccess = userService.updateUserInfo(user);
            if (!ifSuccess) {
                this.getErrorResponse(response, "请先登录");
                logger.error("请先登录");
            }
            this.getSuccessResponse(response);
        } catch (IOException e) {
            logger.error("请求流解析异常");
            this.getErrorResponse(response, "请求流解析异常");
        } catch (JsonSyntaxException e) {
            logger.error("解析json转化异常");
            this.getErrorResponse(response, "解析json转化异常");
        } catch (Exception e) {
            logger.error("操作异常", e);
            this.getErrorResponse(response);
        }

    }
}
