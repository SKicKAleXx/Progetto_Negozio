package org.generation.italy.NegozioMarioRossi.dao;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.model.Ordine;

public interface IDaoOrdini {
	
	List<Ordine> ordini();
	
	Ordine ordine(int id);
	
	List<Ordine> ordiniUtente(int utenteId);
	
	void add (Ordine o);
	
	void delete (int id);
	
	void edit(Ordine o);

}
