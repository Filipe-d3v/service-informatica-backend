package com.filipe.serviceinfo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.serviceinfo.controllers.exceptions.ViolationException;
import com.filipe.serviceinfo.dominian.ADM;
import com.filipe.serviceinfo.dominian.Pessoa;
import com.filipe.serviceinfo.dtos.ADMDTO;
import com.filipe.serviceinfo.repositories.ADMRepository;
import com.filipe.serviceinfo.repositories.PessoaRepository;
import com.filipe.serviceinfo.services.exceptions.ObjectNotFoundException;

@Service
public class ADMService {

	@Autowired
	private ADMRepository admRepository;

	@Autowired
	private PessoaRepository pRepository;

	public ADM findById(Long id) {
		Optional<ADM> obj = admRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + ADM.class.getName()));
	}

	public List<ADM> findAll() {
		return admRepository.findAll();
	}

	public ADM create(ADMDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new ViolationException("CPF Já Cadastrado!");
		}
		return admRepository
				.save(new ADM(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getEndereco(), objDTO.getFone(), null));
	}

	private Pessoa findByCPF(ADMDTO objDTO) {
		Pessoa obj = pRepository.findByCPF(objDTO.getCpf());

		if (obj != null) {
			return obj;
		}
		return null;
	}

	public ADM update(Long id, @Valid ADMDTO objDTO) {
		ADM oldObj = findById(id);

		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new ViolationException("CPF Já cadastrado!");
		}

		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setEndereco(objDTO.getEndereco());
		oldObj.setFone(objDTO.getFone());
		return admRepository.save(oldObj);
	}

	public void delete(Long id) {
		admRepository.deleteById(id);
	}
}
