package com.filipe.serviceinfo.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filipe.serviceinfo.dominian.VendaAprazo;
import com.filipe.serviceinfo.dominian.enums.Estado;

public class VendaAprazoDTO {

	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	private Long funcionario;
	private String nome_cliente;
	private String cpf_cliente;
	private String endereco_cliente;
	private String fone_cliente;
	private Integer estado;
	
	public VendaAprazoDTO() {
		super();
	}

	public VendaAprazoDTO(VendaAprazo obj) {
		super();
		this.id = obj.getId();
		this.funcionario = obj.getFuncionario().getId();
		this.nome_cliente = obj.getNome_cliente();
		this.cpf_cliente = obj.getCpf_cliente();
		this.endereco_cliente = obj.getEndereco_cliente();
		this.fone_cliente = obj.getFone_cliente();
		this.estado = obj.getEstado().getCod();
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

	public Long getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Long funcionario) {
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
	
}
