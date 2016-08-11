package org.infobip.campus.model;

import org.infobip.campus.acceptor.model.Alert;

import java.util.List;

/**
 * Created by grumin on 10.8.2016.
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
