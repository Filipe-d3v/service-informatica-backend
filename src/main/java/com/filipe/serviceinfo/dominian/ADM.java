package com.filipe.serviceinfo.dominian;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ADM extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	

	public ADM() {
		super();
	}

	public ADM(Long id, String nome, String cpf, String endereco, String fone, String senha) {
		super(id, nome, cpf, endereco, fone, senha);
	}


	
}
