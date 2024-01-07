package com.workflownexus.organizationservice.query.projection;

import com.workflownexus.organizationservice.common.mappers.EmployeeMapper;
import com.workflownexus.organizationservice.data.entity.EmployeeRoles;
import com.workflownexus.organizationservice.data.entity.Employees;
import com.workflownexus.organizationservice.data.repository.EmployeeRepo;
import com.workflownexus.organizationservice.query.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.query.model.response.RoleResponse;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetAllEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetEmployee;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeProjection {
    private final EmployeeRepo employeeRepo;

    @QueryHandler
    public List<EmployeeResponse> handle(GetAllEmployee getAllEmployee){

        List<Employees> employeesList = employeeRepo.findAll();
        List<EmployeeResponse> responseList = new ArrayList<>();

        for (Employees employee: employeesList) {
            EmployeeResponse response = mapEmpEntityToEmpResponse(employee);
            responseList.add(response);
        }

        return responseList;
    }

    @QueryHandler
    public EmployeeResponse handle(GetEmployee getEmployee){

        Employees employee = employeeRepo.findById(getEmployee.getEmployeeId()).orElse(null);

        if(employee != null){
            EmployeeResponse response = mapEmpEntityToEmpResponse(employee);
            return response;
        }

        return null;
    }



    private EmployeeResponse mapEmpEntityToEmpResponse(Employees employee){
        EmployeeResponse response = EmployeeMapper.INSTANCE.mapToEmployeeEntity(employee);
        List<RoleResponse> roleList = getRoleResponses(employee.getEmployeeRoles());
        response.setRoleList(roleList);
        return response;
    }

    private List<RoleResponse> getRoleResponses(List<EmployeeRoles> employeeRoleList){

        List<RoleResponse> roleResponseList = new ArrayList<>();
        for (EmployeeRoles employeeRole: employeeRoleList) {
            RoleResponse roleResponse = new RoleResponse(employeeRole.getRole().getRoleId(), employeeRole.getRole().getRoleName());
            roleResponseList.add(roleResponse);
        }

        return roleResponseList;
    }
}
