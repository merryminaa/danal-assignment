package com.danal.prototype.repository;

import com.danal.prototype.domain.CommercialDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommercialDistrictRepository extends JpaRepository<CommercialDistrict, Long> {

    Optional<CommercialDistrict> findByBizNo(String bizNo);
}
