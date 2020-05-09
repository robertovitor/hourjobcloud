package br.com.hourjob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.LoginCandidato;
import br.com.hourjob.repository.LoginCandidatoRepository;

public class LoginCandidatoService {
	
	@Autowired
	LoginCandidatoRepository loginCandidatoRepository;

	public Optional<LoginCandidato> findByCandidato(Optional<Candidato> candidato) {
		return loginCandidatoRepository.findByCandidato(candidato);
	}

}
