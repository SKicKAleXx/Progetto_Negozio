package org.generation.italy.NegozioMarioRossi.dao;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.model.Stock;

public interface IDaoStock {
	
	List<Stock>prodotti();
	
	Stock prodotto(int id);
	
	void update(Stock p);
	
	void add(Stock p);
	
	void delete(int id);
	
}
