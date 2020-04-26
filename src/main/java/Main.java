package main.java;

import java.util.Scanner;
import java.text.ParseException;
import main.java.copas.*;
import main.java.database.*;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		
		DBConnection.main();
		
		DBPatient dbpMenu = new DBPatient();
		DBHealthProfessional dbhpMenu = new DBHealthProfessional();
		
		HealthProfessional doc = null;
		
		int iId = 0;
		int iRg = 0;
		int iCpf = 0;
		String sName = "";
		String sRole = "";
	    String sEmail = "";
	    String sSusCard = "";
	    String sAddress = "";
	    String sPassword = "";
	    String sBornDate = "";
		
		int iOpt = 0;
		int iAction = 0;

		System.out.println("Você é um médico ou um paciente?\n1- Médico \n2- Paciente");
		iOpt = scan.nextInt();

		System.out.println("Você deseja: \n1- Fazer login \n2- Cadastrar");
		iAction = scan.nextInt();

		while (iAction < 1 || iAction > 2) {
			System.out.println("Opção inválida!");
			System.out.println("Você deseja: \n1- Fazer login \n2- Cadastrar");
			iAction = scan.nextInt();
		}

		switch (iOpt) {
		case 1:
			if (iAction == 1) {
				System.out.println("Digite seu ID:");
				iId = scan.nextInt();
				scan.nextLine();
				
				HealthProfessional doctor = dbhpMenu.SignUp(iId);
				
				System.out.println(doctor);
			} else {
				System.out.println("Digite seu CPF:");
				iCpf = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Digite seu RG:");
				iRg = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Digite seu nome:");
				sName = scan.nextLine();
				
				System.out.println("Digite sua função:");
				sRole = scan.nextLine();
				
				HealthProfessional doctor = dbhpMenu.SignIn(iCpf, iRg, sName, sRole);
				
				System.out.println(doctor);
			}
			
			break;
		case 2:
			if (iAction == 1) {
				System.out.println("Digite seu CPF:");
				iCpf = scan.nextInt();
				scan.nextLine();
				System.out.println("Digite sua senha:");
				sPassword = scan.nextLine();
				
				Patient patient = dbpMenu.SignUp(iCpf, sPassword);
				
				System.out.println(patient);
				
			} else {
				System.out.println("Digite seu CPF:");
				iCpf = scan.nextInt();
				scan.nextLine();
				
				while (dbpMenu.UserExists(iCpf)) {
					System.out.println("Usuário já existe, digite novamente o CPF.");
					iCpf = scan.nextInt();
					scan.nextLine();
				} 
				
				System.out.println("Digite seu RG:");
				iRg = scan.nextInt();
				scan.nextLine();
				System.out.println("Digite seu nome:");
				sName = scan.nextLine();
				
				System.out.println("Digite seu e-mail:");
				sEmail = scan.nextLine();
				
				System.out.println("Digite seu cartão do SUS:");
				sSusCard = scan.nextLine();
				
				System.out.println("Digite sua data de nascimento:");
				sBornDate = scan.nextLine();
				
				System.out.println("Digite seu endereço:");
				sAddress = scan.nextLine();
				
				System.out.println("Digite uma senha:");
				sPassword = scan.nextLine();
				
				Patient patient = dbpMenu.SignIn(iCpf, iRg, sName, sEmail, sSusCard, sBornDate, sAddress, sPassword);					
				
				System.out.println(patient);
			}
			
			break;
		}

		scan.close();
	}

}
