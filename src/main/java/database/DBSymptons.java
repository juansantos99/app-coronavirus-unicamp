package main.java.database;

import java.sql.*;

import main.java.copas.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import main.java.copas.Symptons;


public class DBSymptons {

	Connection connection = null;
	
	public DBSymptons() {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void UpdateSymptons (int idSintoma, int cpf) {
				
		PreparedStatement select = null;
		ResultSet res = null;
		
		try {

			select = this.connection.prepareStatement("INSERT into PATIENT_SYMPTONS values (?,?)");
			select.setInt(1, cpf);
			select.setInt(2, idSintoma);
			select.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public Symptons[] ShowSymptons(int cpf) {
						
		PreparedStatement select = null;
		ResultSet res = null;
		Symptons[] listSymptons = {
				
		};
		try {

			select = this.connection.prepareStatement("select NAME from SYMPTONS_PACIENT inner join SYMPTONS on (ID = ID) where CPF = ? ");
			select.setInt(1, cpf);
			res = select.executeQuery();		
			while (res.next()) {
				Symptons s = new Symptons();
				s.setDescription(res.getString(1));
				listSymptons[listSymptons.length] = s;
				//listSymptons.add(s);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSymptons;
	}	
	public void ListSymptons() {	
				
		PreparedStatement select = null;
		ResultSet res = null;
		
		try {

			select = this.connection.prepareStatement("select ID,NAME from SYMPTONS ");
			res = select.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
