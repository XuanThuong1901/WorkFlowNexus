package com.workflownexus.organizationservice.query.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private String employeeId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private Boolean sex;
    private String avatar;
    private Boolean status;
    private List<RoleResponse> roleList;
}
