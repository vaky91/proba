package org.infobip.campus.acceptor.model;

import java.util.List;

public class AlertRequest {

    private String groupKey;
    private String version;
    private String status;
    private List<Alert> alerts;

    public AlertRequest(String groupKey, String version, String status, List<Alert> alerts) {
        this.groupKey = groupKey;
        this.version = version;
        this.status = status;
        this.alerts = alerts;
    }

    private AlertRequest() {
    }

    public String getGroupKey() {
        return groupKey;
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

}
