package src.view;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import src.model.*;
import src.model.enums.*;
import src.util.Util;

public class ProjetoView {
  public static void menuProjetos(Laboratorio lab, Scanner scanner) {
    Util.clrscr();

    loop: while (true) {
      System.out.println("Menu principal > Gerenciamento de projetos");

      System.out.println();

      System.out.println("Escolha uma opcao para continuar:");

      System.out.println();

      System.out.println(" [ 1 ] Cadastrar projeto");
      System.out.println(" [ 2 ] Gerenciar projeto existente");
      System.out.println(" [ 3 ] Listar projetos do laboratorio");
      System.out.println(" [ 4 ] Voltar para o menu principal");

      System.out.println();

      System.out.print(" - Digite sua opcao: ");
      String op = scanner.nextLine();

      switch (op) {
        case "1":
          Util.clrscr();
          if (lab.getColaboradores().stream().filter(colaborador -> colaborador.getTipo() == TipoColaborador.Prof)
              .count() > 0) {
            System.out.println("Para cadastrar um novo projeto, informe os dados pedidos:");

            System.out.println();

            System.out.print(" - Titulo do projeto: ");
            String titulo = scanner.nextLine();
            System.out.print(" - ID do professor responsavel (numero): ");
            String idResponsavel = scanner.nextLine();
            System.out.print("Deseja informar os outros dados do projeto agora? (S/N): ");
            String op2 = scanner.nextLine();

            String r;

            switch (op2) {
              case "S":
                System.out.print(" - Data de inicio do projeto: ");
                String dataInicio = scanner.nextLine();
                System.out.print(" - Data de termino do projeto: ");
                String dataTermino = scanner.nextLine();
                System.out.print(" - Agencia financiadora: ");
                String agenciaFinanciadora = scanner.nextLine();
                System.out.print(" - Valor financiado (apenas numeros, separe os centavos com .): R$ ");
                String valorFinanciado = scanner.nextLine();
                System.out.print(" - Ojetivo: ");
                String objetivo = scanner.nextLine();
                System.out.print(" - Descricao: ");
                String descricao = scanner.nextLine();

                if (idResponsavel.matches("-?\\d+")) {
                  if (Integer.parseInt(idResponsavel) <= lab.getColaboradores().size()
                      && Integer.parseInt(idResponsavel) > 0) {
                    r = lab.criarProjetoCompleto(titulo, dataInicio, dataTermino, agenciaFinanciadora,
                        Float.parseFloat(valorFinanciado), objetivo, descricao, Integer.parseInt(idResponsavel));
                  } else {
                    r = "O ID informado nao pertence a nenhum colaborador";
                  }
                } else {
                  r = "Opcao invalida! Tente novamente";
                }

                if (r == "") {
                  menuAlocarColaboradores(lab, scanner, lab.getProjeto(lab.getProjetos().size()));
                }
                break;
              default:
                if (idResponsavel.matches("-?\\d+")) {
                  if (Integer.parseInt(idResponsavel) <= lab.getColaboradores().size()
                      && Integer.parseInt(idResponsavel) > 0) {
                    r = lab.criarProjetoResumido(titulo, Integer.parseInt(idResponsavel));
                  } else {
                    r = "O ID informado nao pertence a nenhum colaborador";
                  }
                } else {
                  r = "Opcao invalida! Tente novamente";
                }

                Util.clrscr();
            }

            if (r != "") {
              Util.clrscr();
            }
            System.out.println(r == "" ? "Projeto criado com sucesso!" : r);
            System.out.println();
          } else {
            Util.clrscr();
            System.out.println("Ainda nao existem professores cadastrados. Cadastre um professor para continuar");
            System.out.println();
          }
          break;
        case "2":
          Util.clrscr();
          if (lab.getProjetos().size() > 0) {
            System.out.print(" - Digite o ID do projeto desejado: ");
            String op2 = scanner.nextLine();

            if (op2.matches("-?\\d+")) {
              if (Integer.parseInt(op2) <= lab.getProjetos().size() && Integer.parseInt(op2) > 0) {
                menuGerenciarProjetoExistente(lab, scanner, lab.getProjeto(Integer.parseInt(op2)));
              } else {
                Util.clrscr();
                System.out.println("O ID informado nao pertence a nenhum projeto");
                System.out.println();
              }
            } else {
              System.out.println("ID invalido! Tente novamente");
              System.out.println();
            }
          } else {
            System.out.println("Nao existem projetos cadastrados");
            System.out.println();
          }
          break;
        case "3":
          Util.clrscr();
          LaboratorioView.relatorioProjetos(lab);
          System.out.println();
          System.out.println("Pressione ENTER para continuar...");
          scanner.nextLine();
          Util.clrscr();
          break;
        case "4":
          break loop;
        default:
          Util.clrscr();
          System.out.println("Opcao invalida! Tente novamente");
          System.out.println();
      }
    }
  }

