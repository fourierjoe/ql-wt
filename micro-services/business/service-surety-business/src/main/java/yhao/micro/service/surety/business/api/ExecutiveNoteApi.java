package yhao.micro.service.surety.business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.ExecutivePostSaveForm;
import yhao.micro.service.surety.business.apilist.form.complex.QuerySingleGuaranteeInfoForm;
import yhao.micro.service.surety.business.apilist.form.complex.WindControllerGuaranteeQueryForm;
import yhao.micro.service.surety.business.apilist.model.ExecutiveNoteListModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.surety.business.service.ExecutiveNoteService;

/**
 * @Description 执行岗备注api
 *
 * @Author leice
 * @Date 2018/12/11 11:27
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/executivenote")
public class ExecutiveNoteApi extends RestfulBaseController {
    @Autowired
    private ExecutiveNoteService executiveNoteService;

    /**
     * 功能描述: 担保单是否备注分页查询
     */
    @PostMapping("/pageQueryExecutiveNote")
    public RequestResult<Pagination<WindControllerGuaranteeModel>> pageQueryExecutiveNote(@RequestBody WindControllerGuaranteeQueryForm form) throws Exception {
            return new RequestResult<>(executiveNoteService.pageQueryExecutiveNote(form));
    }

    /**
     * 功能描述: 担保单新增备注
     */
    @PostMapping("/executiveNoteSave")
    public RequestResult<ExecutivePostSaveForm> executiveNoteSave(@RequestBody ExecutivePostSaveForm form) throws Exception {
            return new RequestResult<>(executiveNoteService.executiveNoteSave(form));
    }

    /**
     * 功能描述: 根据担保单id查询担保单备注历史
     */
    @PostMapping("/pageQueryExecutiveNoteById")
    public RequestResult<Pagination<ExecutiveNoteListModel>> pageQueryExecutiveNoteById(@RequestBody QuerySingleGuaranteeInfoForm form) throws Exception {
            return new RequestResult<>(executiveNoteService.pageQueryExecutiveNoteById(form));
    }
}
