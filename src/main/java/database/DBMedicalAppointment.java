package main.java.database;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.copas.Appointment;
import main.java.copas.HealthProfessional;
import main.java.copas.Symptons;

public class DBMedicalAppointment {

	Connection connection = null;

	public DBMedicalAppointment() {
	}

	public void createAppointment(int cpf, int idHealthProfissional, java.util.Date dateAppointment)
			throws SQLException {

		Connection connection = null;
		PreparedStatement select = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
			select = this.connection.prepareStatement(
					"insert into MEDICAL_APPOINTMENT(DATE,PACIENT_CPF,HEALTHPROFESSIONAL_ID) values(?,?,?)");

			select.setDate(1, (Date) dateAppointment);
			select.setInt(2, cpf);
			select.setInt(3, idHealthProfissional);

			select.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			select.close();
			connection.close();
		}
	}

	public Appointment[] ShowMedicalAppointment(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement select = null;
		ResultSet res = null;

		Appointment[] listAppointment = {

		};

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:corona.db");

			select = this.connection.prepareStatement(
					"select PATIENT_CPF,HEALTHPROFESSIONAL_ID  from MEDICAL_APPOINTMENT where id = ?");
			select.setInt(1, id);
			res = select.executeQuery();
			select.executeUpdate();

			while (res.next()) {
				Appointment a = new Appointment();
				a.setCpf(res.getInt(1));
				a.setIdHealthProfissional(res.getInt(2));
				listAppointment[listAppointment.length] = a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			select.close();
			connection.close();
		}

		return listAppointment;
	}
}
