package com.workflownexus.organizationservice.common.mappers;

import com.workflownexus.organizationservice.command.command.teamCommand.CreateTeamCommand;
import com.workflownexus.organizationservice.command.model.request.TeamRequest;
import com.workflownexus.organizationservice.data.entity.Teams;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    Object mapToTeamCommand(TeamRequest request);
    Object mapToTeamEvent(Object command);
    Object mapToTeamEntity(Object event);

    Object mapToTeamResponse(Teams teams);
}
