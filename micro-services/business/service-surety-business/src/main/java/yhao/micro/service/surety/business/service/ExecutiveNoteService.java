package yhao.micro.service.surety.business.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.ExecutivePostSaveForm;
import yhao.micro.service.surety.business.apilist.form.complex.PreviousNodeFinishTimeForm;
import yhao.micro.service.surety.business.apilist.form.complex.QuerySingleGuaranteeInfoForm;
import yhao.micro.service.surety.business.apilist.form.complex.WindControllerGuaranteeQueryForm;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.business.dao.automapper.DiscountApplicationDao;
import yhao.micro.service.surety.business.dao.automapper.ExaminerReviewDao;
import yhao.micro.service.surety.business.dao.automapper.ExecutiveNoteDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description 执行岗备注Service
 *
 * @Author leice
 * @Date 2018/12/11 11:29
 * @Version 1.0
 */
@Service
public class ExecutiveNoteService {

    @Autowired
    private ExecutiveNoteDao executiveNoteDao;

    @Autowired
    private ExaminerReviewDao examinerReviewDao;

    @Autowired
    private DiscountApplicationDao discountApplicationDao;

    public Pagination<WindControllerGuaranteeModel> pageQueryExecutiveNote(WindControllerGuaranteeQueryForm form) throws Exception {
        if (null == form.getIsRemarks()){
            throw new Exception("是否备注不能为空");
        }
        form.setThingCode("ZXGBZ");
        Pagination<WindControllerGuaranteeModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<WindControllerGuaranteeModel> windControllerGuaranteeModelPagination = executiveNoteDao.pageQueryExecutiveNote(page, form);
        List<WindControllerGuaranteeModel> items = windControllerGuaranteeModelPagination.getItems();
        if (null != items && items.size() > 0){
            for (WindControllerGuaranteeModel item : items) {
                PreviousNodeFinishTimeForm previousNodeFinishTimeForm = new PreviousNodeFinishTimeForm(item.getTaskId(), item.getNodeOrder() - 1);
                PreviousNodeFinishTime previousNodeFinishTime = executiveNoteDao.queryPreviousNodeFinishTime(previousNodeFinishTimeForm);
                String s = examinerReviewDao.queryManageName(item.getAccountManagerId());
                item.setAccountManagerOrg(s);
                if (null != previousNodeFinishTime){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = sdf.parse(previousNodeFinishTime.getPreviousNodeFinishTime());
                    long time = parse.getTime();
                    Date date = new Date();
                    long time1 = date.getTime();
                    long l = time1 - time;
                    item.setDays(Integer.parseInt(l/(24*60*60*1000)+""));
                }
            }
        }

        return windControllerGuaranteeModelPagination;
    }

    public ExecutivePostSaveForm executiveNoteSave(ExecutivePostSaveForm form) throws Exception {
        form.setId(UUID.randomUUID().toString());
        executiveNoteDao.executiveNoteSave(form);
        return form;
    }

    public Pagination<ExecutiveNoteListModel> pageQueryExecutiveNoteById(QuerySingleGuaranteeInfoForm form) throws Exception {
        Pagination<ExecutiveNoteListModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<ExecutiveNoteListModel> executiveNoteListModelPagination = executiveNoteDao.pageQueryExecutiveNoteById(page, form);
        return executiveNoteListModelPagination;
    }
}
