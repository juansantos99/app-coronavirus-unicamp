package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.java.copas.MedicalRecord;

public class DBMedicalRecord {

	private int id = 0;

	public DBMedicalRecord() {
	}

	public int nextId() {
		this.id = this.id + 1;

		return this.id;
	}

	public MedicalRecord showMedicalRecord(long cpf) throws SQLException {
		MedicalRecord document = null;

		Connection connection = null;
		PreparedStatement select = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
			select = connection.prepareStatement("select * from MEDICAL_RECORD where PATIENT_CPF = ?");

			select.setLong(1, cpf);

			resultSet = select.executeQuery();

			document = new MedicalRecord(resultSet.getString("RECORD_DATE"), resultSet.getString("STATUS"),
					resultSet.getLong("PATIENT_CPF"), resultSet.getInt("DOCTOR_ID"), resultSet.getString("DIAGNOSIS"),
					resultSet.getInt("EXAM_ID"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			select.close();
			resultSet.close();
			connection.close();
		}

		return document;
	}

	public MedicalRecord createMedicalRecord(String date, String status, long patientCpf, int doctor_id,
			String diagnosis, int exam_id) throws SQLException {
		int generatedId = 0;

		MedicalRecord document = null;

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
			statement = connection.prepareStatement(
					"INSERT INTO MEDICAL_RECORD(STATUS, RECORD_DATE, PATIENT_CPF, DOCTOR_ID, DIAGNOSIS) VALUES(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, status);
			statement.setString(2, date);
			statement.setLong(3, patientCpf);
			statement.setInt(4, doctor_id);
			statement.setString(5, diagnosis);

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating medical report failed, no rows affected.");
			}

			generatedKeys = statement.getGeneratedKeys();

			if (generatedKeys.next()) {
				generatedId = (int) generatedKeys.getLong(1);
			} else {
				throw new SQLException("Creating medical report failed, no ID obtained.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
			generatedKeys.close();
			connection.close();
		}

		document = new MedicalRecord(date, status, patientCpf, doctor_id, diagnosis, exam_id);

		System.out.println("Medical report successfully created! ID: " + generatedId);

		return document;
	}
}
