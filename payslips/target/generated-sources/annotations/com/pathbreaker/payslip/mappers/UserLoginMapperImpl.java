package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.UserLoginEntity;
import com.pathbreaker.payslip.request.UserRequest;
import com.pathbreaker.payslip.request.UserUpdateRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserLoginMapperImpl implements UserLoginMapper {

    @Override
    public UserLoginEntity entityToRequest(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserLoginEntity userLoginEntity = new UserLoginEntity();

        userLoginEntity.setEmailId( userRequest.getEmailId() );
        userLoginEntity.setUserName( userRequest.getUserName() );
        userLoginEntity.setPassword( userRequest.getPassword() );
        userLoginEntity.setRole( userRequest.getRole() );

        return userLoginEntity;
    }

    @Override
    public UserLoginEntity updateEntityFromRequest(UserUpdateRequest userUpdateRequest, UserLoginEntity userLoginEntity) {
        if ( userUpdateRequest == null ) {
            return userLoginEntity;
        }

        userLoginEntity.setEmailId( userUpdateRequest.getEmailId() );
        userLoginEntity.setUserName( userUpdateRequest.getUserName() );
        userLoginEntity.setPassword( userUpdateRequest.getPassword() );
        userLoginEntity.setRole( userUpdateRequest.getRole() );

        return userLoginEntity;
    }
}
