package br.com.hourjob.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Vaga {
	
	public Vaga() {}
	
	public Vaga(Candidato candidato, Empregador empregador, boolean perfilDaVaga, int periodo,
			BigDecimal remuneracao, StatusVagaEnum status, Date data) {
		
		this.candidato = candidato;
		this.data = data;
		this.empregador = empregador;
		this.perfilDaVaga = perfilDaVaga;
		this.periodo= periodo;
		this.remuneracao = remuneracao;
		this.status = status;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Candidato candidato;
	@ManyToOne
	private Empregador empregador;
	private boolean perfilDaVaga;
	private int periodo;
	private BigDecimal remuneracao;
	@Enumerated(EnumType.STRING)
	private StatusVagaEnum status;
	private Date data;
	
}
