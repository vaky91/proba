package org.infobip.campus.notifier;

/**
 * Created by grumin on 11.8.2016.
 */
public class PushRequest {

    private final String from = "6dad0991ff524d69f84cd1ae07683895-cf5fc25c-9334-4e9a-bcf6-df8301bb1b6d";
    private final String to;
    private final String text;

    public PushRequest(String to, String text) {
        this.to = to;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "PushRequest{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
