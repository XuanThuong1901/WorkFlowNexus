package com.workflownexus.organizationservice.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    private String employeeId;

    @Unique
    private String email;

    private String password;

    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private boolean sex;
    private String avatar;
    private boolean status;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeRoles> employeeRoles;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeSubTeams> employeeSubTeamsList;

//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
//    private List<EmployeeDepartments> employeeDepartments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departmentId")
    private Departments department;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teamId")
    private Teams team;


}
