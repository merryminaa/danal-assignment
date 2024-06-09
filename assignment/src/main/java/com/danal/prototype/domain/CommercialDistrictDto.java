package com.danal.prototype.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommercialDistrictDto {

    private String bizNo;

    private String bizName;

    private String mainClassCode;

    private String mainClassCodeName;

    private String subClassCode;

    private String subClassCodeName;

    private String detailClassCode;

    private String detailClassCodeName;

    private String standardClassCode;

    private String standardClassCodeName;

    public CommercialDistrict toEntity(){
        return CommercialDistrict.builder()
                .bizNo(bizNo)
                .bizName(bizName)
                .mainClassCode(mainClassCode)
                .mainClassCodeName(mainClassCodeName)
                .subClassCode(subClassCode)
                .subClassCodeName(subClassCodeName)
                .detailClassCode(detailClassCode)
                .detailClassCodeName(detailClassCodeName)
                .standardClassCode(standardClassCode)
                .standardClassCodeName(standardClassCodeName)
                .build();
    }


}
