package br.com.hourjob.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Jornada {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Candidato candidato;
	@OneToOne
	private Empregador empregador;
	@OneToOne
	private Vaga vaga;
	@Enumerated(EnumType.STRING)
	private JornadaEnum jornada;

}
