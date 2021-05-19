package org.generation.italy.NegozioMarioRossi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.generation.italy.NegozioMarioRossi.model.Ordine;
import org.generation.italy.NegozioMarioRossi.util.BasicDao;
import org.generation.italy.NegozioMarioRossi.util.IMappablePro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoOrdini extends BasicDao implements IDaoOrdini {
	
	public DaoOrdini(
			@Value("${db.address}") String dbAddress, 
			@Value("${db.user}") String user, 
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Ordine> ordini() {
		List<Ordine> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM ordini");
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Ordine.class, map));
		}
		return ris;
	}

	@Override
	public Ordine ordine(int id) {
		return IMappablePro.fromMap(Ordine.class, getOne("SELECT * FROM ordini WHERE id = ?", id));
	}

	@Override
	public List<Ordine> ordiniUtente(int utenteId) {
		List<Ordine> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM ordini WHERE idutente = ?", utenteId);
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Ordine.class, map));
		}
		return ris;
	}

	@Override
	public void add(Ordine o) {
		execute("INSERT INTO ordini (idutente, prezzo) VALUES (?, ?)", o.getUtenteId(), o.getPrezzo());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM ordini WHERE id = ?", id);
	}

	@Override
	public void edit(Ordine o) {
		execute("UPDATE ordini SET idutente = ?, prezzo = ?, WHERE id = ?", o.getUtenteId(), o.getPrezzo(), o.getId());
	}

}
