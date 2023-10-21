package br.com.biopark.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biopark.data.vo.v1.CategoriaVO;
import br.com.biopark.dtos.CategoriaQntdDTO;
import br.com.biopark.dtos.ItemDTO;
import br.com.biopark.exceptions.MinhaException;
import br.com.biopark.mapper.Mapper;
import br.com.biopark.models.Categoria;
import br.com.biopark.models.Item;
import br.com.biopark.repositories.CategoriaRepository;
import br.com.biopark.repositories.ItemRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	@Autowired
	ItemRepository itemRepository;
	
	public List<CategoriaVO> findAll(){
		return Mapper.parseListObjects(repository.findAll(), CategoriaVO.class);
	}
	
	public CategoriaVO findById(Long id) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		return Mapper.parseObject(repository.findById(id).orElseThrow(() -> new MinhaException("Categoria não encontrada!")), CategoriaVO.class);
	}
	
	public void save(CategoriaVO categoria) {
		if (categoria.getId() != null) throw new MinhaException("Id não deve ser preenchido!");
		if (categoria.getNome() == null) throw new MinhaException("Nome deve ser preenchido!");
		repository.save(Mapper.parseObject(categoria, Categoria.class));
	}
	
	public void update(CategoriaVO categoria) {
		if (categoria.getId() == null) throw new MinhaException("Id deve ser preenchido!");
		if (categoria.getNome() == null) throw new MinhaException("Nome deve ser preenchido!");
		repository.save(Mapper.parseObject(categoria, Categoria.class));
	}
	
	public void delete(Long id) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		Categoria categoria = repository.findById(id).orElseThrow(() -> new MinhaException("Categoria não encontrada!"));
		repository.delete(categoria);
	}
	
	public CategoriaQntdDTO findQntdByCategoriaId(Long id) {
		if (id == null) throw new MinhaException("Id deve ser preenchido!");
		Categoria categoria = repository.findById(id).orElseThrow(() -> new MinhaException("Categoria não existe!"));
		List<Item> itens = itemRepository.findAllByCategoriaId(id);
		CategoriaQntdDTO dto = new CategoriaQntdDTO(categoria.getNome(), 0, new ArrayList<ItemDTO>());
		itens.forEach((item) -> {
			dto.setQntdTotal(dto.getQntdTotal() + item.getQntd());
			ItemDTO itemDTO = new ItemDTO(item.getNome(), item.getQntd());
			dto.getItens().add(itemDTO);
		});
		return dto;
	}
}
