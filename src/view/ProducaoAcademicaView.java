package src.view;

import java.util.Comparator;
import java.util.stream.Collectors;

import src.model.*;
import src.model.enums.TipoProducao;

public class ProducaoAcademicaView {
  public void relatorio(ProducaoAcademica producaoAcademica) {
    System.out.println("Mostrando dados da producao academica de ID " + producaoAcademica.getId() + ":");

    System.out.println();

    System.out.println(" * Tipo: " + producaoAcademica.getTipo().getDescricao());

    System.out.println();

    if (producaoAcademica.getTipo() == TipoProducao.P) {
      Publicacao p = (Publicacao) producaoAcademica;
      System.out.println(" - Titulo: " + p.getTitulo());
      System.out.println(" - Ano de publicacao: " + p.getAnoPublicacao());
      System.out.println(" - Nome da conferencia: " + p.getNomeConferencia());

      System.out.println();

      if (p.getProjeto() != null) {
        System.out.println(" * Projeto: " + p.getProjeto().getTitulo());
      } else {
        System.out.println(" * A publicacao nao foi associada a nenhum projeto");
      }

      System.out.println();

      if (p.getAutores().size() > 0) {
        System.out.println("Autores:");

        System.out.println();

        System.out.println("Tipo         |  Nome");
        System.out.println("--------------------");

        p.getAutores().stream().sorted(Comparator.comparing(Colaborador::getNome)).collect(Collectors.toList())
            .forEach(colaborador -> System.out
                .println(String.format("%-13s", colaborador.getTipo().getDescricao()) + "|  " + colaborador.getNome()));
      } else {
        System.out.println(" * Os autores ainda nao foram cadastrados");
      }
    } else {
      Orientacao o = (Orientacao) producaoAcademica;
      System.out.println(" - Titulo: " + o.getTitulo());
      System.out.println(" - Ano de publicacao: " + o.getAnoPublicacao());

      System.out.println();

      System.out.println(" * Orientador: " + o.getOrientador().getNome());

      System.out.println();

      if (o.getOrientados().size() > 0) {
        System.out.println("Orientados:");

        System.out.println();

        System.out.println("Tipo         |  Nome");
        System.out.println("--------------------");

        o.getOrientados().stream().sorted(Comparator.comparing(Colaborador::getNome)).collect(Collectors.toList())
            .forEach(colaborador -> System.out
                .println(String.format("%-13s", colaborador.getTipo().getDescricao()) + "|  " + colaborador.getNome()));
      } else {
        System.out.println(" * Os orientados ainda nao foram cadastrados");
      }
    }
  }
}
