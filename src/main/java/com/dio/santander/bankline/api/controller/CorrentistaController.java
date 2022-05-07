package com.dio.santander.bankline.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;

@RestController
@RequestMapping ("/correntistas")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save (@RequestBody NovoCorrentista novoCorrentista) {
		service.save(novoCorrentista);
	}
	
	//Atualiza alguma postagem por meio do ID
	@PutMapping
	public ResponseEntity<Correntista> putPostagem (@Valid @RequestBody Correntista correntista){
		return repository.findById(correntista.getId())
				.map(resposta -> ResponseEntity.ok().body(repository.save(correntista)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Deleta uma postagem por meio do ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCorrentista(@PathVariable int id){
		
		return repository.findById(id).map(resposta -> {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		})
				.orElse(ResponseEntity.notFound().build());
	}

}
