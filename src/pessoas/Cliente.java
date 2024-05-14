package pessoas;

import composicoes.Endereco;
import composicoes.Profissao;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import interfaces.Cadastramento;

import java.time.LocalDate;

public class Cliente extends Pessoa implements Cadastramento {
    private String codigo;
    private Profissao profissao;
    public Cliente() {
        System.out.println("Criando cliente" +
                " sem atributos!");
    }
    public Cliente(String nome, LocalDate dataNascimento,
                   Endereco endereco, ListaDeTelefonesNaoOrdenados telsContato, String codigo, Profissao profissao) {
        super(nome, dataNascimento, endereco, telsContato);
        this.codigo = codigo;
        this.profissao = profissao;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    @Override
    public void cadastrar() {
        //criar o cadastrar com Scanner


    }
}
