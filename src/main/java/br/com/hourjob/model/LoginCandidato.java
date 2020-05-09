package br.com.hourjob.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Data
public class LoginCandidato implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5609483637134073314L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne @JoinColumn(unique = true)
	private Candidato candidato;
	private String senha;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return this.getPassword();
	}
	@Override
	public String getUsername() {
		return this.candidato.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
