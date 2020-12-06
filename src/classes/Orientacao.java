package src.classes;

import java.util.ArrayList;

import src.classes.enums.TipoProducao;

public class Orientacao extends ProducaoAcademica {
  private Colaborador professor;
  private ArrayList<Colaborador> alunos = new ArrayList<Colaborador>();

  public Orientacao(int id, String titulo, int anoPublicacao, Colaborador professor) {
    super(id, titulo, anoPublicacao, TipoProducao.O);
    this.professor = professor;
  }

  public Colaborador getProfessor() {
    return professor;
  }

  public ArrayList<Colaborador> getAlunos() {
    return alunos;
  }

  public void setProfessor(Colaborador professor) {
    this.professor = professor;
  }

  public void setAlunos(ArrayList<Colaborador> alunos) {
    this.alunos = alunos;
  }

  public void adicionaAluno(Colaborador aluno) {
    this.alunos.add(aluno);
  }
}
