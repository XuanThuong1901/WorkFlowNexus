package com.workflownexus.organizationservice.command.service;

import com.workflownexus.organizationservice.command.command.employeeCommand.CreateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateStatusEmployeeCommand;
import com.workflownexus.organizationservice.command.event.employeeEvent.CreateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateRoleEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateStatusEmployeeEvent;
import com.workflownexus.organizationservice.command.model.response.EmployeeResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IEmployeeService {
    EmployeeResponse createEmployee(CreateEmployeeEvent event);
    EmployeeResponse updateEmployee(UpdateEmployeeEvent event);
    EmployeeResponse updateRoleEmployee(UpdateRoleEmployeeEvent event);
    EmployeeResponse updateStatusEmployee(UpdateStatusEmployeeEvent event);
}
