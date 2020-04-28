package br.com.hourjob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class LoginCandidato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne @JoinColumn(unique = true)
	private Candidato candidato;
	private String senha;
	
}
