package com.workflownexus.organizationservice.command.command.teamCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTeamCommand {
    @TargetAggregateIdentifier
    private String teamId;
}
