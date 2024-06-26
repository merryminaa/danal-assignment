package com.danal.prototype.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Entity
public class CommercialDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private LocalDateTime createdAt;


    @Builder
    public CommercialDistrict(String bizNo, String bizName, String branchName,
                              String mainClassCode, String mainClassCodeName,
                              String subClassCode, String subClassCodeName,
                              String detailClassCode, String detailClassCodeName,
                              String standardClassCode, String standardClassCodeName,
                              LocalDateTime createdAt) {
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
        this.createdAt = createdAt;
    }
}
