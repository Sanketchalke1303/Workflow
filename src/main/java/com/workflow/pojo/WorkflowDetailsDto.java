package com.workflow.pojo;

import com.aerospike.mapper.annotations.*;
import lombok.Data;

@AerospikeRecord(namespace = "test", set = "workflow-details")
@Data
public class WorkflowDetailsDto {
    @AerospikeKey
    private int workflowId;

    @AerospikeBin
    private String workflowName;

    @AerospikeBin
    private String description;

    @AerospikeBin
    private int noOfApprovals;

    @AerospikeEmbed
    private ApprovalHierarchy approvers;
}
