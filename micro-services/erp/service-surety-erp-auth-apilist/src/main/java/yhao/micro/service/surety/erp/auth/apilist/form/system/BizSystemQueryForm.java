package yhao.micro.service.surety.erp.auth.apilist.form.system;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * Created by yoara on 2017/8/23.
 */
public class BizSystemQueryForm extends PageForm {
    @ApiModelProperty(value = "系统key或名称")
    private String queryKey;

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }
}
