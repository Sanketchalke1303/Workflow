package com.workflow.pojo;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.Data;

@AerospikeRecord(namespace = "test", set = "user-details")
@Data
public class UserDetailsDto {
    @AerospikeKey
    private int userId;

    @AerospikeBin
    private String userName;

    @AerospikeBin
    private String name;

    @AerospikeBin
    private String password;

    @AerospikeBin
    private String roleId;

    @AerospikeBin
    private String description;

}
