package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.StatusEntity;
import com.pathbreaker.payslip.request.StatusRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusEntity entityToRequest(StatusRequest statusRequest);
}
