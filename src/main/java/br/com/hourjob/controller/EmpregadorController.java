package br.com.hourjob.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.hourjob.controller.form.EmpregadorForm;
import br.com.hourjob.dto.EmpregadorDto;
import br.com.hourjob.model.Empregador;
import br.com.hourjob.service.EmpregadorService;
import lombok.Data;

@RestController
@RequestMapping("/empregado")
@Data
public class EmpregadorController {
	
	@Autowired
	private EmpregadorService empregadorService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EmpregadorDto> cadastrar(@RequestBody @Valid EmpregadorForm form, UriComponentsBuilder uriBuilder) {
		
		Empregador empregador = empregadorService.salvar(form);
		
		URI uri = uriBuilder.path("/empregador/{id}").buildAndExpand(empregador.getId()).toUri();
		return ResponseEntity.created(uri).body(new EmpregadorDto(empregador));
	}
	
	@PutMapping("/avaliacao/{id}/{nota}")
	@Transactional
	public ResponseEntity<EmpregadorDto> atualizar(@PathVariable Long id, int nota) {
		return empregadorService.avaliar(id,nota);
	}
	
}