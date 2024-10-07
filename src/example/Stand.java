package example;

import java.util.ArrayList;
import java.util.Scanner;

public class Stand {

    private ArrayList<Carro> stockCarro = new ArrayList<>();

    Scanner ler = new Scanner(System.in);
    Scanner lerN = new Scanner(System.in);

    public Stand() {

    }

    // metodo: Inseir Novo Carro
    public void inserirNovoCarro() {

        // garantir que a matricula é unica
        boolean matriculaUnica = false;

        System.out.println("Indique a matricula do carro:");
        String matricula = ler.nextLine();

        for (int i = 0; i < stockCarro.size(); i++) {
            Carro listarCarro = stockCarro.get(i);
            if(listarCarro.getMatricula().equals(matricula)) {
                matriculaUnica = true;
                System.out.println("\n Essa matricula já existe!!\n");
                break;
            }
        }

        System.out.println("\nIndique a marca do carro:");
        String marca = ler.nextLine();

        System.out.println("Indique o modelo do carro:");
        String modelo = ler.nextLine();

        System.out.println("Indique o ano da matricula do carro:");
        int anoMatricula = lerN.nextInt();

        Carro novoCarro = new Carro(marca, modelo, matricula, "D", anoMatricula);

        // Inserção do objeto "Carro" no ArrayList
        stockCarro.add(novoCarro);

        System.out.println("Carro inserido com sucesso!!\n\n");
    }

    // Metodo: Listar todos Carros
    public void ListarCarros() {
        if (stockCarro.size() == 0) {
            System.out.println("\nAinda não existem carros disponiveis !\n");
        } else {
            System.out.println("\n ---------------------- \n");
            for (int i = 0; i < stockCarro.size(); i++) {
                // para termos acesso ao conteudo, necessario fazer um split/decompor a informacao por forma a termos acesso ao conteudo
                Carro listarCarro = stockCarro.get(i);
                System.out.println((i + 1) + " " + listarCarro.getMarca() + " - " + listarCarro.getModelo() + " - " + listarCarro.getMatricula() + " - " + listarCarro.getEstado());
            }
            System.out.println("\n ---------------------- \n");
        }
    }

    // Metodo: Alugar Carros
    public void AlugarCarro() {

        boolean numeroCarros = false;
        int opcao = 0;

        if (stockCarro.size() == 0) {
            System.out.println("\nAinda não existem carros disponiveis !\n");
        } else {
            for (int i = 0; i < stockCarro.size(); i++) {
                // para termos acesso ao conteudo, necessario fazer um split/decompor a informacao por forma a termos acesso ao conteudo
                Carro listarCarro = stockCarro.get(i);

                if (listarCarro.getEstado().equals("D")) {

                    numeroCarros = true;
                    System.out.println((i + 1) + " " + listarCarro.getMarca() + " - " + listarCarro.getModelo() + " - " + listarCarro.getMatricula() + " - " + listarCarro.getEstado());

                }
            }

            System.out.println("\n ---------------------- \n");

            if (!numeroCarros) {
                System.out.println("\nNã existem carros disponiveis para alugar!\n");
            } else {

                boolean aux = false;

                System.out.println("\nIndique a matricula do Carro que pretende alugar:\n");
                String matriculaAlugar = ler.nextLine();

                for (int i = 0; i < stockCarro.size(); i++) {

                    Carro listarCarros= stockCarro.get(i);
                    if (listarCarros.getMatricula().equals(matriculaAlugar) && listarCarros.getEstado().equals("D")) {

                        System.out.println("Quantos dias pretende alugar o carro?");
                        int numeroDias = lerN.nextInt();

                        System.out.println("Qual é o valor dia afeto ao carro?");
                        float valorDia = lerN.nextFloat();

                        float total = numeroDias * valorDia;

                        // listarCarros.SetEstado("A");

                        Aluguer novoAluguer = new Aluguer(listarCarros.getMarca(), listarCarros.getModelo(), listarCarros.getMatricula(), "A", listarCarros.getAnoMatricula(), numeroDias, valorDia, total);

                        // estamos a substituir a informacao antiga pela nova informacao
                        stockCarro.set(i, novoAluguer);

                        System.out.println("\nCarro alugado com sucedsso!!\n");

                        aux = true;
                        break;

                    }
                }

                if (!aux) {
                    System.out.println("\nMatricula está errada ou não disponivel!\n");
                }

            }

        }
    }

}
