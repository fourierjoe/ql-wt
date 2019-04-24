package yhao.micro.service.surety.erp.auth.apilist.form.system;

import java.util.List;

public class BizSystemRelaDeleteForm {
    private List<String> dataKey;
    private String systemKey;

    public List<String> getDataKey() {
        return dataKey;
    }

    public void setDataKey(List<String> dataKey) {
        this.dataKey = dataKey;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }
}
