package com.workflow.serviceimpl;

import com.workflow.dao.WorkflowDao;
import com.workflow.pojo.WorkflowDetailsDto;
import com.workflow.service.WorkflowService;
import jakarta.inject.Inject;

import java.util.List;

public class WorkflowServiceImpl implements WorkflowService {

    @Inject
    private WorkflowDao dao;
    public void addNewWorkflow(WorkflowDetailsDto workflow) {
        dao.addNewWorkflow(workflow);
    }

    @Override
    public List<WorkflowDetailsDto> getAllWorkflows() {
        return dao.getAllWorkflows();
    }

}
