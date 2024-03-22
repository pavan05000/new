package com.pathbreaker.payslip.controller;

import com.pathbreaker.payslip.exception.NotFoundException;
import com.pathbreaker.payslip.request.PaySlipUpdateRequest;
import com.pathbreaker.payslip.request.PaySlipsRequest;
import com.pathbreaker.payslip.service.PaySlipService;
import jakarta.persistence.Column;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Slf4j
@CrossOrigin(origins="*")
@RequestMapping("/payslip")
public class PaySlipUploadController {

    @Autowired
    private PaySlipService paySlipService;

    @RequestMapping(value = "/upload-document", method= RequestMethod.POST,
                   consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadDocument(@ModelAttribute PaySlipsRequest paySlipsRequest,
                                            @RequestPart("file") MultipartFile file){
        System.out.println("the contrller upload hitted..");
        return paySlipService.uploadFile(paySlipsRequest,file);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getPayslipById(@PathVariable Long id){
        return paySlipService.getPayslipById(id);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downlaodPayslipById(@PathVariable Long id){
        return paySlipService.downlaodPayslipById(id);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.PUT, consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updatePayslipById(@PathVariable Long id ,@ModelAttribute PaySlipUpdateRequest paySlipsRequest,
                                               @RequestPart("file") MultipartFile file){
        return paySlipService.updatePayslipById(id,paySlipsRequest,file);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayslipById(@PathVariable Long id){
        return paySlipService.deletePayslipById(id);
    }

}
