package com.danal.prototype.job;

import com.danal.prototype.domain.CommercialDistrictDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class CustomFieldSetMapper implements FieldSetMapper<CommercialDistrictDto> {

    private static final Logger log = LoggerFactory.getLogger(CustomFieldSetMapper.class);

    @Override
    public CommercialDistrictDto mapFieldSet(FieldSet fieldSet) {
        return CommercialDistrictDto.builder()
                .bizNo(fieldSet.readString("상가업소번호"))
                .bizName(fieldSet.readString("상호명"))
                .branchName(fieldSet.readString("지점명"))
                .mainClassCode(fieldSet.readString("상권업종대분류코드"))
                .mainClassCodeName(fieldSet.readString("상권업종대분류명"))
                .subClassCode(fieldSet.readString("상권업종중분류코드"))
                .subClassCodeName(fieldSet.readString("상권업종중분류명"))
                .detailClassCode(fieldSet.readString("상권업종소분류코드"))
                .detailClassCodeName(fieldSet.readString("상권업종소분류명"))
                .standardClassCode(fieldSet.readString("표준산업분류코드"))
                .standardClassCodeName(fieldSet.readString("표준산업분류명"))
                .build();
    }
}
