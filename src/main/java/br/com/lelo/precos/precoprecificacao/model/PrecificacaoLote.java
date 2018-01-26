package br.com.lelo.precos.precoprecificacao.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrecificacaoLote {

	@JsonProperty(required = true)
	private Integer filialInicial;

	@JsonProperty(required = true)
	private Integer filialFinal;

	@JsonProperty(required = true)
	private Long produto;

	@JsonProperty(required = true)
	private BigDecimal valor;

	public Integer getFilialInicial() {
		return filialInicial;
	}

	public Integer getFilialFinal() {
		return filialFinal;
	}

	public Long getProduto() {
		return produto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setFilialInicial(Integer filialInicial) {
		this.filialInicial = filialInicial;
	}

	public void setFilialFinal(Integer filialFinal) {
		this.filialFinal = filialFinal;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
