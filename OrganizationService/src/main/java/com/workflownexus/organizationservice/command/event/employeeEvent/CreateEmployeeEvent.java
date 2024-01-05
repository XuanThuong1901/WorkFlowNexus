package com.workflownexus.organizationservice.command.event.employeeEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeEvent {
    private String employeeId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private boolean sex;
    private MultipartFile avatar;
    private boolean status;
    private List<Integer> roles;
}
