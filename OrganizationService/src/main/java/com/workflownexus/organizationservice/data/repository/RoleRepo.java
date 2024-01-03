package com.workflownexus.organizationservice.data.repository;

import com.workflownexus.organizationservice.data.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {
}
