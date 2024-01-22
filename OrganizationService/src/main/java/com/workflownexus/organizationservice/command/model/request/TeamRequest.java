package com.workflownexus.organizationservice.command.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    private String teamName;
    private String departmentId;
    private String description;
}
