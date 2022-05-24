package com.filipe.serviceinfo.dtos;

import javax.validation.constraints.NotEmpty;

import com.filipe.serviceinfo.dominian.Produto;

public class ProdutoDTO {

	private Long id;
	
	@NotEmpty(message = "Capo nome é Obrigatório!")
	private String nome;
	private Double preco;
	private String descricao;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
		this.descricao = obj.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
