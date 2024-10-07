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
        System.out.println("\nIndique a marca do carro:");
        String marca = ler.nextLine();

        System.out.println("Indique o modelo do carro:");
        String modelo = ler.nextLine();

        System.out.println("Indique a matricula do carro:");
        String matricula = ler.nextLine();

        System.out.println("Indique o ano da matricula do carro:");
        int anoMatricula = lerN.nextInt();

        Carro novoCarro = new Carro(marca, modelo, matricula, "D", anoMatricula);

        // Inserção do objeto "Carro" no ArrayList
        stockCarro.add(novoCarro);

        System.out.println("Carro inserido com sucesso!!\n\n");
    }

    // Metodo: Listar todos Carros
    public void ListarCarros() {

        if(stockCarro.size() == 0) {
            System.out.println("\nAinda não existem carros disponiveis !\n");
        } else {
            for (int i = 0; i < stockCarro.size(); i++) {
                // para termos acesso ao conteudo, necessario fazer um split/decompor a informacao por forma a termos acesso ao conteudo
                Carro listarCarro = stockCarro.get(i);
                System.out.println((i + 1) + " " + listarCarro.getMarca() + " - " + listarCarro.getModelo() + " - " + listarCarro.getMatricula() + " - " + listarCarro.getEstado());
            }
            System.out.println("\n ---------------------- \n");
        }

    }

}
