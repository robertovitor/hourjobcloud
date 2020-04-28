package br.com.hourjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hourjob.model.Vaga;


public interface VagaRepository  extends JpaRepository<Vaga, Long> {}
