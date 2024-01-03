package com.workflownexus.organizationservice.data.repository;

import com.workflownexus.organizationservice.data.entity.EmployeeSubTeams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSubTeamRepo extends JpaRepository<EmployeeSubTeams, Integer> {
}
