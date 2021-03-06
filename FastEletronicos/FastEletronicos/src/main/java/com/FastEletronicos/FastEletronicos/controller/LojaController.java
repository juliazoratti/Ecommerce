package com.FastEletronicos.FastEletronicos.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.FastEletronicos.FastEletronicos.model.Loja;
import com.FastEletronicos.FastEletronicos.repository.LojaRepository;

@RestController
@RequestMapping ("/loja")
@CrossOrigin ("*")
public class LojaController {
	
	@Autowired
	public LojaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Loja>> getAll (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{idLoja}")
	public ResponseEntity<Loja> getById (@PathVariable long idLoja){
		return repository.findById(idLoja)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	/*@GetMapping ("/nomeLoja/{nomeLoja}")
	public ResponseEntity<List<Loja>> getByTitulo (@PathVariable String nomeLoja){
		return ResponseEntity.ok(repository.findAllByNomeLojaContainingIgoneCase(nomeLoja));
	}*/
	
	@PostMapping
	public ResponseEntity<Loja> post (@RequestBody Loja loja){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(loja));
	}
	
	@PutMapping
	public ResponseEntity<Loja> put (@RequestBody Loja loja){
		return ResponseEntity.ok(repository.save(loja));
	}
	
	@DeleteMapping
	public void delete (@PathVariable long idLoja) {
		repository.deleteById(idLoja);
	}

}
