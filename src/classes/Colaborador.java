package src.classes;

import src.classes.enums.TipoColaborador;

public class Colaborador {
  private int id;
  private String nome;
  private String email;
  private TipoColaborador tipo;

  public Colaborador(int id, String nome, String email, TipoColaborador tipo) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.tipo = tipo;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public TipoColaborador getTipo() {
    return tipo;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setTipo(TipoColaborador tipo) {
    this.tipo = tipo;
  }
}
