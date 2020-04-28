package br.com.hourjob.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Candidato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private String nomeDaMae;
	private Date dataDeNascimento;
	private String cep;
	@Lob
	private String selfie;
	@Lob
	private String fotoDoDocumento;
	private int pontuacao;
	@OneToMany(mappedBy = "candidato")
	private List<Qualificacao> qualificacao;
	@OneToMany
	private List<ServicosPrestados> servicosPrestados;

}
