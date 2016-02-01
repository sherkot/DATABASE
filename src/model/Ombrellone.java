package model;

public class Ombrellone {
	private int numero;
	private String posizione;
	private int idSpiaggia;
	
	
	public Ombrellone(int numero, String posizione, int idSpiaggia) {
		super();
		this.setNumero(numero);
		this.setPosizione(posizione);;
		this.setIdSpiaggia(idSpiaggia);;
	}
	
	
	public int getNumero() {
		return numero;
	}
	
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public String getPosizione() {
		return posizione;
	}
	
	
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
	
	public int getIdSpiaggia() {
		return idSpiaggia;
	}
	
	
	public void setIdSpiaggia(int idSpiaggia) {
		this.idSpiaggia = idSpiaggia;
	}
	
	@Override
	public String toString(){
		return "Ombrellone numero " + this.getNumero() + " situato in " + this.getPosizione() + " della spiaggia " + this.getIdSpiaggia();
	}
	
	
}
