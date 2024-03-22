package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.EmployeeEntity;
import com.pathbreaker.payslip.entity.EmployeeLoginEntity;
import com.pathbreaker.payslip.request.EmployeeLoginRequest;
import com.pathbreaker.payslip.request.EmployeeLoginRequestUpdate;
import com.pathbreaker.payslip.request.EmployeeRequest;
import com.pathbreaker.payslip.request.EmployeeUpdateRequest;
import com.pathbreaker.payslip.response.EmployeeLoginResponse;
import com.pathbreaker.payslip.response.EmployeeResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeEntity entityToRequest(EmployeeRequest employeeRequest) {
        if ( employeeRequest == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmployeeId( employeeRequest.getEmployeeId() );
        employeeEntity.setEmployeeType( employeeRequest.getEmployeeType() );
        employeeEntity.setFirstName( employeeRequest.getFirstName() );
        employeeEntity.setLastName( employeeRequest.getLastName() );
        employeeEntity.setEmailId( employeeRequest.getEmailId() );
        employeeEntity.setPassword( employeeRequest.getPassword() );
        employeeEntity.setDesignation( employeeRequest.getDesignation() );
        employeeEntity.setDateOfHiring( employeeRequest.getDateOfHiring() );
        employeeEntity.setDepartment( employeeRequest.getDepartment() );
        employeeEntity.setLocation( employeeRequest.getLocation() );
        employeeEntity.setManager( employeeRequest.getManager() );
        employeeEntity.setRole( employeeRequest.getRole() );
        employeeEntity.setStatus( employeeRequest.getStatus() );
        employeeEntity.setIpAddress( employeeRequest.getIpAddress() );
        employeeEntity.setLoginEntity( employeeRequest.getLoginEntity() );

        return employeeEntity;
    }

    @Override
    public EmployeeResponse responseListToEntity(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setEmployeeId( employeeEntity.getEmployeeId() );
        employeeResponse.setEmployeeType( employeeEntity.getEmployeeType() );
        employeeResponse.setFirstName( employeeEntity.getFirstName() );
        employeeResponse.setLastName( employeeEntity.getLastName() );
        employeeResponse.setEmailId( employeeEntity.getEmailId() );
        employeeResponse.setPassword( employeeEntity.getPassword() );
        employeeResponse.setDesignation( employeeEntity.getDesignation() );
        employeeResponse.setDateOfHiring( employeeEntity.getDateOfHiring() );
        employeeResponse.setDepartment( employeeEntity.getDepartment() );
        employeeResponse.setLocation( employeeEntity.getLocation() );
        employeeResponse.setManager( employeeEntity.getManager() );
        employeeResponse.setRole( employeeEntity.getRole() );
        employeeResponse.setStatus( employeeEntity.getStatus() );
        employeeResponse.setIpAddress( employeeEntity.getIpAddress() );
        employeeResponse.setLoginResponse( employeeLoginEntityToEmployeeLoginResponse( employeeEntity.getLoginEntity() ) );

        return employeeResponse;
    }

    @Override
    public EmployeeEntity updateEntityFromRequest(EmployeeUpdateRequest employeeUpdateRequest, EmployeeEntity employeeEntity) {
        if ( employeeUpdateRequest == null ) {
            return employeeEntity;
        }

        employeeEntity.setEmployeeType( employeeUpdateRequest.getEmployeeType() );
        employeeEntity.setFirstName( employeeUpdateRequest.getFirstName() );
        employeeEntity.setLastName( employeeUpdateRequest.getLastName() );
        employeeEntity.setEmailId( employeeUpdateRequest.getEmailId() );
        employeeEntity.setPassword( employeeUpdateRequest.getPassword() );
        employeeEntity.setDesignation( employeeUpdateRequest.getDesignation() );
        employeeEntity.setDateOfHiring( employeeUpdateRequest.getDateOfHiring() );
        employeeEntity.setDepartment( employeeUpdateRequest.getDepartment() );
        employeeEntity.setLocation( employeeUpdateRequest.getLocation() );
        employeeEntity.setManager( employeeUpdateRequest.getManager() );
        employeeEntity.setRole( employeeUpdateRequest.getRole() );
        employeeEntity.setStatus( employeeUpdateRequest.getStatus() );
        employeeEntity.setIpAddress( employeeUpdateRequest.getIpAddress() );

        return employeeEntity;
    }

    @Override
    public EmployeeEntity employeeEntityToRequest(EmployeeLoginRequest loginRequest) {
        if ( loginRequest == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmailId( loginRequest.getEmailId() );
        employeeEntity.setPassword( loginRequest.getPassword() );
        employeeEntity.setRole( loginRequest.getRole() );
        employeeEntity.setStatus( loginRequest.getStatus() );
        employeeEntity.setIpAddress( loginRequest.getIpAddress() );

        return employeeEntity;
    }

    @Override
    public EmployeeEntity updateEmployeeEntityFromRequest(EmployeeLoginRequestUpdate loginRequestUpdate, EmployeeEntity employeeEntity) {
        if ( loginRequestUpdate == null ) {
            return employeeEntity;
        }

        employeeEntity.setEmailId( loginRequestUpdate.getEmailId() );
        employeeEntity.setPassword( loginRequestUpdate.getPassword() );
        employeeEntity.setRole( loginRequestUpdate.getRole() );
        employeeEntity.setStatus( loginRequestUpdate.getStatus() );
        employeeEntity.setIpAddress( loginRequestUpdate.getIpAddress() );

        return employeeEntity;
    }

    protected EmployeeLoginResponse employeeLoginEntityToEmployeeLoginResponse(EmployeeLoginEntity employeeLoginEntity) {
        if ( employeeLoginEntity == null ) {
            return null;
        }

        EmployeeLoginResponse employeeLoginResponse = new EmployeeLoginResponse();

        employeeLoginResponse.setId( employeeLoginEntity.getId() );
        if ( employeeLoginEntity.getOtp() != null ) {
            employeeLoginResponse.setOtp( employeeLoginEntity.getOtp().intValue() );
        }
        employeeLoginResponse.setEmailId( employeeLoginEntity.getEmailId() );
        employeeLoginResponse.setPassword( employeeLoginEntity.getPassword() );
        employeeLoginResponse.setStatus( employeeLoginEntity.getStatus() );
        employeeLoginResponse.setLastLoginTime( employeeLoginEntity.getLastLoginTime() );
        employeeLoginResponse.setRole( employeeLoginEntity.getRole() );
        employeeLoginResponse.setIpAddress( employeeLoginEntity.getIpAddress() );

        return employeeLoginResponse;
    }
}
