package com.workflow.pojo;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@AerospikeRecord(namespace = "test", set = "dummy")
@Data
//@JsonSerialize
public class ApprovalHierarchy {
    @AerospikeKey
    private String approval1;

    private String approval2;

    private String approval3;

    private String approval4;
}
