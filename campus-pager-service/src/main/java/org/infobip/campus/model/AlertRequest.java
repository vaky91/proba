package org.infobip.campus.model;

import java.util.List;

/**
 * Created by grumin on 10.8.2016.
 */
public class AlertRequest {

    private String version;
    private String status;
    private List<Alert> alerts;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @Override
    public String toString() {
        return "AlertRequest{" +
                "version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", alerts=" + alerts +
                '}';
    }
}
