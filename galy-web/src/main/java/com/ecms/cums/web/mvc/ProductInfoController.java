package com.ecms.cums.web.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecms.cums.logutils.FunOrderLog;
import com.ecms.cums.utils.StringReaderUtils;
import com.google.gson.JsonSyntaxException;

/**
 * @ClassName: ProductInfoController
 * @Description: 旅游产品-聚合国旅等多供应商
 * @author: zJin
 * @date: 2018年4月8日 上午11:39:42
 */
@Controller
@RequestMapping("/productInfoController")
public class ProductInfoController extends BaseController {

    /**
     * @return
     * @Title: getProductInfoByPrimaryId
     * @Description: 通过产品id获取产品详情信息
     * @return: Response
     */
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = "application/json")
    public void getProductInfoByPrimaryId(HttpServletRequest request, HttpServletResponse response) {
        String reqJSON = null;
        try {
            reqJSON = StringReaderUtils.readFromIO(request.getInputStream());
            FunOrderLog.logger.info("报案请求参数>>>" + reqJSON);
            JSONObject param = JSONObject.fromObject(reqJSON);
            JSONObject body = param.getJSONObject("body");
            String productId = body.getString("productId");
            /*根据产品id获得产品详细信息*/
        } catch (IOException e) {
            FunOrderLog.logger.error("请求流解析异常", e);
            this.getErrorResponse(response, "请求流解析异常");
        } catch (JsonSyntaxException e) {
            FunOrderLog.logger.error("解析json转化异常", e);
            this.getErrorResponse(response, "解析json转化异常");
        } catch (Exception e) {
            FunOrderLog.logger.error("解析json转化异常", e);
            this.getErrorResponse(response, "操作失败");
        }
    }
}
