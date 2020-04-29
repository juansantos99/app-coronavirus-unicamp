package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.copas.HealthProfessional;

public class DBHealthProfessional {
	
	private int id = 0;
	
	
	public DBHealthProfessional() {
	}
	
	public int nextId() {
		this.id = this.id + 1;

		return this.id;
	}
	
	public HealthProfessional SignUp(int id) {

		HealthProfessional doc = null;
		
		PreparedStatement select = null;
		ResultSet res = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			select = connection.prepareStatement("select * from HEALTHPROFESSIONAL where ID = ?");
			
			select.setInt(1, id);
			
			res = select.executeQuery();
			
			doc = new HealthProfessional(id, res.getInt("CPF"), res.getInt("RG"), res.getString("NAME"), res.getString("ROLE"));
	
			connection.close();
			select.close();
			res.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doc;
	}
	
	public HealthProfessional SignIn(long cpf, int rg, String name, String role) throws SQLException {		

		int generatedId = 0;
		PreparedStatement statement = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			statement = connection.prepareStatement("INSERT INTO HEALTHPROFESSIONAL(CPF, RG, NAME, ROLE) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, cpf);
			statement.setInt(2, rg);
			statement.setString(3, name);
			statement.setString(4, role);
			
	        int affectedRows = statement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating doctor failed, no rows affected.");
	        }
			
			ResultSet generatedKeys = statement.getGeneratedKeys();
			
            if (generatedKeys.next()) {
                generatedId = (int) generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating doctor failed, no ID obtained.");
            }
            
            connection.close();
            statement.close();
            generatedKeys.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HealthProfessional doc = new HealthProfessional(generatedId, cpf, rg, name, role);
		
		System.out.println("Doctor created - ID: " + generatedId);
		
		return doc;
	}
	
	public Boolean UserExists(long cpf) throws SQLException {

		Boolean exists = false;
		
		PreparedStatement select = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			select = connection.prepareStatement("select * from HEALTHPROFESSIONAL where CPF = ?");
			
			select.setLong(1, cpf);
			ResultSet resultSet = select.executeQuery();			

			if (resultSet.next()) {
				exists = true;
			}
			
			connection.close();
			select.close();
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exists;
	}
}
