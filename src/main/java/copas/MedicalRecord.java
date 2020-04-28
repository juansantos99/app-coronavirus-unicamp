package main.java.copas;

import java.util.Date;

public class MedicalRecord {
    private Date date;
    private String status;
    private int patientCpf;
    private String team;
    private String diagnosis;
    private String exam;

    public MedicalRecord() {
    }

    public MedicalRecord(Date date, String status, int patientCpf, int doctor_id, String diagnosis, int exam_id) {
        this.setDate(date);
        this.setStatus(status);
        this.setPatientCpf(patientCpf);
        this.setTeam(team);
        this.setDiagnosis(diagnosis);
        this.setExam(exam);
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

    public int getPatientCpf() {
        return this.patientCpf;
    }

    public void setPatientCpf(int patientCpf) {
        this.patientCpf = patientCpf;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getExam() {
        return this.exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
}