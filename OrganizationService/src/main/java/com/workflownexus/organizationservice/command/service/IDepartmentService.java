package com.workflownexus.organizationservice.command.service;

import com.workflownexus.organizationservice.command.event.departmentEvent.CreateDepartmentEvent;
import com.workflownexus.organizationservice.command.event.departmentEvent.DeleteDepartmentEvent;
import com.workflownexus.organizationservice.command.event.departmentEvent.UpdateDepartmentEvent;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;

public interface IDepartmentService {

    CommandResponse createDepartment(CreateDepartmentEvent event);
    CommandResponse updateDepartment(UpdateDepartmentEvent event);
    CommandResponse deleteDepartment(DeleteDepartmentEvent event);
}
