package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.DepartmentEntity;
import com.pathbreaker.payslip.request.DepartmentRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentEntity entityToRequest(DepartmentRequest departmentRequest) {
        if ( departmentRequest == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId( departmentRequest.getId() );
        departmentEntity.setDepartmentTitle( departmentRequest.getDepartmentTitle() );

        return departmentEntity;
    }
}
