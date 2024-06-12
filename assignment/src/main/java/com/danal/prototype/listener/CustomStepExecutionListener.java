package com.danal.prototype.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class CustomStepExecutionListener extends StepExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(CustomStepExecutionListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info(">>>>>>>>> Step started : {}", stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info(">>>>>>>>> Step finished : {}, status: {}", stepExecution.getStepName(), stepExecution.getStatus());
        return null;
    }
}
