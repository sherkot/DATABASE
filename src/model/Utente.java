package model;

import java.time.LocalDate;

public class Utente {
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private LocalDate dataCreazione;
	
	
	
	
	public Utente(String username, String password, String nome,
			String cognome, LocalDate dataCreazione) {
		super();
		this.setUsername(username);
		this.setPassword(password);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setDataCreazione(dataCreazione);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public LocalDate getDataCreazione() {
		return dataCreazione;
	}
	
	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
	@Override
	public String toString(){
		return "L'utente " + this.getNome() + " " + this.getCognome() +
				" si e' registrato in data " + LocalDate.now() + 
				" col seguente username = " + this.getUsername();
	}
}
