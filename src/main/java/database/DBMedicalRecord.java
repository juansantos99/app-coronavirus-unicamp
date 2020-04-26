package main.java.database;

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
			
			document = new MedicalRecord(res.getDate("RECORD_DATE"), res.getString("STATUS"), res.getInt("PATIENT_CPF"), res.getInt("DOCTOR_ID"), res.getString("DIAGNOSIS"), res.getString("EXAMS_ID"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return document;
	}
}
