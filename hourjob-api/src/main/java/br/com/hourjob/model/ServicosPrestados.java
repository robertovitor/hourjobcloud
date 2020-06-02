package br.com.hourjob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ServicosPrestados {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Candidato candidato;
	@OneToOne
	private HistoricoVaga historicoVaga;
	
}
