package br.com.hourjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.Empregador;


public interface EmpregadorRepository  extends JpaRepository<Empregador, Long> {}
