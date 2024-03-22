package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.UserLoginEntity;
import com.pathbreaker.payslip.request.UserRequest;
import com.pathbreaker.payslip.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserLoginMapper {
    UserLoginEntity entityToRequest(UserRequest userRequest);

    UserLoginEntity updateEntityFromRequest(UserUpdateRequest userUpdateRequest, @MappingTarget UserLoginEntity userLoginEntity);
}
