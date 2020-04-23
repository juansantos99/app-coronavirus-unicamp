package main.java;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import main.java.copas.*;
import main.java.database.*;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		DBPatient dbpMenu = new DBPatient();
		DBHealthProfessional dbhpMenu = new DBHealthProfessional();

		int iId = 0;
		int iRg = 0;
		int iCpf = 0;
		String sName = "";
		String sRole = "";
		String sEmail = "";
		String sSusCard = "";
		String sAddress = "";
		String sPassword = "";
		String sStatus = "";
		Date dBornDate = new Date();

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

					HealthProfessional doctor = dbhpMenu.SignIn(iId);

					System.out.println(doctor);
				} else {
					System.out.println("Digite seu CPF:");
					iCpf = scan.nextInt();

					System.out.println("Digite seu RG:");
					iRg = scan.nextInt();

					System.out.println("Digite seu nome:");
					sName = scan.nextLine();

					System.out.println("Digite sua função:");
					sRole = scan.nextLine();

					HealthProfessional doctor = dbhpMenu.SignUp(iRg, iCpf, sName, sRole);

					System.out.println(doctor);
				}

				break;
			case 2:
				if (iAction == 1) {
					System.out.println("Digite seu CPF:");
					iCpf = scan.nextInt();
					System.out.println("Digite sua senha:");
					sPassword = scan.nextLine();

					Patient patient = dbpMenu.SignUp(iCpf, sPassword);

					System.out.println(patient);

				} else {
					System.out.println("Digite seu CPF:");
					iCpf = scan.nextInt();

					System.out.println("Digite seu RG:");
					iRg = scan.nextInt();

					System.out.println("Digite seu nome:");
					sName = scan.nextLine();

					System.out.println("Digite seu e-mail:");
					sEmail = scan.nextLine();

					System.out.println("Digite seu cartão do SUS:");
					sSusCard = scan.nextLine();

					System.out.println("Digite sua data de nascimento:");
					dBornDate = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());

					System.out.println("Digite seu endereço:");
					sAddress = scan.nextLine();

					System.out.println("Digite uma senha:");
					sPassword = scan.nextLine();

					System.out.println("Digite seu status:");
					sStatus = scan.nextLine();

					Patient patient = dbpMenu.SignIn(iCpf, iRg, sName, sEmail, sSusCard, dBornDate, sAddress, sPassword,
							sStatus);

					System.out.println(patient);
				}

				break;
		}

		scan.close();
	}

}
