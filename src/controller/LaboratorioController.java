package src.controller;

import java.util.ArrayList;

import src.model.*;
import src.model.enums.*;

public class LaboratorioController {
  private Laboratorio lab;

  public boolean criarLaboratorio(String nome, String instituicao, String nomeAdm) {
    lab = new Laboratorio(nome, instituicao, nomeAdm);
    return true;
  }

  public boolean criarColaborador(String nome, String email, int tipo) {
    TipoColaborador t;

    switch (tipo) {
      case 1:
        t = TipoColaborador.G;
        break;
      case 2:
        t = TipoColaborador.M;
        break;
      case 3:
        t = TipoColaborador.D;
        break;
      case 4:
        t = TipoColaborador.Prof;
        break;
      case 5:
        t = TipoColaborador.Pesq;
        break;
      default:
        return false;
    }

    lab.adicionaColaborador(new Colaborador(lab.getColaboradores().size() + 1, nome, email, t));

    return true;
  }

  public boolean criarProjetoResumido(String titulo, int idResponsavel) {
    if (lab.getColaboradores().get(idResponsavel - 1).getTipo() == TipoColaborador.Prof) {
      lab.adicionaProjeto(new Projeto(lab.getProjetos().size() + 1, titulo, lab.getColaboradores().get(idResponsavel)));
      return true;
    }
    return false;
  }

  public boolean criarProjetoCompleto(String titulo, String dataInicio, String dataTermino, String agenciaFinanciadora,
      float valorFinanciado, String objetivo, String descricao, int idResponsavel) {
    if (lab.getColaboradores().get(idResponsavel - 1).getTipo() == TipoColaborador.Prof) {
      lab.adicionaProjeto(new Projeto(lab.getProjetos().size() + 1, titulo, dataInicio, dataTermino,
          agenciaFinanciadora, valorFinanciado, objetivo, descricao, lab.getColaboradores().get(idResponsavel)));
      return true;
    }
    return false;
  }

  public boolean criarPublicacao(String titulo, int anoPublicacao, String nomeConferencia) {
    lab.adicionaProducaoAcademica(
        new Publicacao(lab.getProducoesAcademicas().size() + 1, titulo, anoPublicacao, nomeConferencia));
    return true;
  }

  public boolean criarOrientacao(String titulo, int anoPublicacao, int idOrientador) {
    if (lab.getColaboradores().get(idOrientador - 1).getTipo() == TipoColaborador.Prof) {
      lab.adicionaProducaoAcademica(new Orientacao(lab.getProducoesAcademicas().size() + 1, titulo, anoPublicacao,
          lab.getColaboradores().get(idOrientador)));
      return true;
    }

    return false;
  }

  public ArrayList<Colaborador> buscaColaboradores(String termo) {
    ArrayList<Colaborador> result = new ArrayList<Colaborador>();

    lab.getColaboradores().forEach(colaborador -> {
      if (colaborador.getNome().matches("(?i).*" + termo + ".*")
          || colaborador.getEmail().matches(".*" + termo + ".*")) {
        result.add(colaborador);
      }
    });

    return result;
  }

  public ArrayList<Projeto> buscaProjetos(String termo) {
    ArrayList<Projeto> result = new ArrayList<Projeto>();

    lab.getProjetos().forEach(projeto -> {
      if (projeto.getTitulo().matches("(?i).*" + termo + ".*")
          || projeto.getDescricao().matches("(?i).*" + termo + ".*")
          || projeto.getAgenciaFinanciadora().matches("(?i).*" + termo + ".*")) {
        result.add(projeto);
      }
    });

    return result;
  }

  public ArrayList<ProducaoAcademica> buscaProducaoAcademica(String termo) {
    ArrayList<ProducaoAcademica> result = new ArrayList<ProducaoAcademica>();

    lab.getProducoesAcademicas().forEach(producaoAcademica -> {
      if (producaoAcademica.getTitulo().matches("(?i).*" + termo + ".*")) {
        result.add(producaoAcademica);
      }
    });

    return result;
  }
}
