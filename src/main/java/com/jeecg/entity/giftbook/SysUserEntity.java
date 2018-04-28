package com.jeecg.entity.giftbook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.core.common.entity.IdEntity;


/**
 * @Title: Entity
 * @Description: 用户
 * @author onlineGenerator
 * @date 2016-11-04 13:51:00
 * @version V1.0
 * 
 */
@Entity
@Table(name = "sys_user")
@SuppressWarnings("serial")
public class SysUserEntity extends IdEntity {  //sys_user
	/** 自动编号 */
	private String id;
	/** 手机号码 */
	/** 性别1=男，2=女，0=未知 */
	private Integer sex;
	/** 用户头像 */
	private String portrait;
	/** 用户头像 */
	private String portraitThumbnail;
	/** 真实姓名 */
	private String username;
	/** 登录账号 */
	private String loginname;
	private  String n;
	private  String p;
	private String o;
	private String t;
	private String d;
	/** 登录密码 */
	private String loginpassword;

	/** 电子邮箱 */
	private String useremail;
	/** 所属省Id */
	private Integer provinceid;
	/** 所属省 */
	private String province;
	/** 所属市Id */
	private Integer cityid;
	/** 所属市 */
	private String city;
	/** 所属区/县Id */
	private Integer districtid;
	/** 所属区/县 */
	private String district;
	/** 详细地址 */
	private String detailaddress;
	/** 使用状态(1启用2停用） */
	private Integer loginflag;
	/** qqopenid */
	private String qqopenid;
	/** wxopenid */
	private String wxopenid;
	/** sinaopenid */
	private String sinaopenid;
	/** 创建时间 */
	private java.util.Date createDate;
	/** 创建人编号 */
	private String createBy;
	/** 创建人姓名 */
	private String createName;
	/** 更新时间 */
	private java.util.Date updateDate;
	/** 更新人编号 */
	private String updateBy;
	/** 更信任姓名 */
	private String updateName;
	private String timestamp;
	private String decvices;
   private  String userphone;
	@Transient
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Transient
	public String getDecvices() {
		return decvices;
	}

