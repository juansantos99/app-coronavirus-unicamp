package main.java.database;

import main.java.copas.HealthProfessional;

public class DBHealthProfessional {
	private int id = 0;
	
	public DBHealthProfessional() {
		/*
		 * Estrutura para conexão com o banco de dados
		 * Novos atributos deverão ser criados.
		 * Define o id baseado no último ID.
		 * 
		 */
	}
	
	public HealthProfessional SignIn(int id) {
		return new HealthProfessional();
	}
	
	public HealthProfessional SignUp(int rg, int cpf, String name, String role) {
		
		HealthProfessional doctor = new HealthProfessional(this.nextId(), rg, cpf, name, role);
		
		return doctor;
	}
	
	
	
	public int nextId() {
		this.id = this.id + 1;
		
		return this.id;
	}
}
