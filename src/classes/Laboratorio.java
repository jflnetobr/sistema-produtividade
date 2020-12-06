package src.classes;

import java.util.ArrayList;

public class Laboratorio {
  private String nome;
  private String instituicao;
  private String nomeAdm;
  private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
  private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
  private ArrayList<ProducaoAcademica> producoesAcademicas = new ArrayList<ProducaoAcademica>();

  public Laboratorio(String nome, String instituicao, String nomeAdm) {
    this.nome = nome;
    this.instituicao = instituicao;
    this.nomeAdm = nomeAdm;
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

  public ArrayList<Colaborador> getColaboradores() {
    return colaboradores;
  }

  public ArrayList<Projeto> getProjetos() {
    return projetos;
  }

  public ArrayList<ProducaoAcademica> getProducoesAcademicas() {
    return producoesAcademicas;
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

  public void setColaboradores(ArrayList<Colaborador> colaboradores) {
    this.colaboradores = colaboradores;
  }

  public void setProjetos(ArrayList<Projeto> projetos) {
    this.projetos = projetos;
  }

  public void setProducoesAcademicas(ArrayList<ProducaoAcademica> producoesAcademicas) {
    this.producoesAcademicas = producoesAcademicas;
  }

  public void adicionaColaborador(Colaborador colaborador) {
    this.colaboradores.add(colaborador);
  }

  public void adicionaProjeto(Projeto projeto) {
    this.projetos.add(projeto);
  }

  public void adicionaProducaoAcademica(ProducaoAcademica producaoAcademica) {
    this.producoesAcademicas.add(producaoAcademica);
  }
}