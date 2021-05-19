package org.generation.italy.NegozioMarioRossi.dao;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.model.Prodotto;

public interface IDaoProdotti {
	
	List<Prodotto> prodotti();
	
	List<Prodotto> prodotti(double prezzo);
	
	List<Prodotto> prodottiBetween(double prezzo1, double prezzo2);
	
	Prodotto prodotto (int id);
	
	void add(Prodotto p);
	
	void delete(int id);
	
	void update(Prodotto p);
	
}
