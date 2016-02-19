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
import javax.swing.JTextArea;

import model.Prenotazione;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.Font;

public class UIPrenotazione extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ID_txt;
	private JTextField dal_txt;
	private JTextField al_txt;
	private JTextField numeroOmbrellone_txt;
	private JTextField prezzoReale_txt;
	private JTextField usernameUtente_txt;
	private JTextField idListino_txt;
	private JButton inserisci_btn, indietro_btn;
	private JTextArea result_txtArea;
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	private JLabel label;
	private JLabel label_1;
	private JButton btnVisualizzaIDati;
	private /*Dichiarazione oggetto json*/ JSONObject obj = new JSONObject();
	private /*Dichiarazione array json*/ JSONArray prenotazioni = new JSONArray();
	


	public UIPrenotazione(Connection connection, Statement statement) {
		this.connection = connection;
		this.statement = statement;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{113, 306, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel ID_lbl = new JLabel("ID");
		GridBagConstraints gbc_ID_lbl = new GridBagConstraints();
		gbc_ID_lbl.anchor = GridBagConstraints.EAST;
		gbc_ID_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_ID_lbl.gridx = 0;
		gbc_ID_lbl.gridy = 0;
		panel.add(ID_lbl, gbc_ID_lbl);
		
		ID_txt = new JTextField();
		GridBagConstraints gbc_ID_txt = new GridBagConstraints();
		gbc_ID_txt.insets = new Insets(0, 0, 5, 0);
		gbc_ID_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_ID_txt.gridx = 1;
		gbc_ID_txt.gridy = 0;
		panel.add(ID_txt, gbc_ID_txt);
		ID_txt.setColumns(10);
		
		JLabel dal_lbl = new JLabel("Dal");
		GridBagConstraints gbc_dal_lbl = new GridBagConstraints();
		gbc_dal_lbl.anchor = GridBagConstraints.EAST;
		gbc_dal_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_dal_lbl.gridx = 0;
		gbc_dal_lbl.gridy = 1;
		panel.add(dal_lbl, gbc_dal_lbl);
		
		dal_txt = new JTextField();
		GridBagConstraints gbc_dal_txt = new GridBagConstraints();
		gbc_dal_txt.insets = new Insets(0, 0, 5, 0);
		gbc_dal_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_dal_txt.gridx = 1;
		gbc_dal_txt.gridy = 1;
		panel.add(dal_txt, gbc_dal_txt);
		dal_txt.setColumns(10);
		
		label = new JLabel("YYYY-MM-GG");
		label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);
		
		JLabel al_lbl = new JLabel("Al");
		GridBagConstraints gbc_al_lbl = new GridBagConstraints();
		gbc_al_lbl.anchor = GridBagConstraints.EAST;
		gbc_al_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_al_lbl.gridx = 0;
		gbc_al_lbl.gridy = 3;
		panel.add(al_lbl, gbc_al_lbl);
		
		al_txt = new JTextField();
		GridBagConstraints gbc_al_txt = new GridBagConstraints();
		gbc_al_txt.insets = new Insets(0, 0, 5, 0);
		gbc_al_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_al_txt.gridx = 1;
		gbc_al_txt.gridy = 3;
		panel.add(al_txt, gbc_al_txt);
		al_txt.setColumns(10);
		
		label_1 = new JLabel("YYYY-MM-GG");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 4;
		panel.add(label_1, gbc_label_1);
		
		JLabel prezzoReale_lbl = new JLabel("Prezzo reale");
		GridBagConstraints gbc_prezzoReale_lbl = new GridBagConstraints();
		gbc_prezzoReale_lbl.anchor = GridBagConstraints.EAST;
		gbc_prezzoReale_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_prezzoReale_lbl.gridx = 0;
		gbc_prezzoReale_lbl.gridy = 5;
		panel.add(prezzoReale_lbl, gbc_prezzoReale_lbl);
		
		prezzoReale_txt = new JTextField();
		GridBagConstraints gbc_prezzoReale_txt = new GridBagConstraints();
		gbc_prezzoReale_txt.insets = new Insets(0, 0, 5, 0);
		gbc_prezzoReale_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_prezzoReale_txt.gridx = 1;
		gbc_prezzoReale_txt.gridy = 5;
		panel.add(prezzoReale_txt, gbc_prezzoReale_txt);
		prezzoReale_txt.setColumns(10);
		
		JLabel numeroOmbrellone_lbl = new JLabel("Numero Ombrellone");
		GridBagConstraints gbc_numeroOmbrellone_lbl = new GridBagConstraints();
		gbc_numeroOmbrellone_lbl.anchor = GridBagConstraints.EAST;
		gbc_numeroOmbrellone_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_numeroOmbrellone_lbl.gridx = 0;
		gbc_numeroOmbrellone_lbl.gridy = 6;
		panel.add(numeroOmbrellone_lbl, gbc_numeroOmbrellone_lbl);
		
		numeroOmbrellone_txt = new JTextField();
		GridBagConstraints gbc_numeroOmbrellone_txt = new GridBagConstraints();
		gbc_numeroOmbrellone_txt.insets = new Insets(0, 0, 5, 0);
		gbc_numeroOmbrellone_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_numeroOmbrellone_txt.gridx = 1;
		gbc_numeroOmbrellone_txt.gridy = 6;
		panel.add(numeroOmbrellone_txt, gbc_numeroOmbrellone_txt);
		numeroOmbrellone_txt.setColumns(10);
		
		JLabel usernameUtente_lbl = new JLabel("Username Utente");
		GridBagConstraints gbc_usernameUtente_lbl = new GridBagConstraints();
		gbc_usernameUtente_lbl.anchor = GridBagConstraints.EAST;
		gbc_usernameUtente_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_usernameUtente_lbl.gridx = 0;
		gbc_usernameUtente_lbl.gridy = 7;
		panel.add(usernameUtente_lbl, gbc_usernameUtente_lbl);
		
		usernameUtente_txt = new JTextField();
		GridBagConstraints gbc_usernameUtente_txt = new GridBagConstraints();
		gbc_usernameUtente_txt.insets = new Insets(0, 0, 5, 0);
		gbc_usernameUtente_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameUtente_txt.gridx = 1;
		gbc_usernameUtente_txt.gridy = 7;
		panel.add(usernameUtente_txt, gbc_usernameUtente_txt);
		usernameUtente_txt.setColumns(10);
		
		JLabel idListino_lbl = new JLabel("ID Listino");
		GridBagConstraints gbc_idListino_lbl = new GridBagConstraints();
		gbc_idListino_lbl.anchor = GridBagConstraints.EAST;
		gbc_idListino_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_idListino_lbl.gridx = 0;
		gbc_idListino_lbl.gridy = 8;
		panel.add(idListino_lbl, gbc_idListino_lbl);
		
		idListino_txt = new JTextField();
		GridBagConstraints gbc_idListino_txt = new GridBagConstraints();
		gbc_idListino_txt.insets = new Insets(0, 0, 5, 0);
		gbc_idListino_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_idListino_txt.gridx = 1;
		gbc_idListino_txt.gridy = 8;
		panel.add(idListino_txt, gbc_idListino_txt);
		idListino_txt.setColumns(10);
		
		indietro_btn = new JButton("<-");
		indietro_btn.addActionListener(this);
		GridBagConstraints gbc_indietro_btn = new GridBagConstraints();
		gbc_indietro_btn.insets = new Insets(0, 0, 5, 5);
		gbc_indietro_btn.gridx = 0;
		gbc_indietro_btn.gridy = 10;
		panel.add(indietro_btn, gbc_indietro_btn);
		
		result_txtArea = new JTextArea();
		GridBagConstraints gbc_result_txtArea = new GridBagConstraints();
		gbc_result_txtArea.insets = new Insets(0, 0, 5, 0);
		gbc_result_txtArea.fill = GridBagConstraints.BOTH;
		gbc_result_txtArea.gridx = 1;
		gbc_result_txtArea.gridy = 10;
		panel.add(result_txtArea, gbc_result_txtArea);
		
		btnVisualizzaIDati = new JButton("Visualizza i dati");
		GridBagConstraints gbc_btnVisualizzaIDati = new GridBagConstraints();
		gbc_btnVisualizzaIDati.insets = new Insets(0, 0, 0, 5);
		gbc_btnVisualizzaIDati.gridx = 0;
		gbc_btnVisualizzaIDati.gridy = 12;
		panel.add(btnVisualizzaIDati, gbc_btnVisualizzaIDati);
		btnVisualizzaIDati.addActionListener(this);
		
		inserisci_btn = new JButton("Inserisci Prenotazione");
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
		}else if(arg0.getSource() == btnVisualizzaIDati){
			try {
			this.statement = this.connection.createStatement();
			String querySelect = "SELECT * FROM prenotazione";
			result = this.statement.executeQuery(querySelect);
			List<Prenotazione> list = new ArrayList<>();
			  
			//INTERROGAZIONE SULLA TABELLA LISTINO		
			 while (result.next()){
			    	list.add(new Prenotazione(Integer.parseInt(result.getString("ID")), 
			    						LocalDate.parse(result.getString("Dal")), 
			    						LocalDate.parse(result.getString("Al")), 
			    						Integer.parseInt(result.getString("Prezzo_Reale")),
			    						Integer.parseInt(result.getString("Numero_ombrellone")),
			    						result.getString("Username_utente"),
			    						Integer.parseInt(result.getString("ID_listino"))));
			    }
				result_txtArea.setText("");
				for (Prenotazione attuale : list){
					result_txtArea.append(attuale.toString() + "\n");
					prenotazioni.add(attuale.toString());
				}
			this.pack();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			try{

				Prenotazione pr = new Prenotazione(Integer.parseInt(ID_txt.getText()), 
											LocalDate.parse(dal_txt.getText()),
											LocalDate.parse(al_txt.getText()), 
											Integer.parseInt(prezzoReale_txt.getText()),
											Integer.parseInt(numeroOmbrellone_txt.getText()),
											usernameUtente_txt.getText(),
											Integer.parseInt(idListino_txt.getText()));
			    //INSERIMENTO NELLA TABELLA PRENOTAZIONE
				String insertOnPrenotazione = String.format("INSERT INTO prenotazione VALUES (%s,'%s','%s',%s,%s,'%s',%s)",pr.getID(),
																										pr.getDal().toString(),
			    																						pr.getAl().toString(),
			    																						pr.getPrezzoReale(),
			    																						pr.getNumeroOmbrellone(),
			    																						pr.getUsernameUtente(),
			    																						pr.getIdListino());
			    statement.executeUpdate(insertOnPrenotazione);
			    
			    //INTERROGAZIONE SULLA TABELLA PRENOTAZIONE
			    statement = connection.createStatement();
			    String queryOnPrenotazione = "SELECT * FROM prenotazione";
			    result = statement.executeQuery(queryOnPrenotazione);
			    btnVisualizzaIDati.doClick();
				obj.put("Nome", "Prova JSON");
				obj.put("Creato da", "Marco Sisca");
				obj.put("Creato il", LocalDate.now());
				obj.put("Prenotazioni",prenotazioni);
				
				//SCRIVO I RISULTATI SU UN FILE
				try (FileWriter file = new FileWriter("parsingPrenotazioni.txt")) {
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
