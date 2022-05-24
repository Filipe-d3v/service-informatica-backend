package com.filipe.serviceinfo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.serviceinfo.controllers.exceptions.ViolationException;
import com.filipe.serviceinfo.dominian.Funcionario;
import com.filipe.serviceinfo.dominian.Pessoa;
import com.filipe.serviceinfo.dtos.FuncionarioDTO;
import com.filipe.serviceinfo.repositories.FuncionarioRepository;
import com.filipe.serviceinfo.repositories.PessoaRepository;
import com.filipe.serviceinfo.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository fRepository;
	
	@Autowired
	private PessoaRepository pRepository;

	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = fRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
	public List<Funcionario> findAll() {
		return fRepository.findAll();
	}
	
	public Funcionario create( FuncionarioDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new ViolationException("CPF Já Cadastrado!");
		}
		return fRepository.save(new Funcionario(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getEndereco(), objDTO.getFone(), null));
	}
	
	private Pessoa findByCPF(FuncionarioDTO objDTO) {
		Pessoa obj = pRepository.findByCPF(objDTO.getCpf());

		if (obj != null) {
			return obj;
		}
		return null;
	}
	
	public Funcionario update(Long id, @Valid FuncionarioDTO objDTO) {
		Funcionario oldObj = findById(id);
		
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new ViolationException("CPF Já cadastrado!");
		}
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setEndereco(objDTO.getEndereco());
		oldObj.setFone(objDTO.getFone());
		return fRepository.save(oldObj);
	}
	
	public void delete(Long id) {
		//Funcionario obj = findById(id);
		//if(obj.getListOS().size() > 0) {
			//throw new ViolationException("Ordem de serviço associada ao funcionário, não pode ser deletado!");
		//}
		fRepository.deleteById(id);
	}
}
