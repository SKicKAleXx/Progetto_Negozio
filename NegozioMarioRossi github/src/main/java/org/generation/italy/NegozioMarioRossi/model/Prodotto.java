package org.generation.italy.NegozioMarioRossi.model;

import org.generation.italy.NegozioMarioRossi.util.IMappablePro;

public class Prodotto implements IMappablePro {
	private int id;
	private String nome;
	private String categoria;
	private double prezzo;
	
	public Prodotto(int id, String nome, String categoria, double prezzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.prezzo = prezzo;
	}
	
	public Prodotto() {
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nome:" + nome + ", categoria:" + categoria + ", prezzo:" + prezzo + "}";
	}
}
