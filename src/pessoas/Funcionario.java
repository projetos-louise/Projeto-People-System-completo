package pessoas;

import composicoes.Cargo;
import composicoes.Endereco;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import interfaces.Cadastramento;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa implements Cadastramento {
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

    @Override
    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Data de Nascimento (dd-MM-yyyy): ");
            String dataNascimentoStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);


            System.out.print("Endereço (Rua, Número, Cidade, Estado, CEP): ");
            String enderecoInput = scanner.nextLine();
            String[] enderecoParts = enderecoInput.split(",");
            Endereco endereco = new Endereco();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            ListaDeTelefonesNaoOrdenados telsContato = new ListaDeTelefonesNaoOrdenados();
            telsContato.adicionarTelefone(telefone);

            System.out.print("Matrícula: ");
            int matricula = Integer.parseInt(scanner.nextLine());

            System.out.println("Cargo (0: ESTAGIARIO, 1: TRAINEE, 2: JUNIOR, 3: PLENO, 4: SENIOR, 5: ESPECIALISTA): ");
            int cargoOrdinal = Integer.parseInt(scanner.nextLine());
            Cargo cargo = Cargo.values()[cargoOrdinal];

            System.out.print("Salário: ");
            double salario = Double.parseDouble(scanner.nextLine());

            // Data de Admissão
            System.out.print("Data de Admissão (DD/MM/AAAA): ");
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataAdmissao = LocalDate.parse(scanner.nextLine(), formatter);




            this.setNome(nome);
            this.setDataNascimento(dataNascimento);
            this.setEndereco(endereco);
            this.setTelsContato(telsContato);
            this.setMatricula(matricula);
            this.setCargo(cargo);
            this.setSalario(salario);
            this.setDataAdmissao(dataAdmissao);

            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void setSalario(double salario) {
    }

    private void setDataAdmissao(LocalDate dataAdmissao) {
    }

    private void setCargo(Cargo cargo) {
    }

    private void setMatricula(int matricula) {
    }

    @Override
    public void realizarCadastroCliente() {
        // Implementação do método
    }

    @Override
    public void realizarCadastroFuncionario() {
        // Implementação do método
    }

    @Override
    public void realizarCadastroDependente() {
        // Implementação do método
    }
}
