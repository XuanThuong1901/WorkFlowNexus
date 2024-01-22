package com.workflownexus.organizationservice.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teams")
public class Teams {

    @Id
    private String teamId;

    private String teamName;
    private String description;
    private Boolean status;
    private Date createdDate;
    private Date closedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departmentId")
    private Departments department;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Employees> employeesList;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<SubTeams> subTeamsList;
}