  public static void menuGerenciarProjetoExistente(Laboratorio lab, Scanner scanner, Projeto projeto) {
    Util.clrscr();

    loop: while (true) {
      System.out.println("Menu principal > Gerenciamento de projetos > Gerenciar projeto existente");

      System.out.println();

      System.out.println("Gerenciando o projeto " + projeto.getId() + " - " + projeto.getTitulo()
          + ". Escolha uma opcao para continuar:");

      System.out.println();

      System.out.println(" * Status: " + projeto.getStatus().getDescricao());

      System.out.println();

      System.out.println(" [ 1 ] Avancar status");
      System.out.println(" [ 2 ] Alocar colaboradores");
      System.out.println(" [ 3 ] Associar publicacoes");
      System.out.println(" [ 4 ] Complementar os dados do projeto");
      System.out.println(" [ 5 ] Visualizar relatorio do projeto");
      System.out.println(" [ 6 ] Voltar para o gerenciamento de projetos");

      System.out.println();

      System.out.print(" - Digite sua opcao: ");
      String op = scanner.nextLine();

      switch (op) {
        case "1":
          Util.clrscr();
          String r = projeto.avancaStatus();
          Util.clrscr();
          System.out
              .println(r == "" ? "Status alterado para " + projeto.getStatus().getDescricao() + " com sucesso!" : r);
          System.out.println();
          break;
        case "2":
          Util.clrscr();
          if (projeto.getStatus() == Status.E) {
            menuAlocarColaboradores(lab, scanner, projeto);
          } else {
            Util.clrscr();
            System.out.println("Nao e possivel alocar colaboradores: o projeto nao esta em elaboracao");
            System.out.println();
          }
          break;
        case "3":
          Util.clrscr();
          if (projeto.getStatus() == Status.A) {
            menuAssociarPublicacao(lab, scanner, projeto);
          } else {
            Util.clrscr();
            System.out.println("Nao e possivel associar publicacoes: o projeto nao esta em andamento");
            System.out.println();
          }
          break;
        case "4":
          Util.clrscr();
          if (projeto.getDataInicio() == null && projeto.getDataTermino() == null
              && projeto.getAgenciaFinanciadora() == null && projeto.getValorFinanciado() == 0
              && projeto.getObjetivo() == null && projeto.getDescricao() == null) {
            System.out.println("Informe os dados pedidos:");

            System.out.println();

            System.out.print(" - Data de inicio do projeto: ");
            String dataInicio = scanner.nextLine();
            System.out.print(" - Data de termino do projeto: ");
            String dataTermino = scanner.nextLine();
            System.out.print(" - Agencia financiadora: ");
            String agenciaFinanciadora = scanner.nextLine();
            System.out.print(" - Valor financiado (apenas numeros, separe os centavos com .): R$ ");
            String valorFinanciado = scanner.nextLine();
            System.out.print(" - Ojetivo: ");
            String objetivo = scanner.nextLine();
            System.out.print(" - Descricao: ");
            String descricao = scanner.nextLine();

            r = projeto.complementarDados(dataInicio, dataTermino, agenciaFinanciadora,
                Float.parseFloat(valorFinanciado), objetivo, descricao);

            Util.clrscr();
            System.out.println(r == "" ? "Dados atualizados com sucesso!" : r);
            System.out.println();
          } else {
            Util.clrscr();
            System.out.println("As informacoes basicas do projeto ja foram cadastradas");
            System.out.println();
          }
          break;
        case "5":
          Util.clrscr();
          relatorio(projeto);
          System.out.println();
          System.out.println("Pressione ENTER para continuar...");
          scanner.nextLine();
          Util.clrscr();
          break;
        case "6":
          Util.clrscr();
          break loop;
        default:
          Util.clrscr();
          System.out.println("Opcao invalida! Tente novamente");
          System.out.println();
      }
    }
  }

