package pessoas;

import composicoes.Cargo;
import composicoes.Endereco;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import interfaces.Cadastramento;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Funcionario extends Pessoa implements Cadastramento {
    private int matricula;
    private Cargo cargo;
    private double salario;
    private LocalDate dataAdmissao;

    public Funcionario(String nome, String cpf, Cargo cargo) {
    }

    public Funcionario(String nome, LocalDate dataNascimento, Endereco endereco, ListaDeTelefonesNaoOrdenados telsContato, int matricula,
                       Cargo cargo, double salario, LocalDate dataAdmissao) {
        super(nome, dataNascimento, endereco, telsContato);
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public static String obterTempoDeEmpresa(LocalDate dataAdmissao) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataAdmissao, dataAtual);

        int anos = periodo.getYears();
        int meses = periodo.getMonths();

        String anosPlural = (anos == 1) ? "ano" : "anos";
        String mesesPlural = (meses == 1) ? "mês" : "meses";

        return String.format("O funcionário está na empresa há %d %s e %d %s.", anos, anosPlural, meses, mesesPlural);
    }

    public void reajustarSalario(double percentual){
        this.salario = this.salario * (1 + (percentual / 100));
    }

    public void promover(Cargo novoCargo){
        this.cargo = novoCargo;
    }

    public int getMatricula() { return matricula;}

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

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        System.out.print("Endereço: ");
        Endereco endereco = new Endereco();

        System.out.print("Telefone: ");
        ListaDeTelefonesNaoOrdenados telsContato = new ListaDeTelefonesNaoOrdenados();

        System.out.print("Matrícula: ");
        int matricula = Integer.parseInt(scanner.nextLine());

        System.out.println("Cargo (0: ESTAGIARIO, 1: TRAINEE, 2: JUNIOR, 3: PLENO, 4: SENIOR, 5: ESPECIALISTA): ");
        int cargoOrdinal = Integer.parseInt(scanner.nextLine());
        Cargo cargo = Cargo.values()[cargoOrdinal];

        System.out.print("Salário: ");
        double salario = Double.parseDouble(scanner.nextLine());

        System.out.print("Data de Admissão (AAAA-MM-DD): ");
        LocalDate dataAdmissao = LocalDate.parse(scanner.nextLine());


        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setTelsContato(telsContato);
        this.setMatricula(matricula);
        this.setCargo(cargo);
        this.setSalario(salario);
        this.setDataAdmissao(dataAdmissao);

        System.out.println("Funcionário cadastrado com sucesso!");
    }
}
