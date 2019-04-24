package yhao.micro.service.surety.business.apilist.form.businessType;

import yhao.infra.apilist.ValidationForm;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/19 10:34
 * @Description:
 */
public class OverdueRateParseForm implements ValidationForm {
    private Integer min;
    private Integer max;
    private Double rate;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
