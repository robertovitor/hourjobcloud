package br.com.hourjob.model;

import java.math.BigDecimal;
import java.util.Date;

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
public class HistoricoVaga {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Vaga vaga;
	private Date data;
	private String setor;
	private String perfilVaga;
	private int periodo;
	private BigDecimal remuneracao;
	@Enumerated(EnumType.STRING)
	private StatusVagaEnum statusVagaEnum;
	private Date dataMatch;

}
