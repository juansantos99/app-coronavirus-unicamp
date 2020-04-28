package main.java.copas;

//import java.sql.Date;
import java.util.Date;
import java.util.Scanner;

//import main.java.database.date;

public class Appointment {
	private int AppointmentCod;
	int cpf;
	int idHealthProfissional;
	private String patientName;
	private Date date;
	private HealthProfessional prof;
	
//	Scanner scan = new Scanner(System.in);
//	String date = scan.nextLine();
//	Date dateAppointment = format.parse(date);
	
	
	HealthProfessional doctor = new HealthProfessional();
	
	
	
	public Appointment(String patientName, Date date, HealthProfessional prof) {
	super();
	this.patientName = patientName;
	this.date = date;
	this.prof = prof;
}


	public Appointment(int appointmentCod, int cpf, int idHealthProfissional, String patientName, Date date,
			HealthProfessional prof, HealthProfessional doctor) {
		super();
		AppointmentCod = appointmentCod;
		this.cpf = cpf;
		this.idHealthProfissional = idHealthProfissional;
		this.patientName = patientName;
		this.date = date;
		this.prof = prof;
		this.doctor = doctor;
	}


	public Appointment()
	{
		
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
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

	public HealthProfessional getDoctor() {
		return doctor;
	}

	public void setDoctor(HealthProfessional doctor) {
		this.doctor = doctor;
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