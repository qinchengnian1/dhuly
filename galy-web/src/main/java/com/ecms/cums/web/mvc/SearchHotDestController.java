package com.ecms.cums.web.mvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.cums.services.SearchHotDestService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("sys/search")
public class SearchHotDestController {
	@Autowired
	private SearchHotDestService searchHotDestService;
	/**
	 * 获取全文检索热门目的地接口
	 * @param body
	 * @param request
	 * @param response
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="getSearchHotDest",method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public String getSearchHotDest(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
			Map<String, Object> reMap = searchHotDestService.getSearchHotDest(jsonbody.toString());
			return (String) reMap.get("responseBody");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 

} 
