package org.generation.italy.NegozioMarioRossi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.generation.italy.NegozioMarioRossi.model.Utente;
import org.generation.italy.NegozioMarioRossi.util.BasicDao;
import org.generation.italy.NegozioMarioRossi.util.IMappablePro;
import org.springframework.beans.factory.annotation.Value;

public class DaoUtenti extends BasicDao implements IDaoUtenti {

	public DaoUtenti(			
			@Value("${db.address}") String dbAddress, 
			@Value("${db.user}") String user, 
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Utente> utenti() {
		List<Utente> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM utenti");
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Utente.class, map));
		}
		return ris;
	}

	@Override
	public Utente utente(int id) {
		return IMappablePro.fromMap(Utente.class, getOne("SELECT * FROM utente WHERE id = ?", id));
	}

	@Override
	public void add(Utente u) {
		execute("INSERT INTO utenti (nome, cognome, cellulare, indirizzo) VALUES (?, ?, ?, ?)", u.getNome(), u.getCognome(), u.getCell(), u.getIndirizzo());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM utenti WHERE id = ?", id);
	}

	@Override
	public void edit(Utente u) {
		execute("UPDATE utente SET nome = ?, cognome = ?, cellulare = ?, indirizzo = ? WHERE id = ?", u.getNome(), u.getCognome(), u.getCell(), u.getIndirizzo());
	}

}
