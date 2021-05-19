package org.generation.italy.NegozioMarioRossi.model;

import org.generation.italy.NegozioMarioRossi.util.IMappablePro;

public class Utente implements IMappablePro {
	private int id;
	private String nome;
	private String cognome;
	private String cell;
	private String indirizzo;
	
	public Utente(int id, String nome, String cognome, String cell, String indirizzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cell = cell;
		this.indirizzo = indirizzo;
	}

	public Utente() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nome:" + nome + ", cognome:" + cognome + ", cell:" + cell + ", indirizzo:" + indirizzo
				+ "}";
	}	
}
