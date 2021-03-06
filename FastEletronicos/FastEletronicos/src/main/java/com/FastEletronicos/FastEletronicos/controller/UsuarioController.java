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

import com.FastEletronicos.FastEletronicos.model.Usuario;
import com.FastEletronicos.FastEletronicos.repository.UsuarioRepository;

@RestController
@RequestMapping ("/usuario")
@CrossOrigin ("*")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{idUsuario}")
	public ResponseEntity<Usuario> getById (@PathVariable long idUsuario){
		return repository.findById(idUsuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByTitulo (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	@DeleteMapping
	public void delete (@PathVariable long idUsuario) {
		repository.deleteById(idUsuario);
	}

}