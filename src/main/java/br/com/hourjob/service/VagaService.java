package br.com.hourjob.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.hourjob.controller.form.VagaForm;
import br.com.hourjob.dto.VagaDto;
import br.com.hourjob.model.Candidato;
import br.com.hourjob.model.Qualificacao;
import br.com.hourjob.model.StatusVagaEnum;
import br.com.hourjob.model.Vaga;
import br.com.hourjob.repository.CandidatoRepository;
import br.com.hourjob.repository.EmpregadorRepository;
import br.com.hourjob.repository.VagaRepository;

@Service
public class VagaService {

  @Autowired
  private VagaRepository vagaRepository;

  @Autowired
  private CandidatoRepository candidatoRepository;

  public Vaga salvar(@Valid VagaForm form, EmpregadorRepository empregadorRepository) {

    return vagaRepository.save(form.toVaga(empregadorRepository));
  }

  public Page<VagaDto> listar(long id, Pageable paginacao) {
    if (id == 0) {
      Page<Vaga> topicos = vagaRepository.findAll(paginacao);
      return VagaDto.converter(topicos);
    } else {
      Page<Vaga> topicos = vagaRepository.findById(id, paginacao);
      return VagaDto.converter(topicos);
    }
  }

  public List<Vaga> match(long id) {

    Optional<Candidato> candidato = candidatoRepository.findById(id);
    List<Vaga> vagas = new ArrayList<Vaga>();

    if (candidato.isPresent()) {

      for (Qualificacao qualificacao : candidato.get().getQualificacao()) {

        vagas.addAll(vagaRepository.findByRequisitoAndCandidatoId(qualificacao.getHabilidades(), null));

      }
    }

    if (vagas.size() != 0) {

      return vagas;
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
  }

  public ResponseEntity<VagaDto> candidatar(long idVaga, long idCandidato) {

    Optional<Candidato> candidato = candidatoRepository.findById(idCandidato);
    Optional<Vaga> oldVaga = vagaRepository.findById(idVaga);

    if (candidato.isPresent() && oldVaga.isPresent()) {

      Vaga vaga = oldVaga.get();

      vaga.setCandidato(candidato.get());
      vaga.setStatus(StatusVagaEnum.MATCH);

      vagaRepository.save(vaga);

      return new ResponseEntity<VagaDto>(new VagaDto(vaga), HttpStatus.OK);

    }

    else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
  }

}
