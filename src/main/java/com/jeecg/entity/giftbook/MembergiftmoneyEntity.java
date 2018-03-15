package com.jeecg.entity.giftbook;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 成员礼金记录
 * @author onlineGenerator
 * @date 2016-11-03 17:23:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "membergiftmoney", schema = "")
@SuppressWarnings("serial")
public class MembergiftmoneyEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**组成员id*/
	private String gourpmemberid;
	/**组成员姓名*/
	private String groupmember;
	/**是否支出*/
	private Integer isexpenditure;
	/**金额*/
	private String money;
	/**支出类型编号*/
	private String expendituretype;
	/**支出类型名称*/
	private String expendituretypename;
	/**相关请帖*/
	private String correlativeinvitation;
	/**支出时间*/
	private java.util.Date expendituredate;

	/**状态(0=删除，1正常)*/
	private Integer state;
	private String remark;
	/**创建时间*/
	private java.util.Date createDate;
	/**创建人编号*/
	private String createBy;
	/**创建人姓名*/
	private String createName;
	/**更新时间*/
	private java.util.Date updateDate;
	/**更新人编号*/
	private String updateBy;
	/**更信任姓名*/
	private String updateName;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  Id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组成员id
	 */
	@Column(name ="GOURPMEMBERID",nullable=true,length=32)
	public String getGourpmemberid(){
		return this.gourpmemberid;
	}

	/**
	 *方法: 相关请帖
	 *@param: 相关请帖
	 */
	public void setCorrelativeinvitation(String correlativeinvitation){
		this.correlativeinvitation = correlativeinvitation;
	}
	/**
	 *方法: 相关请帖
	 *@return: 相关请帖
	 */
	@Column(name ="CORRELATIVEINVITATION",nullable=true,length=32)
	public String getCorrelativeinvitation(){
		return this.correlativeinvitation;
	}



	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组成员id
	 */
	public void setGourpmemberid(String gourpmemberid){
		this.gourpmemberid = gourpmemberid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组成员姓名
	 */
	@Column(name ="GROUPMEMBER",nullable=true,length=100)
	public String getGroupmember(){
		return this.groupmember;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组成员姓名
	 */
	public void setGroupmember(String groupmember){
		this.groupmember = groupmember;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否支出
	 */
	@Column(name ="ISEXPENDITURE",nullable=true,length=1)
	public Integer getIsexpenditure(){
		return this.isexpenditure;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否支出
	 */
	public void setIsexpenditure(Integer isexpenditure){
		this.isexpenditure = isexpenditure;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  金额
	 */
	@Column(name ="MONEY",nullable=true,scale=2,length=10)
	public String getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  金额
	 */
	public void setMoney(String money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支出类型编号
	 */
	@Column(name ="EXPENDITURETYPE",nullable=true,length=10)
	public String getExpendituretype(){
		return this.expendituretype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支出类型编号
	 */
	public void setExpendituretype(String expendituretype){
		this.expendituretype = expendituretype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支出类型名称
	 */
	@Column(name ="EXPENDITURETYPENAME",nullable=true,length=100)
	public String getExpendituretypename(){
		return this.expendituretypename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支出类型名称
	 */
	public void setExpendituretypename(String expendituretypename){
		this.expendituretypename = expendituretypename;
	}


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支出时间
	 */
	@Column(name ="EXPENDITUREDATE",nullable=true,length=100)
	public java.util.Date getExpendituredate(){
		return this.expendituredate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支出时间
	 */
	public void setExpendituredate(java.util.Date expendituredate){
		this.expendituredate = expendituredate;
	}


	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态(0=删除，1正常)
	 */
	@Column(name ="STATE",nullable=true,length=10)
	public Integer getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态(0=删除，1正常)
	 */
	public void setState(Integer state){
		this.state = state;
	}

	@Column(name ="REMARK",nullable=true,length=255)
	public String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态(0=删除，1正常)
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人编号
	 */
	@Column(name ="CREATE_BY",nullable=true,length=100)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人编号
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人姓名
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=100)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人姓名
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人编号
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=100)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人编号
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更信任姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更信任姓名
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
}
