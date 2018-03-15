package com.jeecg.controller.giftbook;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: ApiAllTypeCtrl
 * @Description: TODO(意见反馈与关于)
 * @author 张相伟
 * @date 2016年11月8日 下午4:27:01
 */
@Controller
@RequestMapping("/apiFeedbackCtrl")
public class ApiFeedbackCtrl extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ApiGifttypeController.class);


	/**
	 *  意见反馈
	 * 
	 * @param request
	 * @param response
	 */

	@RequestMapping(params = "feedback")
	public ModelAndView feedback(HttpServletRequest request,
							   HttpServletResponse response) {
		return new ModelAndView("com/jeecg/giftbook/api_feedback");
	}

	@RequestMapping(params = "about")
	public ModelAndView about(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("com/jeecg/giftbook/api_about");
	}

}
