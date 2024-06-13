package com.danal.prototype.job;

import com.danal.prototype.domain.CommercialDistrict;
import com.danal.prototype.domain.CommercialDistrictDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CsvScheduleWriter implements ItemWriter<CommercialDistrictDto> {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void write(Chunk<? extends CommercialDistrictDto> chunk) throws Exception {
        List<CommercialDistrict> commercialDistricts = new ArrayList<>();

        chunk.forEach(getCommercialDistrictDto -> {
            commercialDistricts.add(getCommercialDistrictDto.toEntity());
        });

        batchInsert(commercialDistricts);
    }

    private void batchInsert(List<CommercialDistrict> commercialDistricts) {
        String sql = "INSERT INTO commercial_district " +
                "(biz_no, biz_name, branch_name, main_class_code, main_class_code_name, sub_class_code, sub_class_code_name, " +
                "detail_class_code, detail_class_code_name, standard_class_code, standard_class_code_name, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        List<Object[]> batchArgs = new ArrayList<>();
        for (CommercialDistrict commercialDistrict : commercialDistricts) {
            Object[] values = new Object[] {
                    commercialDistrict.getBizNo(),
                    commercialDistrict.getBizName(),
                    commercialDistrict.getBranchName(),
                    commercialDistrict.getMainClassCode(),
                    commercialDistrict.getMainClassCodeName(),
                    commercialDistrict.getSubClassCode(),
                    commercialDistrict.getSubClassCodeName(),
                    commercialDistrict.getDetailClassCode(),
                    commercialDistrict.getDetailClassCodeName(),
                    commercialDistrict.getStandardClassCode(),
                    commercialDistrict.getStandardClassCodeName(),
                    LocalDateTime.now()
            };
            batchArgs.add(values);
        }

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
