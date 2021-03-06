package com.jeecg.service.impl.giftbook;

import com.jeecg.entity.giftbook.VReceivingMoneyEntity;
import com.jeecg.service.giftbook.VReceivingMoneyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("vReceivingMoneyService")
@Transactional
public class VReceivingMoneyServiceImpl extends CommonServiceImpl implements VReceivingMoneyServiceI {

	
 	public void delete(VReceivingMoneyEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VReceivingMoneyEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VReceivingMoneyEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VReceivingMoneyEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(VReceivingMoneyEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(VReceivingMoneyEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(VReceivingMoneyEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("title", t.getTitle());
		map.put("createdate", t.getCreatedate());
		map.put("createby", t.getCreateby());
		map.put("id", t.getId());
		map.put("typeid", t.getTypeid());
		map.put("receivestype", t.getReceivestype());
		map.put("summoney", t.getSummoney());
		map.put("num", t.getNum());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VReceivingMoneyEntity t){
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{createdate}",String.valueOf(t.getCreatedate()));
 		sql  = sql.replace("#{createby}",String.valueOf(t.getCreateby()));
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{typeid}",String.valueOf(t.getTypeid()));
 		sql  = sql.replace("#{receivestype}",String.valueOf(t.getReceivestype()));
 		sql  = sql.replace("#{summoney}",String.valueOf(t.getSummoney()));
 		sql  = sql.replace("#{num}",String.valueOf(t.getNum()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}