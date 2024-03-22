package com.pathbreaker.payslip.repository;

import com.pathbreaker.payslip.entity.DesignationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<DesignationEntity, Integer> {
}
