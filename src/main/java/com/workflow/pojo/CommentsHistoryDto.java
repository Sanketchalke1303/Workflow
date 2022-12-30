package com.workflow.pojo;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

import java.time.LocalDateTime;

@AerospikeRecord(namespace = "test", set = "comments-history")
public class CommentsHistoryDto {
    @AerospikeBin
    private String formId;

    @AerospikeBin
    private int userId;

    @AerospikeBin
    private String userName;

    @AerospikeBin
    private String comments;

    @AerospikeBin
    private LocalDateTime createdDateTime;

}
