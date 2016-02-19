package model;
import java.io.FileInputStream;
import java.sql.*;
//import java.time.LocalDate;
import java.util.Properties;

import view.UI;


public class Main {
	public static void main(String[] args){
		Connection connection = null;
		Statement statement;
		
		try {
			Properties p = new Properties();
			//nel file di properties ci sono tutti i dati che servono per collegarmi al DB
			p.load(new FileInputStream(System.getProperty("user.dir") + "\\cconfig.properties")); 
			String driver = p.getProperty("jdbcDriver");
			Class.forName(driver);
			String url = p.getProperty("jdbcUrl");
			connection = DriverManager.getConnection(url, p.getProperty("jdbcUsername"), p.getProperty("jdbcPassword"));
			statement = connection.createStatement();
			UI ui = new UI(connection,statement);
			ui.setVisible(true);		 
		} catch (SQLException e) {
		    e.printStackTrace();
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    //PROVA COMMIT 
		    }
		
	}
}
