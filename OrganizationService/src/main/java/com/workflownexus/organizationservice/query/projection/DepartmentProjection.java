package com.workflownexus.organizationservice.query.projection;

import com.workflownexus.organizationservice.query.model.response.DepartmentResponse;
import com.workflownexus.organizationservice.query.query.departmentQuery.GetAllDepartment;
import com.workflownexus.organizationservice.query.query.departmentQuery.GetDepartment;
import com.workflownexus.organizationservice.query.service.IDepartmentQueryService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentProjection {

    private final IDepartmentQueryService iDepartmentQueryService;

    @QueryHandler
    public List<DepartmentResponse> getAllDepartment(GetAllDepartment getAllDepartment){

        return iDepartmentQueryService.getAllDepartment();
    }

    private DepartmentResponse getDepartment(GetDepartment getDepartment){

        return iDepartmentQueryService.getDepartment(getDepartment);
    }
}
