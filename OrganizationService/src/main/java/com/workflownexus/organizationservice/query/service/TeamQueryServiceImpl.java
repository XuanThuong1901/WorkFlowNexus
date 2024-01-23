package com.workflownexus.organizationservice.query.service;

import com.workflownexus.organizationservice.common.mappers.TeamMapper;
import com.workflownexus.organizationservice.data.entity.Teams;
import com.workflownexus.organizationservice.data.repository.TeamRepo;
import com.workflownexus.organizationservice.query.model.response.TeamResponse;
import com.workflownexus.organizationservice.query.query.teamQuery.GetTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamQueryServiceImpl implements ITeamQueryService{

    private final TeamRepo teamRepo;

    @Override
    public List<TeamResponse> getALlTeam() {
        List<Teams> teamsList = teamRepo.findAll();
        List<TeamResponse> responseList = new ArrayList<>();
        for (Teams team: teamsList) {
            TeamResponse response = mapToTeamResponse(team);
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public TeamResponse getTeam(GetTeam getTeam) {
        Teams team = teamRepo.findById(getTeam.getTeamId()).orElse(null);
        if(team == null)
            return null;
        TeamResponse response = mapToTeamResponse(team);

        return response;
    }


    private TeamResponse mapToTeamResponse(Teams team){
        return (TeamResponse) TeamMapper.INSTANCE.mapToTeamResponse(team);
    }
}
