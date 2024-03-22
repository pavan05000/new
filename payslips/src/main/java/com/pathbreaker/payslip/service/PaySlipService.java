package com.pathbreaker.payslip.service;

import com.pathbreaker.payslip.exception.NotFoundException;
import com.pathbreaker.payslip.request.PaySlipUpdateRequest;
import com.pathbreaker.payslip.request.PaySlipsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface PaySlipService {
    ResponseEntity<?> uploadFile(PaySlipsRequest paySlipsRequest,MultipartFile file);

    ResponseEntity<?> downlaodPayslipById(Long id);

    ResponseEntity<?> updatePayslipById(Long id , PaySlipUpdateRequest paySlipsRequest, MultipartFile file);

    ResponseEntity<?> deletePayslipById(Long id);

    ResponseEntity<byte[]> getPayslipById(Long id);
}
