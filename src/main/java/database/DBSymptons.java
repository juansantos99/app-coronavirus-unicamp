package main.java.database;

import main.java.database.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.copas.Symptons;
import main.java.copas.Patient;

public class Symptons {

	Connection connection = null;
	
	public Symptons() {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:corona.db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public UpdateSymptons (int idSintoma, int cpf) {
		
				
		PreparedStatement select = null;
		ResultSet res = null;
		
		try {

			select = this.connection.prepareStatement("INSERT into PATIENT_SYMPTONS values (?,?)");
			select.setString(1, cpf);
			select.setString(2, idSintoma);
			select.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	public ShowSymptons (int cpf) {
		
				
		PreparedStatement select = null;
		ResultSet res = null;
		
		try {

			select = this.connection.prepareStatement("select NAME from SYMPTONS_PACIENT inner join SYMPTONS on (ID = ID) where CPF = ? ");
			select.setString(1, cpf);
			res = select.executeQuery();
			if (resultSet.next()) {
				res.getint(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	public ListSymptons () {	
				
		PreparedStatement select = null;
		ResultSet res = null;
		
		try {

			select = this.connection.prepareStatement("select ID,NAME from SYMPTONS ");
			select.setString(1, ID);
			select.setString(2, NAME);
			res = select.executeQuery();
			if (resultSet.next()) {
				res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
