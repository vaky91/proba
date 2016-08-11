package org.infobip.campus.notifier;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of Repository interface.
 * Created by hbusic on 11.8.2016.
 */
@Component
public class InMemoryRepository implements Repository {

    private List<Group> groups = new LinkedList<>();

    @PostConstruct
    private void init() {
        addGroup(new Group("campusteam", Arrays.asList(new Member("385994931414"))));
    }

    @Override
    public void addGroup(Group group) {
        if(!groups.contains(group)) {
            groups.add(group);
        }
    }

    @Override
    public Group getGroupById(String groupId) {
        for(Group group : groups) {
            if(group.getGroupID().equals(groupId)) {
                return  group;
            }
        }
        return null;
    }
}
