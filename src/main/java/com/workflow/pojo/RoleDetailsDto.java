package com.workflow.pojo;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.Data;

@AerospikeRecord(namespace = "test", set = "role-details")
@Data
public class RoleDetailsDto {

    @AerospikeKey
    private int roleId;

    @AerospikeBin
    private String roleName;

    @AerospikeBin
    private String description;

}
