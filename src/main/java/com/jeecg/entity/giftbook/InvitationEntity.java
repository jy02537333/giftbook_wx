package com.jeecg.entity.giftbook;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**   
 * @Title: Entity
 * @Description: 请帖
 * @author onlineGenerator
 * @date 2017-02-21 15:56:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "invitation", schema = "")
@SuppressWarnings("serial")
public class InvitationEntity implements java.io.Serializable {
	/**Id*/
	private String id;
	/**邀请人*/
	private String inviterid;
	/**邀请人电话*/
	private String inviterphone;
	/**宴席地址*/
	private String feastaddress;
	/**宴席酒店*/
	private String feasthotel;
	/**宴席时间*/
	private Date feastdate;
	/**宴席类型*/
	private String feasttype;
	/**男士*/
	@Column(name = "ID", nullable = true, length = 32)
	private String manname;
	/**女士*/
	private String womanname;
	/**封面图片*/
	private String coverimg;
	/**相册图片*/
	private String photoalbum;
	/**状态(0=删除，1正常)*/
	private Integer state;
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
	/**更信任姓名*/
	private String updateName;

	/**收礼名称*/
	private String receivinggiftsname;

	private List<InvitationlistEntity> invitationlistEntityList;
	@Transient
	public List<InvitationlistEntity> getInvitationlistEntityList() {
		return invitationlistEntityList;
	}
	public void setInvitationlistEntityList(List<InvitationlistEntity> invitationlistEntityList) {
		this.invitationlistEntityList = invitationlistEntityList;
	}

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
	 *@return: java.lang.String  邀请人
	 */
	@Column(name ="INVITERID",nullable=true,length=32)
	public String getInviterid(){
		return this.inviterid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀请人
	 */
	public void setInviterid(String inviterid){
		this.inviterid = inviterid;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人电话
	 */
	@Column(name ="INVITERPHONE",nullable=true,length=32)
	public String getInviterphone() {
		return inviterphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀请人电话
	 */
	public void setInviterphone(String inviterphone) {
		this.inviterphone = inviterphone;
	}



	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席酒店
	 */
	@Column(name ="FEASTHOTEL",nullable=true,length=100)
	public String getFeasthotel(){
		return this.feasthotel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席酒店
	 */
	public void setFeasthotel(String feasthotel){
		this.feasthotel = feasthotel;
	}



	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宴席地址
	 */
	@Column(name ="FEASTADDRESS",nullable=true,length=150)
	public String getFeastaddress(){
		return this.feastaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宴席地址
	 */
	public void setFeastaddress(String feastaddress){
		this.feastaddress = feastaddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  宴席时间
	 */
	@Column(name ="FEASTDATE",nullable=true)
	public Date getFeastdate(){
		return this.feastdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  宴席时间
	 */
	public void setFeastdate(Date feastdate){
		this.feastdate = feastdate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  宴席类型
	 */
	@Column(name ="FEASTTYPE",nullable=true,length=32)
	public String getFeasttype(){
		return this.feasttype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  宴席类型
	 */
	public void setFeasttype(String feasttype){
		this.feasttype = feasttype;
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
	 *@return: java.lang.String  请帖名称
	 */
	@Column(name ="RECEIVINGGIFTSNAME",nullable=true,length=100)
	public String getReceivinggiftsname(){
		return this.receivinggiftsname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  请帖名称
	 */
	public void setReceivinggiftsname(String receivinggiftsname){
		this.receivinggiftsname = receivinggiftsname;
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
	 *@return: java.lang.String  封面图片
	 */
	@Column(name ="COVERIMG",nullable=true,length=255)
	public String getCoverimg(){
		return this.coverimg;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String 封面图片
	 */
	public void setCoverimg(String coverimg){
		this.coverimg = coverimg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  相册图片
	 */
	@Column(name ="PHOTOALBUM",nullable=true,length=2000)
	public String getPhotoalbum(){
		return this.photoalbum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  相册图片
	 */
	public void setPhotoalbum(String photoalbum){
		this.photoalbum = photoalbum;
	}

}
