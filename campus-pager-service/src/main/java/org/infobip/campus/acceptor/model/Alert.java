package org.infobip.campus.acceptor.model;

import java.util.Map;

/**
 * Created by grumin on 10.8.2016.
 */
public class Alert {

    private String status;
    private Map<String, String> labels;
    private Map<String, String> annotations;
    private String startsAt;
    private String endsAt;

    private Alert() {
    }

    public Alert(String status, Map<String, String> annotations, String startsAt, String endsAt, Map<String, String> labels) {
        this.status = status;
        this.annotations = annotations;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.labels = labels;
    }

    public String getStatus() {
        return status;
    }

    public Object getLabels() {
        return labels;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public Object getAnnotations() {
        return annotations;
    }

    public String getEndsAt() {
        return endsAt;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "labels=" + labels +
                ", annotations=" + annotations +
                ", startsAt='" + startsAt + '\'' +
                ", endsAt='" + endsAt + '\'' +
                '}';
    }
}
