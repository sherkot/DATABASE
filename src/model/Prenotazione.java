package model;

import java.time.LocalDate;

public class Prenotazione {
	private int ID;
	private LocalDate dal;
	private LocalDate al;
	private int prezzoReale;
	private int numeroOmbrellone;
	private String usernameUtente;
	private int idListino;
	
	
	public Prenotazione(int ID, LocalDate dal, LocalDate al, int prezzoReale,
			int numeroOmbrellone, String usernameUtente, int idListino) {
		super();
		this.setID(ID);
		this.setDal(dal);
		this.setAl(al);
		this.setPrezzoReale(prezzoReale);;
		this.setNumeroOmbrellone(numeroOmbrellone);;
		this.setUsernameUtente(usernameUtente);;
		this.setIdListino(idListino);;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public LocalDate getDal() {
		return dal;
	}
	
	public void setDal(LocalDate dal) {
		this.dal = dal;
	}
	
	public LocalDate getAl() {
		return al;
	}
	
	public void setAl(LocalDate al) {
		this.al = al;
	}
	
	public int getPrezzoReale() {
		return prezzoReale;
	}
	
	public void setPrezzoReale(int prezzoReale) {
		this.prezzoReale = prezzoReale;
	}
	
	public int getNumeroOmbrellone() {
		return numeroOmbrellone;
	}
	
	public void setNumeroOmbrellone(int numeroOmbrellone) {
		this.numeroOmbrellone = numeroOmbrellone;
	}
	
	public String getUsernameUtente() {
		return usernameUtente;
	}
	
	public void setUsernameUtente(String usernameUtente) {
		this.usernameUtente = usernameUtente;
	}
	
	public int getIdListino() {
		return idListino;
	}
	
	public void setIdListino(int idListino) {
		this.idListino = idListino;
	}
	
	@Override
	public String toString(){
		return "La prenotazione con ID = " + this.getID() +
				" , che ha come numero ombrellone " + this.getNumeroOmbrellone() +
				", ha un prezzo di €" + this.getPrezzoReale() +
				" ed e' stata effettuata da " + this.getUsernameUtente() +
				" dal " + this.getDal() + " al " + this.getAl() +
				". ID listino = " + this.getIdListino();
	}
	

}
