package com.workflownexus.organizationservice.data.repository;

import com.workflownexus.organizationservice.data.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Teams, String> {
}
