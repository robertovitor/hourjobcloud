package br.com.hourjob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Qualificacao {
 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String escolaridade;
	private String curso;
	private String habilidades;
	@ManyToOne
	private Candidato candidato;

}
