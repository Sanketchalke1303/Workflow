package com.workflow.daoimpl;

import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.mapper.tools.AeroMapper;
import com.workflow.dao.FormDao;
import com.workflow.pojo.FormDetailsDto;
import com.workflow.pojo.FormWorkflowStatusTracker;
import jakarta.inject.Inject;

import java.util.List;

public class FormDaoImpl implements FormDao {

    @Inject
    AeroMapper mapper;

    @Override
    public void addNewForm(FormDetailsDto formDetails) {
        WritePolicy writePolicy = new WritePolicy();
        writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
        mapper.save(writePolicy, formDetails);
        System.out.println("Added New Form!");
    }

    @Override
    public void attachWorkflowToForm(List<FormWorkflowStatusTracker> formWorkflowStatusTracker) {
        WritePolicy writePolicy = new WritePolicy();
        writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
        for (FormWorkflowStatusTracker fwst : formWorkflowStatusTracker) {
            mapper.save(writePolicy, fwst);
        }
        System.out.println("Attached form to workflow!");
    }
}
