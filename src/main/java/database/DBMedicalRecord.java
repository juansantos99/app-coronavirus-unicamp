package main.java.database;

import java.sql.Date;
import main.java.database.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.copas.HealthProfessional;
import main.java.copas.MedicalRecord;
import main.java.copas.Patient;

public class DBMedicalRecord {
  Connection connection = null;
  
	private int id = 0;
	
	public DBMedicalRecord() {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int nextId() {
		this.id = this.id + 1;

		return this.id;
	}
	
	public MedicalRecord SignUp(int id) {
		MedicalRecord document = null;
				
		PreparedStatement select = null;
		ResultSet res = null;
		
		try {
			select = this.connection.prepareStatement("select * from MEDICALRECORD where ID = ?");
			
			select.setInt(1, id);
			
			res = select.executeQuery();
			
			document = new MedicalRecord(res.getDate("RECORD_DATE"), res.getString("STATUS"), res.getInt("PATIENT_CPF"), res.getInt("DOCTOR_ID"), res.getString("DIAGNOSIS"), res.getString("EXAM_ID"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return document;
	}
	
	public HealthProfessional SignIn(Date date, String status, int patientCpf, int doctor_id, String diagnosis, int exam_id) {		
		
		int generatedId = 0;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO MEDICAL_RECORD(ID, STATUS, RECORD_DATE, PATIENT_CPF, DOCTOR_ID, DIAGNOSIS, EXAM_ID) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
      
      statement.setInt(1,  generatedId);
			statement.setString(2, status);
			statement.setDate(3, date);
      statement.setInt(4, patientCpf);
      statement.setInt(5, doctor_id);
      statement.setString(6, diagnosis);
      statement.setInt(7, exam_id);
			
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating medical report failed, no rows affected.");
	        }
			
			ResultSet generatedKeys = statement.getGeneratedKeys();
			
            if (generatedKeys.next()) {
                generatedId = (int) generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating medical report failed, no ID obtained.");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HealthProfessional document = new MedicalRecord(date, status, patientCpf, doctor_id, diagnosis, exam_id);
		
		System.out.println("Medical report successfully created! ID: " + generatedId);
		
		return document;
  }
  
  public Boolean UserExists(int medicalRecord_id) {
		
		Boolean exists = false;
		
		PreparedStatement select;
		try {
			select = this.connection.prepareStatement("select * from MEDICAL_RECORD where ID = ?");
			
			select.setInt(1, medicalRecord_id);
			ResultSet resultSet = select.executeQuery();			

			if (resultSet.next()) {
				exists = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exists;
	}
}
