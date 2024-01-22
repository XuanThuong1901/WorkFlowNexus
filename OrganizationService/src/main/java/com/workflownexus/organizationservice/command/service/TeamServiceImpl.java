package com.workflownexus.organizationservice.command.service;

import com.workflownexus.organizationservice.command.event.teamEvent.CreateTeamEvent;
import com.workflownexus.organizationservice.command.event.teamEvent.DeleteTeamEvent;
import com.workflownexus.organizationservice.command.event.teamEvent.UpdateTeamEvent;
import com.workflownexus.organizationservice.command.model.response.CommandResponse;
import com.workflownexus.organizationservice.common.Message;
import com.workflownexus.organizationservice.data.entity.Departments;
import com.workflownexus.organizationservice.data.entity.Teams;
import com.workflownexus.organizationservice.data.repository.DepartmentRepo;
import com.workflownexus.organizationservice.data.repository.TeamRepo;
import com.workflownexus.organizationservice.query.model.response.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements ITeamService{

    private final TeamRepo teamRepo;
    private final DepartmentRepo departmentRepo;

    @Override
    public CommandResponse createTeam(CreateTeamEvent event) {
        try {
            Departments  department = departmentRepo.findById(event.getDepartmentId()).orElse(null);
            if(department == null)
                return new CommandResponse(Message.DEPARTMENT_NOT_FOUND);

            Teams team = Teams.builder()
                    .teamId(event.getTeamId())
                    .teamName(event.getTeamName())
                    .department(department)
                    .description(event.getDescription())
                    .status(true)
                    .createdDate(new Date())
                    .build();
            teamRepo.save(team);
            return new CommandResponse(Message.CREATE_TEAM_SUCCESS);
        }catch (Exception e){
            return new CommandResponse(Message.CREATE_TEAM_ERROR);
        }
    }

    @Override
    public CommandResponse updateTeam(UpdateTeamEvent event) {
        try {
            Teams team = teamRepo.findById(event.getTeamId()).orElse(null);
            if(team == null)
                return new CommandResponse(Message.TEAM_NOT_FOUND);
            team.setTeamName(event.getTeamName());
            team.setDescription(event.getDescription());
            teamRepo.save(team);
            return new CommandResponse(Message.UPDATE_TEAM_SUCCESS);
        }catch (Exception e){
            return new CommandResponse(Message.UPDATE_TEAM_ERROR);
        }
    }

    @Override
    public CommandResponse deleteTeam(DeleteTeamEvent event) {
        try {
            Teams team = teamRepo.findById(event.getTeamId()).orElse(null);

            if(team == null)
                return new CommandResponse(Message.TEAM_NOT_FOUND);
            if(team.getEmployeesList().size() > 0)
                return new CommandResponse(Message.TEAM_CANNOT_DELETE);

            //--------------------
            //  lack check product
            //--------------------


            teamRepo.delete(team);
            return new CommandResponse(Message.DELETE_TEAM_SUCCESS);

        }catch (Exception e){
            return new CommandResponse(Message.DELETE_TEAM_ERROR);
        }
    }
}
