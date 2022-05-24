package com.filipe.serviceinfo.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filipe.serviceinfo.dominian.VendaAvista;
import com.filipe.serviceinfo.dominian.enums.FormaPagamento;

public class VendaAvistaDTO {

	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	private Long funcionario;
	private Integer fPagamento;
	
	public VendaAvistaDTO() {
		super();
	}

	public VendaAvistaDTO(VendaAvista obj) {
		super();
		this.id = obj.getId();
		this.data = obj.getData();
		this.funcionario = obj.getFuncionario().getId();
		this.fPagamento = obj.getfPagamento().getCod();
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

	public FormaPagamento getfPagamento() {
		return FormaPagamento.toEnum(this.fPagamento);
	}

	public void setfPagamento(FormaPagamento fPagamento) {
		this.fPagamento = fPagamento.getCod();
	}	
	
}
