package com.workflow.serviceimpl;

import com.workflow.dao.FormDao;
import com.workflow.dao.WorkflowDao;
import com.workflow.pojo.FormDetailsDto;
import com.workflow.pojo.FormWorkflowStatusTracker;
import com.workflow.pojo.WorkflowDetailsDto;
import com.workflow.service.FormService;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FormServiceImpl implements FormService {
    @Inject
    public FormDao formDao;

    @Inject
    public WorkflowDao workflowDao;

    @Override
    public void addNewForm(FormDetailsDto formDetails) {
        // insert into form-details table
        formDao.addNewForm(formDetails);

        // get workflow details based on workflowId
        WorkflowDetailsDto workflowDetails = workflowDao.getWorkflowDetails(formDetails.getWorkflowId());

        // insert into form-approval-tracker table
        List<FormWorkflowStatusTracker> list = convertFormToTracker(formDetails, workflowDetails);

        // formDetails.setFormApprovalStatusList(list);
        formDao.attachWorkflowToForm(list);
    }

    private List<FormWorkflowStatusTracker> convertFormToTracker(FormDetailsDto formDetails, WorkflowDetailsDto workflowDetails) {
//        formId, formName, AssignedTo, currentlyActive, step, createdDateTime, lastUpdatedDateTime
        List<FormWorkflowStatusTracker> list = new ArrayList<>();
        for (int i=0; i<workflowDetails.getNoOfApprovals(); i++) {
            FormWorkflowStatusTracker formWorkflowStatusTracker = new FormWorkflowStatusTracker();
            formWorkflowStatusTracker.setId(formDetails.getFormId() + "_" + i);
            formWorkflowStatusTracker.setFormId(formDetails.getFormId());
            formWorkflowStatusTracker.setFormName(formDetails.getFormName());
            formWorkflowStatusTracker.setCurrentlyActive(i==0 ? true : false);
            formWorkflowStatusTracker.setStep("Step" + (i+1));
            formWorkflowStatusTracker.setCreatedDateTime(null); //(LocalDateTime.now());
            formWorkflowStatusTracker.setLastUpdatedDateTime(null); //(LocalDateTime.now());
            // To-do: logic for task assignment as per WF pending. Fetch users based on roles
            String user = "";
            switch (i) {
                case 0 : user = "test1"; break;
                case 1 : user = "test2"; break;
                case 2 : user = "test3"; break;
            }
            formWorkflowStatusTracker.setAssignedTo(user);

            list.add(formWorkflowStatusTracker);
        }
        return list;
    }
}
