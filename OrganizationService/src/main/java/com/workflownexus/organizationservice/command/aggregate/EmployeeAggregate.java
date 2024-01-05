package com.workflownexus.organizationservice.command.aggregate;

import com.workflownexus.organizationservice.command.command.employeeCommand.CreateEmployeeCommand;
import com.workflownexus.organizationservice.command.event.employeeEvent.CreateEmployeeEvent;
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
    private MultipartFile avatar;
    private List<Integer> roles;


    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand employeeCommand) throws IOException {
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
}
