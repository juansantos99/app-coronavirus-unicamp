package main.java.copas;

import java.util.Date;

public class Consulta {
	private int agendaCod;
	private String nomePaciente;
	private Date data;
	private HealthProfessional prof;
	
	public Consulta() {
	}
	
	public Consulta(String nomePaciente, Date data, HealthProfessional prof) {
		this.nomePaciente = nomePaciente;
		this.data = data;
		this.prof = prof;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public int getAgendaCod() {
		return agendaCod;
	}
	
	public void setAgendaCod(int agendaCod) {
		this.agendaCod = agendaCod;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	public HealthProfessional getProf() {
		return prof;
	}
	public void setProf(HealthProfessional prof) {
		this.prof = prof;
	}
	public void agendarConsulta() {
		//bd
	}
}
