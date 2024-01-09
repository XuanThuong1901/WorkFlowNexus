package com.workflownexus.organizationservice.query.service;

import com.workflownexus.organizationservice.query.model.response.DepartmentResponse;
import com.workflownexus.organizationservice.query.query.departmentQuery.GetDepartment;

import java.util.List;

public interface IDepartmentQueryService {
    List<DepartmentResponse> getAllDepartment();
    DepartmentResponse getDepartment(GetDepartment getDepartment);
}
