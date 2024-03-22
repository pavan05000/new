package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.EmployeeLoginEntity;
import com.pathbreaker.payslip.request.EmployeeRequest;
import com.pathbreaker.payslip.request.EmployeeUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeLoginMappers {

    @Mappings({
            @Mapping(target = "emailId", source = "employeeRequest.emailId"),
            @Mapping(target = "password", source = "employeeRequest.password"),
            @Mapping(target = "status", source = "employeeRequest.status"),
            @Mapping(target = "role", source = "employeeRequest.role"),
            @Mapping(target = "ipAddress", source = "employeeRequest.ipAddress"),
            @Mapping(target = "employeeEntity", source = "employeeRequest.loginEntity")
    })
    EmployeeLoginEntity entityToRequest(EmployeeRequest employeeRequest);

    EmployeeLoginEntity updateEntityFromRequest(EmployeeUpdateRequest employeeUpdateRequest, @MappingTarget EmployeeLoginEntity loginEntity);

}
