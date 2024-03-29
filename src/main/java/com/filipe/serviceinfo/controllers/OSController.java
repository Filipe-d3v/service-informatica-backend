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

import com.filipe.serviceinfo.dtos.OSDTO;
import com.filipe.serviceinfo.services.OSService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/os")
public class OSController {

	@Autowired
	private OSService osService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OSDTO> findById(@PathVariable Long id) {
		OSDTO obj = new OSDTO(osService.findById(id));
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<OSDTO>> findAll() {
		List<OSDTO> list = osService.findAll().stream().map(obj -> new OSDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<OSDTO> create(@Valid @RequestBody OSDTO obj){
		obj = new OSDTO(osService.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<OSDTO> update(@Valid @RequestBody OSDTO obj){
		obj = new OSDTO(osService.update(obj));
		
		return ResponseEntity.ok().body(obj);
	}
}