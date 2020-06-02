package br.com.hourjob.controller.form;

import br.com.hourjob.model.Empregador;
import lombok.Data;

@Data
public class EmpregadorForm {
	
	
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String cpfResponsavel;
	private String cep;
	private String funcResponsavel;
	private String porteEmpresa;
	private String atividade;

	

	public Empregador toEmpregador() {
		
		Empregador empregador = new Empregador();
		
		empregador.setAtividade(this.atividade);
		empregador.setCep(this.cep);
		empregador.setCnpj(this.cnpj);
		empregador.setCpfResponsavel(this.cpfResponsavel);
		empregador.setEmail(this.email);
		empregador.setFuncResponsavel(this.funcResponsavel);
		empregador.setNome(this.nome);
		empregador.setPorteEmpresa(this.porteEmpresa);
		empregador.setTelefone(this.telefone);
		
		return empregador;
	}

}
