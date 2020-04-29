package main.java.database;

import java.sql.*;

import main.java.copas.Patient;

public class DBPatient {
	public DBPatient() {
	}

	public Patient SignUp(long cpf, String password) throws SQLException {

		Patient patient = null;
		PreparedStatement select = null;
		ResultSet res = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			select = connection.prepareStatement("select * from PATIENTS where CPF = ? and PASSWORD = ?");
			
			select.setLong(1, cpf);
			select.setString(2, password);
			
			res = select.executeQuery();
			
			select.close();
			connection.close();
			res.close();
			
			patient = new Patient(cpf, res.getInt("RG"), res.getString("NAME"), res.getString("EMAIL"), res.getString("SUSCARD"), res.getString("BORNDATE"), res.getString("ADDRESS"), password, res.getString("STATUS"));
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return patient;
	}
	
	public Patient SignIn(long cpf, int rg, String name, String email, String susCard, String bornDate, String address, String password) throws SQLException {		

		Patient patient = new Patient(cpf, rg, name, email, susCard, bornDate, address, password, "Sem consulta");
		
		PreparedStatement statement = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			statement = connection.prepareStatement("INSERT INTO PATIENTS(CPF, RG, NAME, EMAIL, SUSCARD, BORNDATE, ADDRESS, PASSWORD, STATUS) VALUES(?,?,?,?,?,?,?,?,?)");
			statement.setLong(1,  cpf);
			statement.setInt(2, rg);
			statement.setString(3, name);
			statement.setString(4, email);
			statement.setString(5, susCard);
			statement.setString(6, bornDate);
			statement.setString(7, address);
			statement.setString(8, password);
			statement.setString(9, "Sem consulta");
			
			statement.executeUpdate();
			
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Usuário criado com sucesso");
		
		return patient;
	}
	
	public Boolean UserExists(long cpf) throws SQLException {

		Boolean exists = false;
		
		PreparedStatement select = null;
		
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {
			select = connection.prepareStatement("select * from PATIENTS where CPF = ?");
			
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

