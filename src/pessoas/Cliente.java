package pessoas;

import composicoes.Endereco;
import composicoes.Profissao;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import interfaces.Cadastramento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cliente extends Pessoa implements Cadastramento {
    private String codigo;
    private Profissao profissao;

    public Cliente(String nome, String cpf, String endereco) {
        // Construtor padrão
    }

    public Cliente(String nome, LocalDate dataNascimento, Endereco endereco, ListaDeTelefonesNaoOrdenados telsContato, String codigo, Profissao profissao) {
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Cliente ===");

        // Nome
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        // Data de nascimento
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        // Endereço
        System.out.println("Endereço:");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha restante
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        Endereco endereco = new Endereco();

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

        // Configurar os dados no objeto atual
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setTelsContato(telsContato);
        this.setCodigo(codigo);
        this.setProfissao(profissao);

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", profissao=" + profissao +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", endereco=" + getEndereco() +
                ", telefones=" + getTelsContato() +
                '}';
    }
}
