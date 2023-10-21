package br.com.biopark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.models.Categoria;
import br.com.biopark.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void save(Categoria categoria) {
		repository.save(categoria);
	}
	
	public void update(Categoria categoria) {
		repository.save(categoria);
	}
	
	public void delete(Long id) {
		Categoria categoria = repository.findById(id).get();
		repository.delete(categoria);
	}
}
