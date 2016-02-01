package model;

import java.time.LocalDate;

public class Listino {
	private int ID;
	private String descrizione;
	private int durata;
	private LocalDate dal;
	private LocalDate al;
	private int prezzo;
	private int idSpiaggia;

	public Listino(int ID, String descrizione, int durata, LocalDate dal, LocalDate al,
			int prezzo, int idSpiaggia) {
		super();
		this.setID(ID);
		this.setDescrizione(descrizione);
		this.setDurata(durata);
		this.setDal(dal);
		this.setAl(al);
		this.setPrezzo(prezzo);
		this.setIdSpiaggia(idSpiaggia);
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getDurata() {
		return durata;
	}
	
	public void setDurata(int durata) {
		this.durata = durata;
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
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	public int getIdSpiaggia() {
		return idSpiaggia;
	}
	
	public void setIdSpiaggia(int idSpiaggia) {
		this.idSpiaggia = idSpiaggia;
	}

	@Override
	public String toString(){
		return " Il listino numero " + this.getID() + " " + 
				this.getDescrizione() + " che ha durata " + this.getDurata() + " giorni dal "
				+ this.getDal().toString() + " al " + this.getAl().toString() + " con un prezzo di "
				+ this.getPrezzo() + "€ sulla spiaggia numero" + this.getIdSpiaggia();
	}
}
