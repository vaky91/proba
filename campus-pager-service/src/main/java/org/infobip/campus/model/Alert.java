package org.infobip.campus.model;

/**
 * Created by grumin on 10.8.2016.
 */
public class Alert {

    private Object labels;
    private Object annotations;
    private String startsAt;
    private String endsAt;

    private Alert() {}

    public Alert(Object annotations, String startsAt, String endsAt, Object labels) {
        this.annotations = annotations;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.labels = labels;
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
