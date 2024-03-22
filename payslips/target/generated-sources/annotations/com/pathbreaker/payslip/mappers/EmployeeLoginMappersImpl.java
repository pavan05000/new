package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.EmployeeEntity;
import com.pathbreaker.payslip.entity.EmployeeLoginEntity;
import com.pathbreaker.payslip.request.EmployeeRequest;
import com.pathbreaker.payslip.request.EmployeeUpdateRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeLoginMappersImpl implements EmployeeLoginMappers {

    @Override
    public EmployeeLoginEntity entityToRequest(EmployeeRequest employeeRequest) {
        if ( employeeRequest == null ) {
            return null;
        }

        EmployeeLoginEntity employeeLoginEntity = new EmployeeLoginEntity();

        employeeLoginEntity.setEmailId( employeeRequest.getEmailId() );
        employeeLoginEntity.setPassword( employeeRequest.getPassword() );
        employeeLoginEntity.setStatus( employeeRequest.getStatus() );
        employeeLoginEntity.setRole( employeeRequest.getRole() );
        employeeLoginEntity.setIpAddress( employeeRequest.getIpAddress() );
        employeeLoginEntity.setEmployeeEntity( employeeLoginEntityToEmployeeEntity( employeeRequest.getLoginEntity() ) );

        return employeeLoginEntity;
    }

    @Override
    public EmployeeLoginEntity updateEntityFromRequest(EmployeeUpdateRequest employeeUpdateRequest, EmployeeLoginEntity loginEntity) {
        if ( employeeUpdateRequest == null ) {
            return loginEntity;
        }

        loginEntity.setEmailId( employeeUpdateRequest.getEmailId() );
        loginEntity.setPassword( employeeUpdateRequest.getPassword() );
        loginEntity.setStatus( employeeUpdateRequest.getStatus() );
        loginEntity.setRole( employeeUpdateRequest.getRole() );
        loginEntity.setIpAddress( employeeUpdateRequest.getIpAddress() );

        return loginEntity;
    }

    protected EmployeeEntity employeeLoginEntityToEmployeeEntity(EmployeeLoginEntity employeeLoginEntity) {
        if ( employeeLoginEntity == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmailId( employeeLoginEntity.getEmailId() );
        employeeEntity.setPassword( employeeLoginEntity.getPassword() );
        employeeEntity.setRole( employeeLoginEntity.getRole() );
        employeeEntity.setStatus( employeeLoginEntity.getStatus() );
        employeeEntity.setIpAddress( employeeLoginEntity.getIpAddress() );

        return employeeEntity;
    }
}
