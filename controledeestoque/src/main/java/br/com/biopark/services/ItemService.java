package br.com.biopark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.exceptions.MinhaException;
import br.com.biopark.models.Item;
import br.com.biopark.repositories.CategoriaRepository;
import br.com.biopark.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository repository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Item> findAll(){
		return repository.findAll();
	}
	
	public Item findById(Long id) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		return repository.findById(id).orElseThrow(() -> new MinhaException("Item não encontrado!"));
	}
	
	public void save(Item item) {
		if (item.getId() != null) throw new MinhaException("Id não deve ser preenchido!");
		if (item.getNome() == null) throw new MinhaException("Nome deve ser preenchido!");
		if (item.getQntd() <=0 ) throw new MinhaException("Quantidade deve ser preenchida e não pode ser menor ou igual a 0!");
		if (item.getCategoria() == null) throw new MinhaException("Categoria deve ser relacionada!");
		repository.save(item);
	}
	
	public void update(Item item) {
		if (item.getId() == null) throw new MinhaException("Id deve ser preenchido!");
		if (item.getNome() == null) throw new MinhaException("Nome deve ser preenchido!");
		if (item.getQntd() <=0 ) throw new MinhaException("Quantidade deve ser preenchida e não pode ser menor ou igual a 0!");
		if (item.getCategoria() == null) throw new MinhaException("Categoria deve ser relacionada!");
		repository.save(item);
	}
	
	public void delete(Long id) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		Item item = repository.findById(id).orElseThrow(() -> new MinhaException("Item não encontrado!"));
		repository.delete(item);
	}
	
	public int somarQuantidade(Long id, int qntd) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		if (qntd <= 0) throw new MinhaException("Quantidade deve ser preenchida e não pode ser menor ou igual a 0!");
		Item item = repository.findById(id).orElseThrow(() -> new MinhaException("Item não encontrado!"));
		item.setQntd(item.getQntd() + qntd);
		repository.save(item);
		return item.getQntd();
	}
	
	public int diminuirQuantidade(Long id, int qntd) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		if (qntd <= 0) throw new MinhaException("Quantidade deve ser preenchida e não pode ser menor ou igual a 0!");
		Item item = repository.findById(id).orElseThrow(() -> new MinhaException("Item não encontrado!"));
		if (qntd > item.getQntd()) throw new MinhaException("Quantidade não pode ser retirada por ser maior do que está em estoque!");
		item.setQntd(item.getQntd() - qntd);
		repository.save(item);
		return item.getQntd();
	}
	
	public List<Item> findAllByCategoriaId(Long id){
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		if (categoriaRepository.existsById(id) == false) throw new MinhaException("Categoria não existe!");
		return repository.findAllByCategoriaId(id);
	}
}
