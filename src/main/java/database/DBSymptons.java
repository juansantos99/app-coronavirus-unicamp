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




public class DBSymptons {

	Connection connection = null;
	public DBSymptons() {
	}
		
	public Symptons ShowSymptons(int cpf) throws SQLException {
			
		PreparedStatement select = null;
		ResultSet res = null;
		Symptons doc = null;
		try {

			select = DBConnection.getConnection(connection).prepareStatement("select NAME from SYMPTONS_PACIENT inner join SYMPTONS on (ID = ID) where CPF = ? ");
			select.setInt(1, cpf);
            res = select.executeQuery();
			
			doc = new Symptons(res.getString("NAME"));
		
			res.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doc;
	}	
	public Symptons ListSymptons(int idSintomas) throws SQLException {	
		PreparedStatement select = null;
		ResultSet res = null;
		Symptons doc = null;
		try {
			this.connection = DBConnection.getConnection(connection);
			select = this.connection.prepareStatement("select ID,NAME from SYMPTONS where ID = ?");
            select.setInt(1,idSintomas);
			res = select.executeQuery();
			
			if (res.next()) {
				doc = new Symptons(idSintomas,res.getString("NAME"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			  if (this.connection != null) {
			    try {
			      this.connection.close(); // <-- This is important
			    } catch (SQLException e) {
			      /* handle exception */
			    }
			  }
			}
		return doc;
	}
}
