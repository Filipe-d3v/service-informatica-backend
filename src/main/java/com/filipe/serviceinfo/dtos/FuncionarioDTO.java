package com.filipe.serviceinfo.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.filipe.serviceinfo.dominian.Funcionario;

public class FuncionarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Campo nome é obrigatório!")
	private String nome;
	
	@CPF
	@NotEmpty(message = "Campo CPF é obrigatório!")
	private String cpf;
	
	@NotEmpty(message = "Campo endereço é obrigatório!")
	private String endereco;
	
	@NotEmpty(message = "Campo telefone é obrigatório!")
	private String fone;
	
	public FuncionarioDTO() {
		super();
	}
	
	public FuncionarioDTO(Funcionario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.endereco = obj.getEndereco();
		this.fone = obj.getFone();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

}
