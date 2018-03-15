package com.jeecg.controller.giftbook;

import org.jeecgframework.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * @Title: Controller
 * @Description: truck
 * @author onlineGenerator
 * @date 2018-01-08 20:56:14
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiWxIndexController")
public class ApiWxIndexController extends BaseController {



	/**
	 * truck列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "truck")
	public ModelAndView truck(HttpServletRequest request) {
		return new ModelAndView("weixin/index");
	}

}
