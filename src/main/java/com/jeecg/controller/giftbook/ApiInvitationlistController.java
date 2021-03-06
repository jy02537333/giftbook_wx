package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.InvitationlistEntity;
import com.jeecg.entity.giftbook.VReceivesInvitationEntity;
import com.jeecg.service.giftbook.InvitationlistServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.*;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: 请帖人员列表
 * @author onlineGenerator
 * @date 2017-02-21 15:55:36
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiInvitationlistController")
public class ApiInvitationlistController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiInvitationlistController.class);

	@Autowired
	private InvitationlistServiceI invitationlistService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 请帖人员列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/invitationlistList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(InvitationlistEntity invitationlist, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,invitationid,invitationName,inviteeid,inviteename,inviteephone,state,createDate");
		if (TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		org.jeecgframework.core.entity.AjaxJson j = new org.jeecgframework.core.entity.AjaxJson();

		CriteriaQuery cq = new CriteriaQuery(VReceivesInvitationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, invitationlist, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.addOrder("createDate", SortDirection.desc);
			//
			cq.add();
			this.invitationlistService.getDataGridReturn(cq, true);
			j.setVarList(cq.getResults());
			j.setSumCount(dataGrid.getTotal());
			j.setResult(1);
			j.setMsg("成功！");
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(0);
			j.setMsg("网络异常！");
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	/**
	 * 删除请帖人员列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(InvitationlistEntity invitationlist, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		invitationlist = systemService.getEntity(InvitationlistEntity.class, invitationlist.getId());
		message = "请帖人员列表删除成功";
		try{
			invitationlistService.delete(invitationlist);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "请帖人员列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除请帖人员列表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "请帖人员列表删除成功";
		try{
			for(String id:ids.split(",")){
				InvitationlistEntity invitationlist = systemService.getEntity(InvitationlistEntity.class,
				id
				);
				invitationlistService.delete(invitationlist);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "请帖人员列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加请帖人员列表
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(InvitationlistEntity invitationlist, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "请帖人员列表添加成功";
		try{
			invitationlistService.save(invitationlist);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "请帖人员列表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新请帖人员列表
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(InvitationlistEntity invitationlist, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "请帖人员列表更新成功";
		InvitationlistEntity t = invitationlistService.get(InvitationlistEntity.class, invitationlist.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(invitationlist, t);
			invitationlistService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "请帖人员列表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 请帖人员列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(InvitationlistEntity invitationlist, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(invitationlist.getId())) {
			invitationlist = invitationlistService.getEntity(InvitationlistEntity.class, invitationlist.getId());
			req.setAttribute("invitationlistPage", invitationlist);
		}
		return new ModelAndView("com/jeecg/giftbook/invitationlist-add");
	}
	/**
	 * 请帖人员列表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(InvitationlistEntity invitationlist, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(invitationlist.getId())) {
			invitationlist = invitationlistService.getEntity(InvitationlistEntity.class, invitationlist.getId());
			req.setAttribute("invitationlistPage", invitationlist);
		}
		return new ModelAndView("com/jeecg/giftbook/invitationlist-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","invitationlistController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(InvitationlistEntity invitationlist, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public void exportXlsByT(InvitationlistEntity invitationlist, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setNeedSave(true);
			try {
				List<InvitationlistEntity> listInvitationlistEntitys = (List<InvitationlistEntity>)
						ExcelImportUtil.importExcelByIs(file.getInputStream(),InvitationlistEntity.class,params);
				for (InvitationlistEntity invitationlist : listInvitationlistEntitys) {
					invitationlistService.save(invitationlist);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<InvitationlistEntity> list() {
		List<InvitationlistEntity> listInvitationlists=invitationlistService.getList(InvitationlistEntity.class);
		return listInvitationlists;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		InvitationlistEntity task = invitationlistService.get(InvitationlistEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody InvitationlistEntity invitationlist, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<InvitationlistEntity>> failures = validator.validate(invitationlist);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			invitationlistService.save(invitationlist);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = invitationlist.getId();
		URI uri = uriBuilder.path("/rest/invitationlistController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody InvitationlistEntity invitationlist) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<InvitationlistEntity>> failures = validator.validate(invitationlist);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			invitationlistService.saveOrUpdate(invitationlist);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		invitationlistService.deleteEntityById(InvitationlistEntity.class, id);
	}
}
