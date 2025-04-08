package com.happiest.apigateway.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;

@Configuration
public class UtilityConfig {
    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();

        // Configure Hazelcast network (optional, you can skip this if you don't need clustering)
        NetworkConfig networkConfig = config.getNetworkConfig();
        networkConfig.setPublicAddress("127.0.0.1"); // Adjust based on your network config

        // You can add more custom configurations here

        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return new DefaultServerCodecConfigurer();
    }
}
