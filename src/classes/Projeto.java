package src.classes;

import src.classes.enums.Status;

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

  public Projeto(int id, String titulo, String dataInicio, String dataTermino, String agenciaFinanciadora,
      float valorFinanciado, String objetivo, String descricao, Status status) {

    this.id = id;
    this.titulo = titulo;
    this.dataInicio = dataInicio;
    this.dataTermino = dataTermino;
    this.agenciaFinanciadora = agenciaFinanciadora;
    this.valorFinanciado = valorFinanciado;
    this.objetivo = objetivo;
    this.descricao = descricao;
    this.status = status;
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
}
