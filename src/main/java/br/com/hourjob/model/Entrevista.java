package br.com.hourjob.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Entrevista {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoEntrevistaEnum tipoEntrevista;
	@Enumerated(EnumType.STRING)
	private ResultandoEntrevistaEnum resultadoEntrevista;
	@OneToOne @JoinColumn(unique = true)
	private Jornada jornada;


}
