package br.com.biopark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biopark.data.vo.v1.ItemVO;
import br.com.biopark.services.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {

	@Autowired
	ItemService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody ItemVO item){
		service.save(item);
		return ResponseEntity.ok("Item " + item.getNome() + " salvo com sucesso!");
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody ItemVO item){
		service.update(item);
		return ResponseEntity.ok("Item " + item.getNome() + " salvo com sucesso!");
	}
	
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.ok("Item deletado com sucesso!");
	}
	
	@PatchMapping(value = "/sum/{id}/{qntd}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> somarQuantidade(@PathVariable(value = "id") Long id, @PathVariable(value = "qntd") int qntd){
		int qntdNova = service.somarQuantidade(id, qntd);
		return ResponseEntity.ok("Quantidade do item alterada! Nova quantidade: " + qntdNova);
	}
	
	@PatchMapping(value = "/dim/{id}/{qntd}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> dimQuantidade(@PathVariable(value = "id") Long id, @PathVariable(value = "qntd") int qntd){
		int qntdNova = service.diminuirQuantidade(id, qntd);
		return ResponseEntity.ok("Quantidade do item alterada! Nova quantidade: " + qntdNova);
	}
	
	@GetMapping(value = "/categoria/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemVO> findAllByCategoriaId(@PathVariable(value = "id") Long id){
		return service.findAllByCategoriaId(id);
	}
}
