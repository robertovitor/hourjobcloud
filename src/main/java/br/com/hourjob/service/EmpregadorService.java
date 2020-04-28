package br.com.hourjob.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hourjob.controller.form.EmpregadorForm;
import br.com.hourjob.model.Empregador;
import br.com.hourjob.repository.EmpregadorRepository;

@Service
public class EmpregadorService {
	
	@Autowired
	private EmpregadorRepository empregadorRepository;
	
	public Empregador salvar(@Valid EmpregadorForm form) {
		
		return empregadorRepository.save(form.toEmpregador());
	}


}
