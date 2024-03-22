package com.pathbreaker.payslip.service;

import com.pathbreaker.payslip.entity.DepartmentEntity;
import com.pathbreaker.payslip.request.DepartmentRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    ResponseEntity<?> createDepartment(DepartmentRequest departmentRequest);

    List<DepartmentEntity> getAllDepartments();

    Optional<DepartmentEntity> getById(int id);

    ResponseEntity<?> updateById(int id, DepartmentRequest departmentRequest);

    ResponseEntity<?> deleteById(int id);
}
