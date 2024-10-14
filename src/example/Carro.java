package example;

public class Carro {

    private String marca;
    private String modelo;
    private String matricula;
    private String estado;
    private int anoMatricula;

    // construcao do construtor
    public Carro(String marca, String modelo, String matricula, String estado, int anoMatricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.estado = estado;
        this.anoMatricula = anoMatricula;
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(int anoMatricula) {
        this.anoMatricula = anoMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String mostrarDados() {
        return this.marca + " " + this.modelo + " " + this.matricula + " " + this.estado + " " + this.anoMatricula;
    }

}
