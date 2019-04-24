package yhao.micro.service.surety.erp.auth.login.apilist.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 人员Model类
 * Created by null on 2017-09-04
 */
@ApiModel
public class LoginPersonModel extends Entity<String> {
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

	@ApiModelProperty(value = "电话号码")
	private String phone;

	@ApiModelProperty(value = "头像")
	private String photoUrl;

	@ApiModelProperty(value = "密码",hidden = true)
	@JSONField(serialize = false)
	private String password;

	@ApiModelProperty(value = "是否为超级管理员")
	private boolean admin;

	@ApiModelProperty(value = "是否为组织管理员")
	private boolean manager;

	@ApiModelProperty(value = "当前使用岗位上级组织id")
	private String orgId;

	@ApiModelProperty(value = "当前使用岗位上级组织name")
	private String orgName;

	@ApiModelProperty(value = "当前使用岗位上级组织长编码")
	private String orgLongNumber;

	@ApiModelProperty(value = "当前使用岗位组织所属城市组织长编码")
	private String cityOrgLongNumber;

	@ApiModelProperty(value = "当前使用岗位组织所属城市组织ID")
	private String cityOrgId;

	@ApiModelProperty(value = "当前使用岗位组织所属城市组织名称")
	private String cityOrgName;

	@ApiModelProperty(value = "当前使用岗位挂职ID")
	private String positionLinkId;

	@ApiModelProperty(value = "当前使用挂职岗位名称")
	private String positionName;

	@ApiModelProperty(value = "系统所有权限菜单")
	private LinkedHashMap<String,LinkedHashSet<String>> allMenu;

	@ApiModelProperty(value = "用户在万通担保系统的状态")
	private CommonStatusEnum suretyStatus;
	/**
	 * List<兼职信息>
	 */
	@ApiModelProperty(value = "[兼职信息]")
	List<LoginPositionLinkModel> positionLinkModelList;
	/**
	 * <岗位ID,Set<权限url>>
	 */
	@ApiModelProperty(hidden = true)
	@JSONField(serialize = false)
	private Map<String,Set<String>> authMap;

	/**
	 * <岗位ID,<数据权限类型,List<数据权限>>>
	 */
	@ApiModelProperty(hidden = true)
	@JSONField(serialize = false)
	private Map<String,Map<String,List<LoginDataAuthModel>>> dataAuthMap;

	/**
	 * <岗位ID,<主菜单,List<子菜单>>>
	 */
	@ApiModelProperty(hidden = true)
	@JSONField(serialize = false)
	private Map<String,LinkedHashMap<String,LinkedHashSet<String>>> menuMap;

