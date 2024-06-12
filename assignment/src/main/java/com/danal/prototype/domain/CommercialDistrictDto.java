package com.danal.prototype.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CommercialDistrictDto {

    private String bizNo;

    private String bizName;

    private String branchName;

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
                .branchName(branchName)
                .mainClassCode(mainClassCode)
                .mainClassCodeName(mainClassCodeName)
                .subClassCode(subClassCode)
                .subClassCodeName(subClassCodeName)
                .detailClassCode(detailClassCode)
                .detailClassCodeName(detailClassCodeName)
                .standardClassCode(standardClassCode)
                .standardClassCodeName(standardClassCodeName)
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Builder
    public CommercialDistrictDto(String bizNo, String bizName, String branchName, String mainClassCode, String mainClassCodeName, String subClassCode, String subClassCodeName, String detailClassCode, String detailClassCodeName, String standardClassCode, String standardClassCodeName) {
        this.bizNo = bizNo;
        this.bizName = bizName;
        this.branchName = branchName;
        this.mainClassCode = mainClassCode;
        this.mainClassCodeName = mainClassCodeName;
        this.subClassCode = subClassCode;
        this.subClassCodeName = subClassCodeName;
        this.detailClassCode = detailClassCode;
        this.detailClassCodeName = detailClassCodeName;
        this.standardClassCode = standardClassCode;
        this.standardClassCodeName = standardClassCodeName;
    }
}
