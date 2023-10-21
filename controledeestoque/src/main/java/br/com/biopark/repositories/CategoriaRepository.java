package br.com.biopark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biopark.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
