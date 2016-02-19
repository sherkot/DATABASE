package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import model.Spiaggia;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.JTextArea;

public class UISpiaggia extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_txt;
	private JTextField nome_txt;
	private JTextField via_txt;
	private JTextField citta_txt;
	private JButton indietro_btn,inserisci_btn;
	private JTextField informazioni_txt;
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	private JTextArea result_txtArea;
	
	public UISpiaggia(Connection connection, Statement statement) {
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
		gbl_panel.columnWidths = new int[]{91, 351, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel id_lbl = new JLabel("ID");
		GridBagConstraints gbc_id_lbl = new GridBagConstraints();
		gbc_id_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_id_lbl.gridx = 0;
		gbc_id_lbl.gridy = 0;
		panel.add(id_lbl, gbc_id_lbl);
		
		id_txt = new JTextField();
		GridBagConstraints gbc_id_txt = new GridBagConstraints();
		gbc_id_txt.insets = new Insets(0, 0, 5, 0);
		gbc_id_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_id_txt.gridx = 1;
		gbc_id_txt.gridy = 0;
		panel.add(id_txt, gbc_id_txt);
		id_txt.setColumns(10);
		
		JLabel nome_lbl = new JLabel("Nome");
		GridBagConstraints gbc_nome_lbl = new GridBagConstraints();
		gbc_nome_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_nome_lbl.gridx = 0;
		gbc_nome_lbl.gridy = 1;
		panel.add(nome_lbl, gbc_nome_lbl);
		
		nome_txt = new JTextField();
		GridBagConstraints gbc_nome_txt = new GridBagConstraints();
		gbc_nome_txt.insets = new Insets(0, 0, 5, 0);
		gbc_nome_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nome_txt.gridx = 1;
		gbc_nome_txt.gridy = 1;
		panel.add(nome_txt, gbc_nome_txt);
		nome_txt.setColumns(10);
		
		JLabel via_lbl = new JLabel("Via");
		GridBagConstraints gbc_via_lbl = new GridBagConstraints();
		gbc_via_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_via_lbl.gridx = 0;
		gbc_via_lbl.gridy = 2;
		panel.add(via_lbl, gbc_via_lbl);
		
		via_txt = new JTextField();
		GridBagConstraints gbc_via_txt = new GridBagConstraints();
		gbc_via_txt.insets = new Insets(0, 0, 5, 0);
		gbc_via_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_via_txt.gridx = 1;
		gbc_via_txt.gridy = 2;
		panel.add(via_txt, gbc_via_txt);
		via_txt.setColumns(10);
		
		JLabel citta_lbl = new JLabel("Citt\u00E0");
		GridBagConstraints gbc_citta_lbl = new GridBagConstraints();
		gbc_citta_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_citta_lbl.gridx = 0;
		gbc_citta_lbl.gridy = 3;
		panel.add(citta_lbl, gbc_citta_lbl);
		
		citta_txt = new JTextField();
		GridBagConstraints gbc_citta_txt = new GridBagConstraints();
		gbc_citta_txt.insets = new Insets(0, 0, 5, 0);
		gbc_citta_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_citta_txt.gridx = 1;
		gbc_citta_txt.gridy = 3;
		panel.add(citta_txt, gbc_citta_txt);
		citta_txt.setColumns(10);
		
		JLabel informazioni_lbl = new JLabel("Informazioni");
		GridBagConstraints gbc_informazioni_lbl = new GridBagConstraints();
		gbc_informazioni_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_informazioni_lbl.gridx = 0;
		gbc_informazioni_lbl.gridy = 4;
		panel.add(informazioni_lbl, gbc_informazioni_lbl);
		
		informazioni_txt = new JTextField();
		GridBagConstraints gbc_informazioni_txt = new GridBagConstraints();
		gbc_informazioni_txt.insets = new Insets(0, 0, 5, 0);
		gbc_informazioni_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_informazioni_txt.gridx = 1;
		gbc_informazioni_txt.gridy = 4;
		panel.add(informazioni_txt, gbc_informazioni_txt);
		informazioni_txt.setColumns(10);
		
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
		gbc_indietro_btn.gridy = 8;
		panel.add(indietro_btn, gbc_indietro_btn);
		
		inserisci_btn = new JButton("Inserisci spiaggia");
		inserisci_btn.addActionListener(this);
		contentPane.add(inserisci_btn, BorderLayout.SOUTH);
		this.pack();
	}


	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == indietro_btn){
			UI mainUI = new UI(this.connection,this.statement);
			mainUI.setVisible(true);
			this.setVisible(false);
		}
		else {
			try{
				JSONObject obj = new JSONObject();
				JSONArray spiagge = new JSONArray();
				obj.put("Autore", "Marco Sisca");
				obj.put("Creato il", LocalDate.now());
		
				Spiaggia s = new Spiaggia(Integer.parseInt(id_txt.getText()),
										nome_txt.getText(),
										via_txt.getText(),
										citta_txt.getText(),
										informazioni_txt.getText());

				//INSERIMENTO NELLA TABELLA OMBRELLONE
				String insertOnSpiaggia = String.format("INSERT INTO spiaggia VALUES (%s,'%s','%s','%s','%s')",s.getID(),
	    																						s.getNome(),s.getVia(),s.getCitta(),s.getInformazioni());
				this.statement.executeUpdate(insertOnSpiaggia);
				//INTERROGAZIONE SULLA TABELLA OMBRELLONE
				this.statement = this.connection.createStatement();
				String queryOnSpiaggia = "SELECT * FROM spiaggia";
				result = this.statement.executeQuery(queryOnSpiaggia);
				List<Spiaggia> list = new ArrayList<>();
	  
				while (result.next()){
					list.add(new Spiaggia(Integer.parseInt(result.getString("ID")),
					result.getString("Nome"), result.getString("Via"),result.getString("Citta"),result.getString("Informazioni")));

				}
				result_txtArea.setText("");
				for (Spiaggia attuale : list){
					result_txtArea.append(attuale.toString() + "\n");
					spiagge.add(attuale.toString());
				}
				obj.put("Spiagge", spiagge);
				//SCRIVO I RISULTATI SU UN FILE
				try (FileWriter file = new FileWriter("parsingSpiagge.txt")) {
					file.write(obj.toJSONString());
				}
				this.pack();
			}  catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
	}

}
