package br.com.hourjob.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hourjob.controller.form.VagaForm;
import br.com.hourjob.dto.VagaDto;
import br.com.hourjob.model.Vaga;
import br.com.hourjob.repository.CandidatoRepository;
import br.com.hourjob.repository.EmpregadorRepository;
import br.com.hourjob.service.VagaService;
import lombok.Data;

@RestController
@RequestMapping("/vaga")
@Data
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	@Autowired
	CandidatoRepository candidatoRepository;
	EmpregadorRepository empregadorRepository;
	@PostMapping
	@Transactional
	public ResponseEntity<VagaDto> cadastrar(@RequestBody @Valid VagaForm form, UriComponentsBuilder uriBuilder) {
		
		Vaga vaga = vagaService.salvar(form,empregadorRepository,candidatoRepository);
		
		URI uri = uriBuilder.path("/vaga/{id}").buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).body(new VagaDto(vaga));
	}
	
}