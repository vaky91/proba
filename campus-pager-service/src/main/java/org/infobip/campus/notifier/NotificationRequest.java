package org.infobip.campus.notifier;

/**
 * Created by hbusic on 10.8.2016.
 */
public class NotificationRequest {

    private final String groupId;

    public NotificationRequest(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }
}
