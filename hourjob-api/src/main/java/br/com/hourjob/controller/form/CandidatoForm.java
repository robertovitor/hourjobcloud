package br.com.hourjob.controller.form;

import java.util.Date;

import br.com.hourjob.model.Candidato;
import lombok.Data;

@Data
public class CandidatoForm {
	
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private String nomeMae;
	private Date dataNascimento;
	private String cep;
	
	
	
	public Candidato toCandidato() {
		
		Candidato candidato = new Candidato();
		
		candidato.setCpf(this.cpf);
		candidato.setNome(this.nome);
		candidato.setCep(this.cep);
		candidato.setNomeDaMae(this.nomeMae);
		candidato.setEmail(this.email);
		candidato.setDataDeNascimento(this.dataNascimento);
		candidato.setTelefone(this.telefone);
		
		
		return candidato;
	}
}
