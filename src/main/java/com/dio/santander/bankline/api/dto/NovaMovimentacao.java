package com.dio.santander.bankline.api.dto;

import com.dio.santander.bankline.api.model.MovimantacaoTipo;

public class NovaMovimentacao {

	private String descricao;
	private Double valor;
	private Integer idConta;
	private MovimantacaoTipo tipo;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	public MovimantacaoTipo getTipo() {
		return tipo;
	}
	public void setTipo(MovimantacaoTipo tipo) {
		this.tipo = tipo;
	}
	
}
