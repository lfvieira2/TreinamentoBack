package com.stefanini.treinamento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.treinamento.exceptions.CarroException;
import com.stefanini.treinamento.model.Carro;
import com.stefanini.treinamento.service.CarroService;

@CrossOrigin
@RestController
@RequestMapping(value="/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public List<Carro> findAll(){
		return carroService.findAll();
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Carro>> searchByName(@PathVariable String nome){
		List<Carro> carrosEncontrados = carroService.searchByName(nome);
		if(carrosEncontrados == null) {
			return ResponseEntity.ok(null);
			}
		return ResponseEntity.ok(carrosEncontrados);
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Carro carro){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(carroService.create(carro));
		} catch (CarroException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id_carro}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_carro) {
		carroService.delete(id_carro);
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@Valid @RequestBody Carro carro){
		
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(carroService.update(carro));
		
	}
}
