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
//		ResultSet result = null;
//		Spiaggia s = new Spiaggia(125,"lavelabianca","via casio","milano","tanti giochi");
//		Ombrellone o = new Ombrellone(16,"seconda fila",1);
//		Listino l = new Listino(2,"provadescrizione",7,LocalDate.of(2016, 10, 21),LocalDate.of(2016, 9, 15),150,123);
//		Utente u = new Utente("minchia","ciao","Giovanni","Nicopolidis",LocalDate.now());
//		Prenotazione pr = new Prenotazione(1,LocalDate.of(2016, 10, 21),LocalDate.of(2016, 9, 15),130,105,"sherkot",2);
		
		try {
			Properties p = new Properties();
			//nel file di properties ci sono tutti i dati che servono per collegarmi al DB
			p.load(new FileInputStream("C:\\Users\\marxs.94\\JAVA-MYSQL\\DATABASE\\src\\model\\config.properties")); 
			String driver = p.getProperty("jdbcDriver");
			Class.forName(driver);
			String url = p.getProperty("jdbcUrl");
			connection = DriverManager.getConnection(url, p.getProperty("jdbcUsername"), p.getProperty("jdbcPassword"));
			statement = connection.createStatement();
			
			UI ui = new UI(connection,statement);
			ui.setVisible(true);
			
			//INSERIMENTO NELLA TABELLA SPIAGGIA
//			String insertOnSpiaggia = String.format("INSERT INTO spiaggia VALUES (%s,'%s','%s','%s','%s')",s.getID(),
//																								 s.getNome(), 
//																								 s.getVia(),
//																								 s.getCitta(),
//																								 s.getInformazioni());
//			statement.executeUpdate(insertOnSpiaggia);
			
			//INTERROGAZIONE SULLA TABELLA SPIAGGIA
//			statement = connection.createStatement();
//			String queryOnSpiaggia = "SELECT * FROM spiaggia WHERE Nome LIKE '%vela%'";
//			result = statement.executeQuery(queryOnSpiaggia);  
//		    while (result.next()){
//		    	System.out.println(result.getString("ID") + " " + 
//		    						result.getString("Nome") + " " + 
//		    						result.getString("Via") + " " + 
//		    						result.getString("Citta") + " " + 
//		    						result.getString("Informazioni"));
//		    }
		    
		    
		    
		    
		    //INSERIMENTO NELLA TABELLA OMBRELLONE
//		    String insertOnOmbrellone = String.format("INSERT INTO ombrelloni VALUES (%s,'%s',%s)",o.getNumero(),
//		    																						o.getPosizione(),
//		    																						o.getIdSpiaggia());
//		    statement.executeUpdate(insertOnOmbrellone);
//		    
//		    //INTERROGAZIONE SULLA TABELLA OMBRELLONE
//		    statement = connection.createStatement();
//		    String queryOnOmbrellone = "SELECT * FROM ombrelloni,spiaggia WHERE ombrelloni.ID_Spiaggia = spiaggia.ID";
//		    result = statement.executeQuery(queryOnOmbrellone);
//		    while (result.next()){
//		    	System.out.println(result.getString("Numero") + " " + 
//		    						result.getString("Posizione") + " " + 
//		    						result.getString("ID_Spiaggia"));
//		    }
			
			
//		    //INSERIMENTO NELLA TABELLA LISTINO
//			String insertOnListino = String.format("INSERT INTO listino VALUES (%s,'%s',%s,'%s','%s',%s,%s)",l.getID(),l.getDescrizione(),
//		    																						l.getDurata(),
//		    																						l.getDal().toString(),
//		    																						l.getAl().toString(),
//		    																						l.getPrezzo(),
//		    																						l.getIdSpiaggia());
//		    statement.executeUpdate(insertOnListino);
//		    
//		    //INTERROGAZIONE SULLA TABELLA LISTINO
//		    statement = connection.createStatement();
//		    String queryOnListino = "SELECT * FROM listino";
//		    result = statement.executeQuery(queryOnListino);
//		    while (result.next()){
//		    	System.out.println(result.getString("ID") + " " + 
//		    						result.getString("Descrizione") + " " + 
//		    						result.getString("Durata") + " dal " + 
//		    						result.getString("Dal") + " al " + 
//		    						result.getString("Al") + " " + 
//		    						result.getString("Prezzo") + " " +
//		    						result.getString("ID_Spiaggia"));
//		    }
			
			
			
			
			
//		    //INSERIMENTO NELLA TABELLA UTENTE
//			String insertOnUtente = String.format("INSERT INTO utente VALUES ('%s','%s','%s','%s','%s')",u.getUsername(),
//																									u.getPassword(),
//		    																						u.getNome(),
//		    																						u.getCognome(),
//		    																						u.getDataCreazione().toString());
//		    statement.executeUpdate(insertOnUtente);
//		    
//		    //INTERROGAZIONE SULLA TABELLA UTENTE
//		    statement = connection.createStatement();
//		    String queryOnUtente = "SELECT * FROM utente";
//		    result = statement.executeQuery(queryOnUtente);
//		    while (result.next()){
//		    	System.out.println(result.getString("Username") + " " + 
//		    						result.getString("Nome") + " " + 
//		    						result.getString("Cognome") + " " + 
//		    						result.getString("Data_Creazione"));
//		    }
			
			
//		    //INSERIMENTO NELLA TABELLA PRENOTAZIONE
//			String insertOnPrenotazione = String.format("INSERT INTO prenotazione VALUES (%s,'%s','%s',%s,%s,'%s',%s)",pr.getID(),
//																									pr.getDal().toString(),
//		    																						pr.getAl().toString(),
//		    																						pr.getPrezzoReale(),
//		    																						pr.getNumeroOmbrellone(),
//		    																						pr.getUsernameUtente(),
//		    																						pr.getIdListino());
//		    statement.executeUpdate(insertOnPrenotazione);
//		    
//		    //INTERROGAZIONE SULLA TABELLA PRENOTAZIONE
//		    statement = connection.createStatement();
//		    String queryOnPrenotazione = "SELECT * FROM prenotazione";
//		    result = statement.executeQuery(queryOnPrenotazione);
//		    while (result.next()){
//		    	System.out.println(result.getString("ID") + " " + 
//		    						result.getString("Dal") + " " + 
//		    						result.getString("Al") + " " + 
//		    						result.getString("Prezzo_Reale") + " " +
//		    						result.getString("Numero_ombrellone") + " " +
//		    						result.getString("Username_utente") + " " +
//		    						result.getString("ID_listino"));
//		    }
			
		
		    
		    
		 
		} catch (SQLException e) {
		    e.printStackTrace();
		} catch (Exception e) {
		    System.out.println(e.getMessage());}
//		} finally {
//		    try {
//		        if (connection != null)
//		            connection.close();
//		    } catch (SQLException e) {
//		        // gestione errore in chiusura
//		    }
//		}
		
	}
}
