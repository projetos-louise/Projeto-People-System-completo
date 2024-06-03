package apps;

import composicoes.Cargo;
import composicoes.Endereco;
import composicoes.Profissao;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import interfaces.Cadastramento;
import pessoas.Cliente;
import pessoas.Dependente;
import pessoas.Funcionario;
import pessoas.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPeople implements Cadastramento {

    private List<Cliente> clientes;
    private List<Dependente> dependentes;
    private List<Funcionario> funcionarios;
    private List<Pessoa> pessoas;

    public SistemaPeople(){
        this.clientes = new ArrayList<>();
        this.dependentes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    @Override
    public void realizarCadastroCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Cadastro de Cliente ===");

        // Nome
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        // Data de nascimento
        System.out.print("Data de Nascimento (dd-MM-yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);


        // Endereço
        System.out.println("Endereço:");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        Endereco endereco = new Endereco(rua, numero, cidade, estado, cep);

        // Lista de Telefones
        ListaDeTelefonesNaoOrdenados telsContato = new ListaDeTelefonesNaoOrdenados();
        boolean adicionandoTelefones = true;
        while (adicionandoTelefones) {
            System.out.print("Digite um telefone de contato (ou 'sair' para terminar): ");
            String telefone = scanner.nextLine();
            if (telefone.equalsIgnoreCase("sair")) {
                adicionandoTelefones = false;
            } else {
                telsContato.adicionarTelefone(telefone);
            }
        }

        // Código do cliente
        System.out.print("Código do Cliente: ");
        String codigo = scanner.nextLine();

        // Profissão
        System.out.print("Profissão: ");
        String nomeProfissao = scanner.nextLine();
        Profissao profissao = new Profissao(nomeProfissao);

        // Criar uma instância de Cliente com os dados fornecidos
        Cliente cliente = new Cliente(nome, dataNascimento, endereco, telsContato, codigo, profissao);
        this.clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");


    }

    @Override
    public void realizarCadastroFuncionario() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Data de Nascimento (dd-MM-yyyy): ");
            String dataNascimentoStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

            System.out.println("Endereço:");
            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            System.out.print("Número: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline
            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Estado: ");
            String estado = scanner.nextLine();
            System.out.print("CEP: ");
            String cep = scanner.nextLine();
            Endereco endereco = new Endereco(rua, numero, cidade, estado, cep);

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
            System.out.print("Data de Admissão (DD-MM-AAAA): ");
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dataAdmissao = LocalDate.parse(scanner.nextLine(), formatter);

            Funcionario funcionario = new Funcionario(nome, dataNascimento, endereco, telsContato, matricula, cargo,
                    salario, dataAdmissao);

            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    @Override
    public void realizarCadastroDependente() {
        Scanner scanner = new Scanner(System.in);
        if(!this.clientes.isEmpty()){
            System.out.println("Nome: ");
            String nomeDependente = scanner.nextLine();

            System.out.print("Idade: ");
            int idadeDependente = Integer.parseInt(scanner.nextLine());

            System.out.print("Relacionamento: ");
            String relacionamentoDependente = scanner.nextLine();

            System.out.print("Nome do Cliente Parente: ");
            String nomeClienteParente = scanner.nextLine();

            Cliente clienteParente = null;
            for(Cliente c1 : clientes){
                if(c1.getNome().equals(nomeClienteParente)){
                    clienteParente = c1;
                }
            }

            Dependente d = new Dependente(nomeDependente, idadeDependente, relacionamentoDependente, clienteParente);
            dependentes.add(d);
            return;
        }
        System.out.println("Não há clientes cadastrados no sistema!");
        System.out.println("Cadastre um primeiro!\n\n");
    }
}
