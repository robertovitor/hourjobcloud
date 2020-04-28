package br.com.hourjob.dto;

import org.springframework.data.domain.Page;

import br.com.hourjob.model.Empregador;
import lombok.Data;

@Data
public class EmpregadorDto {
	
	public EmpregadorDto(Empregador empregador) {
		this.id = empregador.getId();
		this.cpf = empregador.getCep();
		this.nome = empregador.getNome();
		this.email = empregador.getEmail();

	}
	
	private long id; 
	private String cpf;
	private String nome;
	private String email;
	
	public static Page<EmpregadorDto	> converter(Page<Empregador> empregador) {
		return empregador.map(EmpregadorDto::new);
	}

}
