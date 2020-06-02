package br.com.hourjob.model;

import java.math.BigDecimal;

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
public class Pagamento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	TipoPagamentoEnum tipoPagamento;
	private BigDecimal valor;
	@OneToOne @JoinColumn(unique = true)
	private Jornada jornada;
 	
}
