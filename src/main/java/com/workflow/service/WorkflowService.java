package com.workflow.service;

import com.workflow.pojo.WorkflowDetailsDto;

import java.util.List;

public interface WorkflowService {

    void addNewWorkflow(WorkflowDetailsDto workflow);

    List<WorkflowDetailsDto> getAllWorkflows();
}
