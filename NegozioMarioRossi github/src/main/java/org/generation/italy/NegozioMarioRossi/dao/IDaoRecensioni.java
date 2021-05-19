package org.generation.italy.NegozioMarioRossi.dao;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.model.Recensione;

public interface IDaoRecensioni {
	
	List<Recensione> recensioni();
	
	List<Recensione> recensioni(int prodottoId);
	
	void add(Recensione r);
	
	void delete(int id);
	
	void update(Recensione r);

}
