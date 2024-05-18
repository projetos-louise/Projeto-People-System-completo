package apps;

import composicoes.Cargo;
import composicoes.Endereco;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import pessoas.Cliente;
import pessoas.Dependente;
import pessoas.Funcionario;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option;

		do {
			System.out.println("==== MENU ====");
			System.out.println("1. Cadastro de Funcionário");
			System.out.println("2. Cadastro de Cliente");
			System.out.println("3. Cadastro de Dependente");
			System.out.println("0. Sair");
			System.out.print("Selecione uma opção: ");
			option = scanner.nextInt();

			switch (option) {
				case 1:
					cadastrarFuncionario(scanner);
					break;
				case 2:
					cadastrarCliente(scanner);
					break;
				case 3:
					cadastrarDependente(scanner);
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (option != 0);

		scanner.close();
	}

	private static void cadastrarFuncionario(Scanner scanner) {
		scanner.nextLine();  // Consumir o newline
		System.out.println("=== Cadastro de Funcionário ===");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		System.out.print("Cargo: ");
		String cargoStr = scanner.nextLine();
		Cargo cargo = Cargo.valueOf(cargoStr.toUpperCase());

		Funcionario funcionario = new Funcionario(nome, cpf, cargo);
		System.out.println("Funcionário cadastrado: " + funcionario);
	}

	private static void cadastrarCliente(Scanner scanner) {
		scanner.nextLine();  // Consumir o newline
		System.out.println("=== Cadastro de Cliente ===");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		System.out.print("Endereço: ");
		String endereco = scanner.nextLine();

		Cliente cliente = new Cliente(nome, cpf, endereco);
		System.out.println("Cliente cadastrado: " + cliente);
	}

	private static void cadastrarDependente(Scanner scanner) {
		scanner.nextLine();  // Consumir o newline
		System.out.println("=== Cadastro de Dependente ===");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Idade: ");
		int idade = scanner.nextInt();
		scanner.nextLine();  // Consumir o newline
		System.out.print("Relacionamento: ");
		String relacionamento = scanner.nextLine();
		System.out.print("Nome do Cliente Parente: ");
		String nomeClienteParente = scanner.nextLine();


		Cliente clienteParente = buscarClientePorNome(nomeClienteParente);

		if (clienteParente != null) {
			Dependente dependente = new Dependente(nome, idade, relacionamento, clienteParente);
			System.out.println("Dependente cadastrado: " + dependente);
		} else {
			System.out.println("Cliente parente não encontrado.");
		}
	}

	private static Cliente buscarClientePorNome(String nomeCliente) {
		return null;
	}
}
