package org.generation.italy.NegozioMarioRossi.controller;

import java.util.List;

import org.generation.italy.NegozioMarioRossi.dao.IDaoStock;
import org.generation.italy.NegozioMarioRossi.model.Stock;
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
@RequestMapping("/stock")
public class ControllerStock {
	
	@Autowired
	private IDaoStock dao;
	
	@GetMapping
	public List<Stock> get() {
		return dao.prodotti();
	}
	
	@GetMapping("/{id}")
	public Stock get(@PathVariable int id) {
		return dao.prodotto(id);
	}
	
	@PostMapping
	public void add(@RequestBody Stock p) {
		dao.add(p);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody Stock p) {
		dao.update(p);
	}

}
