package com.jeecg.entity.giftbook;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: v_receives_invitation
 * @author onlineGenerator
 * @date 2017-06-02 23:18:08
 * @version V1.0
 *
 */
@Entity
@Table(name = "v_receives_invitation", schema = "")
@SuppressWarnings("serial")
public class VReceivesInvitationEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**邀请人编号*/
	private String inviterid;
	/**收礼名称*/
	private String receivinggiftsname;
	/**宴席时间*/
	private java.util.Date feastdate;
	/**宴席类型*/
	private String feasttype;
	/**封面图片*/
	private String coverimg;
	/**男士姓名*/
	private String manname;
	/**女士姓名*/
	private String womanname;
	/**summoney*/
	private String summoney;
	/**sumcount*/
	private Double sumcount;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=32)
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
	 *@return: java.lang.String  邀请人编号
	 */
	@Column(name ="INVITERID",nullable=true,length=32)
	public String getInviterid(){
		return this.inviterid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人编号
	 */
	public void setInviterid(String inviterid){
		this.inviterid = inviterid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收礼名称
	 */
	@Column(name ="RECEIVINGGIFTSNAME",nullable=true,length=100)
	public String getReceivinggiftsname(){
		return this.receivinggiftsname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收礼名称
	 */
	public void setReceivinggiftsname(String receivinggiftsname){
		this.receivinggiftsname = receivinggiftsname;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  宴席时间
	 */
	@Column(name ="FEASTDATE",nullable=true)
	public java.util.Date getFeastdate(){
		return this.feastdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  宴席时间
	 */
	public void setFeastdate(java.util.Date feastdate){
		this.feastdate = feastdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席类型
	 */
	@Column(name ="FEASTTYPE",nullable=true,length=32)
	public String getFeasttype(){
		return this.feasttype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席类型
	 */
	public void setFeasttype(String feasttype){
		this.feasttype = feasttype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  封面图片
	 */
	@Column(name ="COVERIMG",nullable=true,length=255)
	public String getCoverimg(){
		return this.coverimg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  封面图片
	 */
	public void setCoverimg(String coverimg){
		this.coverimg = coverimg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  男士姓名
	 */
	@Column(name ="MANNAME",nullable=true,length=100)
	public String getManname(){
		return this.manname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  男士姓名
	 */
	public void setManname(String manname){
		this.manname = manname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  女士姓名
	 */
	@Column(name ="WOMANNAME",nullable=true,length=100)
	public String getWomanname(){
		return this.womanname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  女士姓名
	 */
	public void setWomanname(String womanname){
		this.womanname = womanname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  summoney
	 */
	@Column(name ="SUMMONEY",nullable=true,scale=2,length=32)
	public String getSummoney(){
		return this.summoney;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  summoney
	 */
	public void setSummoney(String summoney){
		this.summoney = summoney;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  sumcount
	 */
	@Column(name ="SUMCOUNT",nullable=true,length=23)
	public Double getSumcount(){
		return this.sumcount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  sumcount
	 */
	public void setSumcount(Double sumcount){
		this.sumcount = sumcount;
	}
}
