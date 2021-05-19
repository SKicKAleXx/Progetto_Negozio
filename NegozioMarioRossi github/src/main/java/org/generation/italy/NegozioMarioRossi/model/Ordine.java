package org.generation.italy.NegozioMarioRossi.model;

import org.generation.italy.NegozioMarioRossi.util.IMappablePro;

public class Ordine implements IMappablePro {
	private int id;
	private double prezzo;
	private int utenteId;
	
	public Ordine(int id, double prezzo, int utenteId) {
		super();
		this.id = id;
		this.prezzo = prezzo;
		this.utenteId = utenteId;
	}

	public Ordine() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getUtenteId() {
		return utenteId;
	}

	public void setUtenteid(int utenteId) {
		this.utenteId = utenteId;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", prezzo:" + prezzo + ", idUtente:" + utenteId + "}";
	}
}
