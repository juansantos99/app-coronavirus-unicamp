package main.java;

import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import main.java.copas.*;
import main.java.database.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);

		new DBConnection();

		DBSymptons dbsymptons = new DBSymptons();
		DBPatient dbpMenu = new DBPatient();
		DBHealthProfessional dbhpMenu = new DBHealthProfessional();
		DBSymptonsPatient dbSymptonsPatient = new DBSymptonsPatient();
		DBMedicalRecord dbMedicalRecord = new DBMedicalRecord();
		DBMedicalAppointment dbappointment = new DBMedicalAppointment();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		int iId = 0;
		int iRg = 0;
		long iCpf = 0;
		String sName = "";
		String sRole = "";
		String sEmail = "";
		String sSusCard = "";
		String sAddress = "";
		String sPassword = "";
		String sBornDate = "";

		int iOpcaoMenu = 0;
		int iAction = 0;

		System.out.println("Você é um médico ou um paciente?\n1 - Médico \n2 - Paciente\n3 - Sair ");
		iOpcaoMenu = scan.nextInt();
		scan.nextLine();

	
		while (iOpcaoMenu != 3) {
			
			if (iOpcaoMenu == 1 || iOpcaoMenu == 2) {
				System.out.println("Você deseja: \n1 - Fazer login \n2 - Cadastrar");
				iAction = scan.nextInt();
				scan.nextLine();
			}

			while (iOpcaoMenu < 1 || iOpcaoMenu > 3) {
				System.out.println("Opção inválida!");
				System.out.println("Você deseja: \n1 - Fazer login \n2 - Cadastrar");
				iAction = scan.nextInt();
				scan.nextLine();
			}
			
			switch (iOpcaoMenu) {
			/* Quando o usuário for médico */
		
			case 1:

				/* Médico realiza login */
				if (iAction == 1) {
					System.out.println("Digite seu ID:");
					iId = scan.nextInt();
					scan.nextLine();

					try {
						HealthProfessional doctor = dbhpMenu.SignUp(iId);

						System.out.println(doctor);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("Digite aa opção desejada: ");
					// System.out.println("1 - Agendar visita");
					// System.out.println("2 - Sair");
					int opcao = 0;
					do {
						System.out.println("1 - Agendar visita");
						System.out.println("2 - Criar um novo prontuário");
						System.out.println("3 - Visualizar os Pacientes por cpf");
						System.out.println("4 - Visualizar pacientes");
						System.out.println("5 - Visualizar o prontu�rio");
						System.out.println("6 - Visualizar Agenda");
						System.out.println("7 - Sair");
						// System.out.println("7 - Sair");
						opcao = scan.nextInt();
						switch (opcao) {
						case 1:
							System.out.println("Digite o CPF do paciente: ");
							long cpf = scan.nextLong();
							scan.nextLine();
							System.out.println("Digite a data para visita: ");
							String visit = scan.nextLine();
							
							dbappointment.createAppointment(cpf, iId, visit);
							
							break;
						case 2:
							scan.nextLine();

							System.out.println("Digite o CPF do paciente: ");
							long patient_cpf = scan.nextLong();
							scan.nextLine();

							System.out.println("Digite a data (dia/mês/ano): ");
							String medical_record_date = scan.nextLine();

							System.out.println("Descreva o diagnóstico do paciente: ");
							String patient_diagnosis = scan.nextLine();

							System.out.println("Digite o status do paciente: ");
							String patient_status = scan.nextLine();

							MedicalRecord patient_medical_record = dbMedicalRecord.createMedicalRecord(
									medical_record_date, patient_status, patient_cpf, iId, patient_diagnosis, 0);

							System.out.println("Prontuário registrado com sucesso!");
							System.out.println("CPF do paciente: " + patient_medical_record.getPatientCpf());
							System.out.println("Data de criação do prontuário: " + patient_medical_record.getDate());
							System.out.println("Descrição do diagnóstico:" + patient_medical_record.getDiagnosis());
							System.out.println("Status do paciente: " + patient_medical_record.getStatus());

							break;
						case 3:
							System.out.println("Digite o CPF do paciente:");
							iCpf = scan.nextLong();
							scan.nextLine();
							Patient patient = dbpMenu.ShowPatient(iCpf);
							System.out.println(patient);
							break;
						case 4:
							dbpMenu.ShowPatientAll();
							break;
						case 5: 
							
							System.out.println("Digite o CPF do paciente:");
							iCpf = scan.nextLong();
							scan.nextLine();
							MedicalRecord medicalrecord = dbMedicalRecord.showMedicalRecord(iCpf);
							System.out.println(medicalrecord);
							break;
						case 6:
							dbappointment.ShowMedicalAppointment(iId);
							break;
						case 7:
							System.out.println("Você saiu do programa");
							iOpcaoMenu = 3;
							break;
						}
					} while (opcao != 7);
					break;
				} else {
					System.out.println("Digite seu CPF:");
					iCpf = scan.nextLong();
					scan.nextLine();

					System.out.println("Digite seu RG:");
					iRg = scan.nextInt();
					scan.nextLine();

					System.out.println("Digite seu nome:");
					sName = scan.nextLine();

					System.out.println("Digite sua função:");
					sRole = scan.nextLine();

					try {
						HealthProfessional doctor = dbhpMenu.SignIn(iCpf, iRg, sName, sRole);

						System.out.println(doctor);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

				break;

			/* Quando o usuário for Paciente */
			case 2:

				/* Login do Paciente */
				if (iAction == 1) {
					System.out.println("Digite seu CPF:");
					iCpf = scan.nextLong();
					scan.nextLine();
					System.out.println("Digite sua senha:");
					sPassword = scan.nextLine();

					try {
						Patient patient = dbpMenu.SignUp(iCpf, sPassword);

						System.out.println(patient);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("Digite a opção desejada: ");

					int opcao = 0;
					do {
						System.out.println("1 - Cadastrar Sintomas");
						System.out.println("2 - Visualizar Visitas");
						System.out.println("3 - Visualizar Prontu�rio");
						System.out.println("7 - Sair");
						opcao = scan.nextInt();
						switch (opcao) {
						/* Cadastrar Sintomas */
						case 1:

							Symptons sin = new Symptons();

							int i = 1;
							try {
								for (i = 1; i < 6; i++) {
									sin = dbsymptons.ListSymptons(i);
									System.out.println(sin);
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							System.out.println("Quantos destes sintomas voce esta sentindo?");
							int sint = scan.nextInt();

							System.out.println("Digite os Sintomas que possu� pelo id");
							for (i = 0; i < sint; i++) {
								int idSintoma = scan.nextInt();
								SymptonsPatient simyptonspatient = dbSymptonsPatient.RegisterSymptons(idSintoma, iCpf);
							}
							break;
						case 2:
							dbappointment.ShowMedicalAppointmentPatient(iCpf);
							break;
						case 3:	
							MedicalRecord medicalrecord = dbMedicalRecord.showMedicalRecord(iCpf);
							System.out.println(medicalrecord);
							break;
						case 7:
							System.out.println("Voc� saiu do programa");
							iOpcaoMenu = 3;
							break;
						}
					} while (iOpcaoMenu != 3);
				} else {
					System.out.println("Digite seu CPF:");
					iCpf = Math.abs(scan.nextLong());
					scan.nextLine();

					try {
						while (dbpMenu.UserExists(iCpf)) {
							System.out.println("Usuário já existe, digite novamente o CPF.");
							iCpf = scan.nextLong();
							scan.nextLine();
						}
					} catch (Exception e) {
						// TODO: handle exception
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
					try {
						String date = scan.nextLine();
						sBornDate = format.parse(date).toString();
					} catch (Exception e) {
						// TODO: handle exception
					}

					System.out.println("Digite seu endereço:");
					sAddress = scan.nextLine();

					System.out.println("Digite uma senha:");
					sPassword = scan.nextLine();

					try {
						Patient patient = dbpMenu.SignIn(iCpf, iRg, sName, sEmail, sSusCard, sBornDate, sAddress,
								sPassword);

						System.out.println(patient);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				break;

			case 3:
				System.out.println("Voce saiu do programa");
				break;
				
			default:
				break;
			}
		}
		
		System.out.println("Você saiu do programa");
		scan.close();
	}
}
