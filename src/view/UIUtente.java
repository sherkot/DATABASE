package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.FileWriter;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import model.Utente;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.JTextArea;

public class UIUtente extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username_txt;
	private JTextField password_txt;
	private JTextField nome_txt;
	private JTextField cognome_txt;
	private JButton inserisci_btn, indietro_btn;
	private Statement statement;
	private Connection connection;
	private ResultSet result;
	private JTextArea result_txtArea;

	public UIUtente(Connection connection, Statement statement) {
		this.connection = connection;
		this.statement = statement;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{95, 367, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel username_lbl = new JLabel("Username");
		GridBagConstraints gbc_username_lbl = new GridBagConstraints();
		gbc_username_lbl.anchor = GridBagConstraints.EAST;
		gbc_username_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_username_lbl.gridx = 0;
		gbc_username_lbl.gridy = 0;
		panel.add(username_lbl, gbc_username_lbl);
		
		username_txt = new JTextField();
		GridBagConstraints gbc_username_txt = new GridBagConstraints();
		gbc_username_txt.insets = new Insets(0, 0, 5, 0);
		gbc_username_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_username_txt.gridx = 1;
		gbc_username_txt.gridy = 0;
		panel.add(username_txt, gbc_username_txt);
		username_txt.setColumns(10);
		
		JLabel password_lbl = new JLabel("Password");
		GridBagConstraints gbc_password_lbl = new GridBagConstraints();
		gbc_password_lbl.anchor = GridBagConstraints.EAST;
		gbc_password_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_password_lbl.gridx = 0;
		gbc_password_lbl.gridy = 1;
		panel.add(password_lbl, gbc_password_lbl);
		
		password_txt = new JTextField();
		GridBagConstraints gbc_password_txt = new GridBagConstraints();
		gbc_password_txt.insets = new Insets(0, 0, 5, 0);
		gbc_password_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_password_txt.gridx = 1;
		gbc_password_txt.gridy = 1;
		panel.add(password_txt, gbc_password_txt);
		password_txt.setColumns(10);
		
		JLabel nome_lbl = new JLabel("Nome");
		GridBagConstraints gbc_nome_lbl = new GridBagConstraints();
		gbc_nome_lbl.anchor = GridBagConstraints.EAST;
		gbc_nome_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_nome_lbl.gridx = 0;
		gbc_nome_lbl.gridy = 2;
		panel.add(nome_lbl, gbc_nome_lbl);
		
		nome_txt = new JTextField();
		GridBagConstraints gbc_nome_txt = new GridBagConstraints();
		gbc_nome_txt.insets = new Insets(0, 0, 5, 0);
		gbc_nome_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nome_txt.gridx = 1;
		gbc_nome_txt.gridy = 2;
		panel.add(nome_txt, gbc_nome_txt);
		nome_txt.setColumns(10);
		
		JLabel cognome_lbl = new JLabel("Cognome");
		GridBagConstraints gbc_cognome_lbl = new GridBagConstraints();
		gbc_cognome_lbl.anchor = GridBagConstraints.EAST;
		gbc_cognome_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_cognome_lbl.gridx = 0;
		gbc_cognome_lbl.gridy = 3;
		panel.add(cognome_lbl, gbc_cognome_lbl);
		
		cognome_txt = new JTextField();
		GridBagConstraints gbc_cognome_txt = new GridBagConstraints();
		gbc_cognome_txt.insets = new Insets(0, 0, 5, 0);
		gbc_cognome_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_cognome_txt.gridx = 1;
		gbc_cognome_txt.gridy = 3;
		panel.add(cognome_txt, gbc_cognome_txt);
		cognome_txt.setColumns(10);
		
		result_txtArea = new JTextArea();
		GridBagConstraints gbc_result_txtArea = new GridBagConstraints();
		gbc_result_txtArea.insets = new Insets(0, 0, 5, 0);
		gbc_result_txtArea.fill = GridBagConstraints.BOTH;
		gbc_result_txtArea.gridx = 1;
		gbc_result_txtArea.gridy = 6;
		panel.add(result_txtArea, gbc_result_txtArea);
		
		indietro_btn = new JButton("<-");
		indietro_btn.addActionListener(this);
		GridBagConstraints gbc_indietro_btn = new GridBagConstraints();
		gbc_indietro_btn.insets = new Insets(0, 0, 0, 5);
		gbc_indietro_btn.gridx = 0;
		gbc_indietro_btn.gridy = 7;
		panel.add(indietro_btn, gbc_indietro_btn);
		
		inserisci_btn = new JButton("Inserisci utente");
		inserisci_btn.addActionListener(this);
		contentPane.add(inserisci_btn, BorderLayout.SOUTH);
		this.pack();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == indietro_btn){
			UI mainUI = new UI(this.connection,this.statement);
			this.setVisible(false);
			mainUI.setVisible(true);	
		}
		else {
			try{
			/*Dichiarazione oggetto json*/ JSONObject obj = new JSONObject();
			/*Dichiarazione array json*/ 	JSONArray utenti = new JSONArray();
			obj.put("Autore", "Marco Sisca");
			obj.put("Creato il", LocalDate.now());
				Utente u = new Utente(username_txt.getText(), 
											password_txt.getText(), 
											nome_txt.getText(),
											cognome_txt.getText(),
											LocalDate.now());
			    //INSERIMENTO NELLA TABELLA UTENTE
				String insertOnUtente = String.format("INSERT INTO utente VALUES ('%s','%s','%s','%s','%s')",u.getUsername(),
																										u.getPassword(),
			    																						u.getNome(),
			    																						u.getCognome(),
			    																						u.getDataCreazione().toString());
			    statement.executeUpdate(insertOnUtente);
			    
			    //INTERROGAZIONE SULLA TABELLA UTENTE
			    statement = connection.createStatement();
			    String queryOnUtente = "SELECT * FROM utente";
			    result = statement.executeQuery(queryOnUtente);
			    List<Utente> list = new ArrayList<>();
			
				while (result.next()){
					//INSERISCO IN UNA LISTA TUTTE LE RIGHE RISULTATE DALLA QUERY - POTREI EVITARLO
					list.add(new Utente(result.getString("Username"), 
    						result.getString("Password"), 
    						result.getString("Nome"),
    						result.getString("Cognome"),
    						LocalDate.parse(result.getString("Data_Creazione"))));
				}
				result_txtArea.setText("");
				for (Utente attuale : list){
					result_txtArea.append(attuale.toString() + "\n");
					utenti.add(attuale.toString());
				}
				obj.put("Utenti", utenti);
				//SCRIVO I RISULTATI SU UN FILE
				try (FileWriter file = new FileWriter("parsingUtenti.txt")) {
					file.write(obj.toJSONString());
				}
				this.pack();
				} catch (SQLException e) {
				    e.printStackTrace();
				} catch (Exception e) {
				    System.out.println(e.getMessage());
				}
			}
	}

}
