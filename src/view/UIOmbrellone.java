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

import javax.swing.JTextField;

import java.awt.Insets;
import java.io.FileWriter;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Ombrellone;

public class UIOmbrellone extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numero_txt;
	private JTextField posizione_txt;
	private JTextField idSpiaggia_txt;
	private JButton ombrellone_btn;
	private JTextArea result_txtArea;
	private Connection connection;
	private Statement statement;
	private ResultSet result = null;
	private JButton indietro_btn;


	public UIOmbrellone(Connection connection, Statement statement) {
		this.connection = connection;
		this.statement = statement;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{105, 46, 0};
		gbl_panel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel numero_lbl = new JLabel("Numero");
		GridBagConstraints gbc_numero_lbl = new GridBagConstraints();
		gbc_numero_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_numero_lbl.anchor = GridBagConstraints.NORTHEAST;
		gbc_numero_lbl.gridx = 0;
		gbc_numero_lbl.gridy = 0;
		panel.add(numero_lbl, gbc_numero_lbl);
		
		numero_txt = new JTextField();
		GridBagConstraints gbc_numero_txt = new GridBagConstraints();
		gbc_numero_txt.insets = new Insets(0, 0, 5, 0);
		gbc_numero_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_numero_txt.gridx = 1;
		gbc_numero_txt.gridy = 0;
		panel.add(numero_txt, gbc_numero_txt);
		numero_txt.setColumns(10);
		
		JLabel poisizone_lbl = new JLabel("Posizione (FILA)");
		GridBagConstraints gbc_poisizone_lbl = new GridBagConstraints();
		gbc_poisizone_lbl.anchor = GridBagConstraints.EAST;
		gbc_poisizone_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_poisizone_lbl.gridx = 0;
		gbc_poisizone_lbl.gridy = 1;
		panel.add(poisizone_lbl, gbc_poisizone_lbl);
		
		posizione_txt = new JTextField();
		GridBagConstraints gbc_posizione_txt = new GridBagConstraints();
		gbc_posizione_txt.insets = new Insets(0, 0, 5, 0);
		gbc_posizione_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_posizione_txt.gridx = 1;
		gbc_posizione_txt.gridy = 1;
		panel.add(posizione_txt, gbc_posizione_txt);
		posizione_txt.setColumns(10);
		
		JLabel idSpiaggia_lbl = new JLabel("ID Spiaggia");
		GridBagConstraints gbc_idSpiaggia_lbl = new GridBagConstraints();
		gbc_idSpiaggia_lbl.anchor = GridBagConstraints.EAST;
		gbc_idSpiaggia_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_idSpiaggia_lbl.gridx = 0;
		gbc_idSpiaggia_lbl.gridy = 2;
		panel.add(idSpiaggia_lbl, gbc_idSpiaggia_lbl);
		
		idSpiaggia_txt = new JTextField();
		GridBagConstraints gbc_idSpiaggia_txt = new GridBagConstraints();
		gbc_idSpiaggia_txt.insets = new Insets(0, 0, 5, 0);
		gbc_idSpiaggia_txt.fill = GridBagConstraints.HORIZONTAL;
		gbc_idSpiaggia_txt.gridx = 1;
		gbc_idSpiaggia_txt.gridy = 2;
		panel.add(idSpiaggia_txt, gbc_idSpiaggia_txt);
		idSpiaggia_txt.setColumns(10);
		
		result_txtArea = new JTextArea();
		GridBagConstraints gbc_result_txtArea = new GridBagConstraints();
		gbc_result_txtArea.insets = new Insets(0, 0, 5, 0);
		gbc_result_txtArea.gridx = 1;
		gbc_result_txtArea.gridy = 5;
		panel.add(result_txtArea, gbc_result_txtArea);
		
		indietro_btn = new JButton("<-");
		indietro_btn.addActionListener(this);
		GridBagConstraints gbc_indietro_btn = new GridBagConstraints();
		gbc_indietro_btn.insets = new Insets(0, 0, 0, 5);
		gbc_indietro_btn.gridx = 0;
		gbc_indietro_btn.gridy = 7;
		panel.add(indietro_btn, gbc_indietro_btn);
		
		ombrellone_btn = new JButton("Inserisci Ombrellone");
		ombrellone_btn.addActionListener(this);
		contentPane.add(ombrellone_btn, BorderLayout.SOUTH);
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
				JSONArray ombrelloni = new JSONArray();
				obj.put("Autore", "Marco Sisca");
				obj.put("Creato il", LocalDate.now());
		
				Ombrellone o = new Ombrellone(Integer.parseInt(numero_txt.getText()),
										posizione_txt.getText(),
										Integer.parseInt(idSpiaggia_txt.getText()));

				//INSERIMENTO NELLA TABELLA OMBRELLONE
				String insertOnOmbrellone = String.format("INSERT INTO ombrelloni VALUES (%s,'%s',%s)",o.getNumero(),
	    																						o.getPosizione(),
	    																						o.getIdSpiaggia());
				this.statement.executeUpdate(insertOnOmbrellone);
				//INTERROGAZIONE SULLA TABELLA OMBRELLONE
				this.statement = this.connection.createStatement();
				String queryOnOmbrellone = "SELECT * FROM ombrelloni";
				result = this.statement.executeQuery(queryOnOmbrellone);
				List<Ombrellone> list = new ArrayList<>();
	  
				while (result.next()){
					list.add(new Ombrellone(Integer.parseInt(result.getString("Numero")),
					result.getString("Posizione"),
					Integer.parseInt(result.getString("ID_Spiaggia"))));
				}
				result_txtArea.setText("");
				for (Ombrellone attuale : list){
					result_txtArea.append(attuale.toString() + "\n");
					ombrelloni.add(attuale.toString());
				}
				obj.put("Ombrelloni", ombrelloni);
				//SCRIVO I RISULTATI SU UN FILE
				try (FileWriter file = new FileWriter("C:\\Users\\marxs.94\\Desktop\\MARCO\\PROGETTI JAVA\\GRAND HOTEL AZZURRA\\parsingOmbrelloni.txt")) {
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
