package org.generation.italy.NegozioMarioRossi.model;

import org.generation.italy.NegozioMarioRossi.util.IMappablePro;

public class Stock implements IMappablePro {
	private int id;
	private String colore;
	private String taglia;
	private int nPezzi;
	private int prodottoId;
	
	public Stock(int id, String colore, String taglia, int nPezzi, int prodottoId) {
		super();
		this.id = id;
		this.colore = colore;
		this.taglia = taglia;
		this.nPezzi = nPezzi;
		this.prodottoId = prodottoId;
	}

	public Stock() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	public int getnPezzi() {
		return nPezzi;
	}

	public void setnPezzi(int nPezzi) {
		this.nPezzi = nPezzi;
	}

	public int getProdottoId() {
		return prodottoId;
	}

	public void setProdottoId(int prodottoId) {
		this.prodottoId = prodottoId;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", colore:" + colore + ", taglia:" + taglia + ", nPezzi:" + nPezzi + ", prodottoId:"
				+ prodottoId + "}";
	}
}
