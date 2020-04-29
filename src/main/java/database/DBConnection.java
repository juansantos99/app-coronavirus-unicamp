package main.java.database;

import java.sql.*;

public class DBConnection {

    private static Connection connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:corona.db")) {

            System.out.println("Conexão realizada.");

            Statement statement = connection.createStatement();
            
            statement.execute("CREATE TABLE IF NOT EXISTS PATIENTS( CPF INTEGER PRIMARY KEY, RG INTEGER, NAME VARCHAR, EMAIL VARCHAR, SUSCARD VARCHAR, BORNDATE TEXT, ADDRESS VARCHAR, PASSWORD VARCHAR, STATUS VARCHAR DEFAULT 'SEM CONSULTA')");
            statement.execute("CREATE TABLE IF NOT EXISTS HEALTHPROFESSIONAL( ID INTEGER PRIMARY KEY AUTOINCREMENT, RG INTEGER, CPF INTEGER, NAME VARCHAR, ROLE VARCHAR )");
            statement.execute("CREATE TABLE IF NOT EXISTS SYMPTONS( ID INTEGER PRIMARY KEY , NAME VARCHAR )");
            statement.execute("CREATE TABLE IF NOT EXISTS PATIENT_SYMPTONS( ID INTEGER PRIMARY KEY AUTOINCREMENT, SYMPTONS_ID INTEGER , PATIENT_CPF INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS MEDICAL_APPOINTMENT( ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, PATIENT_CPF INTEGER, HEALTHPROFESSIONAL_ID INTEGER )");
            statement.execute("CREATE TABLE IF NOT EXISTS NOTIFICATIONS( ID INTEGER PRIMARY KEY AUTOINCREMENT, NOTIFICATION VARCHAR, MESSAGE VARCHAR, SCHEDULED TEXT, MEDICAL_APPOINTMENT_ID INTEGER, READ INTEGER DEFAULT 0 )");
            statement.execute("CREATE TABLE IF NOT EXISTS EXAMS( ID INTEGER PRIMARY KEY AUTOINCREMENT, PATIENT_CPF INTEGER, EXAM_DATE TEXT, STATUS VARCHAR, RESULT VARCHAR )");
            statement.execute("CREATE TABLE IF NOT EXISTS MEDICAL_RECORD( ID INTEGER PRIMARY KEY AUTOINCREMENT, STATUS VARHCAR, RECORD_DATE TEXT, PATIENT_CPF INTEGER, DOCTOR_ID INTEGER, DIAGNOSIS VARCHAR, EXAM_ID INTEGER )");
            
            statement.execute("INSERT INTO SYMPTONS (ID,NAME) VALUES ('1','TosseSeca')");
            statement.execute("INSERT INTO SYMPTONS (ID,NAME) VALUES ('2','Febre')");
            statement.execute("INSERT INTO SYMPTONS (ID,NAME) VALUES ('3','Coriça')");
            statement.execute("INSERT INTO SYMPTONS (ID,NAME) VALUES ('4','Faltade_ar')");
            statement.execute("INSERT INTO SYMPTONS (ID,NAME) VALUES ('5','Cansaço')");
            
            return connection;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    public static Connection main() {
        return connect();
    }
	
}
