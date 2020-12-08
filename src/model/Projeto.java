package src.model;

import java.util.ArrayList;

import src.model.enums.*;

public class Projeto {
  private int id;
  private String titulo;
  private String dataInicio;
  private String dataTermino;
  private String agenciaFinanciadora;
  private float valorFinanciado;
  private String objetivo;
  private String descricao;
  private Status status;
  private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
  private ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();

  public Projeto(int id, String titulo, Colaborador responsavel) {
    this.id = id;
    this.titulo = titulo;
    this.status = Status.E;
    colaboradores.add(responsavel);
  }

  public Projeto(int id, String titulo, String dataInicio, String dataTermino, String agenciaFinanciadora,
      float valorFinanciado, String objetivo, String descricao, Colaborador responsavel) {
    this.id = id;
    this.titulo = titulo;
    this.dataInicio = dataInicio;
    this.dataTermino = dataTermino;
    this.agenciaFinanciadora = agenciaFinanciadora;
    this.valorFinanciado = valorFinanciado;
    this.objetivo = objetivo;
    this.descricao = descricao;
    this.status = Status.E;
    colaboradores.add(responsavel);
  }

  public int getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDataInicio() {
    return dataInicio;
  }

  public String getDataTermino() {
    return dataTermino;
  }

  public String getAgenciaFinanciadora() {
    return agenciaFinanciadora;
  }

  public float getValorFinanciado() {
    return valorFinanciado;
  }

  public String getObjetivo() {
    return objetivo;
  }

  public String getDescricao() {
    return descricao;
  }

  public Status getStatus() {
    return status;
  }

  public ArrayList<Colaborador> getColaboradores() {
    return colaboradores;
  }

  public ArrayList<Publicacao> getPublicacoes() {
    return publicacoes;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setDataInicio(String dataInicio) {
    this.dataInicio = dataInicio;
  }

  public void setDataTermino(String dataTermino) {
    this.dataTermino = dataTermino;
  }

  public void setAgenciaFinanciadora(String agenciaFinanciadora) {
    this.agenciaFinanciadora = agenciaFinanciadora;
  }

  public void setValorFinanciado(float valorFinanciado) {
    this.valorFinanciado = valorFinanciado;
  }

  public void setObjetivo(String objetivo) {
    this.objetivo = objetivo;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setColaboradores(ArrayList<Colaborador> colaboradores) {
    this.colaboradores = colaboradores;
  }

  public void setPublicacoes(ArrayList<Publicacao> publicacoes) {
    this.publicacoes = publicacoes;
  }

  public void adicionaPublicacao(Publicacao publicacao) {
    this.publicacoes.add(publicacao);
  }

  public String complementarDados(String dataInicio, String dataTermino, String agenciaFinanciadora,
      float valorFinanciado, String objetivo, String descricao) {
    if (this.dataInicio == null && this.dataTermino == null && this.agenciaFinanciadora == null
        && this.valorFinanciado == 0 && this.objetivo == null && this.descricao == null) {
      this.dataInicio = dataInicio;
      this.dataTermino = dataTermino;
      this.agenciaFinanciadora = agenciaFinanciadora;
      this.valorFinanciado = valorFinanciado;
      this.objetivo = objetivo;
      this.descricao = descricao;
      return "";
    }
    return "O Projeto já tem todas as informações básicas";
  }

  public String avancaStatus() {
    if (status == Status.E) {
      if (this.dataInicio != null && this.dataTermino != null && this.agenciaFinanciadora != null
          && this.valorFinanciado != 0 && this.objetivo != null && this.descricao != null) {
        for (int i = 0; i < colaboradores.size(); i++) {
          if (colaboradores.get(1).getTipo() == TipoColaborador.G) {
            if (colaboradores.get(1).getProjetos().stream().filter(projeto -> projeto.getStatus() == Status.A)
                .count() >= 2) {
              return "Um ou mais Graduandos da equipe está(ão) alocado(s) em dois projetos em andamento";
            }
          }
        }
        this.status = Status.A;
        return "";
      }
      return "As informações básicas do projeto não estão presentes";
    } else if (status == Status.A) {
      if (publicacoes.size() > 0) {
        this.status = Status.C;
        return "";
      }
      return "Não existem publicações associadas ao projeto";
    }
    return "O projeto já foi concluído";
  }

  public String alocaParticipante(Colaborador participante) {
    if (status == Status.E) {
      if (!colaboradores.contains(participante)) {
        colaboradores.add(participante);
        participante.adicionaProjeto(this);
        return "";
      }
      return "O colaborador informado já está alocado no projeto";
    }
    return "Não é possível alocar colaboradores, pois o projeto não está mais em elaboração";
  }

  public String associaPublicacao(Publicacao publicacao) {
    if (status == Status.A) {
      if (publicacoes.contains(publicacao)) {
        publicacoes.add(publicacao);
        publicacao.setProjeto(this);
        return "";
      }
      return "A publicação informada já está associada ao Projeto";
    }
    return "Não foi possível associar a publicação, pois o projeto não está em andamento";
  }
}
