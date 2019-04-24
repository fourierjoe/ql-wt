package yhao.micro.service.surety.business.dao.automapper;

import org.springframework.stereotype.Repository;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.ExecutiveNoteListModel;
import yhao.micro.service.surety.business.apilist.model.PreviousNodeFinishTime;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeItemModel;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/11 11:35
 * @Version 1.0
 */
@Repository
public interface ExecutiveNoteDao {
    Pagination<WindControllerGuaranteeModel> pageQueryExecutiveNote(Pagination page, WindControllerGuaranteeQueryForm form) throws Exception;

    void executiveNoteSave(ExecutivePostSaveForm form) throws Exception;

    Pagination<ExecutiveNoteListModel> pageQueryExecutiveNoteById(Pagination page, QuerySingleGuaranteeInfoForm form) throws Exception;

    /**
     * 功能描述: 查询上一节点完成时间
     *
     * @auther: leice
     * @date: 2018/12/26 11:06
     */
    PreviousNodeFinishTime queryPreviousNodeFinishTime(PreviousNodeFinishTimeForm order);

}
