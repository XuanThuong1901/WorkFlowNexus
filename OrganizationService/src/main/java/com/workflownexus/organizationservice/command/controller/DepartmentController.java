package com.workflownexus.organizationservice.command.controller;

import com.workflownexus.organizationservice.command.command.departmentCommand.CreateDepartmentCommand;
import com.workflownexus.organizationservice.command.command.departmentCommand.UpdateDepartmentCommand;
import com.workflownexus.organizationservice.command.model.request.DepartmentRequest;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.common.mappers.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public ResponseEntity<CommandResponse> createDepartment(@RequestBody DepartmentRequest request){

        CreateDepartmentCommand command = (CreateDepartmentCommand) DepartmentMapper.INSTANCE.mapToDepartmentCommand(request);
        CommandResponse response = commandGateway.sendAndWait(command);

        if(response.getMessage().equals(""))
            return ResponseEntity.ok(response);

        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<CommandResponse> updateDepartment(@RequestBody DepartmentRequest request){

        UpdateDepartmentCommand command = (UpdateDepartmentCommand) DepartmentMapper.INSTANCE.mapToDepartmentCommand(request);
        CommandResponse response = commandGateway.sendAndWait(command);

        if(response.getMessage().equals(""))
            return ResponseEntity.ok(response);

        return ResponseEntity.badRequest().body(response);
    }

//    @PostMapping("/delete")
//    public ResponseEntity<CommandResponse> deleteDepartment(@RequestBody DepartmentRequest request){
//
//        CreateDepartmentCommand command = DepartmentMapper.INSTANCE.mapToDepartmentRequest(request);
//        CommandResponse response = commandGateway.sendAndWait(command);
//
//        if(response.getMessage().equals(""))
//            return ResponseEntity.ok(response);
//
//        return ResponseEntity.badRequest().body(response);
//    }
}
