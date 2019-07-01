package com.ecms.cums.web.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.cums.model.Tourist;
import com.ecms.cums.ordervo.Message;
import com.ecms.cums.services.TouristService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sys/tourist")
public class TouristController extends BaseController{
	@Autowired
	private	TouristService touristService;
	//根据旅客id进行查询返回旅客的详细信息
		@CrossOrigin
		@ResponseBody
		@RequestMapping(value="checkTouristInfo" ,method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
		public void checkTouristInfo(@RequestBody String body,HttpServletRequest request,HttpServletResponse response){
			JSONObject param= JSONObject.fromObject(body);
			JSONObject jsonbody = param.getJSONObject("body");
		try {
			Tourist tourist =  (Tourist) touristService.selectTourist(Integer.parseInt((String)jsonbody.get("touristId")));
			if(tourist==null){
				this.getErrorResponse(response, "查询失败无数据");
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("tourist", tourist);
				this.getSuccessResponseJson(response, map);
			}
		} catch (NumberFormatException e) {
			this.getErrorResponse(response, "系统异常");
			e.printStackTrace();
		}
	}
	//根据用户id进行查询返回旅客的列表
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="checkTouristList" ,method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void checkTouristList(@RequestBody String body,HttpServletRequest request,HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		List<Tourist> tourist;
		try {
			tourist = this.touristService.checkTouristList(Integer.parseInt((String)jsonbody.get("userId")));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tourist", tourist);
			this.getSuccessResponseJson(response, map);
		} catch (NumberFormatException e) {
			this.getErrorResponse(response, "系统异常");
			e.printStackTrace();
		}
	}
	//旅客插入数据库中
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="touristSubmit" ,method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void touristSubmit1(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response) throws ParseException{
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		Message ms;
		try {
			ms = new Message();
			ms.getHeader().put("resCode", "0");
			Tourist tourist = new Tourist();
			//用户id
			if(StringUtils.isBlank((String) jsonbody.get("userId"))){
				ms.getHeader().put("resMsg", "用户id为空");
			}
			tourist.setUserId(Integer.parseInt((String) jsonbody.get("userId")));
			//旅客名称
			if(StringUtils.isBlank((String) jsonbody.get("touristName"))){
				ms.getHeader().put("resMsg", "旅客名称为空");
			}
			tourist.setTouristName((String)jsonbody.get("touristName"));
			//英文名称
			tourist.setTouristNamePy((String)jsonbody.get("touristNamePY")==""?null:(String)jsonbody.get("touristNamePY"));
			//手机号
			if(StringUtils.isBlank((String) jsonbody.get("roommateMobile"))){
				ms.getHeader().put("resMsg", "手机号为空");
			}
			tourist.setTelephone((String)jsonbody.get("roommateMobile"));
			//生日
			tourist.setRouristBirthday((String)jsonbody.get("touristBirthDate")==""?null:(String)jsonbody.get("touristBirthDate"));
			//国籍
			tourist.setTouristNationId("2");
			//出生地址
			tourist.setRouristRegPlace((String)jsonbody.get("touristRegPlace")==""?null:(String)jsonbody.get("touristRegPlace"));
			//性别
			tourist.setSex((String)jsonbody.get("touristSex")==""?null:(String)jsonbody.get("touristSex"));
			//成人/儿童
			tourist.setPasgType((String)jsonbody.get("pasgType")==""?null:(String)jsonbody.get("pasgType"));
			//证件类型
			tourist.setCardType((String)jsonbody.get("touristCredType")==""?null:(String)jsonbody.get("touristCredType"));
			//身份证号码
			if(StringUtils.isBlank((String) jsonbody.get("touristCredId"))){
				ms.getHeader().put("resMsg", "证件号码为空");
			}
			tourist.setCardNo((String)jsonbody.get("touristCredId"));
			//状态
			tourist.setState("1");
			//旅客id
			if(jsonbody.get("touristId")==null || jsonbody.get("touristId").equals("")){
				//创建时间
				tourist.setCreateTime(new Date());
				touristService.touristSubmit(tourist);
				this.getSuccessResponse(response, "增加成功");
			}else{
				tourist.setTouristId(Integer.parseInt((String) jsonbody.get("touristId")));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
				tourist.setCreateTime(format.parse(jsonbody.get("createTime").toString()));
				tourist.setUpdatTime(new Date());
				touristService.updateTourist(tourist);
				this.getSuccessResponse(response, "修改成功");
			}
		} catch (NumberFormatException e) {
			this.getErrorResponse(response, "系统异常");
			e.printStackTrace();
		}
	}
		/**
		 * 根据用户查询删除旅客信息
		 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="delectTourist" ,method=RequestMethod.POST,consumes="application/json",produces="text/html;charset=UTF-8")
	public void delectTourist(@RequestBody String body,HttpServletRequest request,
			HttpServletResponse response){
		JSONObject param= JSONObject.fromObject(body);
		JSONObject jsonbody = param.getJSONObject("body");
		try {
		    touristService.delectTourist(Integer.parseInt((String)jsonbody.get("touristId")));
			this.getSuccessResponse(response, "删除成功");
		} catch (NumberFormatException e) {
			this.getErrorResponse(response, "系统异常");
			e.printStackTrace();
		}
	}

}
