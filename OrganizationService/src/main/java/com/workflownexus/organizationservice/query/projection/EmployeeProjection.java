package com.workflownexus.organizationservice.query.projection;

import com.workflownexus.organizationservice.common.mappers.EmployeeMapper;
import com.workflownexus.organizationservice.data.entity.EmployeeRoles;
import com.workflownexus.organizationservice.data.entity.EmployeeSubTeams;
import com.workflownexus.organizationservice.data.entity.Employees;
import com.workflownexus.organizationservice.data.entity.SubTeams;
import com.workflownexus.organizationservice.data.repository.EmployeeRepo;
import com.workflownexus.organizationservice.data.repository.SubTeamRepo;
import com.workflownexus.organizationservice.query.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.query.model.response.RoleResponse;
import com.workflownexus.organizationservice.query.query.employeeQuery.*;
import com.workflownexus.organizationservice.query.service.IEmployeeQueryService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
