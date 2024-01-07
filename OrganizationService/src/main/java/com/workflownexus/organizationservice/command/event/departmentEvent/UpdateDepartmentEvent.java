package com.workflownexus.organizationservice.command.event.departmentEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDepartmentEvent {

    private String departmentId;
    private String departmentName;
    private String description;
}
