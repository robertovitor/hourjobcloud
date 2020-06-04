package br.com.hourjob.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import br.com.hourjob.model.StatusVagaEnum;
import br.com.hourjob.model.Vaga;
import lombok.Data;

@Data
public class VagaDto {

	public VagaDto(Vaga vaga) {
		this.id = vaga.getId();
		this.periodo = vaga.getPeriodo();
		this.remuneracao = vaga.getRemuneracao();
		this.status = vaga.getStatus();
	}


	private Long id;
	private boolean perfilDaVaga;
	private int periodo;
	private BigDecimal remuneracao;
	private StatusVagaEnum status;




	public static Page<VagaDto> converter(Page<Vaga> vaga) {
		return vaga.map(VagaDto::new);
	}

}
