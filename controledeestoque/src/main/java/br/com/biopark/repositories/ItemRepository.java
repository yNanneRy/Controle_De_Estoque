package br.com.biopark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biopark.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{}
