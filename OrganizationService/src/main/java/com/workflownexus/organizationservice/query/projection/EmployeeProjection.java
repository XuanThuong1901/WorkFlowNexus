package com.workflownexus.organizationservice.query.projection;

import com.workflownexus.organizationservice.query.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.query.query.employeeQuery.*;
import com.workflownexus.organizationservice.query.service.IEmployeeQueryService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeProjection {

    private final IEmployeeQueryService iEmployeeQueryService;

    @QueryHandler
    public List<EmployeeResponse> handle(GetAllEmployee getAllEmployee){

        return iEmployeeQueryService.getAllEmployee();
    }

    @QueryHandler
    public EmployeeResponse handle(GetEmployee getEmployee){

        return iEmployeeQueryService.getEmployee(getEmployee);
    }

    @QueryHandler
    public List<EmployeeResponse> handle(GetDepartmentEmployee getDepartmentEmployee){

        return iEmployeeQueryService.getDepartmentEmployee(getDepartmentEmployee);
    }

    @QueryHandler
    public List<EmployeeResponse> handle(GetTeamEmployee getTeamEmployee){

        return iEmployeeQueryService.getTeamEmployee(getTeamEmployee);
    }

    @QueryHandler
    public List<EmployeeResponse> handle(GetSubTeamEmployee getSubTeamEmployee){

        return iEmployeeQueryService.getSubTeamEmployee(getSubTeamEmployee);
    }

}
