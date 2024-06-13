package com.danal.prototype;

import com.danal.prototype.config.BatchConfiguration;
import com.danal.prototype.config.BatchTestConfiguration;
import com.danal.prototype.domain.CommercialDistrict;
import com.danal.prototype.repository.CommercialDistrictRepository;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ContextConfiguration(classes = {BatchTestConfiguration.class, BatchConfiguration.class})
//@Import({CsvReader.class, CsvScheduleWriter.class, CustomJobExecutionListener.class, CustomStepExecutionListener.class})
@TestPropertySource(locations = "classpath:application-test.yml")
@SpringBootTest
public class BatchJobTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private CommercialDistrictRepository commercialDistrictRepository;

    @Test
    void testJob() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);

        Optional<CommercialDistrict> optionalCommercialDistrict = commercialDistrictRepository.findByBizNo("MA010120220805432327");
        assertThat(optionalCommercialDistrict.isPresent()).isTrue();

        CommercialDistrict commercialDistrict = optionalCommercialDistrict.get();
        assertThat(commercialDistrict.getBizName()).isEqualTo("덕삼당구장");
        assertThat(commercialDistrict.getBranchName()).isNull();
        assertThat(commercialDistrict.getMainClassCode()).isEqualTo("R1");
        assertThat(commercialDistrict.getMainClassCodeName()).isEqualTo("예술·스포츠");
        assertThat(commercialDistrict.getSubClassCode()).isEqualTo("R103");
        assertThat(commercialDistrict.getSubClassCodeName()).isEqualTo("스포츠 서비스");
        assertThat(commercialDistrict.getDetailClassCode()).isEqualTo("R10310");
        assertThat(commercialDistrict.getDetailClassCodeName()).isEqualTo("당구장");
        assertThat(commercialDistrict.getStandardClassCode()).isEqualTo("R91135");
        assertThat(commercialDistrict.getStandardClassCodeName()).isEqualTo("당구장 운영업");
    }
}
