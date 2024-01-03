package com.workflownexus.organizationservice.common.mappers;

import com.workflownexus.organizationservice.command.command.employeeCommand.CreateEmployeeCommand;
import com.workflownexus.organizationservice.command.model.EmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "roles", source = "roleList")
    @Mapping(target = "status", ignore = true) // Nếu không muốn ánh xạ trường này
    CreateEmployeeCommand mapToCreateEmployeeCommand(EmployeeRequest employeeRequest);


}
