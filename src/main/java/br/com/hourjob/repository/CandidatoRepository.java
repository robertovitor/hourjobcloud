package br.com.hourjob.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.Qualificacao;
import br.com.hourjob.model.Vaga;


public interface CandidatoRepository  extends JpaRepository<Candidato, Long> {

	Page<Candidato> findByQualificacao(long id, Pageable paginacao);

	Optional<Candidato> findByEmail(String username);

}
