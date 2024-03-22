package com.pathbreaker.payslip.service;

import com.pathbreaker.payslip.entity.DesignationEntity;
import com.pathbreaker.payslip.request.DesignationRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DesignationService {

    ResponseEntity<?> createDesignation(DesignationRequest designationRequest);

    List<DesignationEntity> getAllDesignation();

    Optional<DesignationEntity> getById(int id);

    ResponseEntity<?> updateById(int id, DesignationRequest designationRequest);

    ResponseEntity<?> deleteById(int id);
}
