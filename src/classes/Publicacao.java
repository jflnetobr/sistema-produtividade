package src.classes;

import src.classes.enums.TipoProducao;

public class Publicacao extends ProducaoAcademica {
  private String nomeConferencia;

  public Publicacao(int id, String titulo, int anoPublicacao, TipoProducao tipo, String nomeConferencia) {
    super(id, titulo, anoPublicacao, tipo);
    this.nomeConferencia = nomeConferencia;
  }

  public String getNomeConferencia() {
    return nomeConferencia;
  }

  public void setNomeConferencia(String nomeConferencia) {
    this.nomeConferencia = nomeConferencia;
  }
}
