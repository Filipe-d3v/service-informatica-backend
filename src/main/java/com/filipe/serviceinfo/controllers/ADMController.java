package com.filipe.serviceinfo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.filipe.serviceinfo.dominian.ADM;
import com.filipe.serviceinfo.dtos.ADMDTO;
import com.filipe.serviceinfo.services.ADMService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/adms")
public class ADMController {

	@Autowired
	private ADMService admService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ADMDTO> findById(@PathVariable Long id) {
		ADM obj = admService.findById(id);
		ADMDTO objDTO = new ADMDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

	@GetMapping
	public ResponseEntity<List<ADMDTO>> findAll() {
		List<ADMDTO> listDTO = admService.findAll().stream().map(obj -> new ADMDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ADMDTO> create(@Valid @RequestBody ADMDTO objDTO) {
		ADM newObj = admService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ADMDTO> update(@PathVariable Long id, @Valid @RequestBody ADMDTO objDTO) {
		ADMDTO newObj = new ADMDTO(admService.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		admService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
