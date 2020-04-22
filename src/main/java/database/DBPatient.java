package main.java.database;

import java.util.Date;

import main.java.copas.Patient;

public class DBPatient {
	public DBPatient() {
		
		/*
		 * Estrutura para conexão com o banco de dados
		 * Novos atributos deverão ser criados.
		 * 
		 */
		
	}
	
	public Patient SignUp(int cpf, String password) {
		return new Patient();
	}
	
	public Patient SignIn(int cpf, int rg, String name, String email, String susCard, Date bornDate, String address, String password, String status) {
		Patient patient = new Patient(cpf, rg, name, email, susCard, bornDate, address, password, status);
		
		return patient;
	}
}
