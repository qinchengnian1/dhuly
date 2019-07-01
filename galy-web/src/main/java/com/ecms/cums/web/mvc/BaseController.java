package com.ecms.cums.web.mvc;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ecms.cums.web.vo.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    private static final String success = "0";

    private static final String successRes = "请求成功";

    private static final String error = "-1";

    private static final String errorRes = "请求失败";

    public void getSuccessResponse(HttpServletResponse response) {
    	Response res = new Response();
    	res.getHeader().put("resCode", success);
    	res.getHeader().put("repDes", successRes);
    	writeJsonResponse(response,res);
	}

    public void getSuccessResponse(HttpServletResponse response,String mes) {
    	Response res = new Response();
    	res.getHeader().put("resCode", success);
    	res.getHeader().put("repDes", mes);
    	writeJsonResponse(response,res);
	}

    public void getSuccessResponseJson(HttpServletResponse response, Map<String,Object> map) {
    	Response res = new Response();
    	res.getHeader().put("resCode", success);
    	res.getHeader().put("repDes", successRes);
    	res.setBody(map);
    	ObjectMapper objectMapper = new ObjectMapper();
    	String glvJson = "";
		try {
			 glvJson = objectMapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	writeJsonResponseJson(response,glvJson);
	}

    public void getSuccessResponse(HttpServletResponse response, Map<String,Object> map) {
    	Response res = new Response();
    	res.getHeader().put("resCode", success);
    	res.getHeader().put("repDes", successRes);
    	res.setBody(map);
    	writeJsonResponse(response,res);
	}

    public void getSuccessResponse(HttpServletResponse response,String mes, Map<String,Object> map) {
    	Response res = new Response();
    	res.getHeader().put("resCode", success);
    	res.getHeader().put("repDes", mes);
    	res.setBody(map);
    	writeJsonResponse(response,res);
	}

    public void getErrorResponse(HttpServletResponse response) {
    	Response res = new Response();
    	res.getHeader().put("resCode", error);
    	res.getHeader().put("repDes", errorRes);
    	writeJsonResponse(response,res);
	}

    public void getErrorResponse(HttpServletResponse response,String mes) {
    	Response res = new Response();
    	res.getHeader().put("resCode", error);
    	res.getHeader().put("repDes", mes);
    	writeJsonResponse(response,res);
	}

    public void getErrorResponse(HttpServletResponse response, Map<String,Object> map) {
    	Response res = new Response();
    	res.getHeader().put("resCode", error);
    	res.getHeader().put("repDes", errorRes);
    	res.setBody(map);
    	writeJsonResponse(response,res);
	}

    public void getErrorResponse(HttpServletResponse response,String mes, Map<String,Object> map) {
    	Response res = new Response();
    	res.getHeader().put("resCode", error);
    	res.getHeader().put("repDes", mes);
    	res.setBody(map);
    	writeJsonResponse(response,res);
	}

    protected void writeJsonResponseJson(HttpServletResponse response, String param) {
    	 response.setContentType("text/html; charset=UTF-8");
         try {
             response.getWriter().write(param);
         } catch (IOException e) {
             logger.error("writing response error : ", e);
         }
    }

    protected void writeJsonResponse(HttpServletResponse response, Response res) {
        response.setContentType("text/html; charset=UTF-8");
        try {
            response.getWriter().write((new Gson()).toJson(res));
        } catch (IOException e) {
            logger.error("writing response error : ", e);
        }

    }

}
