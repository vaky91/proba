package org.infobip.campus.model;

/**
 * Created by grumin on 10.8.2016.
 */
public class Alert {

    private Object labels;
    private Object annotations;
    private String startsAt;
    private String endsAt;

    public Object getLabels() {
        return labels;
    }

    public void setLabels(Object labels) {
        this.labels = labels;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public Object getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Object annotations) {
        this.annotations = annotations;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
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
