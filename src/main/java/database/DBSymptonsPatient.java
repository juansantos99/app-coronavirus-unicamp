package main.java.database;

//import java.sql.Statement;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.database.DBConnection;

import main.java.copas.Symptons;
import main.java.copas.SymptonsPatient;
public class DBSymptonsPatient {

	Connection connection = null;
	private int id = 0;
	
	public DBSymptonsPatient() {
			try {
				this.connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	public SymptonsPatient RegisterSymptons (int idSintoma, int cpf) {
			int generatedId = 0;		
					
			try {
	
				PreparedStatement select = this.connection.prepareStatement("INSERT into PATIENT_SYMPTONS(SYMPTONS_ID,PATIENT_CPF) values (?,?)",Statement.RETURN_GENERATED_KEYS);
				select.setInt(1,idSintoma);
				select.setInt(2,cpf);
				int affectedRows = select.executeUpdate();
	
		        if (affectedRows == 0) {
		            throw new SQLException("Updating Symptons, no rows affected.");
		        }
				
				ResultSet generatedKeys = select.getGeneratedKeys();
				
	            if (generatedKeys.next()) {
	                generatedId = (int) generatedKeys.getLong(1);
	            }
	            else {
	                throw new SQLException("Updating Symptons, no ID obtained.");
	            }
	            connection.close();    
			} catch (SQLException e) {
				e.printStackTrace();
			}
			SymptonsPatient s = new  SymptonsPatient(generatedId,idSintoma,cpf);
			
			return s;
		}
	}