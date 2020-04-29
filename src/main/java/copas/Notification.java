package main.java.copas;

import java.util.Date;

public class Notification {
    private int id;
    private String notification;
    private String message;
    private String scheduling;
    private String recipientName;
    private String schedulingStatus;
    private String mailerName;
    private String sendDate;

    public Notification() {
    }

    public Notification(int id, String notification, String message, String scheduling, String recipientName,
            String schedulingStatus, String mailerName, String sendDate) {
        this.setId(id);
        this.setNotification(notification);
        this.setMessage(message);
        this.setScheduling(scheduling);
        this.setRecipientName(recipientName);
        this.setSchedulingStatus(schedulingStatus);
        this.setMailerName(mailerName);
        this.setSendDate(sendDate);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotification() {
        return this.notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getScheduling() {
        return this.scheduling;
    }

    public void setScheduling(String scheduling) {
        this.scheduling = scheduling;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSchedulingStatus() {
        return this.schedulingStatus;
    }

    public void setSchedulingStatus(String schedulingStatus) {
        this.schedulingStatus = schedulingStatus;
    }

    public String getMailerName() {
        return this.mailerName;
    }

    public void setMailerName(String mailerName) {
        this.mailerName = mailerName;
    }

    public String getSendDate() {
        return this.sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

}