package com.workflownexus.organizationservice.command.aggregate;

import com.workflownexus.organizationservice.command.command.teamCommand.CreateTeamCommand;
import com.workflownexus.organizationservice.command.command.teamCommand.DeleteTeamCommand;
import com.workflownexus.organizationservice.command.command.teamCommand.UpdateTeamCommand;
import com.workflownexus.organizationservice.command.event.teamEvent.CreateTeamEvent;
import com.workflownexus.organizationservice.command.event.teamEvent.DeleteTeamEvent;
import com.workflownexus.organizationservice.command.event.teamEvent.UpdateTeamEvent;
import com.workflownexus.organizationservice.command.model.request.TeamRequest;
import com.workflownexus.organizationservice.common.mappers.TeamMapper;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class TeamAggregate {

    @AggregateIdentifier
    private String teamId;
    private String departmentId;
    private String teamName;
    private String description;

    // create
    @CommandHandler
    public TeamAggregate(CreateTeamCommand command){
        CreateTeamEvent event = (CreateTeamEvent) TeamMapper.INSTANCE.mapToTeamEvent(command);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateTeamEvent event){
        this.teamId = event.getTeamId();
        this.departmentId = event.getDepartmentId();
        this.teamName = event.getTeamName();
        this.description = event.getDescription();
    }

    // Update
    @CommandHandler
    public TeamAggregate(UpdateTeamCommand command){
        UpdateTeamEvent event = (UpdateTeamEvent) TeamMapper.INSTANCE.mapToTeamEvent(command);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateTeamEvent event){
        this.teamId = event.getTeamId();
        this.departmentId = event.getDepartmentId();
        this.teamName = event.getTeamName();
        this.description = event.getDescription();
    }

    // Delete
    @CommandHandler
    public TeamAggregate(DeleteTeamCommand command){
        DeleteTeamEvent event = (DeleteTeamEvent) TeamMapper.INSTANCE.mapToTeamEvent(command);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DeleteTeamEvent event){
        this.teamId = event.getTeamId();
    }
}
