package com.workflownexus.organizationservice.query.service;

import com.workflownexus.organizationservice.common.mappers.EmployeeMapper;
import com.workflownexus.organizationservice.data.entity.EmployeeRoles;
import com.workflownexus.organizationservice.data.entity.EmployeeSubTeams;
import com.workflownexus.organizationservice.data.entity.Employees;
import com.workflownexus.organizationservice.data.entity.SubTeams;
import com.workflownexus.organizationservice.data.repository.EmployeeRepo;
import com.workflownexus.organizationservice.data.repository.SubTeamRepo;
import com.workflownexus.organizationservice.query.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.query.model.response.RoleResponse;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetDepartmentEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetSubTeamEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetTeamEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeQueryServiceImpl implements IEmployeeQueryService{

    private final EmployeeRepo employeeRepo;
    private final SubTeamRepo subTeamRepo;

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        List<Employees> employeesList = employeeRepo.findAll();
        List<EmployeeResponse> responseList = mapEmpEntityToEmpResponseList(employeesList);

        return responseList;
    }

    @Override
    public EmployeeResponse getEmployee(GetEmployee getEmployee) {
        Employees employee = employeeRepo.findById(getEmployee.getEmployeeId()).orElse(null);

        if(employee != null){
            EmployeeResponse response = mapEmpEntityToEmpResponse(employee);
            return response;
        }

        return null;
    }

    @Override
    public List<EmployeeResponse> getDepartmentEmployee(GetDepartmentEmployee getDepartmentEmployee) {
        List<Employees> employeesList = employeeRepo.findByDepartment_DepartmentId(getDepartmentEmployee.getDepartmentId());
        List<EmployeeResponse> responseList = mapEmpEntityToEmpResponseList(employeesList);
        return responseList;
    }

    @Override
    public List<EmployeeResponse> getTeamEmployee(GetTeamEmployee getTeamEmployee) {
        List<Employees> employeesList = employeeRepo.findByTeam_TeamId(getTeamEmployee.getTeamId());
        List<EmployeeResponse> responseList = mapEmpEntityToEmpResponseList(employeesList);

        return responseList;
    }

    @Override
    public List<EmployeeResponse> getSubTeamEmployee(GetSubTeamEmployee getSubTeamEmployee) {
        SubTeams subTeam = subTeamRepo.findById(getSubTeamEmployee.getSubTeamId()).orElse(null);
        if(subTeam != null)
        {
            List<Employees> employeesList = employeeRepo.findByTeam_TeamId(subTeam.getTeam().getTeamId());

            List<Employees> employeesInSubTeam = employeesList.stream().filter(employees -> {
                for (EmployeeSubTeams employeeSubTeam: employees.getEmployeeSubTeamsList()) {
                    if(employeeSubTeam.getEmployeeSubTeamId().equals(getSubTeamEmployee.getSubTeamId()))
                        return true;
                }
                return false;
            }).collect(Collectors.toList());

            List<EmployeeResponse> responseList = mapEmpEntityToEmpResponseList(employeesInSubTeam);

            return responseList;
        }
        return null;
    }

    private List<EmployeeResponse>mapEmpEntityToEmpResponseList(List<Employees> employeesList){
        List<EmployeeResponse> responseList = new ArrayList<>();

        for (Employees employee: employeesList) {
            EmployeeResponse response = mapEmpEntityToEmpResponse(employee);
            responseList.add(response);
        }

        return responseList;
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
