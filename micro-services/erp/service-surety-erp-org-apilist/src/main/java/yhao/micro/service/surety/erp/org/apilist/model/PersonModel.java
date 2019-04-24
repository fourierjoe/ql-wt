package yhao.micro.service.surety.erp.org.apilist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * 人员Model类
 * Created by null on 2017-09-04
 */
@ApiModel
public class PersonModel extends Entity<String> {
	// 姓名
	@ApiModelProperty(value = "姓名")
	private String name;
	// 编号
	@ApiModelProperty(value = "编号")
	private String number;
	// 证件号
	@ApiModelProperty(value = "证件号")
	private String cardId;
	// 状态
	@ApiModelProperty(value = "状态")
	private CommonStatusEnum status;
	// 性别1男，0女
	@ApiModelProperty(value = "性别1男，0女")
	private Integer sex;
	// 上级组织id
	@ApiModelProperty(value = "上级组织id")
	private String orgId;

	@ApiModelProperty(value = "上级组织name")
	private String orgName;

	@ApiModelProperty(value = "电话号码")
	private String phone;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "是否为超级管理员")
	private boolean admin;

	@ApiModelProperty(value = "挂职ID")
	private String positionLinkId;

	@ApiModelProperty(value = "挂职岗位名称")
	private String positionName;

	@ApiModelProperty(value = "是否为组织管理者")
	private boolean manager;

	@ApiModelProperty(value = "入职日期")
	private Date joinDate;

	@ApiModelProperty(value = "头像")
	private String photoUrl;

	@ApiModelProperty(value = "个人介绍")
	private String personIntro;

	@ApiModelProperty(value = "用户在万通担保系统的状态")
	private CommonStatusEnum suretyStatus;

	@ApiModelProperty(value = "用户绑定的微信openId")
	private String wxOpenId;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCardId(String cardId){
		this.cardId = cardId;
	}

	public String getCardId(){
		return cardId;
	}

	public void setStatus(CommonStatusEnum status){
		this.status = status;
	}

	public CommonStatusEnum getStatus(){
		return status;
	}

	public String getStatusDesc(){
		return status==null?"":status.getDesc();
	}

	public void setSex(Integer sex){
		this.sex = sex;
	}

	public Integer getSex(){
		return sex;
	}

	public String getSexDesc(){
		return sex==null||sex==1?"男":"女";
	}

	public void setOrgId(String orgId){
		this.orgId = orgId;
	}

	public String getOrgId(){
		return orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getNumber() {
		return number;
	}

	public String getNumberDesc() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPositionLinkId() {
		return positionLinkId;
	}

	public void setPositionLinkId(String positionLinkId) {
		this.positionLinkId = positionLinkId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPersonIntro() {
		return personIntro;
	}

	public void setPersonIntro(String personIntro) {
		this.personIntro = personIntro;
	}

	public CommonStatusEnum getSuretyStatus() {
		return suretyStatus;
	}

	public void setSuretyStatus(CommonStatusEnum suretyStatus) {
		this.suretyStatus = suretyStatus;
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}
}
