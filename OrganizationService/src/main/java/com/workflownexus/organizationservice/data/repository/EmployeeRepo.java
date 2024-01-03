package com.workflownexus.organizationservice.data.repository;

import com.workflownexus.organizationservice.data.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, String> {
}
