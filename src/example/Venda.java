package example;

public class Venda extends Carro {

    private float preco;
    private String dataVenda;

    public Venda(String marca, String modelo, String matricula, int anoMatricula, float preco, String dataVenda) {
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

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String mostrarDados(){
        return this.getMarca() + " " + this.getModelo() + " " + this.getMatricula() + " " + this.getAnoMatricula() + " " + this.getEstado() + " " + this.preco + " " + this.dataVenda;
    }

}
