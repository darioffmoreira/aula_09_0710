package example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String opcao = "";

        Stand novaEntrada = new Stand();

        while(!opcao.equals("10")) {

            System.out.println("\n=== Bem-vindo ao Stand Tudo Bom e Barato! ===");
            System.out.println("                 BOA VIAGEM!                  \n");
            System.out.println("=============================================");
            System.out.println("                MENU PRINCIPAL              ");
            System.out.println("=============================================");

            System.out.println("=== Opções de Carro ===");
            System.out.println("1 - Alugar um Carro");
            System.out.println("2 - Vender um Carro");
            System.out.println("3 - Verificar Carros Disponíveis para Alugar");
            System.out.println("4 - Inserir um Novo Carro");
            System.out.println("5 - Editar Dados de um Carro");
            System.out.println("6 - Remover um Carro");
            System.out.println();
            System.out.println("=== Opções de Listagem ===");
            System.out.println("7 - Listar Carros Vendidos");
            System.out.println("8 - Listar Carros Alugados");
            System.out.println("9 - Listar Todos os Carros");
            System.out.println();
            System.out.println("=== Outras Opções ===");
            System.out.println("10 - Fechar a Aplicação\n");
            System.out.println("Por favor, indique o número da sua opção e pressione Enter:");
            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    novaEntrada.AlugarCarro();
                    break;

                case "2":
                    novaEntrada.VenderCarro();
                    break;

                case "3":
                    novaEntrada.listarCarrosDisponiveis();
                    break;

                case "4":
                    novaEntrada.inserirNovoCarro();
                    break;

                case "5":
                    novaEntrada.EditarCarro();
                    break;

                case "6":
                    novaEntrada.RemoverCarro();
                    break;

                case "7":
                    novaEntrada.ListarCarrosVendidos();
                    break;

                case "8":
                    novaEntrada.ListarCarrosCompleta();
                    break;

                case "9":
                    novaEntrada.ListarCarros();
                    break;

                case "10":
                    System.out.println("Obrigado e até manhã!!\n");
                    break;

                default:
                    System.out.println("Opcao invalida!!\n");
            }
        }
        ler.close();
    }
}
