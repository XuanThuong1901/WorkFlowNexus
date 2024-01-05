package com.workflownexus.organizationservice.command.aggregate;

import com.workflownexus.organizationservice.command.command.employeeCommand.CreateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateEmployeeCommand;
import com.workflownexus.organizationservice.command.command.employeeCommand.UpdateRoleEmployeeCommand;
import com.workflownexus.organizationservice.command.event.employeeEvent.CreateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateEmployeeEvent;
import com.workflownexus.organizationservice.command.event.employeeEvent.UpdateRoleEmployeeEvent;
import com.workflownexus.organizationservice.common.mappers.EmployeeMapper;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Aggregate
@NoArgsConstructor
public class EmployeeAggregate {

    @AggregateIdentifier
    private String employeeId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private boolean sex;
    private String urlAvatar;
    private MultipartFile avatar;
    private List<Integer> roles;

    // ------- Create event ---------
    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand employeeCommand){
        CreateEmployeeEvent event = EmployeeMapper.INSTANCE.mapToCreateEmployeeEvent(employeeCommand);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateEmployeeEvent event){
        this.employeeId = event.getEmployeeId();
        this.email = event.getEmail();
        this.password = event.getPassword();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.telephone = event.getTelephone();
        this.address = event.getAddress();
        this.sex = event.isSex();
        this.avatar = event.getAvatar();
        this.roles = event.getRoles();
    }

    // ------- Update event ---------
    @CommandHandler
    public EmployeeAggregate(UpdateEmployeeCommand employeeCommand){
        UpdateEmployeeEvent event = EmployeeMapper.INSTANCE.mapToUpdateEmployeeEvent(employeeCommand);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateEmployeeEvent event){
        this.employeeId = event.getEmployeeId();
        this.email = event.getEmail();
        this.password = event.getPassword();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.telephone = event.getTelephone();
        this.address = event.getAddress();
        this.sex = event.isSex();
        this.urlAvatar = event.getUrlAvatar();
        this.avatar = event.getAvatar();
        this.roles = event.getRoles();
    }

    @CommandHandler
    public EmployeeAggregate(UpdateRoleEmployeeCommand command){
        UpdateRoleEmployeeEvent event = EmployeeMapper.INSTANCE.mapToUpdateRoleEmployeeEvent(command);
        System.out.println(event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateRoleEmployeeEvent event){
        this.employeeId = event.getEmployeeId();
        this.roles = event.getRoles();
    }
}
