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
import com.workflownexus.organizationservice.data.repository.EmployeeRoleRepo;
import com.workflownexus.organizationservice.data.repository.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{

    private final EmployeeRepo employeeRepo;
    private final RoleRepo roleRepo;
    private final EmployeeRoleRepo employeeRoleRepo;

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

            List<EmployeeRoles> employeeRolesList = createRoleForEmployee(employee, event.getRoles());
            if(employeeRolesList == null)
                return new EmployeeResponse(Message.ERROR_ACCESSING_ROLE);

            employee.setEmployeeRoles(employeeRolesList);
            employeeRepo.save(employee);

        }catch (Exception e){
            System.out.println(e);
            return new EmployeeResponse(Message.CREATE_EMPLOYEE_SUCCESS);
        }
        return new EmployeeResponse(Message.CREATE_EMPLOYEE_ERROR);
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(UpdateEmployeeEvent event) {
        try {

            Employees employee = employeeRepo.findById(event.getEmployeeId()).orElse(null);
            if(employee == null)
                return new EmployeeResponse(Message.EMPLOYEE_CODE_DOES_NOT_EXIST);

            employee = Employees.builder()
                    .firstName(event.getFirstName())
                    .lastName(event.getLastName())
                    .address(event.getAddress())
                    .telephone(event.getTelephone())
                    .sex(event.isSex())
                    .build();

            if(event.getAvatar() != null){
                String urlAvatar = Firebase.save(event.getAvatar());
                Firebase.delete(employee.getAvatar());

                employee.setAvatar(urlAvatar);
            }

            List<EmployeeRoles> employeeRolesList = updateRoleForEmployee(employee, employee.getEmployeeRoles(), event.getRoles());
            if(employeeRolesList == null)
                return new EmployeeResponse(Message.UPDATE_EMPLOYEE_ERROR);

            employeeRepo.save(employee);
            return new EmployeeResponse(Message.UPDATE_EMPLOYEE_SUCCESS);

        }catch (Exception e){
            System.out.println(e);
            return new EmployeeResponse(Message.UPDATE_EMPLOYEE_ERROR);
        }
    }

    @Override
    @Transactional
    public EmployeeResponse updateRoleEmployee(UpdateRoleEmployeeEvent event) {

        try {
            Employees employee = employeeRepo.findById(event.getEmployeeId()).orElse(null);
            if(employee == null)
                return new EmployeeResponse(Message.EMPLOYEE_CODE_DOES_NOT_EXIST);

            List<EmployeeRoles> employeeRolesList = updateRoleForEmployee(employee, employee.getEmployeeRoles(), event.getRoles());

            if(employeeRolesList == null)
                return new EmployeeResponse(Message.UPDATE_EMPLOYEE_ROLE_ERROR);

            employee.setEmployeeRoles(employeeRolesList);
            employeeRepo.save(employee);
            
            return new EmployeeResponse(Message.UPDATE_EMPLOYEE_ROLE_SUCCESS);

        }catch (Exception e){
            System.out.println(e);
            return new EmployeeResponse(Message.UPDATE_EMPLOYEE_ROLE_ERROR);
        }
    }

    @Override
    public EmployeeResponse updateStatusEmployee(UpdateStatusEmployeeEvent event) {
        return null;
    }

    private List<EmployeeRoles> updateRoleForEmployee(Employees employee, List<EmployeeRoles> employeeRoles, List<Integer> rolesUpdate){

        List<EmployeeRoles> employeeRolesList = createRoleForEmployee(employee, rolesUpdate);

        if(employeeRolesList != null){
            employeeRoleRepo.deleteAllInBatch(employeeRoles);
        }
        return employeeRolesList;
    }


    private List<EmployeeRoles> createRoleForEmployee(Employees employee, List<Integer> roles){

        List<EmployeeRoles> employeeRolesList = new ArrayList<>();
        for (Integer index: roles) {
            Roles role = roleRepo.findById(index).orElse(null);
            if(role == null){
                return null;
            }

            EmployeeRoles employeeRole = new EmployeeRoles(new EmployeeRoleId(role.getRoleId(), employee.getEmployeeId()), role, employee);
            employeeRolesList.add(employeeRole);
        }
        return employeeRolesList;
    }
}
