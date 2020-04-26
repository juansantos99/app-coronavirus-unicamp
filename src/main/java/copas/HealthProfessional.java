package main.java.copas;

import java.util.Scanner;

public class HealthProfessional {
    private int id;
    private int cpf;
    private int rg;
    private String name;
    private String role;

    public String toString() {
    	return "Nome: " + this.name + " - Função: " + this.role;
    }
    
    public HealthProfessional() {
    }

    public HealthProfessional(int id, int cpf, int rg, String name, String role) {
        this.setId(id);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setName(name);
        this.setRole(role);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRg() {
        return this.rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void registerPatient() {
        // Cadastrar novo paciente
    }

    public void consult() {
        // Retorna todos pacientes que tem no banco, com filtro: sintoma, regiao, todos
    }

    public void showPatient(Patient patient) {
 
    	if (patient.getCpf() != 0) {
    		System.out.println(patient.getCpf());
    		System.out.println(patient.getName());
    		System.out.println(patient.getEmail());
    		System.out.println(patient.getName());
    		System.out.println(patient.getSusCard());
    		System.out.println(patient.getBornDate());
    		System.out.println(patient.getStatus());
    	}
    }

    public void consultSchedule() {
        // Retorna os agendamentos que ele agendou
    }

    public void scheduleVisit() {
        // Cria um agendamento
    }

    public void getVisit() {
        // Baixa o prontuario de um paciente em PDF
    }

    public void registerMedicalReport() {
        // Cria o prontuario
    }

    public void updateStatus(Patient patient) {
		Scanner scan = new Scanner(System.in);
		String response;

		try {
       	System.out.println("O paciente est� infectado?");
    	System.out.println("Digite: Sim ou N�o");
    	response = scan.nextLine();
    	
    		if (response == "Sim") {
    		 patient.setStatus("infected");
    		}
    		else {
    	
//    			if(patient.getSymptons().length >= 3) {
//    				patient.setStatus("suspect");
//    			}
    	
//    			if(patient.getSymptons().length == 0) {
//    				patient.setStatus("descarted");
//    			}   
    		}
    		
    	} finally {
    		scan.close();
    	}
    }

    public void contactPatient() {
        // Manda uma notificação para o paciente pelo CPF
    }
}