package com.workflow.pojo;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeEmbed;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.Data;
import netscape.javascript.JSObject;

import java.time.LocalDateTime;
import java.util.List;

@AerospikeRecord(namespace = "test", set = "form-details")
@Data
public class FormDetailsDto {
    @AerospikeKey
    private String formId;

    @AerospikeBin
    private String formName;

    @AerospikeBin
    private String workflowId;

    @AerospikeEmbed
    private List<FormData> formData;

    @AerospikeBin(name = "createdDate")
    private LocalDateTime createdDateTime;

//    @AerospikeEmbed(type = AerospikeEmbed.EmbedType.LIST)
//    private List<FormWorkflowStatusTracker> formApprovalStatusList;

}
