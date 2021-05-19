package org.generation.italy.NegozioMarioRossi.model;

import org.generation.italy.NegozioMarioRossi.util.IMappablePro;

public class Recensione implements IMappablePro {
	private int id;
	private String commento;
	private int valutazione;
	private int prodottoId;
	private int utenteId;
	
	public Recensione(int id, String commento, int valutazione, int prodottoId, int utenteId) {
		super();
		this.id = id;
		this.commento = commento;
		this.valutazione = valutazione;
		this.prodottoId = prodottoId;
		this.utenteId = utenteId;
	}

	public Recensione() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public int getProdottoId() {
		return prodottoId;
	}

	public void setProdottoId(int prodottoId) {
		this.prodottoId = prodottoId;
	}


	public int getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(int utenteId) {
		this.utenteId = utenteId;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", commento:" + commento + ", valutazione:" + valutazione + ", prodottoId:" + prodottoId
				+ ", utenteId:" + utenteId + "}";
	}

}
