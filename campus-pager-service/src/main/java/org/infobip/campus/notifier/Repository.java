package org.infobip.campus.notifier;

/**
 * Created by hbusic on 10.8.2016.
 */
public interface Repository {

    void addGroup(Group group);
    Group getGroupById(String groupId);
}
