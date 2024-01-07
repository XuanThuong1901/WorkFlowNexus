package com.workflownexus.organizationservice.command.aggregate;

import com.workflownexus.organizationservice.command.command.departmentCommand.CreateDepartmentCommand;
import com.workflownexus.organizationservice.command.command.departmentCommand.UpdateDepartmentCommand;
import com.workflownexus.organizationservice.command.event.departmentEvent.CreateDepartmentEvent;
import com.workflownexus.organizationservice.command.event.departmentEvent.UpdateDepartmentEvent;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.common.mappers.DepartmentMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class DepartmentAggregate {

    @AggregateIdentifier
    private String departmentId;
    private String departmentName;
    private String description;

    // create Department event
    @CommandHandler
    public DepartmentAggregate(CreateDepartmentCommand command){
        CreateDepartmentEvent event = (CreateDepartmentEvent) DepartmentMapper.INSTANCE.mapToDepartmentEvent(command);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateDepartmentEvent event){
        this.departmentId = event.getDepartmentId();
        this.departmentName = event.getDepartmentName();
        this.description = event.getDescription();
    }

    // update Department event
    @CommandHandler
    public DepartmentAggregate(UpdateDepartmentCommand command){
        UpdateDepartmentEvent event = (UpdateDepartmentEvent) DepartmentMapper.INSTANCE.mapToDepartmentEvent(command);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateDepartmentEvent event){
        this.departmentId = event.getDepartmentId();
        this.departmentName = event.getDepartmentName();
        this.description = event.getDescription();
    }

}