	@ApiModelProperty(value = "当前菜单项")
	private List<Map<String,Object>> currentMenu ;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

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
		return status.getDesc();
	}

	public void setSex(Integer sex){
		this.sex = sex;
	}

	public Integer getSex(){
		return sex;
	}

	public String getSexDesc(){
		return sex==1?"男":"女";
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

	public Map<String, Set<String>> getAuthMap() {
		return authMap;
	}

	public void setAuthMap(Map<String, Set<String>> authMap) {
		this.authMap = authMap;
	}

	public LinkedHashMap<String, LinkedHashSet<String>> getAllMenu() {
		return allMenu;
	}

	public void setAllMenu(LinkedHashMap<String, LinkedHashSet<String>> allMenu) {
		this.allMenu = allMenu;
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

	public Map<String, Map<String, List<LoginDataAuthModel>>> getDataAuthMap() {
		return dataAuthMap;
	}

	public void setDataAuthMap(Map<String, Map<String, List<LoginDataAuthModel>>> dataAuthMap) {
		this.dataAuthMap = dataAuthMap;
	}

	public Map<String,LinkedHashMap<String,LinkedHashSet<String>>> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<String,LinkedHashMap<String,LinkedHashSet<String>>> menuMap) {
		this.menuMap = menuMap;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public String getOrgLongNumber() {
		return orgLongNumber;
	}

	public void setOrgLongNumber(String orgLongNumber) {
		this.orgLongNumber = orgLongNumber;
	}

	public List<LoginPositionLinkModel> getPositionLinkModelList() {
		return positionLinkModelList;
	}

	public void setPositionLinkModelList(List<LoginPositionLinkModel> positionLinkModelList) {
		this.positionLinkModelList = positionLinkModelList;
	}

	public String getCityOrgLongNumber() {
		return cityOrgLongNumber;
	}

	public void setCityOrgLongNumber(String cityOrgLongNumber) {
		this.cityOrgLongNumber = cityOrgLongNumber;
	}

	public String getCityOrgId() {
		return cityOrgId;
	}

	public void setCityOrgId(String cityOrgId) {
		this.cityOrgId = cityOrgId;
	}

	public String getCityOrgName() {
		return cityOrgName;
	}

	public void setCityOrgName(String cityOrgName) {
		this.cityOrgName = cityOrgName;
	}

	/** 当前岗位挂职的权限相关信息 START**/
	@ApiModelProperty(value = "当前权限列表")
	public Set<String> getCurrentAuthMap(){
		if(authMap!=null){
			return authMap.get(getPositionLinkId());
		}
		return null;
	}

	@ApiModelProperty(value = "当前数据权限列表")
	@JSONField(serialize = false)
	public Map<String,List<LoginDataAuthModel>> getCurrentDataAuthMap(){
		if(dataAuthMap!=null){
			return dataAuthMap.get(getPositionLinkId());
		}
		return null;
	}

	public void setCurrentMenu(List<Map<String, Object>> currentMenu) {
		this.currentMenu = currentMenu;
	}

	public List<Map<String,Object>> getCurrentMenu(){
		LinkedHashMap<String,LinkedHashSet<String>> currentMap = null;
		if(admin){
			currentMap = allMenu;
		}else{
			if(menuMap!=null){
				currentMap = menuMap.get(getPositionLinkId());
			}
		}
		if(currentMap!=null&&currentMap.size()>0){
			List returnArray = new ArrayList();
			for(Map.Entry<String,LinkedHashSet<String>> entry:currentMap.entrySet()){
				Map<String,Object> object = new HashMap<>();
				object.put("name",entry.getKey());
				JSONArray children = new JSONArray();
				object.put("children",children);
				entry.getValue().forEach(o->{
					Map<String,Object> name = new HashMap<>();
					name.put("name",o);
					children.add(name);
				});
				returnArray.add(object);
			}
			return returnArray;
		}
		return new ArrayList<>();
	}
	/** 当前岗位挂职的权限相关信息 END**/

	@JSONField(serialize = false)
	public List<String> getCurrentDataOrgLongNumber(String dataType){
		if(getCurrentDataAuthMap()!=null){
			List<LoginDataAuthModel> dataList = getCurrentDataAuthMap().get(dataType);
			if(dataList!=null && dataList.size()>0){
				return dataList.stream().map(d->d.getOrgLongNumber()).collect(Collectors.toList());
			}
		}
		return null;
	}

	/**
	 * 切换岗位信息
	 * @param positionLinkId
	 */
	public void changePosition(String positionLinkId) {
		for(LoginPositionLinkModel model:positionLinkModelList){
			if(model.getId().equals(positionLinkId)){
				setOrgId(model.getOrgId());
				setOrgLongNumber(model.getOrgLongNumber());
				setCityOrgLongNumber(model.getCityOrgLongNumber());
				setCityOrgId(model.getCityOrgId());
				setCityOrgName(model.getCityOrgName());
				setOrgName(model.getOrgName());
				setPositionLinkId(model.getId());
				setPositionName(model.getPositionName());
				setManager(model.isManager());
				break;
			}
		}
	}

	public CommonStatusEnum getSuretyStatus() {
		return suretyStatus;
	}

	public void setSuretyStatus(CommonStatusEnum suretyStatus) {
		this.suretyStatus = suretyStatus;
	}
}
