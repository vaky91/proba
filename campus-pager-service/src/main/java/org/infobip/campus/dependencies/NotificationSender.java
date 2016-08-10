package org.infobip.campus.dependencies;

import org.infobip.campus.model.NotificationRequest;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by hbusic on 10.8.2016.
 */
public class NotificationSender {

    private Repository repository;
    private List<Gateway> gateways;

    public void setRepository(Repository repository) {
        if(repository == null) {
            throw new IllegalArgumentException();
        }
        this.repository = repository;
    }

    public void addGateway(Gateway gateway) {
        if(gateway == null) {
            throw new IllegalArgumentException();
        }
        gateways.add(gateway);
    }

    public void notify(NotificationRequest request){
        if(request == null) {
            throw new IllegalArgumentException();
        }

        String groupId = request.getGroupID();

        Group group = repository.getGroupById(groupId);
        if(group == null) {
            throw new NoSuchElementException();
        }

        Collection<Member> members = group.getMembers();
        for (Gateway gateway : gateways) {
            gateway.push(members);
        }
    }
}
