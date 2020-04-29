package main.java.copas;

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