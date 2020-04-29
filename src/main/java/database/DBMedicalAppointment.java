package main.java.database;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.copas.Appointment;

public class DBMedicalAppointment {

	Connection connection = null;

	public DBMedicalAppointment() {
	}

	public void createAppointment(long cpf, int idHealthProfissional, String dateAppointment) throws SQLException {

		Connection connection = null;
		PreparedStatement select = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
			select = connection.prepareStatement(
					"insert into MEDICAL_APPOINTMENT(DATE,PATIENT_CPF,HEALTHPROFESSIONAL_ID) values(?,?,?)");

			select.setString(1, dateAppointment);
			select.setLong(2, cpf);
			select.setInt(3, idHealthProfissional);

			select.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Teste");
			e.printStackTrace();

		} finally {

			select.close();
			connection.close();
		}
	}

	public void ShowMedicalAppointment(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement select = null;
		ResultSet res = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:corona.db");

			select = connection.prepareStatement(
					"select PATIENT_CPF,HEALTHPROFESSIONAL_ID,DATE from MEDICAL_APPOINTMENT where HEALTHPROFESSIONAL_ID = ?");
			select.setInt(1, id);
			res = select.executeQuery();

			while (res.next()) {
				Appointment appoint = new Appointment();
				appoint.setPatientCpf((long) res.getInt(1));
				appoint.setDoctorId(res.getInt(2));
				appoint.setDate(res.getString(3));
				System.out.print(appoint);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			select.close();
			connection.close();
		}

	}

	public void ShowMedicalAppointmentPatient(long cpf) throws SQLException {

		Connection connection = null;
		PreparedStatement select = null;
		ResultSet res = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:corona.db");

			select = connection.prepareStatement(
					"select PATIENT_CPF,HEALTHPROFESSIONAL_ID,DATE from MEDICAL_APPOINTMENT where PATIENT_CPF = ?");
			select.setLong(1, cpf);
			res = select.executeQuery();

			while (res.next()) {
				Appointment appoint = new Appointment();
				appoint.setPatientCpf((long) res.getInt(1));
				appoint.setDoctorId(res.getInt(2));
				appoint.setDate(res.getString(3));
				System.out.print(appoint);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			select.close();
			connection.close();
		}

	}
}