package com.workflownexus.organizationservice.query.service;

import com.workflownexus.organizationservice.query.model.response.TeamResponse;
import com.workflownexus.organizationservice.query.query.teamQuery.GetTeam;

import java.util.List;

public interface ITeamQueryService {

    List<TeamResponse> getALlTeam();
    TeamResponse getTeam(GetTeam getTeam);
}
