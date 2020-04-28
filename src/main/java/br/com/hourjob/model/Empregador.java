package br.com.hourjob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Empregador {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String cpfResponsavel;
	private String cep;
	private String funcResponsavel;
	private String porteEmpresa;
	private String atividade;
	private double pontuacao;

}
