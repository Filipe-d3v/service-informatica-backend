package com.filipe.serviceinfo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.filipe.serviceinfo.dominian.Funcionario;
import com.filipe.serviceinfo.dominian.VendaAprazo;
import com.filipe.serviceinfo.dtos.VendaAprazoDTO;
import com.filipe.serviceinfo.repositories.VendaAprazoRepository;
import com.filipe.serviceinfo.services.exceptions.ObjectNotFoundException;

@Service
public class VendaAprazoService {

	private VendaAprazoRepository aprazoRepository;
	
	private FuncionarioService fService;
	
	public VendaAprazo findById(Long id) {
		Optional<VendaAprazo> obj = aprazoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + "Tipo: " + VendaAprazo.class.getName()));
	}
	
	public List<VendaAprazo> findAll(){
		return aprazoRepository.findAll();
	}
	
	public VendaAprazo create (@Valid VendaAprazoDTO obj) {
		return fromDTO(obj); 
	}
	
	private VendaAprazo fromDTO(VendaAprazoDTO obj) {
		VendaAprazo newObj = new VendaAprazo();
		newObj.setId(obj.getId());
		newObj.setNome_cliente(obj.getNome_cliente());
		newObj.setCpf_cliente(obj.getCpf_cliente());
		newObj.setEndereco_cliente(obj.getEndereco_cliente());
		newObj.setFone_cliente(obj.getFone_cliente());
		newObj.setEstado(obj.getEstado());
		
		Funcionario funci = fService.findById(obj.getFuncionario());
		newObj.setFuncionario(funci);
		
		return aprazoRepository.save(newObj);
	}

	public VendaAprazo update(@Valid VendaAprazoDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
}
