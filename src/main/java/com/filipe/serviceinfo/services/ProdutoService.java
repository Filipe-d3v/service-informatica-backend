package com.filipe.serviceinfo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.serviceinfo.controllers.exceptions.ViolationException;
import com.filipe.serviceinfo.dominian.Produto;
import com.filipe.serviceinfo.dtos.ProdutoDTO;
import com.filipe.serviceinfo.repositories.ProdutoRepository;
import com.filipe.serviceinfo.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository pRepository;
	
	public Produto findById(Long id) {
		Optional<Produto> obj = pRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	public List<Produto> findAll() {
		return pRepository.findAll();
	}
	
	public Produto create( ProdutoDTO objDTO) {
		return pRepository.save(new Produto(null, objDTO.getNome(), objDTO.getPreco(), objDTO.getDescricao()));
	}
	
	public Produto update(Long id, @Valid ProdutoDTO objDTO) {
		Produto oldObj = findById(id);
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setPreco(objDTO.getPreco());
		oldObj.setDescricao(objDTO.getDescricao());
		return pRepository.save(oldObj);
	}
	
	public void delete(Long id) {
		Produto obj = findById(id);
		if(obj.getLista_prazo().size() > 0 || obj.getLista_avista().size() > 0) {
			throw new ViolationException("Vendas Associadas ao produto");
		}
		pRepository.deleteById(id);
	}
}
