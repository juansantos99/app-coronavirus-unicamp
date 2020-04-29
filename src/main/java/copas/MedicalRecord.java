package main.java.copas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicalRecord {
	private String date;
	private String status;
	private long patientCpf;
	private int doctor_id;
	private String diagnosis;
	private int exam_id;

	public MedicalRecord(String date, String status, long patientCpf, int doctor_id, String diagnosis, int exam_id) {
		this.setDate(date);
		this.setStatus(status);
		this.setPatientCpf(patientCpf);
		this.setDoctor_id(doctor_id);
		this.setDiagnosis(diagnosis);
		this.setExam_id(exam_id);
	}

	public String toString() {
		Date thisDate = null;
		try {
			SimpleDateFormat originalFormat = new SimpleDateFormat("ddMMyyyy");
			thisDate = originalFormat.parse(this.date.toString());		

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Date: " + thisDate + " - Status do paciente: " + this.status + " - Diagnóstico: " + this.diagnosis
				+ " - Cpf: " + this.patientCpf;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getExam_id() {
		return exam_id;
	}

	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	public long getPatientCpf() {
		return this.patientCpf;
	}

	public void setPatientCpf(long patientCpf) {
		this.patientCpf = patientCpf;
	}
}