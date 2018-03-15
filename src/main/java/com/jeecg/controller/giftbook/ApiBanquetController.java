package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.InvitationEntity;
import com.jeecg.entity.giftbook.InvitationlistEntity;
import com.jeecg.service.giftbook.InvitationServiceI;
import com.jeecg.service.giftbook.InvitationlistServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;
import java.util.List;

/**   
 * @Title: Controller  
 * @Description: 请帖详情
 * @author onlineGenerator
 * @date 2017-02-21 14:54:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiBCtrl")
public class ApiBanquetController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiBanquetController.class);

	@Autowired
	private InvitationServiceI invitationService;
	@Autowired
	private InvitationlistServiceI invitationListService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 婚宴信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		String invitationId=request.getParameter("invitationListId");
		List<InvitationlistEntity> invitationlistEntity= invitationListService.findByProperty(
				InvitationlistEntity.class, "id", invitationId);
		if(invitationlistEntity!=null&&invitationlistEntity.size()>0)
		{
		List<InvitationEntity> invitationEntity=invitationService.findByProperty(
				InvitationEntity.class,"id", invitationlistEntity.get(0).getInvitationid());
		InvitationEntity entity=invitationEntity.get(0);
		modelAndView.addObject("invitationEntity", entity);
		modelAndView.addObject("invitationlistEntity", invitationlistEntity.get(0));
		}
		modelAndView.setViewName("com/jeecg/giftbook/api_banquet");
		return modelAndView;
	}
	
	@RequestMapping(params = "test")
	public ModelAndView test(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("com/jeecg/giftbook/test/index");
		return modelAndView;
	}
	
}
