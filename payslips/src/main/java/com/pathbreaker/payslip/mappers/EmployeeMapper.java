package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.EmployeeEntity;
import com.pathbreaker.payslip.request.EmployeeLoginRequestUpdate;
import com.pathbreaker.payslip.request.EmployeeRequest;
import com.pathbreaker.payslip.request.EmployeeUpdateRequest;
import com.pathbreaker.payslip.request.EmployeeLoginRequest;
import com.pathbreaker.payslip.response.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeEntity entityToRequest(EmployeeRequest employeeRequest);

    @Mappings({
            @Mapping(target = "employeeId", source = "employeeEntity.employeeId"),
            @Mapping(target = "employeeType", source = "employeeEntity.employeeType"),
            @Mapping(target = "firstName", source = "employeeEntity.firstName"),
            @Mapping(target = "lastName", source = "employeeEntity.lastName"),
            @Mapping(target = "emailId", source = "employeeEntity.emailId"),
            @Mapping(target = "password", source = "employeeEntity.password"),
            @Mapping(target = "designation", source = "employeeEntity.designation"),
            @Mapping(target = "dateOfHiring", source = "employeeEntity.dateOfHiring"),
            @Mapping(target = "department", source = "employeeEntity.department"),
            @Mapping(target = "location", source = "employeeEntity.location"),
            @Mapping(target = "manager", source = "employeeEntity.manager"),
            @Mapping(target = "role", source = "employeeEntity.role"),
            @Mapping(target = "status", source = "employeeEntity.status"),
            @Mapping(target = "ipAddress", source = "employeeEntity.ipAddress"),
            @Mapping(target = "loginResponse", source = "employeeEntity.loginEntity"),
    })
    EmployeeResponse responseListToEntity(EmployeeEntity employeeEntity);

    EmployeeEntity updateEntityFromRequest(EmployeeUpdateRequest employeeUpdateRequest, @MappingTarget  EmployeeEntity employeeEntity);

    EmployeeEntity employeeEntityToRequest(EmployeeLoginRequest loginRequest);

    EmployeeEntity updateEmployeeEntityFromRequest(EmployeeLoginRequestUpdate loginRequestUpdate, @MappingTarget EmployeeEntity employeeEntity);
}
