package com.pathbreaker.payslip.mappers;

import com.pathbreaker.payslip.entity.RoleEntity;
import com.pathbreaker.payslip.request.RolesRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T12:51:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class RolesMapperImpl implements RolesMapper {

    @Override
    public RoleEntity entityToRequest(RolesRequest rolesRequest) {
        if ( rolesRequest == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( rolesRequest.getId() );
        roleEntity.setRole( rolesRequest.getRole() );

        return roleEntity;
    }
}
