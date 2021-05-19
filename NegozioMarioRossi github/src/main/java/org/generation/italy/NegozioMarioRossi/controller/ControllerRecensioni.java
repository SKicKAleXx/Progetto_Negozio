package org.generation.italy.NegozioMarioRossi.controller;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.dao.IDaoRecensioni;
import org.generation.italy.NegozioMarioRossi.model.Recensione;
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
@RequestMapping("/recensioni")
public class ControllerRecensioni {
	
	@Autowired
	private IDaoRecensioni dao;
	
	@GetMapping
	public List<Recensione> get() {
		return dao.recensioni();
	}
	
	@GetMapping("/{idprodotto}")
	public List<Recensione> getidProdotto(@PathVariable int prodottoId) {
		return dao.recensioni(prodottoId);
	}
	
	@PostMapping
	public void add(@RequestBody Recensione r) {
		dao.add(r);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody Recensione r) {
		dao.update(r);
	}

}
