package main.java;

import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import main.java.copas.*;
import main.java.database.*;

public class Main {
	
	public static void main(String[] args) {
		Connection dbConnection = null;
		Scanner scan = new Scanner(System.in);

		dbConnection = DBConnection.main();
		
		DBSymptons dbsymptons = new DBSymptons(dbConnection);
		DBPatient dbpMenu = new DBPatient(dbConnection);
		DBHealthProfessional dbhpMenu = new DBHealthProfessional(dbConnection);
    DBSymptonsPatient dbDBsymptonspatient = new DBSymptonsPatient(dbConnection);
    DBMedicalRecord dbMedicalRecord = new DBMedicalRecord(dbConnection);

		HealthProfessional doc = null;
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

		int iOpt = 0;
		int iAction = 0;

		System.out.println("Você é um médico ou um paciente?\n1 - Médico \n2 - Paciente\n3 - Sair ");
		iOpt = scan.nextInt();
		
		if(iOpt == 1 || iOpt == 2)
		{	
			System.out.println("Você deseja: \n1 - Fazer login \n2 - Cadastrar");
			iAction = scan.nextInt();
		}

		while (iOpt < 1 || iOpt > 3) {
			System.out.println("Opção inválida!");
			System.out.println("Você deseja: \n1 - Fazer login \n2 - Cadastrar");
			iAction = scan.nextInt();
		}
		//while (iOpt != 3) {}
		
		
		while(iOpt != 3) {
			switch (iOpt) {
			/*Quando o usuário for médico*/
			
				case 1:
					
					/*Médico realiza login*/
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
							System.out.println("3 - Visualizar os Pacientes por sintomas");
							System.out.println("4 - Visualizar sintomas");
							System.out.println("5 - Criar um novo prontuário");
							System.out.println("6 - Atualizar Agenda");
							System.out.println("7 - Sair");
							//System.out.println("7 - Sair");
							opcao = scan.nextInt();
							switch (opcao) {
								case 1:
									scan.nextLine();
									System.out.println("Digite a data (dia/mes/ano): ");
									try {
										String date = scan.nextLine();
										Date nDate = format.parse(date);
									} catch (Exception e) {
										// TODO: handle exception
									}
									System.out.println("O nome do paciente: ");
									String nomePaciente = scan.nextLine();
							//		Appointment appointment = new Appointment(nomePaciente, nDate, doctor);
							//		System.out.println("Sua consulta ficou agendada para o dia: " + format.format(appointment.getDate()));
									break;
								case 2:
                  scan.nextLine();
                    
                  System.out.println("Digite o CPF do paciente: ");
                  int patient_cpf = scan.nextInt();

                  System.out.println("Digite a data (dia/mês/ano): ");
                  String medical_record_date = scan.nextLine();

                  System.out.println("Descreva o diagnóstico do paciente: ");
                  String patient_diagnosis = scan.nextLine();

                  System.out.println("Digite o status do paciente: ");
                  String patient_status = scan.nextLine();

                  MedicalRecord patient_medical_record = dbMedicalRecord.createMedicalRecord(medical_record_date, patient_status, patient_cpf, iId, patient_diagnosis);
                  
                  System.out.println("Prontuário registrado com sucesso!");
                  System.out.println("CPF do paciente: " + patient_medical_record.getPatientCpf());
                  System.out.println("Data de criação do prontuário: " + patient_medical_record.getDate());
                  System.out.println("Descrição do diagnóstico:" + patient_medical_record.getDiagnosis());
                  System.out.println("Status do paciente: " + patient_medical_record.getStatus());

                  break;
								case 3:
									
									
								case 4:
                  

                  break;
								case 7:
									System.out.println("Voc� saiu do programa");
									iOpt = 3;
									break;
									
							}
						} while (iOpt !=  3);
						break;
					} else{
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
					iOpt = 4;
					iAction = 3;
					
						
					break;
					
				/*Quando o usuário for Paciente*/	
				case 2:
					
					/*Login do Paciente*/
					if (iAction == 1) {
						System.out.println("Digite seu CPF:");
						iCpf = scan.nextInt();
						scan.nextLine();
						System.out.println("Digite sua senha:");
						sPassword = scan.nextLine();
	
						try {
							Patient patient = dbpMenu.SignUp(iCpf, sPassword);
							
							System.out.println(patient);
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out.println("Digite aa opção desejada: ");
	
						int opcao = 0;
						do {
							System.out.println("1 - Cadastrar Sintomas");
							System.out.println("1 - Atualizar Sintomas");
							System.out.println("1 - Atualizar Sintomas");
							System.out.println("1 - Atualizar Sintomas");
							System.out.println("1 - Atualizar Sintomas");
							System.out.println("1 - Atualizar Sintomas");
							System.out.println("7 - Sair");
							opcao = scan.nextInt();
							switch (opcao) {
								/*Cadastrar Sintomas*/
								case 1:
									
									Symptons sin = new Symptons();
				
									int i = 1;
									try {
										for (i = 1; i<6; i++) {
											System.out.println("entrou");
											sin = dbsymptons.ListSymptons(i);
											System.out.println(sin);
											}
									} catch (Exception e) {
										// TODO: handle exception
									}
									System.out.println("Quantos destes sintomas voce esta sentindo?");
									int sint = scan.nextInt();
									
									System.out.println("Digite os Sintomas que possu� pelo id");
									for(i=0;i<sint;i++) {
										int idSintoma = scan.nextInt();
										SymptonsPatient simyptonspatient = dbDBsymptonspatient.RegisterSymptons(idSintoma, iCpf); 
									}
									//System.out.println(simyptonspatient);
									break;
								case 7:
									System.out.println("Voc� saiu do programa");
									iOpt = 3;
									break;
							}
						} while (iOpt != 3);
					} else {
						System.out.println("Digite seu CPF:");
						iCpf = scan.nextInt();
						scan.nextLine();
	
						try {
							while (dbpMenu.UserExists(iCpf)) {
								System.out.println("Usuário já existe, digite novamente o CPF.");
								iCpf = scan.nextInt();
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
							Patient patient = dbpMenu.SignIn(iCpf, iRg, sName, sEmail, sSusCard, sBornDate, sAddress,sPassword);
							
							System.out.println(patient);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					iOpt = 4;
					iAction = 3;
					
					break;
					
					
				case 3:
					System.out.println("Voce saiu do programa");
					break;
					
				case 4:
					
					System.out.println("Você é um médico ou um paciente?\n1- Médico \n2- Paciente\n3- Sair ");
					iOpt = scan.nextInt();
					
					if(iOpt == 1 || iOpt == 2)
					{	
						System.out.println("Você deseja: \n1- Fazer login \n2- Cadastrar");
						iAction = scan.nextInt();
					}
					while (iOpt < 0 || iOpt > 2) {
						System.out.println("Opção inválida!");
						System.out.println("Você deseja: \n1- Fazer login \n2- Cadastrar \n 3- Sair do programa ");
						iAction = scan.nextInt();
					}
					
					
			}
		}
		scan.close();
	}
}
