package pessoas;

import java.util.UUID;

public class Dependente {
    private UUID id;
    private Cliente clienteParente;
    private String nome;
    private int idade;
    private String relacionamento;

    public Dependente(String nome, int idade, String relacionamento, Cliente clienteParente) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.idade = idade;
        this.relacionamento = relacionamento;
        this.clienteParente = clienteParente;
    }

    public UUID getId() {
        return id;
    }

    public Cliente getClienteParente() {
        return clienteParente;
    }

    public void setClienteParente(Cliente clienteParente) {
        this.clienteParente = clienteParente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", relacionamento='" + relacionamento + '\'' +
                ", clienteParente=" + clienteParente.getNome() +
                '}';
    }
}
