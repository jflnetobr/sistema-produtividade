package src.classes.enums;

public enum TipoProducao {
  P("Publicação"), O("Orientação");

  private final String descricao;

  TipoProducao(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }
}
