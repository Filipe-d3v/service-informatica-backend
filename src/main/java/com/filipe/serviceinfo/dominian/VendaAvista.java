package com.filipe.serviceinfo.dominian;

import java.io.Serializable;
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
import com.filipe.serviceinfo.dominian.enums.FormaPagamento;

@Entity
public class VendaAvista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	
	@OneToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@ManyToMany(mappedBy = "lista_avista")
	private List<Produto> prduto;
	  
	private Integer fPagamento;

	public VendaAvista() {
		super();
		this.setData(LocalDateTime.now());
		this.setfPagamento(FormaPagamento.DINHEIRO);
	} 

	public VendaAvista(Long id, Funcionario funcionario, FormaPagamento fPagamento) {
		super();
		this.id = id;
		this.setData(LocalDateTime.now());
		this.funcionario = funcionario;
		this.fPagamento = (fPagamento == null) ? 0 : fPagamento.getCod();
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

	public FormaPagamento getfPagamento() {
		return FormaPagamento.toEnum(this.fPagamento);
	}

	public void setfPagamento(FormaPagamento fPagamento) {
		this.fPagamento = fPagamento.getCod();
	}

	public List<Produto> getPrduto() {
		return prduto;
	}

	public void setLista_prduto(List<Produto> prduto) {
		this.prduto = prduto;
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
		VendaAvista other = (VendaAvista) obj;
		return Objects.equals(id, other.id);
	}

}
