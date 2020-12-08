package src.view;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.stream.Collectors;

import src.model.*;

public class ColaboradorView {
  public void relatorio(Colaborador colaborador) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Mostrando dados do colaborador de ID " + colaborador.getId() + ":");

    System.out.println();

    System.out.println(" - Nome: " + colaborador.getNome());
    System.out.println(" - Email: " + colaborador.getEmail());
    System.out.println(" - Tipo: " + colaborador.getTipo().getDescricao());

    System.out.println();

    if (colaborador.getProjetos().size() > 0) {

      System.out.println("Historico de Projetos:");

      System.out.println();

      System.out.println("Status         |  Data de termino  |  Titulo");
      System.out.println("--------------------------------------------");

      colaborador.getProjetos().stream().filter(projeto -> projeto.getDataTermino() == null)
          .forEach(projeto -> System.out.println(String.format("%-15s", projeto.getStatus().getDescricao())
              + "|    Desconhecido   |  " + projeto.getTitulo()));

      colaborador.getProjetos().stream().filter(projeto -> projeto.getDataTermino() != null)
          .sorted(Comparator.comparing(Projeto::getDataTermino).reversed()).collect(Collectors.toList())
          .forEach(projeto -> System.out.println(String.format("%-15s", projeto.getStatus().getDescricao()) + "|     "
              + sdf.format(projeto.getDataTermino()) + "    |  " + projeto.getTitulo()));
    } else {
      System.out.println("O colaborador nao foi alocado em nenhum projeto ainda.");
    }
  }
}
