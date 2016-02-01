package model;

public class Spiaggia {
	private int ID;
	private String nome;
	private String via;
	private String citta;
	private String informazioni;
	
	
	public Spiaggia(int ID, String nome, String via, String citta,
			String informazioni) {
		super();
		this.setID(ID);
		this.setNome(nome);
		this.setVia(via);
		this.setCitta(citta);
		this.setInformazioni(informazioni);
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	public String getInformazioni() {
		return informazioni;
	}


	public void setInformazioni(String informazioni) {
		this.informazioni = informazioni;
	}
	
	@Override
	public String toString(){
		return "Spiaggia " + this.getNome() +
				" (ID = " + this.getID() + ") sita in " +
				this.getVia() + " di " + this.getCitta() +
				" con le seguenti infomazioni: " + this.getInformazioni();
				
	}
}
