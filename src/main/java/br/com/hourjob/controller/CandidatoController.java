package br.com.hourjob.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hourjob.controller.form.CandidatoForm;
import br.com.hourjob.dto.CandidatoDto;
import br.com.hourjob.model.Candidato;
import br.com.hourjob.service.CandidatoService;
import lombok.Data;

@RestController
@RequestMapping("/candidato")
@Data
public class CandidatoController {
	
	@Autowired
	private CandidatoService usuarioService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CandidatoDto> cadastrar(@RequestBody @Valid CandidatoForm form, UriComponentsBuilder uriBuilder) {
		
		Candidato candidato = usuarioService.salvar(form);
		
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(candidato.getId()).toUri();
		return ResponseEntity.created(uri).body(new CandidatoDto(candidato));
	}
	
	@GetMapping
	public Page<CandidatoDto> lista(@RequestParam(required = false) long idQuali, 
			@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
			return usuarioService.listar(idQuali,paginacao);
	}
	
	
}
