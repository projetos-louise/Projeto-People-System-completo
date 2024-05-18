package apps;

import pessoas.Cliente;
import pessoas.Dependente;
import pessoas.Funcionario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu de Cadastro:");
			System.out.println("1. Cadastrar Funcionário");
			System.out.println("2. Cadastrar Cliente");
			System.out.println("3. Cadastrar Dependente");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");

			try {
				if (scanner.hasNextInt()) {
					int opcao = scanner.nextInt();
					scanner.nextLine(); // Consumir a quebra de linha

					switch (opcao) {
						case 1:
							Funcionario funcionario = new Funcionario();
							funcionario.cadastrar();
							break;
						case 2:
							Cliente cliente = new Cliente();
							cliente.realizarCadastroCliente();
							break;
						case 3:
							Dependente dependente= new Dependente();
							dependente.realizarCadastroDependente(scanner);
						case 4:
							System.out.println("Operação cocluída, saindo ....");
							return;
						default:
							System.out.println("Opção inválida!");
							break;
					}
				} else {
					System.out.println("Por favor, insira um número válido.");
					scanner.nextLine(); // Consumir a entrada inválida
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor, insira um número válido.");
				scanner.nextLine(); // Consumir a entrada inválida
			}
		}
	}
}
