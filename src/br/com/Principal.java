package br.com;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws SQLException {
        boolean ligado = true;

        while (ligado){

            System.out.println("CONTROLE DE CARTEIRA");
            System.out.println();
            System.out.println("1 - Visualizar Todos os Registros");
            System.out.println("Receitas------------------------");
            System.out.println("2 - Visualizar receitas");
            System.out.println("3 - Adicionar receita");
            System.out.println("4 - Deletar receita");
            System.out.println("Despesas------------------------");
            System.out.println("5 - Visualizar despesas");
            System.out.println("6 - Adicionar despesa");
            System.out.println("7 - Deletar despesa");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Digite a opção desejada:");

            Scanner entrada = new Scanner(System.in);
            String num = entrada.nextLine();


            switch (num) {

                case "1" -> {
                    ReceitaUI.listarTodasReceitas();
                    System.out.println("---------------------------------");
                    DespesaUI.listarTodasDespesas();
                    System.out.println();
                    System.out.println();


                    System.out.println("---------------------------------");
                    System.out.println("(aperte enter para voltar ao menu)");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();

                }

                case "2" -> {
                    ReceitaUI.listarTodasReceitas();
                    System.out.println();
                    System.out.println();

                    System.out.println("---------------------------------");
                    System.out.println("(aperte enter para voltar ao menu)");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();
                }

                case "3" -> {
                    ReceitaUI.adicionarReceitas();
                    System.out.println();
                    System.out.println();

                    System.out.println("---------------------------------");
                    System.out.println("(aperte enter para voltar ao menu)");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();
                }

                case "4" -> {
                    ReceitaUI.deletarReceitas();
                    System.out.println();
                    System.out.println();

                    System.out.println("---------------------------------");
                    System.out.println("(aperte enter para voltar ao menu)");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();

                }

                case "5" -> {
                    DespesaUI.listarTodasDespesas();
                    System.out.println();
                    System.out.println();

                    System.out.println("---------------------------------");
                    System.out.println("(aperte enter para voltar ao menu)");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();

                }

                case "6" -> {
                    DespesaUI.adicionarDespesas();
                    System.out.println();
                    System.out.println();


                    System.out.println("---------------------------------");
                    System.out.println("(aperte enter para voltar ao menu)");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();

                }

                case "7" -> {
                    DespesaUI.deletarDespesas();
                    System.out.println();
                    System.out.println();

                    System.out.println("---------------------------------");
                    System.out.println("(aperte enter para voltar ao menu)");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();


                }

                case "0" -> {
                    ligado = false;
                    System.out.println("Saindo.");

                }

                default -> {
                    System.out.println("--------------------------------Erro: opção inválida");
                }

            }

        }

    }
}

