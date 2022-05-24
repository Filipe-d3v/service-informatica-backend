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

import com.filipe.serviceinfo.dtos.VendaAprazoDTO;
import com.filipe.serviceinfo.services.VendaAprazoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/vendasaprazo")
public class VendaAprazoController {

	@Autowired
	private VendaAprazoService aprazoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VendaAprazoDTO> findById(@PathVariable Long id) {
		VendaAprazoDTO obj = new VendaAprazoDTO(aprazoService.findById(id));
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<VendaAprazoDTO>> findAll() {
		List<VendaAprazoDTO> list = aprazoService.findAll().stream().map(obj -> new VendaAprazoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<VendaAprazoDTO> create(@Valid @RequestBody VendaAprazoDTO obj){
		obj = new VendaAprazoDTO(aprazoService.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<VendaAprazoDTO> update(@Valid @RequestBody VendaAprazoDTO obj){
		obj = new VendaAprazoDTO(aprazoService.update(obj));
		
		return ResponseEntity.ok().body(obj);
	}
}
