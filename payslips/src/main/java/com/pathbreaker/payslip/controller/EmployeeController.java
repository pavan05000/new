package com.pathbreaker.payslip.controller;

import com.pathbreaker.payslip.entity.DepartmentEntity;
import com.pathbreaker.payslip.request.EmployeeRequest;
import com.pathbreaker.payslip.request.EmployeeUpdateRequest;
import com.pathbreaker.payslip.response.EmployeeResponse;
import com.pathbreaker.payslip.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins="*")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/registration")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return  employeeService.createEmployee(employeeRequest);
    }
    @GetMapping("/all")
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{employeeId}")
    public  EmployeeResponse getEmployeeById(@PathVariable String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable String employeeId,@RequestBody EmployeeUpdateRequest employeeUpdateRequest){
        return employeeService.updateEmployeeById(employeeId,employeeUpdateRequest);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable String employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }

}
