package br.com.hourjob.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hourjob.controller.form.VagaForm;
import br.com.hourjob.model.Vaga;
import br.com.hourjob.repository.CandidatoRepository;
import br.com.hourjob.repository.EmpregadorRepository;
import br.com.hourjob.repository.VagaRepository;

@Service
public class VagaService {
	
	
	@Autowired
	private VagaRepository vagaRepository;
	
	public Vaga salvar(@Valid VagaForm form, EmpregadorRepository empregadorRepository, CandidatoRepository candidatoRepository) {
		
		return vagaRepository.save(form.toVaga(candidatoRepository, empregadorRepository));
	}

}
