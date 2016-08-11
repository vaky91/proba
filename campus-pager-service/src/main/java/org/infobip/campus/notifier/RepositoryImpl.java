package org.infobip.campus.notifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Repository interface.
 * Created by hbusic on 11.8.2016.
 */
public class RepositoryImpl implements Repository {

    private List<Group> groups;

    public RepositoryImpl() {
        groups = new ArrayList<>();
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
