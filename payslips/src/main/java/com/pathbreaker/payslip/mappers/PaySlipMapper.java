package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.PaySlipUploadEntity;
import com.pathbreaker.payslip.request.PaySlipUpdateRequest;
import com.pathbreaker.payslip.request.PaySlipsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaySlipMapper {
    PaySlipUploadEntity entityToRequest(PaySlipsRequest paySlipsRequest);

    PaySlipUploadEntity entityToUpdateRequest(PaySlipUpdateRequest paySlipsRequest, @MappingTarget PaySlipUploadEntity entity);
}
