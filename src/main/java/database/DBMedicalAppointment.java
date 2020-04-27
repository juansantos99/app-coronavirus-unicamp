package main.java.database;

import main.java.database.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMedicalApointment {
	
	Connection connection = null;
	
	public DBMedicalAppointment() {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Appointment(int cpf, int idHealthProfissional, string dateAppointment){
	  
		PreparedStatement select = null;
		ResultSet res = null;
		try {
			
			select = this.connection.prepareStatment("insert into MEDICAL_APPOINTMENT(PACIENT_CPF,HEALTHPROFESSIONAL_ID,DATE) values(?,?,?)")
			select.setInt(1,  cpf);
			select.setInt(2,  idHealthProfissional);
			select.setString(3,  DateAppointment);
			select.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	public ShowAppointmentsMedical(int id) {
		PreparedStatement select = null;
		ResultSet res = null;
		try {
			
			select = this.connection.prepareStatment("select * from MEDICAL_APPOINTMENT where id = ?")
			select.setInt(1,  id);
		    res = select.executeQuery()
			select.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}	
		
	}
	
	public ShowAppointmentsPatient(int cpf) {
		PreparedStatement select = null;
		ResultSet res = null;
		try {
			
			select = this.connection.prepareStatment("select * from MEDICAL_APPOINTMENT where cpf = ?")
			select.setInt(1,  cpf);
		    res = select.executeQuery()
			select.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}	
		
	}
	/*Como fazer verificação ?*/
	public UpdateAppointment(int cpf, int idHealthProfissional, string DateAppointment) {
		  
				PreparedStatement select = null;
				ResultSet res = null;
				try {
					
					select = this.connection.prepareStatment("insert into MEDICAL_APPOINTMENT(PACIENT_CPF,HEALTHPROFESSIONAL_ID,DATE) values(?,?,?)")
					select.setInt(1,  cpf);
					select.setInt(2,  idHealthProfissional);
					select.setString(3,  DateAppointment);
					select.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				
				}
		
	}
		
}
	
	