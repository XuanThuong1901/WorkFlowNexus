package com.workflownexus.organizationservice.query.service;

import com.workflownexus.organizationservice.query.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetDepartmentEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetSubTeamEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetTeamEmployee;

import java.util.List;

public interface IEmployeeQueryService {
    List<EmployeeResponse> getAllEmployee();
    EmployeeResponse getEmployee(GetEmployee getEmployee);
    List<EmployeeResponse> getDepartmentEmployee(GetDepartmentEmployee getDepartmentEmployee);
    List<EmployeeResponse> getTeamEmployee(GetTeamEmployee getTeamEmployee);
    List<EmployeeResponse> getSubTeamEmployee(GetSubTeamEmployee getSubTeamEmployee);

}
