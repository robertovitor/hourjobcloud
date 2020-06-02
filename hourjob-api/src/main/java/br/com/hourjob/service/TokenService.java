package br.com.hourjob.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.hourjob.model.LoginCandidato;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	@Value("${jwt.expiration}")
	private String expiration;
	
	@Value("${jwt.secret}")
	private String secret;
	public String gerarToken(Authentication auth) {
		
		LoginCandidato logado = (LoginCandidato) auth.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("Api de login HourJob")
				.setSubject(Long.toString(logado.getId()))
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	public boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	public Long getIdUsuario(String token) {
		
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
		
	}
	
	public String getEncrypt(String pass) {
		
		return new BCryptPasswordEncoder().encode(pass);
		
	}

}
