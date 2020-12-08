package src.view;

import src.model.*;
import src.model.enums.*;

public class LaboratorioView {
  public void relatorio(Laboratorio lab) {
    System.out.println("O laboratorio " + lab.getNome() + " da instituicao " + lab.getInstituicao()
        + " tem atualmente os seguintes numeros:");

    System.out.println();

    System.out.println(" - " + String.format("%02d", lab.getColaboradores().size()) + " Colaboradores, sendo:");
    for (TipoColaborador tipo : TipoColaborador.values()) {
      System.out.print("[ "
          + String.format("%02d",
              lab.getColaboradores().stream().filter(colaborador -> colaborador.getTipo() == tipo).count())
          + " ] " + tipo.getDescricao() + "  ");
    }

    System.out.println();
    System.out.println();

    System.out.println(" - " + String.format("%02d", lab.getProjetos().size()) + " Projetos, sendo:");
    for (Status status : Status.values()) {
      System.out.print("[ "
          + String.format("%02d", lab.getProjetos().stream().filter(projeto -> projeto.getStatus() == status).count())
          + " ] " + status.getDescricao() + "  ");
    }

    System.out.println();
    System.out.println();

    System.out
        .println(" - " + String.format("%02d", lab.getProducoesAcademicas().size()) + " Producoes Academicas, sendo:");
    for (TipoProducao tipo : TipoProducao.values()) {
      System.out
          .print("[ "
              + String
                  .format("%02d",
                      lab.getProducoesAcademicas().stream()
                          .filter(producaoAcademica -> producaoAcademica.getTipo() == tipo).count())
              + " ] " + tipo.getDescricao() + "  ");
    }

    System.out.println();
  }

  public void relatorioColaboradores(Laboratorio lab) {
    System.out.println("O laboratorio " + lab.getNome() + " possui atualmente "
        + String.format("%02d", lab.getColaboradores().size()) + " colaboradores, listados abaixo:");

    System.out.println();

    for (TipoColaborador tipo : TipoColaborador.values()) {
      System.out.print("[ "
          + String.format("%02d",
              lab.getColaboradores().stream().filter(colaborador -> colaborador.getTipo() == tipo).count())
          + " ] " + tipo.getDescricao() + "  ");
    }

    System.out.println();
    System.out.println();
    System.out.println("  ID  |     Tipo      |  Nome");
    System.out.println("--------------------------------------");

    lab.getColaboradores().forEach(colaborador -> System.out.println("  " + String.format("%02d", colaborador.getId())
        + "  |  " + String.format("%-13s", colaborador.getTipo().getDescricao()) + "|  " + colaborador.getNome()));
  }

  public void relatorioProjetos(Laboratorio lab) {
    System.out.println("O laboratorio " + lab.getNome() + " possui atualmente "
        + String.format("%02d", lab.getProjetos().size()) + " projetos, listados abaixo:");

    System.out.println();

    for (Status status : Status.values()) {
      System.out.print("[ "
          + String.format("%02d", lab.getProjetos().stream().filter(projeto -> projeto.getStatus() == status).count())
          + " ] " + status.getDescricao() + "  ");
    }

    System.out.println();
    System.out.println();
    System.out.println("  ID  |     Status      |  Titulo");
    System.out.println("--------------------------------------");

    lab.getProjetos().forEach(projeto -> System.out.println("  " + String.format("%02d", projeto.getId()) + "  |  "
        + String.format("%-15s", projeto.getStatus().getDescricao()) + "|  " + projeto.getTitulo()));
  }

  public void relatorioProducaoAcademica(Laboratorio lab) {
    System.out.println("O laboratorio " + lab.getNome() + " possui atualmente "
        + String.format("%02d", lab.getProducoesAcademicas().size()) + " producoes academicas, listadas abaixo:");

    System.out.println();

    for (TipoProducao tipo : TipoProducao.values()) {
      System.out
          .print("[ "
              + String
                  .format("%02d",
                      lab.getProducoesAcademicas().stream()
                          .filter(producaoAcademica -> producaoAcademica.getTipo() == tipo).count())
              + " ] " + tipo.getDescricao() + "  ");
    }

    System.out.println();
    System.out.println();
    System.out.println("  ID  |     Tipo     |  Ano   |  Titulo");
    System.out.println("---------------------------------------");

    lab.getProducoesAcademicas()
        .forEach(producaoAcademica -> System.out.println("  " + String.format("%02d", producaoAcademica.getId())
            + "  |  " + String.format("%-12s", producaoAcademica.getTipo().getDescricao()) + "|  "
            + producaoAcademica.getAnoPublicacao() + "  |  " + producaoAcademica.getTitulo()));
  }
}
