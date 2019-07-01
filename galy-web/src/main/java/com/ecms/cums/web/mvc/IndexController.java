package com.ecms.cums.web.mvc;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController extends BaseController implements ServletContextAware {

	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	private String systemName = "GALY";
	private String systemVersion = "20180301";
	private String systemDescription = "豆会玩";
	private Boolean systemShowPowered = true;


	/** servletContext */
	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@RequestMapping("/")
	public void root(HttpServletRequest request, HttpServletResponse response) {
		String contextPath = request.getContextPath();

		try {
			response.sendRedirect(contextPath + "/main");
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
		}
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response) {
		return "common/main";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("systemName", systemName);
		model.addAttribute("systemVersion", systemVersion);
		model.addAttribute("systemDescription", systemDescription);
		model.addAttribute("systemShowPowered", systemShowPowered);
		model.addAttribute("javaVersion", System.getProperty("java.version"));
		model.addAttribute("javaHome", System.getProperty("java.home"));
		model.addAttribute("osName", System.getProperty("os.name"));
		model.addAttribute("osArch", System.getProperty("os.arch"));
		model.addAttribute("serverInfo", servletContext.getServerInfo());
		model.addAttribute("servletVersion", servletContext.getMajorVersion() + "." + servletContext.getMinorVersion());
		return "common/index";
	}

	@RequestMapping("/error")
	public String error() {
		return "common/error";
	}

	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aDate", new Date());
		mav.setViewName("test");
		return mav;
	}

}
