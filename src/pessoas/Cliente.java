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

    // Getters e Setters
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
        // Aqui você pode implementar a lógica para cadastrar um cliente, se necessário.
        // Por enquanto, deixarei este método vazio.
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

        // Criar uma instância de Cliente com os dados fornecidos
        Cliente cliente = new Cliente();

        System.out.println("Cliente cadastrado com sucesso!");

        scanner.close(); // Fechar o scanner após o uso
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

    @Override
    public void realizarCadastroFuncionario() {
        // Implementação do método
    }

    @Override
    public void realizarCadastroDependente() {
        // Implementação do método
    }
}
