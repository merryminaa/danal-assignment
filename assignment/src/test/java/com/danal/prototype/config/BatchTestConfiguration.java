package com.danal.prototype.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBatchTest
@Configuration
@EnableBatchProcessing
public class BatchTestConfiguration {

    public BatchTestConfiguration() {
    }

    public static BatchTestConfiguration createBatchTestConfiguration() {
        return new BatchTestConfiguration();
    }

    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }
}

