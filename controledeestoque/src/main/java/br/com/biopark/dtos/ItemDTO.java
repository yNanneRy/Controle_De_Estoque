package br.com.biopark.dtos;

import java.util.Objects;

public class ItemDTO {

	private String nome;
	private int qntd;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQntd() {
		return qntd;
	}
	public void setQntd(int qntd) {
		this.qntd = qntd;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome, qntd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		return Objects.equals(nome, other.nome) && qntd == other.qntd;
	}
	public ItemDTO(String nome, int qntd) {
		super();
		this.nome = nome;
		this.qntd = qntd;
	}
}
