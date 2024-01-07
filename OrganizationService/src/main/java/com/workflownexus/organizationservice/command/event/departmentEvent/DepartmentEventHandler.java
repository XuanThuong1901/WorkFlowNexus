package com.workflownexus.organizationservice.command.event.departmentEvent;

import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.command.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentEventHandler {

    private final IDepartmentService iDepartmentService;

    @EventHandler
    public CommandResponse on(CreateDepartmentEvent event){

        return null;
    }

    @EventHandler
    public CommandResponse on(UpdateDepartmentEvent event){

        return null;
    }
}
