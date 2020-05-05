package br.com.hourjob.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hourjob.controller.form.CandidatoForm;
import br.com.hourjob.dto.CandidatoDto;
import br.com.hourjob.model.Candidato;
import br.com.hourjob.repository.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public Candidato salvar(@Valid CandidatoForm form) {
		
		return candidatoRepository.save(form.toCandidato());
	}

	public Page<CandidatoDto> listar(Long id, Pageable paginacao) {
			if (id == null) {
				Page<Candidato> candidato = candidatoRepository.findAll(paginacao);
				return CandidatoDto.converter(candidato);
			} else {
				Page<Candidato> candidato = candidatoRepository.findByQualificacao(id, paginacao);
				return CandidatoDto.converter(candidato);
			}
		}

	public ResponseEntity<CandidatoDto> avaliar(Long id, int nota) {
		Optional<Candidato> optional = candidatoRepository.findById(id);
		if (optional.isPresent()) {
			Candidato candidato = candidatoRepository.getOne(id);
			candidato.setPontuacao(nota);
			return ResponseEntity.ok(new CandidatoDto(candidato));
		}
		
		return ResponseEntity.notFound().build();		
	}

}
