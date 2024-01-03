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
@Table(name = "Departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentId;

    private String departmentName;
    private String description;
    private Date createdDate;
    private boolean status;
    private Date closedDate;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Teams> teamsList;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employees> employeesList;
}
