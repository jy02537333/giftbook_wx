package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.FinancialEntity;
import com.jeecg.service.giftbook.FinancialServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.tag.core.easyui.TagUtil;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: 金融超市
 * @author onlineGenerator
 * @date 2017-02-14 17:48:41
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiFinancialController")
public class ApiFinancialController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiFinancialController.class);

	@Autowired
	private FinancialServiceI financialService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 金融超市列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/giftbook/api_financialList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(FinancialEntity financial, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,thirdpartyname,thirdpartycode,thirdpartycode2,thirdpartyaddr,describe,moneylimit,moneyinterest,create_date");
		CriteriaQuery cq = new CriteriaQuery(FinancialEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, financial, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.financialService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除金融超市
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(FinancialEntity financial, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		financial = systemService.getEntity(FinancialEntity.class, financial.getId());
		message = "金融超市删除成功";
		try{
			financialService.delete(financial);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "金融超市删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除金融超市
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "金融超市删除成功";
		try{
			for(String id:ids.split(",")){
				FinancialEntity financial = systemService.getEntity(FinancialEntity.class,
				id
				);
				financialService.delete(financial);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "金融超市删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加金融超市
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(FinancialEntity financial, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "金融超市添加成功";
		try{
			financial.setCreateDate(new Date());
			financialService.save(financial);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "金融超市添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新金融超市
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(FinancialEntity financial, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "金融超市更新成功";
		FinancialEntity t = financialService.get(FinancialEntity.class, financial.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(financial, t);
			financialService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "金融超市更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 金融超市新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(FinancialEntity financial, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(financial.getId())) {
			financial = financialService.getEntity(FinancialEntity.class, financial.getId());
			req.setAttribute("financialPage", financial);
		}
		return new ModelAndView("com/jeecg/giftbook/financial-add");
	}
	/**
	 * 金融超市编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(FinancialEntity financial, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(financial.getId())) {
			financial = financialService.getEntity(FinancialEntity.class, financial.getId());
			req.setAttribute("financialPage", financial);
		}
		return new ModelAndView("com/jeecg/giftbook/financial-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","financialController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(FinancialEntity financial, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
//		CriteriaQuery cq = new CriteriaQuery(FinancialEntity.class, dataGrid);
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, financial, request.getParameterMap());
//		List<FinancialEntity> financials = this.financialService.getListByCriteriaQuery(cq,false);
//		modelMap.put(NormalExcelConstants.FILE_NAME,"金融超市");
//		modelMap.put(NormalExcelConstants.CLASS,FinancialEntity.class);
//		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("金融超市列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//			"导出信息"));
//		modelMap.put(NormalExcelConstants.DATA_LIST,financials);
//		return NormalExcelConstants.JEECG_EXCEL_VIEW;
		return null;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(FinancialEntity financial, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
//    	modelMap.put(NormalExcelConstants.FILE_NAME,"金融超市");
//    	modelMap.put(NormalExcelConstants.CLASS,FinancialEntity.class);
//    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("金融超市列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
//    	"导出信息"));
//    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
//    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
		return null;
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
//			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<FinancialEntity> listFinancialEntitys = (	List<FinancialEntity>)
				ExcelImportUtil.importExcelByIs(file.getInputStream(),FinancialEntity.class,params);
				for (FinancialEntity financial : listFinancialEntitys) {
					financialService.save(financial);
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
	public List<FinancialEntity> list() {
		List<FinancialEntity> listFinancials=financialService.getList(FinancialEntity.class);
		return listFinancials;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		FinancialEntity task = financialService.get(FinancialEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody FinancialEntity financial, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FinancialEntity>> failures = validator.validate(financial);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			financialService.save(financial);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = financial.getId();
		URI uri = uriBuilder.path("/rest/financialController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody FinancialEntity financial) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FinancialEntity>> failures = validator.validate(financial);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			financialService.saveOrUpdate(financial);
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
		financialService.deleteEntityById(FinancialEntity.class, id);
	}
}
