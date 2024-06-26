package com.danal.prototype.config;

import com.danal.prototype.domain.CommercialDistrictDto;
import com.danal.prototype.job.CsvReader;
import com.danal.prototype.job.CsvScheduleWriter;
import com.danal.prototype.listener.CustomJobExecutionListener;
import com.danal.prototype.listener.CustomStepExecutionListener;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Configuration
public class BatchConfiguration {

    private static final int chunkSize = 1000;
    private final CsvReader csvReader;
    private final CsvScheduleWriter csvScheduleWriter;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final CustomJobExecutionListener customJobExecutionListener;
    private final CustomStepExecutionListener customStepExecutionListener;


    @Bean
    public Job csvFileItemReaderJob() {
        return new JobBuilder("csvFileItemReaderJob", jobRepository)
                .incrementer(new RunIdIncrementer()) // 새로운 Job Parameters 생성
                .listener(customJobExecutionListener)
                .start(csvFileItemReaderStep())
                .build();
    }

    @Bean
    public Step csvFileItemReaderStep() {
        return new StepBuilder("csvFileItemReaderStep", jobRepository)
                .<CommercialDistrictDto, CommercialDistrictDto>chunk(chunkSize, transactionManager)
                .reader(csvReader.csvScheduleReader())
                .writer(csvScheduleWriter)
                .listener(customStepExecutionListener)
                .build();
    }

}