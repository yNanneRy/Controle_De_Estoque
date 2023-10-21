package br.com.biopark.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.models.Item;
import br.com.biopark.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository repository;
	
	public List<Item> findAll(){
		return repository.findAll();
	}
	
	public Item findById(Long id) {
		return repository.findById(id).get();
	}
	
	public void save(Item item) {
		repository.save(item);
	}
	
	public void update(Item item) {
		repository.save(item);
	}
	
	public void delete(Long id) {
		Item item = repository.findById(id).get();
		repository.delete(item);
	}
}
