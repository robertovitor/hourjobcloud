package br.com.hourjob.controller.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.Empregador;
import br.com.hourjob.model.StatusVagaEnum;
import br.com.hourjob.model.Vaga;
import br.com.hourjob.repository.EmpregadorRepository;
import lombok.Data;

@Data
public class VagaForm {
	
	private long idCandidato;
	private long idEmpregador;
	private Candidato candidato;
	private Empregador empregador;
	private boolean perfilDaVaga;
	private int periodo;
	private BigDecimal remuneracao;
	private StatusVagaEnum status;
	private Date data;
	private String requisito;
	
	
	public Vaga toVaga( EmpregadorRepository empregadorRepository) {
		
		Optional<Empregador> empregador = empregadorRepository.findById(idEmpregador);
		return new Vaga(empregador.get(),this.perfilDaVaga,this.periodo,this.remuneracao, this.status,this.data, this.requisito);
	}


}
