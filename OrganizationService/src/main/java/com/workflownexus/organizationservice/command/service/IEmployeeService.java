package com.workflownexus.organizationservice.command.service;

import com.workflownexus.organizationservice.command.command.employeeCommand.CreateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateStatusEmployeeCommand;
import com.workflownexus.organizationservice.command.event.employeeEvent.CreateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateRoleEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateStatusEmployeeEvent;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;

public interface IEmployeeService {
    CommandResponse createEmployee(CreateEmployeeEvent event);
    CommandResponse updateEmployee(UpdateEmployeeEvent event);
    CommandResponse updateRoleEmployee(UpdateRoleEmployeeEvent event);
    CommandResponse updateStatusEmployee(UpdateStatusEmployeeEvent event);
}
