package org.infobip.campus.model;

import java.util.List;

/**
 * Created by grumin on 10.8.2016.
 */
public class NotificationRequest {

    private  String version;
    private  String status;
    private  List<Alert> alerts;
    private  String groupID;


    private NotificationRequest() {}

    public NotificationRequest(String status, List<Alert> alerts, String version, String groupID) {
        this.status = status;
        this.alerts = alerts;
        this.version = version;
        this.groupID = groupID;
    }

    public String getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", alerts=" + alerts +
                ", groupID='" + groupID + '\'' +
                '}';
    }
}
