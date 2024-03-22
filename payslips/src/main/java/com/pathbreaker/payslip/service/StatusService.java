package com.pathbreaker.payslip.service;

import com.pathbreaker.payslip.entity.StatusEntity;
import com.pathbreaker.payslip.request.StatusRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    ResponseEntity<?> createStatus(StatusRequest statusRequest);

    List<StatusEntity> getAllStatus();

    Optional<StatusEntity> getById(int id);

    ResponseEntity<?> updateById(int id, StatusRequest statusRequest);

    ResponseEntity<?> deleteById(int id);
}
