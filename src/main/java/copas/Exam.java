package main.java.copas;

public class Exam {
	private int id;
	private String patientName;
	private String date;
	private String status;
	private String result;

	public Exam() {
	}

	public Exam(int id, String patientName, String date, String status, String result) {
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

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}