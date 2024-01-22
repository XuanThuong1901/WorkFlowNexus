package com.workflownexus.organizationservice.common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Message {

    public static final String CREATE_EMPLOYEE_SUCCESS = "created employee success";
    public static final String CREATE_EMPLOYEE_ERROR = "created employee error";
    public static final String ERROR_ACCESSING_ROLE = "error accessing role";

    public static final String UPDATE_EMPLOYEE_SUCCESS = "updated employee success";
    public static final String UPDATE_EMPLOYEE_ERROR = "updated employee error";
    public static final String EMPLOYEE_CODE_DOES_NOT_EXIST = "employee code does not exist";

    public static final String UPDATE_EMPLOYEE_ROLE_SUCCESS = "updated employee role success";
    public static final String UPDATE_EMPLOYEE_ROLE_ERROR = "updated employee role error";



    public static final String CREATE_DEPARTMENT_SUCCESS = "created department success";
    public static final String CREATE_DEPARTMENT_ERROR = "created department error";
    public static final String DEPARTMENT_NOT_FOUND = "department not found";
    public static final String ERROR_ACCESSING_DEPARTMENT = "error accessing department";
    public static final String UPDATE_DEPARTMENT_SUCCESS = "updated department success";
    public static final String UPDATE_DEPARTMENT_ERROR = "updated department error";

    public static final String CREATE_TEAM_SUCCESS = "created team success";
    public static final String CREATE_TEAM_ERROR = "created team error";
    public static final String TEAM_NOT_FOUND = "Team not found";
    public static final String UPDATE_TEAM_SUCCESS = "updated team success";
    public static final String UPDATE_TEAM_ERROR = "updated team error";
    public static final String TEAM_CANNOT_DELETE = "team can't delete";
    public static final String DELETE_TEAM_SUCCESS = "deleted team success";
    public static final String DELETE_TEAM_ERROR = "deleted team error";

}
