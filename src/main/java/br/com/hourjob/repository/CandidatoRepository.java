package br.com.hourjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hourjob.model.Candidato;


public interface CandidatoRepository  extends JpaRepository<Candidato, Long> {}
