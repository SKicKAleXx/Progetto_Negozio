package org.generation.italy.NegozioMarioRossi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.generation.italy.NegozioMarioRossi.model.Prodotto;
import org.generation.italy.NegozioMarioRossi.util.BasicDao;
import org.generation.italy.NegozioMarioRossi.util.IMappablePro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoProdotti extends BasicDao implements IDaoProdotti {

	public DaoProdotti(			
			@Value("${db.address}") String dbAddress, 
			@Value("${db.user}") String user, 
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Prodotto> prodotti() {
		List<Prodotto> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM prodotti");
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Prodotto.class, map));
		}
		return ris;
	}

	@Override
	public List<Prodotto> prodotti(double prezzo) {
		List<Prodotto> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM prodotti WHERE prezzo < ?", prezzo);
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Prodotto.class, map));
		}
		return ris;
	}

	@Override
	public List<Prodotto> prodottiBetween(double prezzo1, double prezzo2) {
		List<Prodotto> ris = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM prodotti WHERE prezzo > ?", prezzo1 + "AND prezzo < ?", prezzo2);
		
		for (Map<String, String> map : maps) {
			ris.add(IMappablePro.fromMap(Prodotto.class, map));
		}
		return ris;
	}

	@Override
	public Prodotto prodotto(int id) {
		return IMappablePro.fromMap(Prodotto.class, getOne("SELECT * FROM prodotto WHERE id = ?", id));
	}

	@Override
	public void add(Prodotto p) {
		execute("INSERT INTO prodotti (nome, categoria, prezzo) VALUES (?, ?, ?)", p.getNome(), p.getCategoria(), p.getPrezzo());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM stock WHERE idprodotto = ?", id);
		execute("DELETE FROM prodotti WHERE id = ?", id);
	}

	@Override
	public void update(Prodotto p) {
		execute("UPDATE prodotti SET nome = ?, categoria = ?, prezzo = ? WHERE id = ?", p.getNome(), p.getCategoria(), p.getPrezzo(), p.getId());
	}

}
