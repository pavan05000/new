package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.StatusEntity;
import com.pathbreaker.payslip.request.StatusRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusEntity entityToRequest(StatusRequest statusRequest) {
        if ( statusRequest == null ) {
            return null;
        }

        StatusEntity statusEntity = new StatusEntity();

        statusEntity.setStatus( statusRequest.getStatus() );
        statusEntity.setStatusInfo( statusRequest.getStatusInfo() );

        return statusEntity;
    }
}
