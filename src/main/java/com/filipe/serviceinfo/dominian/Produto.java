package com.filipe.serviceinfo.dominian;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "produto_vendavista", joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "venda_vista_id"))
	private List<VendaAvista> lista_avista;
	
	@ManyToMany
	@JoinTable(name = "produto_vendaprazo", joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "venda_prazo_id"))
	private List<VendaAprazo> lista_prazo;

	public Produto() {
		super();
	}

	public Produto(Long id, String nome, Double preco, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
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

	public List<VendaAvista> getLista_avista() {
		return lista_avista;
	}

	public void setLista_avista(List<VendaAvista> lista_avista) {
		this.lista_avista = lista_avista;
	}

	public List<VendaAprazo> getLista_prazo() {
		return lista_prazo;
	}

	public void setLista_prazo(List<VendaAprazo> lista_prazo) {
		this.lista_prazo = lista_prazo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
