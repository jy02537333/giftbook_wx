package com.jeecg.entity.giftbook;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 金融超市
 * @author onlineGenerator
 * @date 2017-02-21 14:54:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "financial_supermarket", schema = "")
@SuppressWarnings("serial")
public class FinancialSupermarketEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**第三方公司名称*/
	private String thirdpartyname;
	/**第三方公司关键字*/
	private String thirdpartycode;
	/**第三方公司关键字2*/
	private String thirdpartycode2;
	/**第三方地址*/
	private String thirdpartyaddr;
	/**描述*/
	private String description;
	/**贷款额度*/
	private String moneylimit;
	/**logo*/
	private String logourl;
	/**贷款利息*/
	private String moneyinterest;
	/**创建时间*/
	private Date createDate;
	/**创建人编号*/
	private String createBy;
	/**创建人姓名*/
	private String createName;
	/**更新时间*/
	private Date updateDate;
	/**更新人编号*/
	private String updateBy;
	/**更新人姓名*/
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
	 *@return: java.lang.String  第三方公司名称
	 */
	@Column(name ="THIRDPARTYNAME",nullable=true,length=200)
	public String getThirdpartyname(){
		return this.thirdpartyname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方公司名称
	 */
	public void setThirdpartyname(String thirdpartyname){
		this.thirdpartyname = thirdpartyname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第三方公司关键字
	 */
	@Column(name ="THIRDPARTYCODE",nullable=true,length=200)
	public String getThirdpartycode(){
		return this.thirdpartycode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方公司关键字
	 */
	public void setThirdpartycode(String thirdpartycode){
		this.thirdpartycode = thirdpartycode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第三方公司关键字2
	 */
	@Column(name ="THIRDPARTYCODE2",nullable=true,length=200)
	public String getThirdpartycode2(){
		return this.thirdpartycode2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方公司关键字2
	 */
	public void setThirdpartycode2(String thirdpartycode2){
		this.thirdpartycode2 = thirdpartycode2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  第三方地址
	 */
	@Column(name ="THIRDPARTYADDR",nullable=true,length=500)
	public String getThirdpartyaddr(){
		return this.thirdpartyaddr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  第三方地址
	 */
	public void setThirdpartyaddr(String thirdpartyaddr){
		this.thirdpartyaddr = thirdpartyaddr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="DESCRIPTION",nullable=true,length=500)
	public String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款额度
	 */
	@Column(name ="MONEYLIMIT",nullable=true,length=100)
	public String getMoneylimit(){
		return this.moneylimit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款额度
	 */
	public void setMoneylimit(String moneylimit){
		this.moneylimit = moneylimit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  logo
	 */
	@Column(name ="LOGOURL",nullable=true,length=255)
	public String getLogourl(){
		return this.logourl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  logo
	 */
	public void setLogourl(String logourl){
		this.logourl = logourl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款利息
	 */
	@Column(name ="MONEYINTEREST",nullable=true,length=100)
	public String getMoneyinterest(){
		return this.moneyinterest;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款利息
	 */
	public void setMoneyinterest(String moneyinterest){
		this.moneyinterest = moneyinterest;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(Date createDate){
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
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateDate(Date updateDate){
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
	 *@return: java.lang.String  更新人姓名
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=100)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人姓名
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
}
