package com.workflownexus.organizationservice.data.repository;

import com.workflownexus.organizationservice.data.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments, String> {
}