  public static void menuAlocarColaboradores(Laboratorio lab, Scanner scanner, Projeto projeto) {
    if (lab.getColaboradores().size() > 0) {
      loopColaboradores: while (true) {
        System.out.println();

        System.out.print(" - Digite o ID de um colaborador para alocar no projeto ou P para encerrar: ");
        String op = scanner.nextLine();

        switch (op) {
          case "P":
            Util.clrscr();
            break loopColaboradores;
          default:
            if (op.matches("-?\\d+")) {
              String r;
              if (Integer.parseInt(op) <= lab.getColaboradores().size() && Integer.parseInt(op) > 0) {
                r = projeto.alocaParticipante(lab.getColaborador(Integer.parseInt(op)));
              } else {
                r = "O ID informado nao pertence a nenhum colaborador";
              }
              System.out.println();
              System.out.println(r == "" ? "Colaborador alocado com sucesso!" : r);
            } else {
              Util.clrscr();
              System.out.println("Opcao invalida! Tente novamente");
              System.out.println();
            }
        }
      }
    } else {
      Util.clrscr();
      System.out
          .println("Nao existem colaboradores cadastrados. Cadastre colaboradores antes de alocar neste projeto.");
      System.out.println();
    }
  }

  public static void menuAssociarPublicacao(Laboratorio lab, Scanner scanner, Projeto projeto) {
    if (lab.getProducoesAcademicas().stream().filter(producaoAcademica -> producaoAcademica.getTipo() == TipoProducao.P)
        .count() > 0) {
      loopPublicacoes: while (true) {
        System.out.println();

        System.out.print(" - Digite o ID de uma publicacao para associar ao projeto ou P para encerrar: ");
        String op = scanner.nextLine();

        switch (op) {
          case "P":
            Util.clrscr();
            break loopPublicacoes;
          default:
            if (op.matches("-?\\d+")) {
              String r;
              if (Integer.parseInt(op) <= lab.getProducoesAcademicas().size() && Integer.parseInt(op) > 0) {
                if (lab.getProducaoAcademica(Integer.parseInt(op)).getTipo() != TipoProducao.P) {
                  r = projeto.associaPublicacao((Publicacao) lab.getProducaoAcademica(Integer.parseInt(op)));
                } else {
                  r = "O ID informado nao pertence a uma publicacao";
                }
              } else {
                r = "O ID informado nao pertence a nenhuma producao academica";
              }
              System.out.println();
              System.out.println(r == "" ? "Publicacao associada com sucesso!" : r);
            } else {
              Util.clrscr();
              System.out.println("Opcao invalida! Tente novamente");
              System.out.println();
            }
        }
      }
    } else {
      Util.clrscr();
      System.out.println("Nao existem publicacoes cadastradas. Cadastre publicacoes antes de associar a este projeto.");
      System.out.println();
    }
  }

  public static void relatorio(Projeto projeto) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Mostrando dados do projeto de ID " + projeto.getId() + ":");

    System.out.println();

    System.out.println(" * Status atual: " + projeto.getStatus().getDescricao());

    System.out.println();

    System.out.println(" - Titulo: " + projeto.getTitulo());
    System.out.println(" - Data de inicio: "
        + (projeto.getDataInicio() != null ? sdf.format(projeto.getDataInicio()) : "Desconhecida"));
    System.out.println(" - Data de termino: "
        + (projeto.getDataTermino() != null ? sdf.format(projeto.getDataTermino()) : "Desconhecida"));
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
