package main.java.copas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
	private long patientCpf;
	private String date;
	private int doctorId;
	

	public Appointment(long patientCpf, String date, int doctorId) {
		this.patientCpf = patientCpf;
		this.date = date;
		this.doctorId = doctorId;
	}
	public Appointment() {

	}

	public String toString() {
		Date thisDate = null;
		try {
			SimpleDateFormat originalFormat = new SimpleDateFormat("ddMMyyyy");
			thisDate = originalFormat.parse(this.date.toString());		

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();

		}
		return "Cpf: " + this.patientCpf + " - Data visita: " + thisDate + " - ID do médico: " + Math.abs(this.doctorId) +"\n";
	}
	
	public long getPatientCpf(){
		return patientCpf;
	}

	public void setPatientCpf(long patientCpf){
		this.patientCpf = patientCpf;
	}

	public int getDoctorId(){
		return doctorId;
	}

	public void setDoctorId(int doctorId){
		this.doctorId = doctorId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}