package com.filipe.serviceinfo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.filipe.serviceinfo.dtos.VendaAvistaDTO;
import com.filipe.serviceinfo.services.VendaAvistaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/vendasavista")
public class VendaAvistaController {

	@Autowired
	private VendaAvistaService avistaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VendaAvistaDTO> findById(@PathVariable Long id) {
		VendaAvistaDTO obj = new VendaAvistaDTO(avistaService.findById(id));
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<VendaAvistaDTO>> findAll() {
		List<VendaAvistaDTO> list = avistaService.findAll().stream().map(obj -> new VendaAvistaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<VendaAvistaDTO> create(@Valid @RequestBody VendaAvistaDTO obj){
		obj = new VendaAvistaDTO(avistaService.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<VendaAvistaDTO> update(@Valid @RequestBody VendaAvistaDTO obj){
		obj = new VendaAvistaDTO(avistaService.update(obj));
		
		return ResponseEntity.ok().body(obj);
	}
}
