package example;

public class Venda extends Carro {

    private float preco;
    private int dataVenda;

    public Venda(String marca, String modelo, String matricula, int anoMatricula, float preco, int dataVenda) {
        super(marca, modelo, matricula, "V", anoMatricula);

        this.preco = preco;
        this.dataVenda = dataVenda;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(int dataVenda) {
        this.dataVenda = dataVenda;
    }

}
