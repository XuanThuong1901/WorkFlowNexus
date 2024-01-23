package com.workflownexus.organizationservice.query.projection;

import com.workflownexus.organizationservice.query.model.response.TeamResponse;
import com.workflownexus.organizationservice.query.query.teamQuery.GetAllTeam;
import com.workflownexus.organizationservice.query.query.teamQuery.GetTeam;
import com.workflownexus.organizationservice.query.service.ITeamQueryService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamProjection {

    private final ITeamQueryService iTeamQueryService;

    @QueryHandler
    public List<TeamResponse> handle(GetAllTeam getAllTeam){
        return iTeamQueryService.getALlTeam();
    }

    @QueryHandler
    public TeamResponse handle(GetTeam getTeam){
        return iTeamQueryService.getTeam(getTeam);
    }

}
