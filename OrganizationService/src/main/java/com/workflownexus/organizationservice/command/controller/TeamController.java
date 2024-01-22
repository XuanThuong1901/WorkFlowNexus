package com.workflownexus.organizationservice.command.controller;

import com.workflownexus.organizationservice.command.command.teamCommand.CreateTeamCommand;
import com.workflownexus.organizationservice.command.command.teamCommand.DeleteTeamCommand;
import com.workflownexus.organizationservice.command.command.teamCommand.UpdateTeamCommand;
import com.workflownexus.organizationservice.command.model.request.TeamRequest;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.common.mappers.TeamMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final CommandGateway commandGateway;

    @PostMapping("/add")
    public ResponseEntity<CommandResponse> add(@RequestBody TeamRequest teamRequest){

        CreateTeamCommand command = (CreateTeamCommand) TeamMapper.INSTANCE.mapToTeamCommand(teamRequest);
        command.setTeamId(UUID.randomUUID().toString());
        CommandResponse response = commandGateway.sendAndWait(command);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public ResponseEntity<CommandResponse> update(@RequestBody TeamRequest teamRequest){

        UpdateTeamCommand command = (UpdateTeamCommand) TeamMapper.INSTANCE.mapToTeamCommand(teamRequest);
        CommandResponse response = commandGateway.sendAndWait(command);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete/{teamId}")
    public ResponseEntity<CommandResponse> delete(@RequestParam("teamId") String teamId){

        DeleteTeamCommand command = new DeleteTeamCommand(teamId);
        CommandResponse response = commandGateway.sendAndWait(command);

        return ResponseEntity.ok(response);
    }
}
