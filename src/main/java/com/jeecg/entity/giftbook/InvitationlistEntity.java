package com.jeecg.entity.giftbook;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: 请帖人员列表
 * @author onlineGenerator
 * @date 2017-02-21 15:55:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "invitationlist", schema = "")
@SuppressWarnings("serial")
public class InvitationlistEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**请帖编号*/
	private String invitationid;
	/**邀请人信息*/
	private String invitationName;
	/**被邀请人*/
	private String inviteeid;
	/**被邀请人*/
	private String inviteename;
	/**男士*/
	private String manname;
	/**女士*/
	private String womanname;
	/**被邀请人电话*/
	private String inviteephone;
	/**状态(0=删除，1正常)*/
	private Integer state;
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
	/**是否已经发送短信(0未发送，1已发送)*/
	private Integer issend;
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
	 *@return: java.lang.String  请帖编号
	 */
	@Column(name ="INVITATIONID",nullable=true,length=32)
	public String getInvitationid(){
		return this.invitationid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请帖编号
	 */
	public void setInvitationid(String invitationid){
		this.invitationid = invitationid;
	}


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人信息
	 */
	@Column(name ="INVITATIONNAME",nullable=true,length=32)
	public String getInvitationName(){
		return this.invitationName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人信息
	 */
	public void setInvitationName(String invitationName){
		this.invitationName = invitationName;
	}


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被邀请人
	 */
	@Column(name ="INVITEEID",nullable=true,length=32)
	public String getInviteeid(){
		return this.inviteeid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被邀请人
	 */
	public void setInviteeid(String inviteeid){
		this.inviteeid = inviteeid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被邀请人
	 */
	@Column(name ="INVITEENAME",nullable=true,length=100)
	public String getInviteename(){
		return this.inviteename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被邀请人
	 */
	public void setInviteename(String inviteename){
		this.inviteename = inviteename;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  男士
	 */
	@Column(name ="MANNAME",nullable=true,length=100)
	public String getManname(){
		return this.manname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  男士
	 */
	public void setManname(String manname){
		this.manname = manname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  女士
	 */
	@Column(name ="WOMANNAME",nullable=true,length=100)
	public String getWomanname(){
		return this.womanname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  女士
	 */
	public void setWomanname(String womanname){
		this.womanname = womanname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被邀请人电话
	 */
	@Column(name ="INVITEEPHONE",nullable=true,length=100)
	public String getInviteephone(){
		return this.inviteephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被邀请人电话
	 */
	public void setInviteephone(String inviteephone){
		this.inviteephone = inviteephone;
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

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否已经发送短信(0未发送，1已发送)
	 */
	@Column(name ="ISSEND",nullable=true,length=100)
	public Integer getIssend(){
		return this.issend;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否已经发送短信(0未发送，1已发送)
	 */
	public void setIssend(Integer issend){
		this.issend = issend;
	}
	
}
