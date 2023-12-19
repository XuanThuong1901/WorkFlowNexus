package com.workflownexus.projecttaskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectTaskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTaskServiceApplication.class, args);
    }

}
