package example;

public class Aluguer extends Carro {

    private int numeroDias;
    private float valorDiario;
    private float totalAluguer;

    public Aluguer(String marca, String modelo, String matricula, String estado, int anoMatricula, int numeroDias, float valorDiario, float totalAluguer) {
        super(marca, modelo, matricula, "A", anoMatricula);

        this.numeroDias = numeroDias;
        this.valorDiario = valorDiario;
        this.totalAluguer = numeroDias * valorDiario;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public float getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(float valorDiario) {
        this.valorDiario = valorDiario;
    }

    public float getTotalAluguer() {
        return totalAluguer;
    }

    public void setTotalAluguer(float totalAluguer) {
        this.totalAluguer = totalAluguer;
    }

    @Override
    public String mostrarDados() {
        return this.getMarca() + " " + this.getModelo() + " " + this.getMatricula() + " " + this.getAnoMatricula() + " " + this.getEstado() + " " + this.numeroDias + " " + this.valorDiario + " " + this.totalAluguer;
    }

}
