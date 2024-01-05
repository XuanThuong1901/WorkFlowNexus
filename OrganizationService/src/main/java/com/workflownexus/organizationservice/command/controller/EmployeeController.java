package com.workflownexus.organizationservice.command.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workflownexus.organizationservice.command.command.employeeCommand.CreateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateRoleEmployeeCommand;
import com.workflownexus.organizationservice.command.model.request.EmployeeRequest;
import com.workflownexus.organizationservice.command.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.common.Message;
import com.workflownexus.organizationservice.common.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponse> createEmployee(@PathVariable("employeeRequest") String request, @PathVariable("avatar")MultipartFile avatar){

        EmployeeRequest employeeRequest = convert(request);

        CreateEmployeeCommand command = EmployeeMapper.INSTANCE.mapToCreateEmployeeCommand(employeeRequest);
        command.setEmployeeId(UUID.randomUUID().toString());
        command.setAvatar(avatar);
//        System.out.println(command);
        EmployeeResponse response = commandGateway.sendAndWait(command);
        if(response.getMessage().equals(Message.CREATE_EMPLOYEE_SUCCESS))
            return ResponseEntity.ok(response);
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("employeeRequest") String request, @PathVariable("avatar")MultipartFile avatar){

        EmployeeRequest employeeRequest = convert(request);

        UpdateEmployeeCommand command = EmployeeMapper.INSTANCE.mapToUpdateEmployeeCommand(employeeRequest);

        command.setAvatar(avatar);
//        System.out.println(command);
        EmployeeResponse response = commandGateway.sendAndWait(command);
        if(response.getMessage().equals(Message.UPDATE_EMPLOYEE_SUCCESS))
            return ResponseEntity.ok(response);
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/update_role")
    public ResponseEntity<EmployeeResponse> updateRoleEmployee(@RequestBody() EmployeeRequest request){

        UpdateRoleEmployeeCommand command = EmployeeMapper.INSTANCE.mapToUpdateRoleEmployeeCommand(request);

//        System.out.println(command);
        EmployeeResponse response = commandGateway.sendAndWait(command);
        if(response.getMessage().equals(Message.UPDATE_EMPLOYEE_SUCCESS))
            return ResponseEntity.ok(response);
        return ResponseEntity.badRequest().body(response);
    }

    private EmployeeRequest convert(String request){
        return new ObjectMapper().convertValue(request, EmployeeRequest.class);
    }


}
