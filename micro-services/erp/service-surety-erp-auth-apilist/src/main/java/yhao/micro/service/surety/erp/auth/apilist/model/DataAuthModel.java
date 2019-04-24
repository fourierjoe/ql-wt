package yhao.micro.service.surety.erp.auth.apilist.model;


import yhao.infra.common.model.Entity;

/**
 * Created by yoara on 2017/7/3.
 */
public class DataAuthModel extends Entity<String> {
    public final static String ALL_DATA_TYPE = "ALL_DATA_TYPE";

    private String personId;
    private String orgId;
    private String systemKey;
    private String dataType;
    private String positionLinkId;
    private String authType;

    //非数据库数据，做桥接用
    private String orgLongNumber;
    private String orgNumber;
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getOrgLongNumber() {
        return orgLongNumber;
    }

    public void setOrgLongNumber(String orgLongNumber) {
        this.orgLongNumber = orgLongNumber;
    }

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }
}
