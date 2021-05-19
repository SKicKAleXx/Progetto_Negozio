package org.generation.italy.NegozioMarioRossi.controller;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.dao.IDaoOrdini;
import org.generation.italy.NegozioMarioRossi.model.Ordine;
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
@RequestMapping("/ordini")
public class ControllerOrdini {
	
	@Autowired
	private IDaoOrdini dao;
	
	@GetMapping
	public List<Ordine> get() {
		return dao.ordini();
	}
	
	@GetMapping("/{id}")
	public Ordine get(@PathVariable int id) {
		return dao.ordine(id);
	}
	 // DEVO ESSERE SICURO CHE LA CHIAMATA RIESCA A PRENDERE L'ID DELL'UTENTE
	@GetMapping("/{idutente}")
	public List<Ordine> getidUtente(@PathVariable int utenteId) {
		return dao.ordiniUtente(utenteId);
	}
	
	@PostMapping
	public void add(@RequestBody Ordine o) {
		dao.add(o);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody Ordine o) {
		dao.edit(o);
	}

}
