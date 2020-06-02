package br.com.hourjob.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hourjob.controller.form.LoginForm;
import br.com.hourjob.dto.TokenDto;
import br.com.hourjob.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager auth;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter(); 
		
		
		try {
			Authentication authetication =  auth.authenticate(dadosLogin);
			
			String token = tokenService.gerarToken(authetication);
			
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@GetMapping("/encrypt/{pass}")
	public String getEncrypt(@PathVariable(name = "pass") String pass) {
		return tokenService.getEncrypt(pass);
	}
}
