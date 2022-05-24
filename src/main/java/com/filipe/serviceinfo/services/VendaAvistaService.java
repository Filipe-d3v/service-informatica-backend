package com.filipe.serviceinfo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.serviceinfo.dominian.Funcionario;
import com.filipe.serviceinfo.dominian.VendaAvista;
import com.filipe.serviceinfo.dtos.VendaAvistaDTO;
import com.filipe.serviceinfo.repositories.VendaAvistaRepository;
import com.filipe.serviceinfo.services.exceptions.ObjectNotFoundException;

@Service
public class VendaAvistaService {

	@Autowired
	private VendaAvistaRepository avistaRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	public VendaAvista findById(Long id) {
		Optional<VendaAvista> obj = avistaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + "Tipo: " + VendaAvista.class.getName()));
	}
	
	public List<VendaAvista> findAll(){
		return avistaRepository.findAll();
	}
	
	public VendaAvista create (@Valid VendaAvistaDTO obj) {
		return fromDTO(obj); 
	}
	
	private VendaAvista fromDTO(VendaAvistaDTO obj) {
		VendaAvista newObj = new VendaAvista();
		newObj.setId(obj.getId());
		newObj.setfPagamento(obj.getfPagamento());
		
		Funcionario funci = funcionarioService.findById(obj.getFuncionario());
		newObj.setFuncionario(funci);
		
		return avistaRepository.save(newObj);
	}

	public VendaAvista update(@Valid VendaAvistaDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
}
