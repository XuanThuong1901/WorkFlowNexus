package com.workflownexus.organizationservice.common.mappers;

import com.workflownexus.organizationservice.command.command.departmentCommand.CreateDepartmentCommand;
import com.workflownexus.organizationservice.command.command.departmentCommand.UpdateDepartmentCommand;
import com.workflownexus.organizationservice.command.model.request.DepartmentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    Object mapToDepartmentCommand(DepartmentRequest request);

    Object mapToDepartmentEvent(Object object);

//    @Mapping(target = "status", ignore = true)
//    Object mapToUpdateDepartmentCommand(DepartmentRequest request);
}
