package br.com.biopark.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.biopark.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM item AS i WHERE i.categoria_id = :id")
	public List<Item> findAllByCategoriaId(Long id);
}
