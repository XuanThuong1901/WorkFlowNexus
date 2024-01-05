package com.workflownexus.organizationservice.command.service;

import com.workflownexus.organizationservice.command.event.employeeEvent.CreateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateRoleEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateStatusEmployeeEvent;
import com.workflownexus.organizationservice.command.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.common.Message;
import com.workflownexus.organizationservice.config.Firebase;
import com.workflownexus.organizationservice.data.entity.EmployeeRoles;
import com.workflownexus.organizationservice.data.entity.Employees;
import com.workflownexus.organizationservice.data.entity.Roles;
import com.workflownexus.organizationservice.data.entity.embeddable.EmployeeRoleId;
import com.workflownexus.organizationservice.data.repository.EmployeeRepo;
import com.workflownexus.organizationservice.data.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{

    private final EmployeeRepo employeeRepo;
    private final RoleRepo roleRepo;

    private final boolean STATUS_WORK = true;
    private final boolean STATUS_STOP_WORK = false;

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeEvent event) {
        try {
            Employees employee = Employees.builder()
                    .employeeId(event.getEmployeeId())
                    .firstName(event.getFirstName())
                    .lastName(event.getLastName())
                    .address(event.getAddress())
                    .email(event.getEmail())
                    .password(event.getPassword())
                    .telephone(event.getTelephone())
                    .sex(event.isSex())
                    .status(STATUS_WORK)
                    .build();

            String urlAvatar = Firebase.save(event.getAvatar());
            employee.setAvatar(urlAvatar);

            List<EmployeeRoles> employeeRolesList = new ArrayList<>();
            for (Integer index: event.getRoles()) {
                Roles role = roleRepo.findById(index).orElse(null);
                if(role == null){
                    return new EmployeeResponse(Message.ERROR_ACCESSING_ROLE);
                }

                EmployeeRoles employeeRole = new EmployeeRoles(new EmployeeRoleId(role.getRoleId(), employee.getEmployeeId()), role, employee);
                employeeRolesList.add(employeeRole);
            }

            employee.setEmployeeRoles(employeeRolesList);
            employeeRepo.save(employee);

        }catch (Exception e){
            System.out.println(e);
            return new EmployeeResponse(Message.CREATE_EMPLOYEE_SUCCESS);
        }
        return new EmployeeResponse(Message.CREATE_EMPLOYEE_ERROR);
    }

    @Override
    public EmployeeResponse updateEmployee(UpdateEmployeeEvent event) {
        return null;
    }

    @Override
    public EmployeeResponse updateRoleEmployee(UpdateRoleEmployeeEvent event) {
        return null;
    }

    @Override
    public EmployeeResponse updateStatusEmployee(UpdateStatusEmployeeEvent event) {
        return null;
    }
}
