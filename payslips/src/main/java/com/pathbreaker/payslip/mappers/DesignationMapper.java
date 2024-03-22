package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.DepartmentEntity;
import com.pathbreaker.payslip.entity.DesignationEntity;
import com.pathbreaker.payslip.request.DepartmentRequest;
import com.pathbreaker.payslip.request.DesignationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DesignationMapper {

    DesignationEntity entityToRequest(DesignationRequest designationRequest);

}
