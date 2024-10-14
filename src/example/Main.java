package example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String opcao = "";

        Stand novaEntrada = new Stand();

        while(!opcao.equals("10")) {

            System.out.println("\nStandTudoBomEBarato - BOA VIAGEM");
            System.out.println("1 - Aluguer de Carro");
            System.out.println("2 - Venda de Carro");
            System.out.println("3 - Verificar Carros | Alugar");
            System.out.println("4 - Inseir novo Carro");
            System.out.println("5 - Editar dados | Carro");
            System.out.println("6 - Remover Carro");
            System.out.println("7 - Listar Carros Vendidos");
            System.out.println("8 - Listar Carros Alugados");
            System.out.println("9 - Listar todos Carros\n");
            System.out.println("10 - Fechar Aplicação\n");

            System.out.println("Indique a sua opção!");
            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    novaEntrada.AlugarCarro();
                    break;

                case "2":
                    novaEntrada.VenderCarro();
                    break;

                case "4":
                    novaEntrada.inserirNovoCarro();
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
