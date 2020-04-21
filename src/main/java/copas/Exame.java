package main.java.copas;

import java.util.Date;

public class Exame {
    private int id;
    private String patientName;
    private Date date;
    private String status;
    private String result;

    public Exame(int id, String patientName, Date date, String status, String result) {
        this.setId(id);
        this.setPatientName(patientName);
        this.setDate(date);
        this.setStatus(status);
        this.setResult(result);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}