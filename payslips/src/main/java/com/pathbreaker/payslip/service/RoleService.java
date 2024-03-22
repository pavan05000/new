package com.pathbreaker.payslip.service;

import com.pathbreaker.payslip.entity.RoleEntity;
import com.pathbreaker.payslip.request.RolesRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    ResponseEntity<?> createRole(RolesRequest rolesRequest);

    List<RoleEntity> getAllRoles();

    Optional<RoleEntity> getById(int id);

    ResponseEntity<?> updateById(int id, RolesRequest rolesRequest);

    ResponseEntity<?> deleteById(int id);
}
