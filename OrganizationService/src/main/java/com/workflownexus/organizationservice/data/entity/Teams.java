package com.workflownexus.organizationservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamId;

    private String teamName;
    private String description;
    private boolean status;
    private Date createdDate;
    private Date closedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departmentId")
    private Departments department;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Employees> employeesList;
}
