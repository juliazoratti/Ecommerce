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

import com.FastEletronicos.FastEletronicos.model.Produto;
import com.FastEletronicos.FastEletronicos.repository.ProdutoRepository;

@RestController
@RequestMapping ("/produto")
@CrossOrigin ("*")
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{idProduto}")
	public ResponseEntity<Produto> getById (@PathVariable long idProduto){
		return repository.findById(idProduto)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/tituloProduto/{tituloProduto}")
	public ResponseEntity<List<Produto>> getByTitulo (@PathVariable String tituloProduto){
		return ResponseEntity.ok(repository.findAllByTituloProdutoContainingIgnoreCase(tituloProduto));
	}
	
	@GetMapping ("/valorMenor/{valor}")
	public ResponseEntity<List<Produto>> getByValorMenor (@PathVariable double valor){
		return ResponseEntity.ok(repository.findAllByValorLessThanEqual(valor));
	}
	
	@GetMapping ("/valorMaior/{valor}")
	public ResponseEntity<List<Produto>> getByValorMaior (@PathVariable double valor){
		return ResponseEntity.ok(repository.findAllByValorGreaterThanEqual(valor));
	}
	
	@GetMapping ("/valor/{valor}")
	public ResponseEntity<List<Produto>> getByValor (@PathVariable double valor){
		return ResponseEntity.ok(repository.findAllByValor(valor));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto){
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@DeleteMapping
	public void delete (@PathVariable long idProduto) {
		repository.deleteById(idProduto);
	}

}
