package org.generation.italy.NegozioMarioRossi.dao;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.model.Utente;

public interface IDaoUtenti {
	
	List<Utente> utenti();
	
	Utente utente(int id);
	
	void add(Utente u);
	
	void delete(int id);
	
	void edit(Utente u);
}
