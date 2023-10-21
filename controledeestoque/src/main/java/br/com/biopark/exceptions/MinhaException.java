package br.com.biopark.exceptions;

import java.time.LocalDateTime;

public class MinhaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String descricao;
	private LocalDateTime dataHora;
	
	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public MinhaException(String descricao) {
		super(descricao);
		this.descricao = descricao;
		this.dataHora = LocalDateTime.now();
	}
}
