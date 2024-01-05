package com.workflownexus.organizationservice.command.event.employeeEvent;

import com.workflownexus.organizationservice.command.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.command.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeEventHandler {

    private final IEmployeeService iEmployeeService;

    @EventHandler
    public EmployeeResponse on(CreateEmployeeEvent event){
        EmployeeResponse response = iEmployeeService.createEmployee(event);
        return response;
    }

    @EventHandler
    public EmployeeResponse on(UpdateEmployeeEvent event){
        EmployeeResponse response = iEmployeeService.updateEmployee(event);
        return response;
    }

    @EventHandler
    public EmployeeResponse on(UpdateRoleEmployeeEvent event){
        EmployeeResponse response = iEmployeeService.updateRoleEmployee(event);
        return response;
    }
}
