package com.workflownexus.organizationservice.command.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String employeeId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private boolean sex;
//    private String avatar;
    private boolean status;
    private List<Integer> roleList;
}
