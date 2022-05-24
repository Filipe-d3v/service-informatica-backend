package com.filipe.serviceinfo.dominian;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filipe.serviceinfo.dominian.enums.Estado;

@Entity
public class VendaAprazo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	
	@OneToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	private String nome_cliente;
	private String cpf_cliente;
	private String endereco_cliente;
	private String fone_cliente;
	private Integer estado;
	
	@ManyToMany(mappedBy = "lista_prazo")
	private List<Produto> produto;
	
	public VendaAprazo() {
		super();
		this.setData(LocalDateTime.now());
		this.setEstado(Estado.DEVENDO);
	}

	public VendaAprazo(Long id, Funcionario funcionario, String nome_cliente,
			String cpf_cliente, String endereco_cliente, String fone_cliente, Estado estado) {
		super();
		this.id = id;
		this.setData(LocalDateTime.now());
		this.funcionario = funcionario;
		this.nome_cliente = nome_cliente;
		this.cpf_cliente = cpf_cliente;
		this.endereco_cliente = endereco_cliente;
		this.fone_cliente = fone_cliente;
		this.estado = (estado == null) ? 0 : estado.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getEndereco_cliente() {
		return endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}

	public String getFone_cliente() {
		return fone_cliente;
	}
 
	public void setFone_cliente(String fone_cliente) {
		this.fone_cliente = fone_cliente;
	}

	public Estado getEstado() {
		return Estado.toEnum(this.estado);
	}

	public void setEstado(Estado estado) {
		this.estado = estado.getCod();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf_cliente, id);
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaAprazo other = (VendaAprazo) obj;
		return Objects.equals(cpf_cliente, other.cpf_cliente) && Objects.equals(id, other.id);
	}
	
}