	public void setDecvices(String decvices) {
		this.decvices = decvices;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 自动编号
	 */
//	@Id
//	@Column(name = "ID", nullable = true, length = 32)
	public String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 自动编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 方法: 性别1=男，2=女，0=未知
	 *
	 * @return: java.lang.Integer 自动编号
	 */
//	@Column(name = "Sex", nullable = true, length = 10)
	public Integer getSex() {
		return this.sex;
	}

	/**
	 * 方法: 性别1=男，2=女，0=未知
	 *
	 * @param: java.lang.Integer 自动编号
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 手机号码
	 */
	@Column(name = "USERPHONE", nullable = true, length = 32)
	public String getUserphone() {
		return this.userphone;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 手机号码
	 */
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 用户头像
	 */
//	@Column(name = "PORTRAIT", nullable = true, length = 255)
	public String getPortrait() {
		return this.portrait;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 用户头像
	 */
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 用户头像
	 */
	@Transient
	public String getPortraitThumbnail() {
		return this.portraitThumbnail;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 用户头像
	 */
	public void setPortraitThumbnail(String portraitThumbnail) {
		this.portrait = portraitThumbnail;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 真实姓名
	 */
	@Column(name = "USERNAME", nullable = true, length = 64)
	public String getUsername() {
		return this.username;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 真实姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 登录账号
	 */
	@Column(name = "LOGINNAME", nullable = true, length = 64)
	public String getLoginname() {
		return this.loginname;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 登录账号
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 登录密码
	 */
	@Column(name = "LOGINPASSWORD", nullable = true, length = 64)
	public String getLoginpassword() {
		return this.loginpassword;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 登录密码
	 */
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	@Transient
	public String getO() {
		return o;
	}
	public void setO(String oldPwd) {
		this.o = oldPwd;
	}
	@Transient
	public String getN() {		return n;	}
	public void setN(String n) {		this.n = n;	}
	@Transient
	public String getP() {		return p;	}
	public void setP(String p) {		this.p = p;	}
	@Transient
	public String getT() {		return t;	}
	public void setT(String t) {		this.t = t;	}
	@Transient
	public String getD() {		return d;	}
	public void setD(String d) {		this.d = d;	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 电子邮箱
	 */
//	@Column(name = "USEREMAIL", nullable = true, length = 128)
	public String getUseremail() {
		return this.useremail;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 电子邮箱
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 所属省Id
	 */
//	@Column(name = "PROVINCEID", nullable = true, length = 10)
	public Integer getProvinceid() {
		return this.provinceid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 所属省Id
	 */
	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 所属省
	 */
//	@Column(name = "PROVINCE", nullable = true, length = 64)
	public String getProvince() {
		return this.province;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 所属省
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 所属市Id
	 */
//	@Column(name = "CITYID", nullable = true, length = 10)
	public Integer getCityid() {
		return this.cityid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 所属市Id
	 */
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 所属市
	 */
	@Column(name = "CITY", nullable = true, length = 64)
	public String getCity() {
		return this.city;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 所属市
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 所属区/县Id
	 */
	@Column(name = "DISTRICTID", nullable = true, length = 10)
	public Integer getDistrictid() {
		return this.districtid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 所属区/县Id
	 */
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 所属区/县
	 */
	@Column(name = "DISTRICT", nullable = true, length = 64)
	public String getDistrict() {
		return this.district;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 所属区/县
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 详细地址
	 */
	@Column(name = "DETAILADDRESS", nullable = true, length = 512)
	public String getDetailaddress() {
		return this.detailaddress;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 详细地址
	 */
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 使用状态(1启用2停用）
	 */
	@Column(name = "LOGINFLAG", nullable = true, length = 10)
	public Integer getLoginflag() {
		return this.loginflag;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 使用状态(1启用2停用）
	 */
	public void setLoginflag(Integer loginflag) {
		this.loginflag = loginflag;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String qqopenid
	 */
	@Column(name = "QQOPENID", nullable = true, length = 100)
	public String getQqopenid() {
		return this.qqopenid;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String qqopenid
	 */
	public void setQqopenid(String qqopenid) {
		this.qqopenid = qqopenid;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String wxopenid
	 */
	@Column(name = "WXOPENID", nullable = true, length = 100)
	public String getWxopenid() {
		return this.wxopenid;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String wxopenid
	 */
	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String sinaopenid
	 */
	@Column(name = "SINAOPENID", nullable = true, length = 100)
	public String getSinaopenid() {
		return this.sinaopenid;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String sinaopenid
	 */
	public void setSinaopenid(String sinaopenid) {
		this.sinaopenid = sinaopenid;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 创建时间
	 */
	@Column(name = "CREATE_DATE", nullable = true)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 创建时间
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 创建人编号
	 */
	@Column(name = "CREATE_BY", nullable = true, length = 100)
	public String getCreateBy() {
		return this.createBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 创建人编号
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 创建人姓名
	 */
	@Column(name = "CREATE_NAME", nullable = true, length = 100)
	public String getCreateName() {
		return this.createName;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 创建人姓名
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 更新时间
	 */
	@Column(name = "UPDATE_DATE", nullable = true)
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 更新时间
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 更新人编号
	 */
	@Column(name = "UPDATE_BY", nullable = true, length = 100)
	public String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 更新人编号
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 更信任姓名
	 */
	@Column(name = "UPDATE_NAME", nullable = true, length = 100)
	public String getUpdateName() {
		return this.updateName;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 更信任姓名
	 */
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public SysUserEntity(){}
	public SysUserEntity(String n,String p,String o,String d,String t)
	{
		loginname=n;		loginpassword=p;		this.o=o;		decvices=d;		timestamp=t;
	}
	public String toSignString(String timestampStr, String decvicesStr) {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"id\":\"");
		sb.append(id).append("\",\"loginname\":\"");
		if (loginname != null)
			sb.append(loginname);
		sb.append("\",\"loginflag\":\"");
		if (loginflag != null)
			sb.append(loginflag);
		sb.append("\",\"qqopenid\":\"");
		if (qqopenid != null)
			sb.append(qqopenid);
		sb.append("\",\"wxopenid\":\"");
		if (wxopenid != null)
			sb.append(wxopenid);
		sb.append("\",\"sinaopenid\":\"");
		if (sinaopenid != null)
			sb.append(sinaopenid);
		sb.append("\",\"createDate\":\"");
		if (createDate != null)
			sb.append(createDate);
		sb.append("\",\"timestamp\":\"");
		if (timestampStr != null)
			sb.append(timestampStr);
		sb.append("\",\"decvices\":\"");
		if (decvicesStr != null)
			sb.append(decvicesStr);
		sb.append("\"");

		sb.append(",\"username\":\"");
		if (decvicesStr != null)
			sb.append(username);
		sb.append("\"");

		sb.append("}");
		return sb.toString();
	}

}
