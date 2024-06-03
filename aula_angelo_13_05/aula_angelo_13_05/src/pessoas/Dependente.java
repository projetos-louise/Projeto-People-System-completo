package pessoas;

import java.util.Scanner;

public class Dependente {
    private String nome;
    private int idade;
    private String relacionamento;
    private Cliente clienteParente;

    // Construtor padrão
    public Dependente() {
        this.nome = "";
        this.idade = 0;
        this.relacionamento = "";
        this.clienteParente = null;
    }

    // Construtor com parâmetros
    public Dependente(String nome, int idade, String relacionamento, Cliente clienteParente) {
        this.nome = nome;
        this.idade = idade;
        this.relacionamento = relacionamento;
        this.clienteParente = clienteParente;
    }

    // Getters e Setters
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

    public Cliente getClienteParente() {
        return clienteParente;
    }

    public void setClienteParente(Cliente clienteParente) {
        this.clienteParente = clienteParente;
    }

}
