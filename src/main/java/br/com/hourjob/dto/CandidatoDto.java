package br.com.hourjob.dto;

import org.springframework.data.domain.Page;

import br.com.hourjob.model.Candidato;
import lombok.Data;

@Data
public class CandidatoDto {
	
	public CandidatoDto(Candidato candidato) {
		this.id = candidato.getId();
		this.cpf = candidato.getCep();
		this.nome = candidato.getNome();
		this.email = candidato.getEmail();

	}
	
	
	private Long id; 
	private String cpf;
	private String nome;
	private String email;
	
	public static Page<CandidatoDto> converter(Page<Candidato> candidato) {
		return candidato.map(CandidatoDto::new);
	}

}
