package com.pathbreaker.payslip.repository;

import com.pathbreaker.payslip.entity.PaySlipUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaySlipRepository extends JpaRepository<PaySlipUploadEntity, Long> {
}
