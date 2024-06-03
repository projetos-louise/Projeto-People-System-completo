package apps;

import pessoas.Cliente;
import pessoas.Dependente;
import pessoas.Funcionario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPeople sistema = new SistemaPeople();

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("Menu de Cadastro:");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Cadastrar Dependente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");


            if (opcao <= 4) {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        sistema.realizarCadastroFuncionario();
                        break;
                    case 2:
                        sistema.realizarCadastroCliente();
                        break;
                    case 3:
                        sistema.realizarCadastroDependente();
                        break;
                    case 4:
                        System.out.println("Operação cocluída, saindo ....");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } else {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine(); // Consumir a entrada inválida
            }
        }
        scanner.close();
    }
}
