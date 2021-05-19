package org.generation.italy.NegozioMarioRossi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.generation.italy.NegozioMarioRossi.model.Ordine;
import org.generation.italy.NegozioMarioRossi.model.Recensione;
import org.generation.italy.NegozioMarioRossi.util.BasicDao;
import org.generation.italy.NegozioMarioRossi.util.IMappablePro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoRecensioni extends BasicDao implements IDaoRecensioni {

	public DaoRecensioni(			
			@Value("${db.address}") String dbAddress, 
			@Value("${db.user}") String user, 
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Recensione> recensioni() {
		List<Recensione> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM recensioni");
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Recensione.class, map));
		}
		return ris;
	}

	@Override
	public List<Recensione> recensioni(int prodottoId) {
		List<Recensione> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM recensioni WHERE idprodotto = ?", prodottoId);
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Recensione.class, map));
		}
		return ris;
		
	}

	@Override
	public void add(Recensione r) {
		execute("INSERT INTO recensione (idprodotto, idutente, commento, valutazione) VALUES (?, ?, ?, ?)", r.getProdottoId(), r.getUtenteId(), r.getCommento(), r.getValutazione());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM recensione WHERE id = ?", id);
		
	}

	@Override
	public void update(Recensione r) {
		execute("UPDATE recensione SET idprodotto = ?, idutente = ?, commento = ?, valutazione = ? WHERE id = ?", r.getProdottoId(), r.getUtenteId(), r.getCommento(), r.getValutazione(), r.getId());
	}

}
