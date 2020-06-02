package br.com.hourjob.controller;

import java.net.URI;
import java.util.List;

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

import br.com.hourjob.controller.form.VagaForm;
import br.com.hourjob.dto.VagaDto;
import br.com.hourjob.model.Vaga;
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
	EmpregadorRepository empregadorRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<VagaDto> cadastrar(@RequestBody @Valid VagaForm form, UriComponentsBuilder uriBuilder) {
		
		Vaga vaga = vagaService.salvar(form,empregadorRepository);
		
		URI uri = uriBuilder.path("/vaga/{id}").buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).body(new VagaDto(vaga));
	}
	
	@GetMapping
	public Page<VagaDto> lista(@RequestParam(required = false) long id, 
			@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
			return vagaService.listar(id,paginacao);
	}
	
	@GetMapping
	@RequestMapping("/match")
	public List<Vaga> match(@RequestParam(required = false) long id) {
		
			return vagaService.match(id);
	}
}