package br.com.hourjob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class Perfil implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8915275687007156068L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String perfil;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return perfil;
	}

}
