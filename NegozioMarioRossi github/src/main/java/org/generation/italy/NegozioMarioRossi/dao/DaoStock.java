package org.generation.italy.NegozioMarioRossi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.generation.italy.NegozioMarioRossi.model.Prodotto;
import org.generation.italy.NegozioMarioRossi.model.Stock;
import org.generation.italy.NegozioMarioRossi.util.BasicDao;
import org.generation.italy.NegozioMarioRossi.util.IMappablePro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoStock extends BasicDao implements IDaoStock {

	public DaoStock(
			@Value("${db.address}") String dbAddress, 
			@Value("${db.user}") String user, 
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Stock> prodotti() {
		List<Stock> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM stock");
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Stock.class, map));
		}
		return ris;
	}

	@Override
	public Stock prodotto(int id) {
		return IMappablePro.fromMap(Stock.class, getOne("SELECT * FROM stock WHERE id = ?", id));
	}

	@Override
	public void update(Stock p) {
		execute("UPDATE stock SET colore = ?, taglia = ?, idprodotto = ?, npezzi = ? WHERE id = ?", p.getColore(), p.getTaglia(), p.getProdottoId(), p.getnPezzi(), p.getId());
	}

	@Override
	public void add(Stock p) {
		execute("INSERT INTO stock (colore, taglia, idprodotto, npezzi) VALUES (?, ?, ?, ?)", p.getColore(), p.getTaglia(), p.getProdottoId(), p.getnPezzi());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM stock WHERE id = ?", id);
	}

}
