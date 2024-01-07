package com.workflownexus.organizationservice.query.controller;

import com.workflownexus.organizationservice.query.model.response.EmployeeResponse;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetAllEmployee;
import com.workflownexus.organizationservice.query.query.employeeQuery.GetEmployee;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){

        GetAllEmployee getAllEmployee = new GetAllEmployee();
        List<EmployeeResponse> responseList = queryGateway.query(getAllEmployee, ResponseTypes.multipleInstancesOf(EmployeeResponse.class)).join();

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@RequestParam(name = "employeeId") String employeeId){

        GetEmployee getEmployee = new GetEmployee(employeeId);
        EmployeeResponse response = queryGateway.query(getEmployee, ResponseTypes.instanceOf(EmployeeResponse.class)).join();

        return ResponseEntity.ok(response);
    }
}
