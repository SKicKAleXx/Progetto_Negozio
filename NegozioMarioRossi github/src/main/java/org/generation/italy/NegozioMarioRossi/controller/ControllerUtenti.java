package org.generation.italy.NegozioMarioRossi.controller;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.dao.IDaoUtenti;
import org.generation.italy.NegozioMarioRossi.model.Utente;
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
@RequestMapping("/utenti")
public class ControllerUtenti {
	
	@Autowired
	private IDaoUtenti dao;
	
	@GetMapping
	public List<Utente> get() {
		return dao.utenti();
	}
	
	@GetMapping("/{id}")
	public Utente get(@PathVariable int id) {
		return dao.utente(id);
	}
	
	@PostMapping
	public void add(@RequestBody Utente u) {
		dao.add(u);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody Utente u) {
		dao.edit(u);
	}

}
