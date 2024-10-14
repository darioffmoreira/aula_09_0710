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

    // Método para verificar e listar carros disponíveis para alugar
    public void listarCarrosDisponiveis() {
        boolean encontrado = false;

        if (stockCarro.isEmpty()) {
            System.out.println("\nAinda não existem carros disponíveis!\n");
        } else {
            System.out.println("\nCarros disponíveis para alugar:\n");
            for (Carro carro : stockCarro) {
                if (carro.getEstado().equals("D")) {
                    System.out.println(carro.mostrarDados());
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("\nNão há carros disponíveis para alugar.\n");
            }
        }
    }

    public void EditarCarro() {
        if (stockCarro.size() == 0) {
            System.out.println("\nAinda não existem carros disponiveis !\n");
        } else {

            System.out.println("\n ---------------------- \n");
            for (int i = 0; i < stockCarro.size(); i++) {
                Carro listarCarro = stockCarro.get(i);
                System.out.println(listarCarro.getMarca() + " - " + listarCarro.getModelo() + " - " + listarCarro.getMatricula() + " - " + listarCarro.getEstado() + " - " + listarCarro.getAnoMatricula());
            }
            System.out.println("\n ---------------------- \n");

            System.out.println("Indique a matricula do carro que pretende atualizar");
            String matriculaAtualizar = ler.nextLine();
            boolean encontrado = false;

            for (int i = 0; i < stockCarro.size(); i++) {
                Carro listarCarros = stockCarro.get(i);

                if(listarCarros.getMatricula().equals(matriculaAtualizar)) {
                    encontrado = true;

                    System.out.println("Indique o novo ano da matricula!");
                    int novoAnoMatricula = lerN.nextInt();

                    // solucao 1 - Apesar de funcionar, esta abordagem pode ser considerada
                    // ineficiente, pois está a remover e a criar um novo objeto quando apenas
                    // um atributo do carro precisa de ser atualizado.
                    // Carro novaAtualizacao = new Carro(listarCarros.getMarca(), listarCarros.getModelo(), listarCarros.getMatricula(), listarCarros.getEstado(), novoAnoMatricula);
                    // stockCarro.remove(i);
                    // stockCarro.add(i, novaAtualizacao);

                    /*
                        * solucao 2 - porque já estamos na posicao pretendida
                        * Assim sendo, só temos que atualizar o estado do objecto na respetiva posicao.
                    */
                    listarCarros.setAnoMatricula(novoAnoMatricula);

                    System.out.println("\nDados do carro atualizados com sucesso!!\n");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\nMatricula introduzida não existe!!\n");
            }

        }
    }

    public void RemoverCarro() {
        if (stockCarro.size() == 0) {
            System.out.println("\nAinda não existem carros disponiveis !\n");
        } else {

            System.out.println("\n ---------------------- \n");
            for (int i = 0; i < stockCarro.size(); i++) {
                Carro listarCarro = stockCarro.get(i);
                System.out.println(listarCarro.getMarca() + " - " + listarCarro.getModelo() + " - " + listarCarro.getMatricula() + " - " + listarCarro.getEstado());
            }
            System.out.println("\n ---------------------- \n");

            System.out.println("Indique a matricula do carro que pretende remover");
            String matriculaRemover = ler.nextLine();
            boolean encontrado = false;
            int posicao = 0;

            for (int i = 0; i < stockCarro.size(); i++) {
                Carro listarCarro = stockCarro.get(i);
                if(listarCarro.getMatricula().equals(matriculaRemover)) {
                    encontrado = true;
                    posicao = i;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\nMatricula introduzida não existe!!\n");
            } else {
                stockCarro.remove(posicao);
                System.out.println("\nO carro deixou de pertencer à empresa\n");
            }
        }
    }

    public void ListarCarrosVendidos() {
        boolean existeVendas = false;

        // Verificar se existem carros vendidos no stock
        for (Carro carro : stockCarro) {
            if (carro.getEstado().equals("V")) {
                System.out.println(carro.mostrarDados());
                existeVendas = true;
            }
        }

        // Se não existir carros vendidos
        if (!existeVendas) {
            System.out.println("\nNão existem carros vendidos!\n");
        }
    }

    public void ListarCarrosCompleta() {
        if (stockCarro.size() == 0) {
            System.out.println("\nAinda não existem carros disponiveis !\n");
        } else {

            // exemplo1

            for(int i = 0; i < stockCarro.size(); i++) {
                Carro listarCarro = stockCarro.get(i);
                System.out.println(listarCarro.mostrarDados());
            }


            // exemplo2
            /*
            for (Carro listarCarro : stockCarro) {
                System.out.println(listarCarro.mostrarDados());  // polimorfismo
            }
             */
        }
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
                System.out.println((i + 1) + " " + listarCarro.getMarca() + " - " + listarCarro.getModelo() + " - " + listarCarro.getMatricula() + " - " + listarCarro.getEstado() + " - " + listarCarro.getAnoMatricula());

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
                System.out.println("\nNão existem carros disponiveis para alugar!\n");
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

    // Metodo: Venda de carro
    public void VenderCarro() {

        boolean numeroCarros = false;

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
                System.out.println("\nNão existem carros disponiveis para vender!\n");
            } else {

                boolean aux = false;
                System.out.println("\nIndique a matricula que pretende vender:\n");
                String matriculaAlugar = ler.nextLine();

                for (int i = 0; i < stockCarro.size(); i++) {

                    Carro listarCarros = stockCarro.get(i);
                    if (listarCarros.getMatricula().equals(matriculaAlugar) && listarCarros.getEstado().equals("D")) {

                        System.out.println("\nIndique o preço do carro:\n");
                        float preco = lerN.nextFloat();

                        System.out.println("\nIndique qual a data de venda:\n");
                        String dataVenda = ler.nextLine();

                        System.out.println("\nCarro alugado com sucesso!!\n");

                        Venda novaVenda = new Venda(listarCarros.getMarca(), listarCarros.getModelo(), listarCarros.getMatricula(), listarCarros.getAnoMatricula(), preco, dataVenda);

                        stockCarro.set(i, novaVenda);

                        numeroCarros = true;
                        break;
                    }
                }

                if (!numeroCarros) {
                    System.out.println("\nNão existem carros disponiveis com essa matricula para vender!!!\n");
                }
            }
        }
    }
}
