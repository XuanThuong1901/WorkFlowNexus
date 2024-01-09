package com.workflownexus.organizationservice.data.repository;

import com.workflownexus.organizationservice.data.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, String> {

    @Query()
    List<Employees> findByDepartment_DepartmentId(String departmentId);

    @Query()
    List<Employees> findByTeam_TeamId(String teamId);

}
