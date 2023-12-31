package com.workflownexus.organizationservice.command.event.employeeEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleEmployeeEvent {
    private String employeeId;
    private List<Integer> roles;
}
