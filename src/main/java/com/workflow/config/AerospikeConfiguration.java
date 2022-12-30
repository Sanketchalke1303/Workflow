package com.workflow.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class AerospikeConfiguration {

    @Singleton
    public AerospikeClient aerospikeClient(AerospikeConfigurationProperties properties) {
        return new AerospikeClient(properties.getHost(), properties.getPort());
    }

    @Singleton
    public AeroMapper aeroMapper(AerospikeClient aerospikeClient){
        return new AeroMapper.Builder(aerospikeClient).build();
    }
}
