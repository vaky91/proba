package org.infobip.campus.dependencies;

/**
 * Created by hbusic on 10.8.2016.
 */
public class NotificationRequest {

    private final String groupID;

    public NotificationRequest(String groupID) {
        if(groupID == null) {
            throw new IllegalArgumentException();
        }
        this.groupID = groupID;
    }

    public String getGroupID() {
        return groupID;
    }
}
