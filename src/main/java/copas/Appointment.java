package main.java.copas;

public class Appointment {
	private int AppointmentCod;
	long cpf;
	int idHealthProfissional;
	private String patientName;
	private String date;
	private HealthProfessional prof;
	
	public Appointment(String patientName, String date, HealthProfessional prof) {
		this.patientName = patientName;
		this.date = date;
		this.prof = prof;
	}

	public Appointment(int appointmentCod, long cpf, int idHealthProfissional, String patientName, String date,
			HealthProfessional prof) {
		AppointmentCod = appointmentCod;
		this.cpf = cpf;
		this.idHealthProfissional = idHealthProfissional;
		this.patientName = patientName;
		this.date = date;
		this.prof = prof;
	}


	public Appointment()
	{
		
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getIdHealthProfissional() {
		return idHealthProfissional;
	}

	public void setIdHealthProfissional(int idHealthProfissional) {
		this.idHealthProfissional = idHealthProfissional;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setAppointmentCod(int appointmentCod) {
		AppointmentCod = appointmentCod;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public HealthProfessional getProf() {
		return prof;
	}
	
	public void setProf(HealthProfessional prof) {
		this.prof = prof;
	}
}