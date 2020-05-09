package br.com.hourjob.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.hourjob.model.LoginCandidato;
import br.com.hourjob.repository.LoginCandidatoRepository;
import br.com.hourjob.service.TokenService;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private LoginCandidatoRepository loginCandidatoRepository;
	

	public AutenticacaoTokenFilter(TokenService tokenService, LoginCandidatoRepository loginCandidatoRepository) {
		this.tokenService = tokenService;
		this.loginCandidatoRepository = loginCandidatoRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isValid(token);
		
		if(valido) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarCliente(String token) {
		
		Long idUsuario = tokenService.getIdUsuario(token);
		LoginCandidato usuario = loginCandidatoRepository.findById(idUsuario).get();
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		
		
	}

	private String recuperarToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
	
	

}
