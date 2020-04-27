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

		DBConnection.main();

		DBPatient dbpMenu = new DBPatient();
		DBHealthProfessional dbhpMenu = new DBHealthProfessional();

		HealthProfessional doc = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

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
					System.out.println("Digite aa opção desejada: ");
					// System.out.println("1 - Agendar visita");
					// System.out.println("2 - Sair");
					int opcao = 0;
					do {
						System.out.println("1 - Agendar visita");
						System.out.println("2 - Sair");
						opcao = scan.nextInt();
						switch (opcao) {
							case 1:
								scan.nextLine();
								System.out.println("Digite a data (dia/mes/ano): ");
								String date = scan.nextLine();
								Date nDate = format.parse(date);
								System.out.println("O nome do paciente: ");
								String nomePaciente = scan.nextLine();
								Consulta consulta = new Consulta(nomePaciente, nDate, doctor);
								System.out.println(
										"Sua consulta ficou agendada para o dia: " + format.format(consulta.getData()));
								break;
						}
					} while (opcao != 2);
					break;
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
					System.out.println("Digite aa opção desejada: ");

					int opcao = 0;
					do {
						System.out.println("1 - Atualizar Sintomas");
						System.out.println("2 - Sair");
						opcao = scan.nextInt();
						switch (opcao) {
							case 1:
								scan.nextLine();
								System.out.println("Escolha o sintoma: ");
								System.out.println("Escolha o sintoma: ");
								System.out.println("Escolha o sintoma: ");
								System.out.println("Escolha o sintoma: ");
								System.out.println("Escolha o sintoma: ");
								int codigoSintoma = scan.nextInt();
								patient.updateSymptoms(patient.getCpf(), codigoSintoma);
								break;
						}
					} while (opcao != 2);
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
					String date = scan.nextLine();
					sBornDate = format.parse(date).toString();

					System.out.println("Digite seu endereço:");
					sAddress = scan.nextLine();

					System.out.println("Digite uma senha:");
					sPassword = scan.nextLine();

					Patient patient = dbpMenu.SignIn(iCpf, iRg, sName, sEmail, sSusCard, sBornDate, sAddress,
							sPassword);

					System.out.println(patient);
				}

				break;
		}

		scan.close();
	}

}
