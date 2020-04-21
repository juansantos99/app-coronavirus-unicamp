package main.java.copas;

import java.util.Date;

public class Notification {
    private int id;
    private String notification;
    private String message;
    private Date scheduling;
    private String recipientName;
    private String schedulingStatus;
    private String mailerName;
    private Date sendDate;

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

    public Date getScheduling() {
        return this.scheduling;
    }

    public void setScheduling(Date scheduling) {
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

    public Date getSendDate() {
        return this.sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

}