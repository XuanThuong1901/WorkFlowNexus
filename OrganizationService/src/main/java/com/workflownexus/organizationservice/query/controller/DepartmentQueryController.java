package com.workflownexus.organizationservice.query.controller;

import com.workflownexus.organizationservice.query.model.response.DepartmentResponse;
import com.workflownexus.organizationservice.query.query.departmentQuery.GetAllDepartment;
import com.workflownexus.organizationservice.query.query.departmentQuery.GetDepartment;
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
@RequestMapping("/Department")
public class DepartmentQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartment(){
        GetAllDepartment getAllDepartment = new GetAllDepartment();
        List<DepartmentResponse> responseList = queryGateway.query(getAllDepartment, ResponseTypes.multipleInstancesOf(DepartmentResponse.class)).join();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponse> getDepartment(@RequestParam(name = "departmentId") String departmentId){
        GetDepartment getDepartment = new GetDepartment(departmentId);
        DepartmentResponse response = queryGateway.query(getDepartment, ResponseTypes.instanceOf(DepartmentResponse.class)).join();
        return ResponseEntity.ok(response);
    }
}
