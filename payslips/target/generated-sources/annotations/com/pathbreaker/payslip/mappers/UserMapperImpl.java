package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.UserEntity;
import com.pathbreaker.payslip.entity.UserLoginEntity;
import com.pathbreaker.payslip.request.UserRequest;
import com.pathbreaker.payslip.request.UserUpdateRequest;
import com.pathbreaker.payslip.response.UserLoginResponse;
import com.pathbreaker.payslip.response.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity entityToRequest(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( userRequest.getUserId() );
        userEntity.setEmailId( userRequest.getEmailId() );
        userEntity.setUserName( userRequest.getUserName() );
        userEntity.setPassword( userRequest.getPassword() );
        userEntity.setRole( userRequest.getRole() );
        userEntity.setRegistrationDate( userRequest.getRegistrationDate() );
        userEntity.setUserLoginEntity( userRequest.getUserLoginEntity() );

        return userEntity;
    }

    @Override
    public UserResponse responseListToEntity(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setEmailId( userEntity.getEmailId() );
        userResponse.setPassword( userEntity.getPassword() );
        userResponse.setUserId( userEntity.getUserId() );
        userResponse.setRole( userEntity.getRole() );
        userResponse.setUserName( userEntity.getUserName() );
        userResponse.setRegistrationDate( userEntity.getRegistrationDate() );
        userResponse.setUserLoginResponse( userLoginEntityToUserLoginResponse( userEntity.getUserLoginEntity() ) );

        return userResponse;
    }

    @Override
    public UserEntity updateEntityFromRequest(UserUpdateRequest userUpdateRequest, UserEntity userEntity) {
        if ( userUpdateRequest == null ) {
            return userEntity;
        }

        userEntity.setEmailId( userUpdateRequest.getEmailId() );
        userEntity.setUserName( userUpdateRequest.getUserName() );
        userEntity.setPassword( userUpdateRequest.getPassword() );
        userEntity.setRole( userUpdateRequest.getRole() );
        userEntity.setRegistrationDate( userUpdateRequest.getRegistrationDate() );

        return userEntity;
    }

    protected UserLoginResponse userLoginEntityToUserLoginResponse(UserLoginEntity userLoginEntity) {
        if ( userLoginEntity == null ) {
            return null;
        }

        UserLoginResponse userLoginResponse = new UserLoginResponse();

        userLoginResponse.setId( userLoginEntity.getId() );
        userLoginResponse.setEmailId( userLoginEntity.getEmailId() );
        userLoginResponse.setUserName( userLoginEntity.getUserName() );
        userLoginResponse.setPassword( userLoginEntity.getPassword() );
        userLoginResponse.setRole( userLoginEntity.getRole() );
        userLoginResponse.setLastLoginTime( userLoginEntity.getLastLoginTime() );

        return userLoginResponse;
    }
}
