package com.workflownexus.organizationservice.command.event.teamEvent;

import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.command.service.ITeamService;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamEventHandler {

    // Thiếu Department cho Team

    private final ITeamService iTeamService;

    @EventHandler
    public CommandResponse on(CreateTeamEvent event){
        return iTeamService.createTeam(event);
    }

    @EventHandler
    public CommandResponse on(UpdateTeamEvent event){
        return iTeamService.updateTeam(event);
    }

    @EventHandler
    public CommandResponse on(DeleteTeamEvent event){
        return iTeamService.deleteTeam(event);
    }
}
