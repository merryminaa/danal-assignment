package com.danal.prototype.job;

import com.danal.prototype.domain.CommercialDistrictDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
@RequiredArgsConstructor
public class CsvReader {

    @Bean
    public FlatFileItemReader<CommercialDistrictDto> csvScheduleReader() {
        return new FlatFileItemReaderBuilder<CommercialDistrictDto>()
                .name("commercialDistrictItemReader")
                .resource(new ClassPathResource("input.csv"))
                .delimited()
                .delimiter(DelimitedLineTokenizer.DELIMITER_COMMA)
                .names(new String[]{"bizNo", "bizName", "mainClassCode", "mainClassCodeName", "subClassCode", "subClassCodeName", "detailClassCode", "detailClassCodeName", "standardClassCode", "standardClassCodeName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<CommercialDistrictDto>() {{
                    setTargetType(CommercialDistrictDto.class);
                }})
                .build();
    }

}
