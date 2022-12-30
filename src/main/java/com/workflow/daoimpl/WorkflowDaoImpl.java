package com.workflow.daoimpl;

import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.mapper.tools.AeroMapper;
import com.workflow.dao.WorkflowDao;
import com.workflow.pojo.WorkflowDetailsDto;
import jakarta.inject.Inject;

import java.util.List;

public class WorkflowDaoImpl implements WorkflowDao {

    @Inject
    AeroMapper mapper;
    @Override
    public void addNewWorkflow(WorkflowDetailsDto workflow) {
        WritePolicy writePolicy = new WritePolicy();
        writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
        mapper.save(writePolicy, workflow);
        System.out.println("Add New Workflow!");
    }

    @Override
    public List<WorkflowDetailsDto> getAllWorkflows() {
        return mapper.scan(WorkflowDetailsDto.class);
    }

    @Override
    public WorkflowDetailsDto getWorkflowDetails(String workflowId) {
        return mapper.read(WorkflowDetailsDto.class, 1);
    }
}
