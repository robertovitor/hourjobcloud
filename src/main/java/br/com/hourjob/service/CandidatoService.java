package br.com.hourjob.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hourjob.controller.form.CandidatoForm;
import br.com.hourjob.dto.CandidatoDto;
import br.com.hourjob.dto.VagaDto;
import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.Vaga;
import br.com.hourjob.repository.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public Candidato salvar(@Valid CandidatoForm form) {
		
		return candidatoRepository.save(form.toCandidato());
	}

	public Page<CandidatoDto> listar(long id, Pageable paginacao) {
			if (id == 0) {
				Page<Candidato> candidato = candidatoRepository.findAll(paginacao);
				return CandidatoDto.converter(candidato);
			} else {
				Page<Candidato> candidato = candidatoRepository.findByQualificacao(id, paginacao);
				return CandidatoDto.converter(candidato);
			}
		}

}
