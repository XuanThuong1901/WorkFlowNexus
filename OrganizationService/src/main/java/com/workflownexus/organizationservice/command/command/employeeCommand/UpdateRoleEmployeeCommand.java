package com.workflownexus.organizationservice.command.command.employeeCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleEmployeeCommand {
    @TargetAggregateIdentifier
    private String employeeId;
    private List<Integer> roles;
}
