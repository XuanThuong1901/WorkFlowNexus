package com.workflownexus.organizationservice.data.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmployeeSubTeamId implements Serializable {

    @Column(name = "EmployeeId")
    private String employeeId;

    @Column(name = "SubTeamId")
    private String subTeamId;
}
