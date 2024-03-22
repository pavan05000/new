package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.DesignationEntity;
import com.pathbreaker.payslip.request.DesignationRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class DesignationMapperImpl implements DesignationMapper {

    @Override
    public DesignationEntity entityToRequest(DesignationRequest designationRequest) {
        if ( designationRequest == null ) {
            return null;
        }

        DesignationEntity designationEntity = new DesignationEntity();

        designationEntity.setId( designationRequest.getId() );
        designationEntity.setDesignationTitle( designationRequest.getDesignationTitle() );

        return designationEntity;
    }
}
