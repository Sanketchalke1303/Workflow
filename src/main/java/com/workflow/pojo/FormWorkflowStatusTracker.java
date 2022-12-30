package com.workflow.pojo;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.Data;

import java.time.LocalDateTime;

@AerospikeRecord(namespace = "test", set = "form-approval-tracker")
@Data
public class FormWorkflowStatusTracker {
    @AerospikeKey
    private String id;

    @AerospikeBin
    private String formId;

    @AerospikeBin
    private String formName;

    @AerospikeBin
    private String assignedTo;

    @AerospikeBin
    private boolean currentlyActive;

    @AerospikeBin
    private String step;

    @AerospikeBin(name = "createdDate")
    private LocalDateTime createdDateTime;

    @AerospikeBin(name = "updatedDate")
    private LocalDateTime lastUpdatedDateTime;
}
