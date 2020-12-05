package src.classes;

public class Laboratorio {
  private String nome;
  private String instituicao;
  private String nomeAdm;
  private String emailAdm;
  private String senhaAdm;

  public Laboratorio(String nome, String instituicao, String nomeAdm, String emailAdm, String senhaAdm) {
    this.nome = nome;
    this.instituicao = instituicao;
    this.nomeAdm = nomeAdm;
    this.emailAdm = emailAdm;
    this.senhaAdm = senhaAdm;
  }

  public String getNome() {
    return nome;
  }

  public String getInstituicao() {
    return instituicao;
  }

  public String getNomeAdm() {
    return nomeAdm;
  }

  public String getEmailAdm() {
    return emailAdm;
  }

  public String getSenhaAdm() {
    return senhaAdm;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setInstituicao(String instituicao) {
    this.instituicao = instituicao;
  }

  public void setNomeAdm(String nomeAdm) {
    this.nomeAdm = nomeAdm;
  }

  public void setEmailAdm(String emailAdm) {
    this.emailAdm = emailAdm;
  }

  public void setSenhaAdm(String senhaAdm) {
    this.senhaAdm = senhaAdm;
  }

}
