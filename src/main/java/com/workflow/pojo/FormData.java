package com.workflow.pojo;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.Data;

@AerospikeRecord(namespace = "test", set = "dummy1")
@Data
//@JsonSerialize
public class FormData {
    @AerospikeKey
    private String label;

    private String value;

}
