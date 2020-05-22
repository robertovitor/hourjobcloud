package br.com.hourjob.model;

import javax.persistence.*;

@Entity
public class RequisitosVaga {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private Candidato candidato;
  @OneToOne
  private Vaga vaga;
  private String escolaridade;
  private String experiencias;
  private String habilidades;

}
