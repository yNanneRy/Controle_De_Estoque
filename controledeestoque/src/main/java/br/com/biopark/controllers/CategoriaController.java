package br.com.biopark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biopark.data.vo.v1.CategoriaVO;
import br.com.biopark.dtos.CategoriaQntdDTO;
import br.com.biopark.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoriaVO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoriaVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody CategoriaVO categoria) {
		service.save(categoria);
		return ResponseEntity.ok("Categoria " + categoria.getNome() + " salva com sucesso!");
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody CategoriaVO categoria){
		service.update(categoria);
		return ResponseEntity.ok("Categoria " + categoria.getNome() + " salva com sucesso!");
	}
	
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.ok("Categoria deletada com sucesso!");
	}
	
	@GetMapping(value = "/qntdTotal/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoriaQntdDTO findQntdByCategoriaId(@PathVariable(value = "id") Long id) {
		return service.findQntdByCategoriaId(id);
	}
}
