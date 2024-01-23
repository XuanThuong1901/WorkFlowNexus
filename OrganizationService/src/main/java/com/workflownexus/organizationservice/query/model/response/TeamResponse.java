package com.workflownexus.organizationservice.query.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {
    private String teamId;
    private String teamName;
    private String description;
    private Boolean status;
    private Date createdDate;
    private Date closedDate;
}
