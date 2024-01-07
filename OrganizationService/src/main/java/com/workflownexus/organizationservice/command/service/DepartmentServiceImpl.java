package com.workflownexus.organizationservice.command.service;

import com.workflownexus.organizationservice.command.event.departmentEvent.CreateDepartmentEvent;
import com.workflownexus.organizationservice.command.event.departmentEvent.DeleteDepartmentEvent;
import com.workflownexus.organizationservice.command.event.departmentEvent.UpdateDepartmentEvent;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.common.Message;
import com.workflownexus.organizationservice.data.entity.Departments;
import com.workflownexus.organizationservice.data.repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService{

    private final DepartmentRepo departmentRepo;

    @Override
    public CommandResponse createDepartment(CreateDepartmentEvent event) {

        try {
            Departments department = Departments.builder()
                    .departmentId(event.getDepartmentId())
                    .departmentName(event.getDepartmentName())
                    .description(event.getDescription())
                    .createdDate(new Date())
                    .status(true)
                    .build();
            departmentRepo.save(department);
            return new CommandResponse(Message.CREATE_DEPARTMENT_SUCCESS);
        }
        catch (Exception e){
            System.out.println(e);
            return new CommandResponse(Message.CREATE_DEPARTMENT_ERROR);
        }
    }

    @Override
    public CommandResponse updateDepartment(UpdateDepartmentEvent event) {
        try {

            Departments department = departmentRepo.findById(event.getDepartmentId()).orElse(null);
            if(department == null)
                return new CommandResponse(Message.CREATE_DEPARTMENT_SUCCESS);

            department.setDepartmentName(event.getDepartmentName());
            department.setDescription(event.getDescription());

            departmentRepo.save(department);
            return new CommandResponse(Message.UPDATE_DEPARTMENT_SUCCESS);
        }
        catch (Exception e){
            System.out.println(e);
            return new CommandResponse(Message.UPDATE_DEPARTMENT_ERROR);
        }
    }

    @Override
    public CommandResponse deleteDepartment(DeleteDepartmentEvent event) {
        return null;
    }
}
