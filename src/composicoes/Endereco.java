package composicoes;

public class Endereco {
    private String rua;
    private int numero;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {
        this.rua = this.rua;
        this.numero = this.numero;
        this.cidade = this.cidade;
        this.estado = this.estado;
        this.cep = this.cep;
    }


    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
