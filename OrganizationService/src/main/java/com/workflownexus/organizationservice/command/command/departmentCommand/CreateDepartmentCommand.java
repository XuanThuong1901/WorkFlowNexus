package com.workflownexus.organizationservice.command.command.departmentCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentCommand {

    @TargetAggregateIdentifier
    private String departmentId;
    private String departmentName;
    private String description;
}
