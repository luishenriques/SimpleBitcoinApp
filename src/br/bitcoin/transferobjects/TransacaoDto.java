package br.bitcoin.transferobjects;

import java.util.Date;

public class TransacaoDto {
	
	private Date data;
	private String endereco;
	private Double valor;
	private Integer confirmacoes;
	
	
	public TransacaoDto(Date data, String endereco, Double valor, Integer confirmacoes) {
		super();
		this.data = data;
		this.endereco = endereco;
		this.valor = valor;
		this.confirmacoes = confirmacoes;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getConfirmacoes() {
		return confirmacoes;
	}
	public void setConfirmacoes(Integer confirmacoes) {
		this.confirmacoes = confirmacoes;
	}

}
