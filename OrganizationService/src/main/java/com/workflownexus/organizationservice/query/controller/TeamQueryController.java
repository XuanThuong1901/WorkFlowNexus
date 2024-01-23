package com.workflownexus.organizationservice.query.controller;

import com.workflownexus.organizationservice.query.model.response.TeamResponse;
import com.workflownexus.organizationservice.query.query.teamQuery.GetAllTeam;
import com.workflownexus.organizationservice.query.query.teamQuery.GetTeam;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamQueryController {

    private final QueryGateway queryGateway;

    @GetMapping("")
    public ResponseEntity<List<TeamResponse>> getAllTeam(){
        GetAllTeam getAllTeam = new GetAllTeam();
        List<TeamResponse> responseList = queryGateway.query(getAllTeam, ResponseTypes.multipleInstancesOf(TeamResponse.class)).join();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamResponse> getTeam(@RequestParam(name = "teamId") String teamId){
        GetTeam getTeam = new GetTeam(teamId);
        TeamResponse responseList = queryGateway.query(getTeam, ResponseTypes.instanceOf(TeamResponse.class)).join();
        return ResponseEntity.ok(responseList);
    }
}
