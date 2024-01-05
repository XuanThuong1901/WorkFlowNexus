package com.workflownexus.organizationservice.command.command.employeeCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeCommand {

    @TargetAggregateIdentifier
    private String employeeId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private boolean sex;
    private String urlAvatar;
    private MultipartFile avatar;
    private List<Integer> roles;
}
