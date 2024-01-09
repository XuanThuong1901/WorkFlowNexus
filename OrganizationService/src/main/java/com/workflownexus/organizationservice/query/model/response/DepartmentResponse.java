package com.workflownexus.organizationservice.query.model.response;

import org.checkerframework.common.aliasing.qual.Unique;

import java.util.Date;

public class DepartmentResponse {
    private String departmentId;
    private String departmentName;
    private String description;
    private Date createdDate;
    private Boolean status;
    private Date closedDate;
}
