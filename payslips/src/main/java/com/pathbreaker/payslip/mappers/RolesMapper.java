package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.RoleEntity;
import com.pathbreaker.payslip.request.RolesRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    RoleEntity entityToRequest(RolesRequest rolesRequest);
}
