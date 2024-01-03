package com.workflownexus.organizationservice.data.entity;


import com.workflownexus.organizationservice.data.entity.embeddable.EmployeeSubTeamId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeDepartments")
public class EmployeeSubTeams {
    @EmbeddedId
    private EmployeeSubTeamId employeeSubTeamId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId", insertable = false, updatable = false)
    private Employees employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SubTeamId", referencedColumnName = "SubTeamId", insertable = false, updatable = false)
    private SubTeams subTeam;
}
