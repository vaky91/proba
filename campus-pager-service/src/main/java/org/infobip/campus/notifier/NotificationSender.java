package org.infobip.campus.notifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hbusic on 10.8.2016.
 */

public class NotificationSender {

    private Repository repository;
    private List<Gateway> gateways;

    @Autowired
    public NotificationSender(Repository repository, List<Gateway> gateways) {
        this.repository = repository;
        this.gateways = gateways;
    }

    public void notify(NotificationRequest request){
        if(request == null) {
            throw new IllegalArgumentException("Notification request is null.");
        }

        String groupId = request.getGroupId();

        Group group = repository.getGroupById(groupId);
        if(group == null) {
            throw new IllegalStateException("Group under given ID could not be found.");
        }

        Collection<Member> members = group.getMembers();
        Collection<GatewayRequest> requests =
                members.stream().map(m -> new GatewayRequest(m, "Test")).collect(Collectors.toList());

        for (Gateway gateway : gateways) {
            try {
                gateway.push(requests);
            } catch (IOException ignorable) {}
        }
    }
}
