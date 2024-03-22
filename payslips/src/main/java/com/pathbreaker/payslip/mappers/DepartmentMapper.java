package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.DepartmentEntity;
import com.pathbreaker.payslip.request.DepartmentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentEntity entityToRequest(DepartmentRequest departmentRequest);
}
