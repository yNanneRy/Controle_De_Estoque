package br.com.biopark.dtos;

import java.util.List;
import java.util.Objects;

public class CategoriaQntdDTO {

	private String nome;
	private int qntdTotal;
	private List<ItemDTO> itens;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQntdTotal() {
		return qntdTotal;
	}
	public void setQntdTotal(int qntdTotal) {
		this.qntdTotal = qntdTotal;
	}
	public List<ItemDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itens, nome, qntdTotal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaQntdDTO other = (CategoriaQntdDTO) obj;
		return Objects.equals(itens, other.itens) && Objects.equals(nome, other.nome) && qntdTotal == other.qntdTotal;
	}
	public CategoriaQntdDTO(String nome, int qntdTotal, List<ItemDTO> itens) {
		super();
		this.nome = nome;
		this.qntdTotal = qntdTotal;
		this.itens = itens;
	}
}
