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
	
	public MedicalRecord showMedicalRecord(int id) {
		MedicalRecord document = null;
				
		PreparedStatement select = null;
		ResultSet resultSet = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			select = connection.prepareStatement("select * from MEDICAL_RECORD where ID = ?");
			
			select.setInt(1, id);
			
			resultSet = select.executeQuery();
			
			document = new MedicalRecord(resultSet.getString("RECORD_DATE"), resultSet.getString("STATUS"), resultSet.getLong("PATIENT_CPF"), resultSet.getInt("DOCTOR_ID"), resultSet.getString("DIAGNOSIS"), resultSet.getInt("EXAM_ID"));
			
			connection.close();
			select.close();
			resultSet.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return document;
	}
	
	public MedicalRecord createMedicalRecord(String date, String status, long patientCpf, int doctor_id, String diagnosis, int exam_id) {		
		int generatedId = 0;
		
		MedicalRecord document = null;
		PreparedStatement statement = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			statement = connection.prepareStatement("INSERT INTO MEDICAL_RECORD(ID, STATUS, RECORD_DATE, PATIENT_CPF, DOCTOR_ID, DIAGNOSIS) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		  
			statement.setInt(1, generatedId);
			statement.setString(2, status);
			statement.setString(3, date);
			statement.setLong(4, patientCpf);
			statement.setInt(5, doctor_id);
			statement.setString(6, diagnosis);
				
		    int affectedRows = statement.executeUpdate();
		
		    if(affectedRows == 0) {
		    	throw new SQLException("Creating medical report failed, no rows affected.");
		    }
				
			ResultSet generatedKeys = statement.getGeneratedKeys();
				
			if(generatedKeys.next()) {
				generatedId = (int) generatedKeys.getLong(1);
			} else {
				throw new SQLException("Creating medical report failed, no ID obtained.");
			}
			
			connection.close();
			statement.close();
			generatedKeys.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		document = new MedicalRecord(date, status, patientCpf, doctor_id, diagnosis, exam_id);
		
		System.out.println("Medical report successfully created! ID: " + generatedId);
		
		return document;
  }
}
