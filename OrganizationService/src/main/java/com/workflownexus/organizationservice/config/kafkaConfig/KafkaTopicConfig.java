package com.workflownexus.organizationservice.config.kafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class KafkaTopicConfig {
//    @Bean
//    NewTopic employee(){
//        // topic name, partition number, replication number
//        return new NewTopic("employee", 2, (short) 1);
//    }
//
//    @Bean
//    NewTopic statistic(){
//        // topic name, partition number, replication number
//        return new NewTopic("statistic", 1, (short) 1);
//    }
}
