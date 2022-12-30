package com.workflow.dao;

import com.workflow.pojo.WorkflowDetailsDto;

import java.util.List;

public interface WorkflowDao {
    void addNewWorkflow(WorkflowDetailsDto workflow);

    List<WorkflowDetailsDto> getAllWorkflows();

    WorkflowDetailsDto getWorkflowDetails(String workflowId);
}
