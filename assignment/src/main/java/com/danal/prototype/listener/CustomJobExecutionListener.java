package com.danal.prototype.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class CustomJobExecutionListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(CustomJobExecutionListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("========== Job started : {} ==========", jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("========== Job finished : {}, status: {} ==========", jobExecution.getJobInstance().getJobName(), jobExecution.getStatus());
    }
}
