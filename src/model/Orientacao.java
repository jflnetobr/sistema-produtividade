package src.model;

import java.util.ArrayList;

import src.model.enums.TipoProducao;

public class Orientacao extends ProducaoAcademica {
  private Colaborador orientador;
  private ArrayList<Colaborador> orientados = new ArrayList<Colaborador>();

  public Orientacao(int id, String titulo, int anoPublicacao, Colaborador orientador) {
    super(id, titulo, anoPublicacao, TipoProducao.O);
    this.orientador = orientador;
  }

  public Colaborador getOrientador() {
    return orientador;
  }

  public ArrayList<Colaborador> getOrientados() {
    return orientados;
  }

  public void setOrientador(Colaborador orientador) {
    this.orientador = orientador;
  }

  public void setOrientados(ArrayList<Colaborador> orientados) {
    this.orientados = orientados;
  }

  public boolean adicionaOrientado(Colaborador orientado) {
    if (!orientados.contains(orientado)) {
      orientados.add(orientado);
      orientado.adicionaProducaoAcademica(this);
      return true;
    }
    return false;
  }
}
