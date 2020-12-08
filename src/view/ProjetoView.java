package src.view;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.stream.Collectors;

import src.model.*;

public class ProjetoView {
  public void relatorio(Projeto projeto) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Mostrando dados do projeto de ID " + projeto.getId() + ":");

    System.out.println();

    System.out.println(" * Status atual: " + projeto.getStatus().getDescricao());

    System.out.println();

    System.out.println(" - Titulo: " + projeto.getTitulo());
    System.out.println(" - Data de inicio: " + sdf.format(projeto.getDataInicio()));
    System.out.println(" - Data de termino: " + sdf.format(projeto.getDataTermino()));
    System.out.println(" - Agencia Financiadora: " + projeto.getAgenciaFinanciadora());
    System.out.println(" - Valor Financiado: R$ " + projeto.getValorFinanciado());
    System.out.println();
    System.out.println(" - Objetivo: ");
    System.out.println(projeto.getObjetivo());
    System.out.println();
    System.out.println(" - Descricao: ");
    System.out.println(projeto.getDescricao());

    System.out.println();

    System.out.println("Colaboradores alocados:");

    System.out.println();

    System.out.println("Tipo         |  Nome");
    System.out.println("--------------------");

    projeto.getColaboradores().stream().sorted(Comparator.comparing(Colaborador::getNome)).collect(Collectors.toList())
        .forEach(colaborador -> System.out
            .println(String.format("%-13s", colaborador.getTipo().getDescricao()) + "|  " + colaborador.getNome()));

    System.out.println();

    if (projeto.getPublicacoes().size() > 0) {
      System.out.println("Publicacoes associadas:");

      System.out.println();

      System.out.println("Ano   |  Conferencia             |  Titulo");
      System.out.println("-------------------------------------------");

      projeto.getPublicacoes().stream().sorted(Comparator.comparing(Publicacao::getAnoPublicacao).reversed())
          .collect(Collectors.toList()).forEach(publicacao -> System.out.println(publicacao.getAnoPublicacao() + "  |  "
              + String.format("%-24s", publicacao.getNomeConferencia()) + "|  " + publicacao.getTitulo()));
    } else {
      System.out.println("Nao existem publicacoes associadas.");
    }
  }
}
