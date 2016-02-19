package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Listino;

import java.awt.Font;

public class UIListino extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ID_txt;
	private JTextField descrizione_txt;
	private JTextField durata_txt;
	private JTextField dal_txt;
	private JTextField al_txt;
	private JTextField prezzo_txt;
	private JTextField idSpiaggia_txt;
	private Statement statement = null;
	private ResultSet result = null;
	private Connection connection = null;
	private JPanel labelPanel;
	private JLabel ID_lbl;
	private JLabel descrizione_lbl;
	private JLabel durata_lbl;
	private JLabel dal_lbl, al_lbl, prezzo_lbl, idSpiaggia_lbl;
	private JButton listino_btn;
	private JTextArea result_txtArea;
	private JButton indietro_btn;
	private JLabel lblNewLabel;
	private JLabel label;
	private JButton btnVisualizzaIDati;
	private JSONObject obj = new JSONObject();
	private JSONArray listini = new JSONArray();

	
	public UIListino(Connection connection, Statement statement) {
		this.statement = statement;
		this.connection = connection;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		labelPanel = new JPanel();
		contentPane.add(labelPanel, BorderLayout.CENTER);
		GridBagLayout gbl_labelPanel = new GridBagLayout();
		gbl_labelPanel.columnWidths = new int[]{105, 46, 0};
		gbl_labelPanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_labelPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_labelPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		labelPanel.setLayout(gbl_labelPanel);
		
		ID_lbl = new JLabel("ID");
		GridBagConstraints gbc_ID_lbl = new GridBagConstraints();
		gbc_ID_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_ID_lbl.gridx = 0;
		gbc_ID_lbl.gridy = 0;
		labelPanel.add(ID_lbl, gbc_ID_lbl);
		
		ID_txt = new JTextField();
		GridBagConstraints gbc_ID_txt = new GridBagConstraints();
		gbc_ID_txt.insets = new Insets(0, 0, 5, 0);
		gbc_ID_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_ID_txt.gridx = 1;
		gbc_ID_txt.gridy = 0;
		labelPanel.add(ID_txt, gbc_ID_txt);
		ID_txt.setColumns(10);
		
		descrizione_lbl = new JLabel("Descrizione");
		GridBagConstraints gbc_descrizione_lbl = new GridBagConstraints();
		gbc_descrizione_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_descrizione_lbl.gridx = 0;
		gbc_descrizione_lbl.gridy = 1;
		labelPanel.add(descrizione_lbl, gbc_descrizione_lbl);
		
		descrizione_txt = new JTextField();
		GridBagConstraints gbc_descrizione_txt = new GridBagConstraints();
		gbc_descrizione_txt.insets = new Insets(0, 0, 5, 0);
		gbc_descrizione_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_descrizione_txt.gridx = 1;
		gbc_descrizione_txt.gridy = 1;
		labelPanel.add(descrizione_txt, gbc_descrizione_txt);
		descrizione_txt.setColumns(10);
		
		durata_lbl = new JLabel("Durata");
		GridBagConstraints gbc_durata_lbl = new GridBagConstraints();
		gbc_durata_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_durata_lbl.gridx = 0;
		gbc_durata_lbl.gridy = 2;
		labelPanel.add(durata_lbl, gbc_durata_lbl);
		
		durata_txt = new JTextField();
		GridBagConstraints gbc_durata_txt = new GridBagConstraints();
		gbc_durata_txt.insets = new Insets(0, 0, 5, 0);
		gbc_durata_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_durata_txt.gridx = 1;
		gbc_durata_txt.gridy = 2;
		labelPanel.add(durata_txt, gbc_durata_txt);
		durata_txt.setColumns(10);
		
		dal_lbl = new JLabel("Dal");
		GridBagConstraints gbc_dal_lbl = new GridBagConstraints();
		gbc_dal_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_dal_lbl.gridx = 0;
		gbc_dal_lbl.gridy = 3;
		labelPanel.add(dal_lbl, gbc_dal_lbl);

		
		dal_txt = new JTextField();
		dal_txt.setToolTipText("");
		GridBagConstraints gbc_dal_txt = new GridBagConstraints();
		gbc_dal_txt.insets = new Insets(0, 0, 5, 0);
		gbc_dal_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_dal_txt.gridx = 1;
		gbc_dal_txt.gridy = 3;
		labelPanel.add(dal_txt, gbc_dal_txt);
		dal_txt.setColumns(10);
		
		lblNewLabel = new JLabel("YYYY-MM-GG");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		labelPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		al_lbl = new JLabel("Al");
		GridBagConstraints gbc_al_lbl = new GridBagConstraints();
		gbc_al_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_al_lbl.gridx = 0;
		gbc_al_lbl.gridy = 5;
		labelPanel.add(al_lbl, gbc_al_lbl);
		
		al_txt = new JTextField();
		GridBagConstraints gbc_al_txt = new GridBagConstraints();
		gbc_al_txt.insets = new Insets(0, 0, 5, 0);
		gbc_al_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_al_txt.gridx = 1;
		gbc_al_txt.gridy = 5;
		labelPanel.add(al_txt, gbc_al_txt);
		al_txt.setColumns(10);
		
		label = new JLabel("YYYY-MM-GG");
		label.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 6;
		labelPanel.add(label, gbc_label);
		
		
		prezzo_lbl = new JLabel("Prezzo");
		GridBagConstraints gbc_prezzo_lbl = new GridBagConstraints();
		gbc_prezzo_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_prezzo_lbl.gridx = 0;
		gbc_prezzo_lbl.gridy = 7;
		labelPanel.add(prezzo_lbl, gbc_prezzo_lbl);
		
		prezzo_txt = new JTextField();
		GridBagConstraints gbc_prezzo_txt = new GridBagConstraints();
		gbc_prezzo_txt.insets = new Insets(0, 0, 5, 0);
		gbc_prezzo_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_prezzo_txt.gridx = 1;
		gbc_prezzo_txt.gridy = 7;
		labelPanel.add(prezzo_txt, gbc_prezzo_txt);
		prezzo_txt.setColumns(10);
		
		idSpiaggia_lbl = new JLabel("ID Spiaggia");
		idSpiaggia_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_idSpiaggia_lbl = new GridBagConstraints();
		gbc_idSpiaggia_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_idSpiaggia_lbl.gridx = 0;
		gbc_idSpiaggia_lbl.gridy = 8;
		labelPanel.add(idSpiaggia_lbl, gbc_idSpiaggia_lbl);
		
		idSpiaggia_txt = new JTextField();
		GridBagConstraints gbc_idSpiaggia_txt = new GridBagConstraints();
		gbc_idSpiaggia_txt.insets = new Insets(0, 0, 5, 0);
		gbc_idSpiaggia_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_idSpiaggia_txt.gridx = 1;
		gbc_idSpiaggia_txt.gridy = 8;
		labelPanel.add(idSpiaggia_txt, gbc_idSpiaggia_txt);
		idSpiaggia_txt.setColumns(10);

		result_txtArea = new JTextArea();
		GridBagConstraints gbc_result_txtArea = new GridBagConstraints();
		gbc_result_txtArea.insets = new Insets(0, 0, 5, 0);
		gbc_result_txtArea.gridx = 1;
		gbc_result_txtArea.gridy = 10;
		labelPanel.add(result_txtArea, gbc_result_txtArea);
		
		indietro_btn = new JButton("<-");
		indietro_btn.addActionListener(this);
		GridBagConstraints gbc_indietro_btn = new GridBagConstraints();
		gbc_indietro_btn.insets = new Insets(0, 0, 5, 5);
		gbc_indietro_btn.gridx = 0;
		gbc_indietro_btn.gridy = 11;
		labelPanel.add(indietro_btn, gbc_indietro_btn);
		
		btnVisualizzaIDati = new JButton("Visualizza i dati");
		GridBagConstraints gbc_btnVisualizzaIDati = new GridBagConstraints();
		gbc_btnVisualizzaIDati.insets = new Insets(0, 0, 0, 5);
		gbc_btnVisualizzaIDati.gridx = 0;
		gbc_btnVisualizzaIDati.gridy = 12;
		labelPanel.add(btnVisualizzaIDati, gbc_btnVisualizzaIDati);
		btnVisualizzaIDati.addActionListener(this);
		
		listino_btn = new JButton("Inserisci Listino");
		listino_btn.addActionListener(this); 
		contentPane.add(listino_btn, BorderLayout.SOUTH);
	//this.pack();
	}



	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		if (arg0.getSource() == indietro_btn){
			UI mainUI = new UI(this.connection,this.statement);
			this.setVisible(false);
			mainUI.setVisible(true);	
		} else if(arg0.getSource() == btnVisualizzaIDati){
			try {
			this.statement = this.connection.createStatement();
			String querySelect = "SELECT * FROM listino";
			result = this.statement.executeQuery(querySelect);
			List<Listino> list = new ArrayList<>();
			  
			//INTERROGAZIONE SULLA TABELLA LISTINO		
			while (result.next()){
				//INSERISCO IN UNA LISTA TUTTE LE RIGHE RISULTATE DALLA QUERY - POTREI EVITARLO
				list.add(new Listino(Integer.parseInt(result.getString("ID")), 
						result.getString("Descrizione"), 
						Integer.parseInt(result.getString("Durata")),
						LocalDate.parse(result.getString("Dal")),
						LocalDate.parse(result.getString("Al")),
						Integer.parseInt(result.getString("Prezzo")),
						Integer.parseInt(result.getString("ID_Spiaggia"))));
			}
			result_txtArea.setText("");
			for (Listino attuale : list){
				result_txtArea.append(attuale.toString() + "\n");
				listini.add(attuale.toString());
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
				Listino l = new Listino(Integer.parseInt(ID_txt.getText()), 
											descrizione_txt.getText(), 
											Integer.parseInt(durata_txt.getText()),
											LocalDate.parse(dal_txt.getText()),
											LocalDate.parse(al_txt.getText()),
											Integer.parseInt(prezzo_txt.getText()),
											Integer.parseInt(idSpiaggia_txt.getText()));
				//INSERIMENTO NELLA TABELLA LISTINO
				String insertOnListino = String.format("INSERT INTO listino VALUES (%s,'%s',%s,'%s','%s',%s,%s)",l.getID(),l.getDescrizione(),
				    																						l.getDurata(),
				    																						l.getDal().toString(),
				    																						l.getAl().toString(),
				    																						l.getPrezzo(),
				    																						l.getIdSpiaggia());
				this.statement.executeUpdate(insertOnListino);
				btnVisualizzaIDati.doClick();
				obj.put("Nome", "Prova JSON");
				obj.put("Creato da", "Marco Sisca");
				obj.put("Creato il", LocalDate.now());
				obj.put("Listini",listini);
			
				//SCRIVO I RISULTATI SU UN FILE
				try (FileWriter file = new FileWriter("parsingListino.txt")) {
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
