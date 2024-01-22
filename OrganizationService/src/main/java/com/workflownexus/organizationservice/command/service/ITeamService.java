package com.workflownexus.organizationservice.command.service;

import com.workflownexus.organizationservice.command.event.teamEvent.CreateTeamEvent;
import com.workflownexus.organizationservice.command.event.teamEvent.DeleteTeamEvent;
import com.workflownexus.organizationservice.command.event.teamEvent.UpdateTeamEvent;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;

public interface ITeamService {

    CommandResponse createTeam(CreateTeamEvent event);
    CommandResponse updateTeam(UpdateTeamEvent event);
    CommandResponse deleteTeam(DeleteTeamEvent event);
}
