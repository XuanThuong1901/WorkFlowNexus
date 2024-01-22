package com.workflownexus.organizationservice.command.event.teamEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTeamEvent {
    private String teamId;
}
