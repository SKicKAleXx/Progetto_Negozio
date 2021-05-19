package org.generation.italy.NegozioMarioRossi.controller;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.dao.IDaoProdotti;
import org.generation.italy.NegozioMarioRossi.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prodotti")
public class ControllerProdotti {
	
	@Autowired
	private IDaoProdotti dao;
	
	@GetMapping
	public List<Prodotto> get() {
		return dao.prodotti();
	}
	
	@GetMapping("/{prezzo}")
	public List<Prodotto> getSottoPrezzo(@PathVariable double prezzo) {
		return dao.prodotti(prezzo);
	}
	
	@GetMapping("/{prezzo1}/{prezzo2}")
	public List<Prodotto> getBetweenPrezzo(@PathVariable double prezzo1,  @PathVariable double prezzo2) {
		return dao.prodottiBetween(prezzo1, prezzo2);
	}
	
	@GetMapping("/{id}")
	public Prodotto get(@PathVariable int id) {
		return dao.prodotto(id);
	}
	
	@PostMapping
	public void add(@RequestBody Prodotto p) {
		dao.add(p);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody Prodotto p) {
		dao.update(p);
	}

}
