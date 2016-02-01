package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class UI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection connection = null;
	private JButton btnInserisciListino = null;
	private JButton btnInserisciSpiaggia = null;
	private JButton btnInserisciOmbrellone = null ;
	private JButton btnInserisciPrenotazione = null;
	private JButton btnInserisciUtente = null;
	private Statement statement = null;
	private JButton esci_btn = null;
	/**
	 * Create the frame.
	 */
	public UI(Connection connection, Statement statement) {
		this.connection = connection;
		this.statement = statement;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{153, 135, 165, 0};
		gbl_contentPane.rowHeights = new int[]{23, 23, 23, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnInserisciOmbrellone = new JButton("INSERISCI OMBRELLONE");
		btnInserisciOmbrellone.addActionListener(this);
		
		btnInserisciListino = new JButton("INSERISCI LISTINO");
		btnInserisciListino.addActionListener(this);
		
		
		GridBagConstraints gbc_btnInserisciListino = new GridBagConstraints();
		gbc_btnInserisciListino.anchor = GridBagConstraints.NORTH;
		gbc_btnInserisciListino.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInserisciListino.insets = new Insets(0, 0, 5, 0);
		gbc_btnInserisciListino.gridwidth = 3;
		gbc_btnInserisciListino.gridx = 0;
		gbc_btnInserisciListino.gridy = 0;
		contentPane.add(btnInserisciListino, gbc_btnInserisciListino);
		GridBagConstraints gbc_btnInserisciOmbrellone = new GridBagConstraints();
		gbc_btnInserisciOmbrellone.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnInserisciOmbrellone.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciOmbrellone.gridx = 0;
		gbc_btnInserisciOmbrellone.gridy = 1;
		contentPane.add(btnInserisciOmbrellone, gbc_btnInserisciOmbrellone);
		
		btnInserisciUtente = new JButton("INSERISCI UTENTE");
		btnInserisciUtente.addActionListener(this);
		
		btnInserisciSpiaggia = new JButton("INSERISCI SPIAGGIA");
		btnInserisciSpiaggia.addActionListener(this);
		GridBagConstraints gbc_btnInserisciSpiaggia = new GridBagConstraints();
		gbc_btnInserisciSpiaggia.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnInserisciSpiaggia.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciSpiaggia.gridx = 1;
		gbc_btnInserisciSpiaggia.gridy = 1;
		contentPane.add(btnInserisciSpiaggia, gbc_btnInserisciSpiaggia);
		
		btnInserisciPrenotazione = new JButton("INSERISCI PRENOTAZIONE");
		btnInserisciPrenotazione.addActionListener(this);
		GridBagConstraints gbc_btnInserisciPrenotazione = new GridBagConstraints();
		gbc_btnInserisciPrenotazione.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnInserisciPrenotazione.insets = new Insets(0, 0, 5, 0);
		gbc_btnInserisciPrenotazione.gridx = 2;
		gbc_btnInserisciPrenotazione.gridy = 1;
		contentPane.add(btnInserisciPrenotazione, gbc_btnInserisciPrenotazione);
		GridBagConstraints gbc_btnInserisciUtente = new GridBagConstraints();
		gbc_btnInserisciUtente.insets = new Insets(0, 0, 5, 0);
		gbc_btnInserisciUtente.anchor = GridBagConstraints.NORTH;
		gbc_btnInserisciUtente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInserisciUtente.gridwidth = 3;
		gbc_btnInserisciUtente.gridx = 0;
		gbc_btnInserisciUtente.gridy = 2;
		contentPane.add(btnInserisciUtente, gbc_btnInserisciUtente);
		
		esci_btn = new JButton("ESCI");
		esci_btn.addActionListener(this);
		GridBagConstraints gbc_esci_btn = new GridBagConstraints();
		gbc_esci_btn.insets = new Insets(0, 0, 0, 5);
		gbc_esci_btn.gridx = 0;
		gbc_esci_btn.gridy = 3;
		contentPane.add(esci_btn, gbc_esci_btn);
		
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInserisciListino){
			UIListino uil = new UIListino(this.connection,this.statement);
			this.setVisible(false);
			uil.setVisible(true);
		}
		else if (e.getSource() == btnInserisciOmbrellone){
			UIOmbrellone uio = new UIOmbrellone(this.connection, this.statement);
			uio.setVisible(true);
			this.setVisible(false);
		}
		else if (e.getSource() == esci_btn){
			try {
		        if (connection != null)
		            connection.close();
		        this.setVisible(false);
		        this.dispose();
		    } catch (SQLException er) {
		        // gestione errore in chiusura
		    }
		}
//		if (e.getSource() == btnInserisciPrenotazione){
//			UIPrenotazione uip = new UIPrenotazione(this.connection, this.statement);
//			uip.setVisible(true);
//		}
//		if (e.getSource() == btnInserisciUtente){
//			UIUtente uiu = new UIUtente(this.connection, this.statement);
//			uiu.setVisible(true);
//		}
//		if (e.getSource() == btnInserisciSpiaggia){
//			UISpiaggia uis = new UISpiaggia(this.connection, this.statement);
//			uis.setVisible(true);
//		}
		
	}
	
	
	
	
}
