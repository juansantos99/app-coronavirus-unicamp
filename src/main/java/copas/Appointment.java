package main.java.copas;

import java.sql.Date;

public class Appointment {
	private int AppointmentCod;
	private String patientName;
	private Date date;
	private HealthProfessional prof;
	
	public Appointment(String patientName, Date date, HealthProfessional prof) {
		this.patientName = patientName;
		this.date = date;
		this.prof = prof;
	}

	public String getpatientName() {
		return patientName;
	}

	public void setpatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAppointmentCod() {
		return AppointmentCod;
	}

	public void setAgendaCod(int AppointmentCod) {
		this.AppointmentCod = AppointmentCod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public HealthProfessional getProf() {
		return prof;
	}
	public void setProf(HealthProfessional prof) {
		this.prof = prof;
	}
	/*public void Appointment() {
		//bd
	}*/
}