package com.workflownexus.organizationservice.command.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    private int departmentId;
    private String departmentName;
    private String description;
    private boolean status;
}
