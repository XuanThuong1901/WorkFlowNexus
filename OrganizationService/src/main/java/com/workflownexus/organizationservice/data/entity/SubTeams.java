package com.workflownexus.organizationservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SubTeams")
public class SubTeams {
    @Id
    private String subTeamId;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teamId")
    private Teams team;

    @OneToMany(mappedBy = "subTeam")
    private List<EmployeeSubTeams> employeeSubTeamsList;
}
