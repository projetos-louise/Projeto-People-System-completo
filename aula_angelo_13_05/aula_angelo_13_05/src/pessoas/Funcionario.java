package pessoas;

import composicoes.Cargo;
import composicoes.Endereco;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import interfaces.Cadastramento;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa{
    private int matricula;
    private Cargo cargo;
    private double salario;
    private LocalDate dataAdmissao;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDate dataNascimento, Endereco endereco, ListaDeTelefonesNaoOrdenados telsContato, int matricula,
                       Cargo cargo, double salario, LocalDate dataAdmissao) {
        super(nome, dataNascimento, endereco, telsContato);
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    // Método para obter o tempo de empresa
    public static String obterTempoDeEmpresa(LocalDate dataAdmissao) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataAdmissao, dataAtual);

        int anos = periodo.getYears();
        int meses = periodo.getMonths();

        String anosPlural = (anos == 1) ? "ano" : "anos";
        String mesesPlural = (meses == 1) ? "mês" : "meses";

        return String.format("O funcionário está na empresa há %d %s e %d %s.", anos, anosPlural, meses, mesesPlural);
    }

    // Método para reajustar o salário
    public void reajustarSalario(double percentual){
        this.salario = this.salario * (1 + (percentual / 100));
    }

    // Método para promover o funcionário
    public void promover(Cargo novoCargo){
        this.cargo = novoCargo;
    }

    // Getters e Setters
    // ...


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

}


