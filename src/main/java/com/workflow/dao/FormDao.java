package com.workflow.dao;

import com.workflow.pojo.FormDetailsDto;
import com.workflow.pojo.FormWorkflowStatusTracker;

import java.util.List;

public interface FormDao {
    void addNewForm(FormDetailsDto workflow);

    void attachWorkflowToForm(List<FormWorkflowStatusTracker> formWorkflowStatusTracker);
}
