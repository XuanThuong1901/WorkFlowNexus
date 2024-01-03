package com.workflownexus.organizationservice.command.controller;

import com.workflownexus.organizationservice.command.command.employeeCommand.CreateEmployeeCommand;
import com.workflownexus.organizationservice.command.model.EmployeeRequest;
import com.workflownexus.organizationservice.common.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class EmployeeController {

    @Autowired
    private final CommandGateway commandGateway;

    @PostMapping("/employee/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        CreateEmployeeCommand command = EmployeeMapper.INSTANCE.mapToCreateEmployeeCommand(employeeRequest);
        System.out.println(command);
//        commandGateway.sendAndWait(command);
        return ResponseEntity.ok(".");
    }
}
