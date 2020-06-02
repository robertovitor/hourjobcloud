package br.com.hourjob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.LoginCandidato;
import br.com.hourjob.repository.LoginCandidatoRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private CandidatoService candidatoService; 
	
	@Autowired
	LoginCandidatoRepository loginCandidatoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Candidato> candidato = candidatoService.findByEmail(username);
		Optional<LoginCandidato> loginCandidato  = null; 
		
		if(candidato.isPresent()) {
			loginCandidato = loginCandidatoRepository.findByCandidato(candidato.get());
		}
		
		if (loginCandidato.isPresent()) {
			return loginCandidato.get();
		}
		
		throw new UsernameNotFoundException("Dados Inválidos!");
	}

}
