package com.workflownexus.organizationservice.command.event.employeeEvent;

import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.command.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeEventHandler {

    private final IEmployeeService iEmployeeService;

    @EventHandler
    public CommandResponse on(CreateEmployeeEvent event){
        CommandResponse response = iEmployeeService.createEmployee(event);
        return response;
    }

    @EventHandler
    public CommandResponse on(UpdateEmployeeEvent event){
        CommandResponse response = iEmployeeService.updateEmployee(event);
        return response;
    }

    @EventHandler
    public CommandResponse on(UpdateRoleEmployeeEvent event){
        CommandResponse response = iEmployeeService.updateRoleEmployee(event);
        return response;
    }
}
