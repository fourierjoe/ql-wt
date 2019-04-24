package yhao.micro.service.surety.erp.org.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.MD5Util;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonPropertiesSaveForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonUpdatePswForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.AddPositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.*;
import yhao.micro.service.surety.erp.org.apilist.enums.PositionTypeEnum;
import yhao.micro.service.surety.erp.org.constants.ErpOrgConstants;
import yhao.micro.service.surety.erp.org.dao.automapper.PersonDao;
import yhao.micro.service.surety.erp.org.dao.automapper.PersonPropertiesDao;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yoara on 2017/2/16.
 */
@Service
public class PersonService {
    @Resource
    private PersonDao personDao;
    @Resource
    private PersonPropertiesDao personPropertiesDao;
    @Resource
    private PositionService positionService;

    public Pagination<PersonModel> queryPersonPage(PersonQueryForm form) {
        Pagination<PersonModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        if (StringUtils.isNotBlank(form.getPositionCodes())) {
            form.setPositionCodeList(Arrays.asList(form.getPositionCodes().split(",")));
        }
        personDao.queryPerson(page, form);
        return page;
    }

    @Transactional
    public boolean savePerson(PersonModel person) {
        if (StringUtils.isEmpty(person.getId())) {
            person.setId(UUID.randomUUID().toString());
            person.setNumber((personDao.selectMaxNumber() + 1) + "");
            person.setPassword(MD5Util.getMD5(ErpOrgConstants.PERSON_DEFAULT_PSW.getBytes()).toLowerCase());
            personDao.insertPerson(person);

            AddPositionLinkSaveForm form = new AddPositionLinkSaveForm();
            form.setPersonId(person.getId());
            form.setPositionLinkId(person.getPositionLinkId());
            form.setType(PositionTypeEnum.MAJOR);
            personDao.saveAddPosition(form);
            addPositionList(person.getId(), person.getPositionLinkId(), PositionTypeEnum.MAJOR);
        } else {
            PersonModel old = pickPersonById(person.getId());
            if (!old.getPositionLinkId().equals(person.getPositionLinkId())
                    && StringUtils.isNotEmpty(person.getPositionLinkId())) {
                //更换兼职职务数据
                AddPositionLinkSaveForm addForm = new AddPositionLinkSaveForm();
                addForm.setType(PositionTypeEnum.MAJOR);
                addForm.setPersonId(person.getId());

                addForm.setPositionLinkId(old.getPositionLinkId());
                deleteAddPosition(addForm);

                addForm.setPositionLinkId(person.getPositionLinkId());
                saveAddPosition(addForm);
            }
            personDao.updatePerson(person);

        }
        return true;
    }

    /**
     * 查询人员履职记录
     *
     * @param personId
     * @return
     */
    public List<PositionListModel> queryPersonPositionList(String personId) {
        return personDao.queryPersonPositionListModel(personId);
    }

    public boolean personStatusChange(StatusUpdateForm form) {
        PersonModel person = new PersonModel();
        person.setId(form.getId());
        person.setStatus(form.getStatus());
        person.addOperatorInfo(form.getOperatorId(), true);
        personDao.updatePerson(person);
        return true;
    }

    public boolean suretyPersonStatusChange(StatusUpdateForm form) {
        PersonPropertiesModel personPropertiesModel = personPropertiesDao.queryPersonPropertiesByPersonId(form.getId());
        if (personPropertiesModel != null) {
            PersonPropertiesSaveForm updateForm = personPropertiesModel.toSaveForm();
            updateForm.setStatus(form.getStatus());
            return personPropertiesDao.updatePersonProperties(updateForm) > 0;
        }
        PersonPropertiesSaveForm saveForm = new PersonPropertiesSaveForm();
        saveForm.setPersonId(form.getId());
        saveForm.setStatus(form.getStatus());
        return personPropertiesDao.insertPersonProperties(saveForm) > 0;
    }

    public PersonModel pickPersonById(String id) {
        return personDao.pickPersonById(id);
    }

    public PersonModel pickPersonByPhone(String phone) {
        return personDao.pickPersonByPhone(phone);
    }

    public boolean updatePassword(PersonUpdatePswForm form) {
        PersonModel person = new PersonModel();
        person.setId(form.getPersonId());
        person.setPassword(StringUtils.isEmpty(form.getNewPswMd5()) ?
                MD5Util.getMD5(ErpOrgConstants.PERSON_DEFAULT_PSW.getBytes()) : form.getNewPswMd5());
        person.setPassword(person.getPassword().toLowerCase());
        personDao.updatePassword(person);
        return true;
    }

    @Transactional
    public boolean saveAddPosition(AddPositionLinkSaveForm form) {
        if (form.getType() == null) {
            form.setType(PositionTypeEnum.PART);
        }
        personDao.saveAddPosition(form);
        //添加履职记录
        addPositionList(form.getPersonId(), form.getPositionLinkId(), form.getType());
        return true;
    }

    public void addPositionList(String personId, String positionLinkId, PositionTypeEnum type) {
        //添加履职记录
        PositionListModel model = new PositionListModel();
        model.setStartTime(new Date());
        model.setPersonId(personId);
        model.setPositionLinkId(positionLinkId);
        model.setType(type);
        personDao.insertPositionListModel(model);
    }

    @Transactional
    public boolean deleteAddPosition(AddPositionLinkSaveForm form) {
        personDao.deleteAddPosition(form);

        //更新履职记录时间
        personDao.addEndTimeToPositionList(form);
        return true;
    }

    /**
     * 查询兼职信息，不包括主职
     *
     * @param personId
     * @return
     */
    public List<PositionLinkModel> queryAddPosition(String personId) {
        return personDao.queryAddPosition(personId);
    }

    public boolean bindWxOpenId(PersonPropertiesSaveForm form) {
        PersonPropertiesModel personPropertiesModel = personPropertiesDao.queryPersonPropertiesByPersonId(form.getPersonId());
        if (personPropertiesModel != null) {
            return personPropertiesDao.updatePersonProperties(form) > 0;
        }
        return personPropertiesDao.insertPersonProperties(form) > 0;
    }

    public List<PersonModel> queryCreditClerkByCityOrg(IdForm idForm) {
        PositionCodeModel positionCodeModel = positionService.queryCreditClerkCodeByCityOrg(idForm);
        if (positionCodeModel == null) {
            return new ArrayList<>();
        }
        PersonQueryForm queryForm = new PersonQueryForm();
        queryForm.setOrgId(idForm.getId());
        queryForm.setSuretyStatus(CommonStatusEnum.ENABLED);
        queryForm.setPositionCodes(positionCodeModel.getPositionCode());
        return personDao.queryPerson(queryForm);
    }
}
