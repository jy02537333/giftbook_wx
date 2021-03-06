
package com.jeecg.controller.giftbook;

import com.jeecg.entity.giftbook.FinancialSupermarketEntity;
import com.jeecg.entity.giftbook.GifttypeEntity;
import com.jeecg.service.giftbook.FinancialSupermarketServiceI;
import com.jeecg.service.giftbook.GifttypeServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.entity.AjaxJson;
import org.jeecgframework.core.util.AjaxReturnTool;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.TokenVerifyTool;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


/**   
 * @Title: Controller
 * @Description: 礼金类型
 * @author zhangdaihao
 * @date 2016/11/4 14:08:41
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/apiGifttypeCtrl")
public class ApiGifttypeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ApiGifttypeController.class);

	@Autowired
	private GifttypeServiceI gifttypeService;
	@Autowired
	private FinancialSupermarketServiceI financialSupermarketService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	
	/**
	 * AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public Object datagrid(GifttypeEntity gifttype, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		dataGrid.setField("id,dtid,typename,parentid,createDate,createBy,createName,updateDate,updateBy,updateName,");
		CriteriaQuery cq = new CriteriaQuery(GifttypeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, gifttype, request.getParameterMap());
		try{
			cq.eq("userid", request.getParameter("userid"));
			cq.eq("isDefault", request.getParameter("1"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.gifttypeService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}
	
	@RequestMapping(params = "datagrid2")
	@ResponseBody
	public Object datagrid2(GifttypeEntity gifttype,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dataGrid.setField("id,dtid,typename,parentid,createDate,createBy,createName,updateDate,updateBy,updateName,");
		CriteriaQuery cq = new CriteriaQuery(GifttypeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, gifttype, request.getParameterMap());
		try{
			cq.eq("userid", request.getParameter("userid"));
			cq.eq("isDefault", request.getParameter("1"));
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.gifttypeService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}
	
	@RequestMapping(params = "getAll")
	@ResponseBody
	public Object getAll(FinancialSupermarketEntity gifttype,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		response.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域访问报错 
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间 
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1. 
		response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0"); 
		dataGrid.setField(//"id,dtid,typename,parentid,createDate,createBy,createName,updateDate,updateBy,updateName,");
		"id,thirdpartyname,thirdpartycode,thirdpartycode2,thirdpartyaddr,description,moneylimit,logourl,moneyinterest,createDate");
		
		CriteriaQuery cq = new CriteriaQuery(FinancialSupermarketEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, gifttype, request.getParameterMap());
		try{
		//	cq.eq("userid", request.getParameter("userid"));
			//cq.eq("isDefault", request.getParameter("1"));
			cq.addOrder("createDate", SortDirection.asc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.financialSupermarketService.getDataGridReturn(cq, true);
		return AjaxReturnTool.retJsonp(
				AjaxReturnTool.hanlderPage(dataGrid), request,response);
	}
	

	/**
	 * 删除礼金类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public Object doDel(GifttypeEntity gifttype, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
		{
			return AjaxReturnTool.emptyKey();
		}
		String message = null;
		AjaxJson j = new AjaxJson();
		gifttype = systemService.getEntity(GifttypeEntity.class, gifttype.getId());
		message = "礼金类型删除成功";
		try{
			gifttypeService.delete(gifttype);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金类型删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
	    return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 批量删除礼金类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public Object doBatchDel(String ids,HttpServletRequest request,HttpServletResponse response){
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型删除成功";
		try{
			for(String id:ids.split(",")){
				GifttypeEntity gifttype = systemService.getEntity(GifttypeEntity.class, 
						id
						);
				gifttypeService.delete(gifttype);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
			j.setResult(1);
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金类型删除失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	/**
	 * 添加礼金类型
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public Object doAdd(GifttypeEntity gifttype, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		gifttype.setCreateDate(new Date());
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型添加成功";
		try{
		Serializable  obj=	gifttypeService.save(gifttype);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			if(obj==null)
				j.setResult(0);
			else
				{
				j.setResult(1);
				gifttype.setId(obj.toString());
				j.setObj(gifttype);
				}
		}catch(Exception e){
			e.printStackTrace();
			message = "礼金类型添加失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	/**
	 * 更新礼金类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public Object doUpdate(GifttypeEntity gifttype, HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "礼金类型更新成功";
		GifttypeEntity t = gifttypeService.get(GifttypeEntity.class, gifttype.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(gifttype, t);
			gifttypeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			j.setResult(1);
		} catch (Exception e) {
			e.printStackTrace();
			message = "礼金类型更新失败";
			j.setResult(3);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return AjaxReturnTool.retJsonp(j, request,response);
	}


	


	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object get(@PathVariable("id") String id,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		GifttypeEntity task = gifttypeService.get(GifttypeEntity.class, id);
		if (task == null) {
			j.setResult(2);
		}
		else {
			j.setObj(task);
			j.setResult(1);
		}
		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object create(@RequestBody GifttypeEntity gifttype, UriComponentsBuilder uriBuilder
			,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson j=new AjaxJson();
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<GifttypeEntity>> failures = validator.validate(gifttype);
		if (!failures.isEmpty()) {
			j.setResult(1);
		}

		//保存
		try{
			gifttypeService.save(gifttype);
		} catch (Exception e) {
			e.printStackTrace();
			j.setResult(3);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = gifttype.getId();

		return AjaxReturnTool.retJsonp(j, request,response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody GifttypeEntity gifttype) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<GifttypeEntity>> failures = validator.validate(gifttype);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			gifttypeService.saveOrUpdate(gifttype);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(params = "delete",value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("id") String id
			,HttpServletRequest request,HttpServletResponse response) {
		if(TokenVerifyTool.verify(request))
			return AjaxReturnTool.emptyKey();
		AjaxJson json=new AjaxJson();
		try {
			gifttypeService.deleteEntityById(GifttypeEntity.class, id);
			json.setResult(1);
			json.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(3);
			json.setMsg("删除发生异常！");
		}
		return AjaxReturnTool.retJsonp(json, request,response);
	}
	
	public static void main(String[] args) {
		Long l= System.currentTimeMillis(); //1488096621l;//1488094255
		System.out.println(l);
		Date date=new Date(1488098049000l);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//小写的mm表示的是分钟  
		System.out.println(sdf.format(date));
	}
}




     





































