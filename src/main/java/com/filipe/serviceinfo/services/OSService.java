package com.filipe.serviceinfo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.serviceinfo.dominian.OS;
import com.filipe.serviceinfo.dtos.OSDTO;
import com.filipe.serviceinfo.repositories.OSRepository;
import com.filipe.serviceinfo.services.exceptions.ObjectNotFoundException;

@Service
public class OSService {

	@Autowired
	private OSRepository osRepository;
	
	
	public OS findById(Long id) {
		Optional<OS> obj = osRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + "Tipo: " + OS.class.getName()));
	}
	
	public List<OS> findAll(){
		return osRepository.findAll();
	}
	
	public OS create (@Valid OSDTO obj) {
		return fromDTO(obj); 
	}
	
	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setNome_cliente(obj.getNome_cliente());
		newObj.setFone_cliente(obj.getFone_cliente());
		newObj.setEndereco_cliente(obj.getEndereco_cliente());
		newObj.setPrioridade(obj.getPrioridade());
		newObj.setStatus(obj.getStatus());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setValor(obj.getValor());
		
		/*Funcionario funci = fService.findById(obj.getFuncionario());
		newObj.setFuncionario(funci);*/
		
		return osRepository.save(newObj);
	}

	public OS update(@Valid OSDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
}
