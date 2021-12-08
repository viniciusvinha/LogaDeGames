package br.org.generation.minhalojadegames.controller;

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

import br.org.generation.minhalojadegames.model.Categoria;
import br.org.generation.minhalojadegames.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll () {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Categoria> getById (@PathVariable long id) {
		
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Para postar um novo dado
	@PostMapping
	
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	//Para atualizar um dado
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	//Para deletar um dado
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(null);
	}
}
