package com.pathbreaker.payslip.controller;

import com.pathbreaker.payslip.entity.DepartmentEntity;
import com.pathbreaker.payslip.entity.RoleEntity;
import com.pathbreaker.payslip.request.DepartmentRequest;
import com.pathbreaker.payslip.request.RolesRequest;
import com.pathbreaker.payslip.service.DepartmentService;
import com.pathbreaker.payslip.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(origins="*")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public ResponseEntity<?> createRole(@RequestBody RolesRequest rolesRequest){
        return roleService.createRole(rolesRequest);
    }

    @GetMapping("/all")
    public List<RoleEntity> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<RoleEntity> getById(@PathVariable int id){
        return roleService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id,@RequestBody RolesRequest rolesRequest){
        return roleService.updateById(id,rolesRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return roleService.deleteById(id);
    }

}
