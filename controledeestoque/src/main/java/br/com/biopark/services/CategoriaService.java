package br.com.biopark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.exceptions.MinhaException;
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
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		return repository.findById(id).orElseThrow(() -> new MinhaException("Categoria não encontrada!"));
	}
	
	public void save(Categoria categoria) {
		if (categoria.getId() != null) throw new MinhaException("Id não deve ser preenchido!");
		if (categoria.getNome() == null) throw new MinhaException("Nome deve ser preenchido!");
		repository.save(categoria);
	}
	
	public void update(Categoria categoria) {
		if (categoria.getId() == null) throw new MinhaException("Id deve ser preenchido!");
		if (categoria.getNome() == null) throw new MinhaException("Nome deve ser preenchido!");
		repository.save(categoria);
	}
	
	public void delete(Long id) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		Categoria categoria = repository.findById(id).orElseThrow(() -> new MinhaException("Categoria não encontrada!"));
		repository.delete(categoria);
	}
}
