package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.PaySlipUploadEntity;
import com.pathbreaker.payslip.request.PaySlipUpdateRequest;
import com.pathbreaker.payslip.request.PaySlipsRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class PaySlipMapperImpl implements PaySlipMapper {

    @Override
    public PaySlipUploadEntity entityToRequest(PaySlipsRequest paySlipsRequest) {
        if ( paySlipsRequest == null ) {
            return null;
        }

        PaySlipUploadEntity paySlipUploadEntity = new PaySlipUploadEntity();

        paySlipUploadEntity.setEmployeeId( paySlipsRequest.getEmployeeId() );
        paySlipUploadEntity.setMonth( paySlipsRequest.getMonth() );
        paySlipUploadEntity.setFinancialYear( paySlipsRequest.getFinancialYear() );
        paySlipUploadEntity.setFilePaths( paySlipsRequest.getFilePaths() );

        return paySlipUploadEntity;
    }

    @Override
    public PaySlipUploadEntity entityToUpdateRequest(PaySlipUpdateRequest paySlipsRequest, PaySlipUploadEntity entity) {
        if ( paySlipsRequest == null ) {
            return entity;
        }

        entity.setMonth( paySlipsRequest.getMonth() );
        entity.setFinancialYear( paySlipsRequest.getFinancialYear() );

        return entity;
    }
}
