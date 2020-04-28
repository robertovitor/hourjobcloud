package br.com.hourjob.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hourjob.controller.form.CandidatoForm;
import br.com.hourjob.model.Candidato;
import br.com.hourjob.repository.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public Candidato salvar(@Valid CandidatoForm form) {
		
		return candidatoRepository.save(form.toCandidato());
	}

}
