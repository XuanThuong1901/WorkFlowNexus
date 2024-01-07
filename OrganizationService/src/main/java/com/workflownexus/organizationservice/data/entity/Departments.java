package com.workflownexus.organizationservice.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departments")
public class Departments {

    @Id
    private String departmentId;

    @Unique
    private String departmentName;
    private String description;
    private Date createdDate;
    private Boolean status;
    private Date closedDate;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Teams> teamsList;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employees> employeesList;
}
