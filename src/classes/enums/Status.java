package src.classes.enums;

public enum Status {
  E("Elaboração"), A("Em Andamento"), C("Concluído");

  private final String descricao;

  Status(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }
}
