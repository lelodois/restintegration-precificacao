package br.com.lelo.precos.precoprecificacao.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Precificacao {

	@JsonProperty(required = true)
	private BigDecimal valor;

	@JsonProperty(required = true)
	private Long produto;

	@JsonProperty(required = true)
	private Long filial;

	public Long getFilial() {
		return filial;
	}

	public Long getProduto() {
		return produto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setFilial(Long filial) {
		this.filial = filial;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
