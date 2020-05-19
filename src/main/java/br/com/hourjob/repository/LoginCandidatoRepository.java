package br.com.hourjob.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.LoginCandidato;


public interface LoginCandidatoRepository  extends JpaRepository<LoginCandidato, Long> {

	Optional<LoginCandidato> findByCandidato(Candidato candidato);
	
}
