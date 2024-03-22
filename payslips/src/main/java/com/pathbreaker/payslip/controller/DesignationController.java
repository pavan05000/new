package com.pathbreaker.payslip.controller;

import com.pathbreaker.payslip.entity.DepartmentEntity;
import com.pathbreaker.payslip.entity.DesignationEntity;
import com.pathbreaker.payslip.request.DepartmentRequest;
import com.pathbreaker.payslip.request.DesignationRequest;
import com.pathbreaker.payslip.service.DepartmentService;
import com.pathbreaker.payslip.service.DesignationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(origins="*")
@RequestMapping("/designation")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping("/add")
    public ResponseEntity<?> createDesignation(@RequestBody DesignationRequest designationRequest){
        return designationService.createDesignation(designationRequest);
    }

    @GetMapping("/all")
    public List<DesignationEntity> getAllDesignation(){
        return designationService.getAllDesignation();
    }

    @GetMapping("/{id}")
    public Optional<DesignationEntity> getById(@PathVariable int id){
        return designationService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id,@RequestBody DesignationRequest designationRequest){
        return designationService.updateById(id,designationRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return designationService.deleteById(id);
    }

}
