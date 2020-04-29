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
	
	public void createAppointment(int cpf, int idHealthProfissional, java.util.Date dateAppointment){
	  
		PreparedStatement select = null;
	
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			select = this.connection.prepareStatement("insert into MEDICAL_APPOINTMENT(DATE,PACIENT_CPF,HEALTHPROFESSIONAL_ID) values(?,?,?)");
			
			select.setDate(1,  (Date) dateAppointment);
			select.setInt(2,  cpf);
			select.setInt(3,  idHealthProfissional);
			
			select.executeUpdate();
			
			connection.close();
			select.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	public Appointment[] ShowMedicalAppointment(int id) {
		PreparedStatement select = null;
		ResultSet res = null;
		Appointment[] listAppointment = {
				
		};
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			
			select = this.connection.prepareStatement("select PATIENT_CPF,HEALTHPROFESSIONAL_ID  from MEDICAL_APPOINTMENT where id = ?");
			select.setInt(1,  id);
		    res = select.executeQuery();
			select.executeUpdate();
			
			while (res.next()) {
				Appointment a = new Appointment();
				a.setCpf(res.getInt(1));
				a.setIdHealthProfissional(res.getInt(2));
				listAppointment[listAppointment.length] = a;
			}
			
			connection.close();
			select.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}	
		
		return listAppointment;
	}		
}
	
	